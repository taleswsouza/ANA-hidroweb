/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.taleswsouza.anahidroweb;

public class Pageable{
    private Sort sort;
    private int pageSize;
    private int pageNumber;
    private int offset;
    private boolean unpaged;
    private boolean paged;

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
     * @return the pageSize
     */
    public int getPageSize() {
        return pageSize;
    }

    /**
     * @param pageSize the pageSize to set
     */
    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    /**
     * @return the pageNumber
     */
    public int getPageNumber() {
        return pageNumber;
    }

    /**
     * @param pageNumber the pageNumber to set
     */
    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    /**
     * @return the offset
     */
    public int getOffset() {
        return offset;
    }

    /**
     * @param offset the offset to set
     */
    public void setOffset(int offset) {
        this.offset = offset;
    }

    /**
     * @return the unpaged
     */
    public boolean isUnpaged() {
        return unpaged;
    }

    /**
     * @param unpaged the unpaged to set
     */
    public void setUnpaged(boolean unpaged) {
        this.unpaged = unpaged;
    }

    /**
     * @return the paged
     */
    public boolean isPaged() {
        return paged;
    }

    /**
     * @param paged the paged to set
     */
    public void setPaged(boolean paged) {
        this.paged = paged;
    }
}
