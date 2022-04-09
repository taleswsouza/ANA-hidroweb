/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.taleswsouza.anahidroweb;

import java.util.ArrayList;

public class EstacaoTelemetrica {

    private ArrayList<Content> content;
    private Pageable pageable;
    private boolean last;
    private int totalPages;
    private int totalElements;
    private Sort sort;
    private boolean first;
    private int numberOfElements;
    private int size;
    private int number;
    private boolean empty;

    public int getId() {
        return content.get(0).getId();
    }

    /**
     * @return the content
     */
    public ArrayList<Content> getContent() {
        return content;
    }

    /**
     * @param content the content to set
     */
    public void setContent(ArrayList<Content> content) {
        this.content = content;
    }

    /**
     * @return the pageable
     */
    public Pageable getPageable() {
        return pageable;
    }

    /**
     * @param pageable the pageable to set
     */
    public void setPageable(Pageable pageable) {
        this.pageable = pageable;
    }

    /**
     * @return the last
     */
    public boolean isLast() {
        return last;
    }

    /**
     * @param last the last to set
     */
    public void setLast(boolean last) {
        this.last = last;
    }

    /**
     * @return the totalPages
     */
    public int getTotalPages() {
        return totalPages;
    }

    /**
     * @param totalPages the totalPages to set
     */
    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    /**
     * @return the totalElements
     */
    public int getTotalElements() {
        return totalElements;
    }

    /**
     * @param totalElements the totalElements to set
     */
    public void setTotalElements(int totalElements) {
        this.totalElements = totalElements;
    }

    /**
     * @return the sort
     */
    public Sort getSort() {
        return sort;
    }

    /**
     * @param sort the sort to set
     */
    public void setSort(Sort sort) {
        this.sort = sort;
    }

    /**
     * @return the first
     */
    public boolean isFirst() {
        return first;
    }

    /**
     * @param first the first to set
     */
    public void setFirst(boolean first) {
        this.first = first;
    }

    /**
     * @return the numberOfElements
     */
    public int getNumberOfElements() {
        return numberOfElements;
    }

    /**
     * @param numberOfElements the numberOfElements to set
     */
    public void setNumberOfElements(int numberOfElements) {
        this.numberOfElements = numberOfElements;
    }

    /**
     * @return the size
     */
    public int getSize() {
        return size;
    }

    /**
     * @param size the size to set
     */
    public void setSize(int size) {
        this.size = size;
    }

    /**
     * @return the number
     */
    public int getNumber() {
        return number;
    }

    /**
     * @param number the number to set
     */
    public void setNumber(int number) {
        this.number = number;
    }

    /**
     * @return the empty
     */
    public boolean isEmpty() {
        return empty;
    }

    /**
     * @param empty the empty to set
     */
    public void setEmpty(boolean empty) {
        this.empty = empty;
    }
}
