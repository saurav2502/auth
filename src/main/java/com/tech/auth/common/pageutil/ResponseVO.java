package com.tech.auth.common.pageutil;

import com.tech.auth.user.entity.PageVO;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class ResponseVO<T> implements Serializable {
    public static final Long RET_CODE_SUCCESS = 00L;
    public static final Long RET_CODE_FAILURE = 01L;
    public static final String SUCCESSS_MSG = "RET_CODE";
    public static final String FAILURE_MSG = "RET_CODE";
    private PageVO pageVO;
    private T items;

    public ResponseVO(PageVO pageVO, T items) {
        this.pageVO = pageVO;
        this.items = items;
    }
    public Map<String, T>createSuccess() {
        Map<String, T> ret = new HashMap<>();
        ret.put(SUCCESSS_MSG, (T) RET_CODE_SUCCESS);
        ret.put("items" , items);
        return ret;
    }
}
