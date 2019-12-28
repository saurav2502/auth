package com.tech.auth.common.pageutil;

import com.tech.auth.user.entity.PageVO;
import java.util.List;

public class pageResult<T> {
    public static final long DEFAULT_OFFSET = 0;
    public static final int DEFAULT_MAX_NO_OF_ROWS = 1000;
    private long totalElements;
    private PageVO pageVO;
    private List<T> elements;

    public pageResult(List<T> elements, PageVO pageVO) {
        this.elements = elements;
        this.pageVO = pageVO;
    }

    public pageResult(long totalElements, List<T> elements, PageVO pageVO) {
        this.totalElements = totalElements;
        this.elements = elements;
        this.pageVO = pageVO;
    }

    public long getTotalElements() {
        return elements.size();
    }

    public List<T> getElements() {
        return elements;
    }

    public PageVO getPageVO() {
        return pageVO;
    }

    public void setPageVO(PageVO pageVO) {
        this.pageVO = pageVO;
    }
}
