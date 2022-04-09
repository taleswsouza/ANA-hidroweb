/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.taleswsouza.anahidroweb;

import java.util.ArrayList;
import java.util.Date;

public class TelemetricaContent {

    private int id;
    private String codigoEstacao;
    private String codigoAdicional;
    private String aneelPlu;
    private String aneelFlu;
    private String nome;
    private double latitude;
    private double longitude;
    private int altitude;
    private Date ultimaAtualizacao;
    private int baciaCodigo;
    private String codigoNomeBacia;
    private String codigoNomeSubBacia;
    private String nomeRio;
    private String nomeEstado;
    private String nomeMunicipio;
    private int subBaciaCodigo;
    private int rioCodigo;
    private int estadoCodigo;
    private int municipioCodigo;
    private int responsavelCodigo;
    private int operadoraCodigo;
    private Date menorDataPeriodo;
    private Date maiorDataPeriodo;
    private String responsavelSigla;
    private String operadoraSigla;
    private String tipoEstacao;
    private int operando;
    private String codigoNome;
    private ArrayList<Medicao> medicoes;
    private Object selecionada;
    private boolean baixarChuva;
    private boolean baixarNivel;
    private boolean baixarVazao;
    private String latFormatada;
    private String lonFormatada;
    private String peridoDisponibilidade;

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the codigoEstacao
     */
    public String getCodigoEstacao() {
        return codigoEstacao;
    }

    /**
     * @param codigoEstacao the codigoEstacao to set
     */
    public void setCodigoEstacao(String codigoEstacao) {
        this.codigoEstacao = codigoEstacao;
    }

    /**
     * @return the codigoAdicional
     */
    public String getCodigoAdicional() {
        return codigoAdicional;
    }

    /**
     * @param codigoAdicional the codigoAdicional to set
     */
    public void setCodigoAdicional(String codigoAdicional) {
        this.codigoAdicional = codigoAdicional;
    }

    /**
     * @return the aneelPlu
     */
    public String getAneelPlu() {
        return aneelPlu;
    }

    /**
     * @param aneelPlu the aneelPlu to set
     */
    public void setAneelPlu(String aneelPlu) {
        this.aneelPlu = aneelPlu;
    }

    /**
     * @return the aneelFlu
     */
    public String getAneelFlu() {
        return aneelFlu;
    }

    /**
     * @param aneelFlu the aneelFlu to set
     */
    public void setAneelFlu(String aneelFlu) {
        this.aneelFlu = aneelFlu;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the latitude
     */
    public double getLatitude() {
        return latitude;
    }

    /**
     * @param latitude the latitude to set
     */
    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    /**
     * @return the longitude
     */
    public double getLongitude() {
        return longitude;
    }

    /**
     * @param longitude the longitude to set
     */
    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    /**
     * @return the altitude
     */
    public int getAltitude() {
        return altitude;
    }

    /**
     * @param altitude the altitude to set
     */
    public void setAltitude(int altitude) {
        this.altitude = altitude;
    }

    /**
     * @return the ultimaAtualizacao
     */
    public Date getUltimaAtualizacao() {
        return ultimaAtualizacao;
    }

    /**
     * @param ultimaAtualizacao the ultimaAtualizacao to set
     */
    public void setUltimaAtualizacao(Date ultimaAtualizacao) {
        this.ultimaAtualizacao = ultimaAtualizacao;
    }

    /**
     * @return the baciaCodigo
     */
    public int getBaciaCodigo() {
        return baciaCodigo;
    }

    /**
     * @param baciaCodigo the baciaCodigo to set
     */
    public void setBaciaCodigo(int baciaCodigo) {
        this.baciaCodigo = baciaCodigo;
    }

    /**
     * @return the codigoNomeBacia
     */
    public String getCodigoNomeBacia() {
        return codigoNomeBacia;
    }

    /**
     * @param codigoNomeBacia the codigoNomeBacia to set
     */
    public void setCodigoNomeBacia(String codigoNomeBacia) {
        this.codigoNomeBacia = codigoNomeBacia;
    }

    /**
     * @return the codigoNomeSubBacia
     */
    public String getCodigoNomeSubBacia() {
        return codigoNomeSubBacia;
    }

    /**
     * @param codigoNomeSubBacia the codigoNomeSubBacia to set
     */
    public void setCodigoNomeSubBacia(String codigoNomeSubBacia) {
        this.codigoNomeSubBacia = codigoNomeSubBacia;
    }

    /**
     * @return the nomeRio
     */
    public String getNomeRio() {
        return nomeRio;
    }

    /**
     * @param nomeRio the nomeRio to set
     */
    public void setNomeRio(String nomeRio) {
        this.nomeRio = nomeRio;
    }

    /**
     * @return the nomeEstado
     */
    public String getNomeEstado() {
        return nomeEstado;
    }

    /**
     * @param nomeEstado the nomeEstado to set
     */
    public void setNomeEstado(String nomeEstado) {
        this.nomeEstado = nomeEstado;
    }

    /**
     * @return the nomeMunicipio
     */
    public String getNomeMunicipio() {
        return nomeMunicipio;
    }

    /**
     * @param nomeMunicipio the nomeMunicipio to set
     */
    public void setNomeMunicipio(String nomeMunicipio) {
        this.nomeMunicipio = nomeMunicipio;
    }

    /**
     * @return the subBaciaCodigo
     */
    public int getSubBaciaCodigo() {
        return subBaciaCodigo;
    }

    /**
     * @param subBaciaCodigo the subBaciaCodigo to set
     */
    public void setSubBaciaCodigo(int subBaciaCodigo) {
        this.subBaciaCodigo = subBaciaCodigo;
    }

    /**
     * @return the rioCodigo
     */
    public int getRioCodigo() {
        return rioCodigo;
    }

    /**
     * @param rioCodigo the rioCodigo to set
     */
    public void setRioCodigo(int rioCodigo) {
        this.rioCodigo = rioCodigo;
    }

    /**
     * @return the estadoCodigo
     */
    public int getEstadoCodigo() {
        return estadoCodigo;
    }

    /**
     * @param estadoCodigo the estadoCodigo to set
     */
    public void setEstadoCodigo(int estadoCodigo) {
        this.estadoCodigo = estadoCodigo;
    }

    /**
     * @return the municipioCodigo
     */
    public int getMunicipioCodigo() {
        return municipioCodigo;
    }

    /**
     * @param municipioCodigo the municipioCodigo to set
     */
    public void setMunicipioCodigo(int municipioCodigo) {
        this.municipioCodigo = municipioCodigo;
    }

    /**
     * @return the responsavelCodigo
     */
    public int getResponsavelCodigo() {
        return responsavelCodigo;
    }

    /**
     * @param responsavelCodigo the responsavelCodigo to set
     */
    public void setResponsavelCodigo(int responsavelCodigo) {
        this.responsavelCodigo = responsavelCodigo;
    }

    /**
     * @return the operadoraCodigo
     */
    public int getOperadoraCodigo() {
        return operadoraCodigo;
    }

    /**
     * @param operadoraCodigo the operadoraCodigo to set
     */
    public void setOperadoraCodigo(int operadoraCodigo) {
        this.operadoraCodigo = operadoraCodigo;
    }

    /**
     * @return the menorDataPeriodo
     */
    public Date getMenorDataPeriodo() {
        return menorDataPeriodo;
    }

    /**
     * @param menorDataPeriodo the menorDataPeriodo to set
     */
    public void setMenorDataPeriodo(Date menorDataPeriodo) {
        this.menorDataPeriodo = menorDataPeriodo;
    }

    /**
     * @return the maiorDataPeriodo
     */
    public Date getMaiorDataPeriodo() {
        return maiorDataPeriodo;
    }

    /**
     * @param maiorDataPeriodo the maiorDataPeriodo to set
     */
    public void setMaiorDataPeriodo(Date maiorDataPeriodo) {
        this.maiorDataPeriodo = maiorDataPeriodo;
    }

    /**
     * @return the responsavelSigla
     */
    public String getResponsavelSigla() {
        return responsavelSigla;
    }

    /**
     * @param responsavelSigla the responsavelSigla to set
     */
    public void setResponsavelSigla(String responsavelSigla) {
        this.responsavelSigla = responsavelSigla;
    }

    /**
     * @return the operadoraSigla
     */
    public String getOperadoraSigla() {
        return operadoraSigla;
    }

    /**
     * @param operadoraSigla the operadoraSigla to set
     */
    public void setOperadoraSigla(String operadoraSigla) {
        this.operadoraSigla = operadoraSigla;
    }

    /**
     * @return the tipoEstacao
     */
    public String getTipoEstacao() {
        return tipoEstacao;
    }

    /**
     * @param tipoEstacao the tipoEstacao to set
     */
    public void setTipoEstacao(String tipoEstacao) {
        this.tipoEstacao = tipoEstacao;
    }

    /**
     * @return the operando
     */
    public int getOperando() {
        return operando;
    }

    /**
     * @param operando the operando to set
     */
    public void setOperando(int operando) {
        this.operando = operando;
    }

    /**
     * @return the codigoNome
     */
    public String getCodigoNome() {
        return codigoNome;
    }

    /**
     * @param codigoNome the codigoNome to set
     */
    public void setCodigoNome(String codigoNome) {
        this.codigoNome = codigoNome;
    }

    /**
     * @return the medicoes
     */
    public ArrayList<Medicao> getMedicoes() {
        return medicoes;
    }

    /**
     * @param medicoes the medicoes to set
     */
    public void setMedicoes(ArrayList<Medicao> medicoes) {
        this.medicoes = medicoes;
    }

    /**
     * @return the selecionada
     */
    public Object getSelecionada() {
        return selecionada;
    }

    /**
     * @param selecionada the selecionada to set
     */
    public void setSelecionada(Object selecionada) {
        this.selecionada = selecionada;
    }

    /**
     * @return the baixarChuva
     */
    public boolean isBaixarChuva() {
        return baixarChuva;
    }

    /**
     * @param baixarChuva the baixarChuva to set
     */
    public void setBaixarChuva(boolean baixarChuva) {
        this.baixarChuva = baixarChuva;
    }

    /**
     * @return the baixarNivel
     */
    public boolean isBaixarNivel() {
        return baixarNivel;
    }

    /**
     * @param baixarNivel the baixarNivel to set
     */
    public void setBaixarNivel(boolean baixarNivel) {
        this.baixarNivel = baixarNivel;
    }

    /**
     * @return the baixarVazao
     */
    public boolean isBaixarVazao() {
        return baixarVazao;
    }

    /**
     * @param baixarVazao the baixarVazao to set
     */
    public void setBaixarVazao(boolean baixarVazao) {
        this.baixarVazao = baixarVazao;
    }

    /**
     * @return the latFormatada
     */
    public String getLatFormatada() {
        return latFormatada;
    }

    /**
     * @param latFormatada the latFormatada to set
     */
    public void setLatFormatada(String latFormatada) {
        this.latFormatada = latFormatada;
    }

    /**
     * @return the lonFormatada
     */
    public String getLonFormatada() {
        return lonFormatada;
    }

    /**
     * @param lonFormatada the lonFormatada to set
     */
    public void setLonFormatada(String lonFormatada) {
        this.lonFormatada = lonFormatada;
    }

    /**
     * @return the peridoDisponibilidade
     */
    public String getPeridoDisponibilidade() {
        return peridoDisponibilidade;
    }

    /**
     * @param peridoDisponibilidade the peridoDisponibilidade to set
     */
    public void setPeridoDisponibilidade(String peridoDisponibilidade) {
        this.peridoDisponibilidade = peridoDisponibilidade;
    }
}
