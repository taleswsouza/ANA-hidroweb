package com.taleswsouza.anahidroweb;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Optional;
import java.util.TimeZone;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.client.HttpClientErrorException.BadRequest;
import org.springframework.web.client.RestTemplate;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class ANAHidrowebIntegrationTests {

    private static final String COD_ESTACAO_MARIO_DE_CARVALHO = "5669600";

    @Autowired
    private RestTemplate restTemplate;

    //?codigosEstacoes=193142390&tipoArquivo=2&periodoInicial=2022-02-11T03:00:00.000Z&periodoFinal=2022-02-12T03:00:00.000Z
    @Value("https://www.snirh.gov.br/hidroweb/rest/api/documento/gerarTelemetricas?codigosEstacoes={codigosEstacoes}&tipoArquivo={tipoArquivo}&periodoInicial={periodoInicial}&periodoFinal={periodoFinal}")
    private String apiAnaGerarTelemetricas;

    //?codigosEstacoes=193142390&tipoArquivo=2&periodoInicial=2022-02-11T03:00:00.000Z // -- removido parametro 'periodoFinal' para testar BadRequest
    @Value("https://www.snirh.gov.br/hidroweb/rest/api/documento/gerarTelemetricas?codigosEstacoes={codigosEstacoes}&tipoArquivo={tipoArquivo}&periodoInicial={periodoInicial}")
    private String apiAlternativaAnaGerarTelemetricasSemPeriodoFinal;

    //https://www.snirh.gov.br/hidroweb/rest/api/estacaotelemetrica?id=5669600
    @Value("https://www.snirh.gov.br/hidroweb/rest/api/estacaotelemetrica?id={id}")
    private String apiAnaEstacaotelemetrica;

    private final SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", new Locale("pt", "BR"));

    private Map<String, Object> params;
    private EstacaoTelemetrica estacao;

    @BeforeEach
    public void setUp() {
        formatter.setTimeZone(TimeZone.getTimeZone("UTC"));

        params = new HashMap<>();
        params.put("id", COD_ESTACAO_MARIO_DE_CARVALHO);

        //https://www.snirh.gov.br/hidroweb/rest/api/estacaotelemetrica
        estacao = restTemplate.getForObject(apiAnaEstacaotelemetrica, EstacaoTelemetrica.class, params);

        params = new HashMap<>();
        params.put("codigosEstacoes", estacao.getId());
        params.put("tipoArquivo", 2);
    }

    @Test
    void verificaDatas() {
        assertEquals("2021-12-31T21:00:00.000Z", formatter.format(convertToDate(LocalDateTime.of(2021, Month.DECEMBER, 31, 18, 00))));
        assertEquals("2022-01-01T00:00:00.000Z", formatter.format(convertToDate(LocalDateTime.of(2021, Month.DECEMBER, 31, 21, 00))));
        assertEquals("2022-01-01T03:00:00.000Z", formatter.format(convertToDate(LocalDateTime.of(2022, Month.JANUARY, 1, 0, 00))));
        assertEquals("2022-01-01T06:00:00.000Z", formatter.format(convertToDate(LocalDateTime.of(2022, Month.JANUARY, 1, 3, 00))));
    }

    @Test
    void leDados_de_07abril2022_00h() {
        params.put("periodoInicial", formatter.format(convertToDate(LocalDate.of(2022, Month.APRIL, 7))));
        params.put("periodoFinal", formatter.format(convertToDate(LocalDate.of(2022, Month.APRIL, 7))));

        //https://www.snirh.gov.br/hidroweb/rest/api/documento/gerarTelemetricas
        TelemetricaContent[] telemetria = restTemplate.getForObject(apiAnaGerarTelemetricas, TelemetricaContent[].class, params);

        assertEquals(1, telemetria[0].getMedicoes().size());

        ArrayList<Medicao> medicoes = telemetria[0].getMedicoes();

        Medicao dados_07abril2022_00h = medicoes.get(medicoes.size() - 1);

        assertEquals(convertToDate(LocalDate.of(2022, Month.APRIL, 7)), dados_07abril2022_00h.getId().getHorDataHora());
        assertEquals(0.0d, dados_07abril2022_00h.getHorChuva());
        assertEquals(159, dados_07abril2022_00h.getHorNivelAdotado());
        assertEquals(44.57d, dados_07abril2022_00h.getHorVazao());
    }

    @Test
    void leDados_de_07abril2022_00h_SemPeriodoFinal() {
        params.put("periodoInicial", formatter.format(convertToDate(LocalDate.of(2022, Month.APRIL, 7))));
//        params.put("periodoFinal", formatter.format(convertToDate(LocalDate.of(2022, Month.APRIL, 7))));

        BadRequest exception = assertThrows(BadRequest.class, () -> {
            //https://www.snirh.gov.br/hidroweb/rest/api/documento/gerarTelemetricas
            TelemetricaContent[] telemetria = restTemplate.getForObject(apiAlternativaAnaGerarTelemetricasSemPeriodoFinal, TelemetricaContent[].class, params);
        });
        assertEquals(exception.getStatusCode(), HttpStatus.BAD_REQUEST);
        assertThat(exception.getRawStatusCode(), is(400));
        assertThat(exception.getMessage(), containsString("Required Date parameter 'periodoFinal' is not present"));
    }

    @Test
    void leDados_de_OutraEstacao_07abril2022_00h() {
        final String COD_ESTACAO_COLATINA_PONTE = "56994500";

        params = new HashMap<>();
        params.put("id", COD_ESTACAO_COLATINA_PONTE);

        //https://www.snirh.gov.br/hidroweb/rest/api/estacaotelemetrica
        EstacaoTelemetrica estacaoColatinaPonte = restTemplate.getForObject(apiAnaEstacaotelemetrica, EstacaoTelemetrica.class, params);

        params = new HashMap<>();
        params.put("codigosEstacoes", estacaoColatinaPonte.getId());
        params.put("tipoArquivo", 2);

        params.put("periodoInicial", formatter.format(convertToDate(LocalDate.of(2022, Month.APRIL, 7))));
        params.put("periodoFinal", formatter.format(convertToDate(LocalDate.of(2022, Month.APRIL, 7))));;

        //https://www.snirh.gov.br/hidroweb/rest/api/documento/gerarTelemetricas
        TelemetricaContent[] telemetria = restTemplate.getForObject(apiAnaGerarTelemetricas, TelemetricaContent[].class, params);

        assertEquals(1, telemetria[0].getMedicoes().size());

        ArrayList<Medicao> medicoes = telemetria[0].getMedicoes();

        Medicao dados_07abril2022_00h = medicoes.get(medicoes.size() - 1);

        assertEquals(convertToDate(LocalDate.of(2022, Month.APRIL, 7)), dados_07abril2022_00h.getId().getHorDataHora());
        assertEquals(0.0d, dados_07abril2022_00h.getHorChuva());
        assertEquals(201, dados_07abril2022_00h.getHorNivelAdotado());
        assertEquals(666.47d, dados_07abril2022_00h.getHorVazao());
    }

    @Test
    void leDados_de_07abril2022_08h_Ate_07abril2022_12h_ContinuaTrazendoSomentoUmaMedicao_NaData_07abril2022_00h() {
        params.put("periodoInicial", formatter.format(convertToDate(LocalDateTime.of(2022, Month.APRIL, 7, 8, 0))));
        params.put("periodoFinal", formatter.format(convertToDate(LocalDateTime.of(2022, Month.APRIL, 7, 12, 0))));

        //https://www.snirh.gov.br/hidroweb/rest/api/documento/gerarTelemetricas
        TelemetricaContent[] telemetria = restTemplate.getForObject(apiAnaGerarTelemetricas, TelemetricaContent[].class, params);

        ArrayList<Medicao> medicoes = telemetria[0].getMedicoes();

        Medicao dados_07abril2022_00h = medicoes.get(medicoes.size() - 1);

        assertEquals(1, telemetria[0].getMedicoes().size());
        assertEquals(convertToDate(LocalDateTime.of(2022, Month.APRIL, 7, 0, 0)), dados_07abril2022_00h.getId().getHorDataHora());
        assertEquals(0.0d, dados_07abril2022_00h.getHorChuva());
        assertEquals(159, dados_07abril2022_00h.getHorNivelAdotado());
        assertEquals(44.57d, dados_07abril2022_00h.getHorVazao());
    }

    @Test
    void leDados_de_07abril2022_00h_Ate_08abril2022_00h_Tras97Resultados_EntreDia07E08DeAbril() {
        params.put("periodoInicial", formatter.format(convertToDate(LocalDateTime.of(2022, Month.APRIL, 6, 23, 59))));
        params.put("periodoFinal", formatter.format(convertToDate(LocalDateTime.of(2022, Month.APRIL, 8, 0, 1))));

        //https://www.snirh.gov.br/hidroweb/rest/api/documento/gerarTelemetricas
        TelemetricaContent[] telemetria = restTemplate.getForObject(apiAnaGerarTelemetricas, TelemetricaContent[].class, params);

        ArrayList<Medicao> medicoes = telemetria[0].getMedicoes();

        assertEquals(97, medicoes.size());

        Medicao dados_07abril2022_00h = medicoes.get(0);
        assertEquals(convertToDate(LocalDateTime.of(2022, Month.APRIL, 7, 0, 0)), dados_07abril2022_00h.getId().getHorDataHora());
        assertEquals(0.0d, dados_07abril2022_00h.getHorChuva());
        assertEquals(159, dados_07abril2022_00h.getHorNivelAdotado());
        assertEquals(44.57d, dados_07abril2022_00h.getHorVazao());

        Medicao dados_08abril2022_12h = medicoes.get(48);
        assertEquals(convertToDate(LocalDateTime.of(2022, Month.APRIL, 7, 12, 0)), dados_08abril2022_12h.getId().getHorDataHora());
        assertEquals(0.0d, dados_08abril2022_12h.getHorChuva());
        assertEquals(180, dados_08abril2022_12h.getHorNivelAdotado());
        assertEquals(58.68d, dados_08abril2022_12h.getHorVazao());

        Medicao dados_08abril2022_00h = medicoes.get(medicoes.size() - 1);
        assertEquals(convertToDate(LocalDateTime.of(2022, Month.APRIL, 8, 0, 0)), dados_08abril2022_00h.getId().getHorDataHora());
        assertEquals(0.0d, dados_08abril2022_00h.getHorChuva());
        assertEquals(152, dados_08abril2022_00h.getHorNivelAdotado());
        assertEquals(40.18d, dados_08abril2022_00h.getHorVazao());
    }

    @Test
    void leDados_de_01marco2022_00h_Ate_31marco2022_23h59m_Tras97Resultados_EntreDia07E08DeAbril() {
        params.put("periodoInicial", formatter.format(convertToDate(LocalDateTime.of(2022, Month.MARCH, 1, 0, 0))));
        params.put("periodoFinal", formatter.format(convertToDate(LocalDateTime.of(2022, Month.MARCH, 31, 23, 59, 59))));

        //https://www.snirh.gov.br/hidroweb/rest/api/documento/gerarTelemetricas
        TelemetricaContent[] telemetria = restTemplate.getForObject(apiAnaGerarTelemetricas, TelemetricaContent[].class, params);

        ArrayList<Medicao> medicoes = telemetria[0].getMedicoes();

        assertEquals(2969, medicoes.size());

        Medicao dados_01marco2022_00h = medicoes.get(0);
        assertEquals(convertToDate(LocalDateTime.of(2022, Month.MARCH, 1, 0, 0)), dados_01marco2022_00h.getId().getHorDataHora());
        assertEquals(0.0d, dados_01marco2022_00h.getHorChuva());
        assertEquals(232, dados_01marco2022_00h.getHorNivelAdotado());
        assertEquals(99.35d, dados_01marco2022_00h.getHorVazao());

        Medicao dados_01abril2022_00h = medicoes.get(medicoes.size() - 1);
        assertEquals(convertToDate(LocalDateTime.of(2022, Month.APRIL, 1, 0, 0)), dados_01abril2022_00h.getId().getHorDataHora());
        assertEquals(0.0d, dados_01abril2022_00h.getHorChuva());
        assertEquals(159, dados_01abril2022_00h.getHorNivelAdotado());
        assertEquals(44.57d, dados_01abril2022_00h.getHorVazao());
    }

    @Test
    void leDados_de_01marco2022_14h45m_ComValoresNulosNoResultados() {
        params.put("periodoInicial", formatter.format(convertToDate(LocalDateTime.of(2022, Month.MARCH, 1, 0, 0))));
        params.put("periodoFinal", formatter.format(convertToDate(LocalDateTime.of(2022, Month.MARCH, 2, 0, 0))));

        //https://www.snirh.gov.br/hidroweb/rest/api/documento/gerarTelemetricas
        TelemetricaContent[] telemetria = restTemplate.getForObject(apiAnaGerarTelemetricas, TelemetricaContent[].class, params);

        ArrayList<Medicao> medicoes = telemetria[0].getMedicoes();

        assertEquals(1 * 24 * 4 + 1, medicoes.size());

        Optional<Medicao> dadoFiltradoPorData = medicoes
                .stream()
                .filter(m -> m.getId().getHorDataHora().equals(convertToDate(LocalDateTime.of(2022, Month.MARCH, 1, 4, 45))))
                .findFirst();
        Medicao dados_01marco2022_14h45m = dadoFiltradoPorData.get();
        assertEquals(convertToDate(LocalDateTime.of(2022, Month.MARCH, 1, 4, 45)), dados_01marco2022_14h45m.getId().getHorDataHora());
        assertEquals(null, dados_01marco2022_14h45m.getHorChuva());
        assertEquals(null, dados_01marco2022_14h45m.getHorNivelAdotado());
        assertEquals(null, dados_01marco2022_14h45m.getHorVazao());
    }

    @Test
    void leDados_de_08abril2022__00h() {
        params.put("periodoInicial", formatter.format(convertToDate(LocalDate.of(2022, Month.APRIL, 8))));
        params.put("periodoFinal", formatter.format(convertToDate(LocalDate.of(2022, Month.APRIL, 8))));

        //https://www.snirh.gov.br/hidroweb/rest/api/documento/gerarTelemetricas
        TelemetricaContent[] telemetria = restTemplate.getForObject(apiAnaGerarTelemetricas, TelemetricaContent[].class, params);

        ArrayList<Medicao> medicoes = telemetria[0].getMedicoes();

        Medicao dados22h45m = medicoes.get(medicoes.size() - 1);

        assertEquals(1, telemetria[0].getMedicoes().size());
        assertEquals(convertToDate(LocalDate.of(2022, Month.APRIL, 8)), dados22h45m.getId().getHorDataHora());
        assertEquals(0.0d, dados22h45m.getHorChuva());
        assertEquals(152, dados22h45m.getHorNivelAdotado());
        assertEquals(40.18d, dados22h45m.getHorVazao());
    }

    private Date convertToDate(LocalDate dateToConvert) {
        return java.sql.Date.valueOf(dateToConvert);
    }

    private Date convertToDate(LocalDateTime dateToConvert) {
        return java.util.Date.from(dateToConvert.atZone(ZoneId.systemDefault())
                .toInstant());
    }
}
