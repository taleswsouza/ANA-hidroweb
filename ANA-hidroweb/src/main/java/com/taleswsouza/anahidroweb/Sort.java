/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.taleswsouza.anahidroweb;


public class Sort{
    private boolean sorted;
    private boolean unsorted;
    private boolean empty;

    /**
     * @return the sorted
     */
    public boolean isSorted() {
        return sorted;
    }

    /**
     * @param sorted the sorted to set
     */
    public void setSorted(boolean sorted) {
        this.sorted = sorted;
    }

    /**
     * @return the unsorted
     */
    public boolean isUnsorted() {
        return unsorted;
    }

    /**
     * @param unsorted the unsorted to set
     */
    public void setUnsorted(boolean unsorted) {
        this.unsorted = unsorted;
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