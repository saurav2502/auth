package com.tech.auth.user.entity;

public class PageVO<T> {
    private int pageNum;
    private int pageSize;
    private long totalRows;
    private int totalPages;

    public PageVO() {
    }

    public PageVO(int pageNum, int pageSize, long totalRows, int totalPages) {
        this.pageNum = pageNum;
        this.pageSize = pageSize;
        this.totalRows = totalRows;
        this.totalPages = totalPages;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public long getTotalRows() {
        return totalRows;
    }

    public void setTotalRows(long totalRows) {
        this.totalRows = totalRows;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }
}
