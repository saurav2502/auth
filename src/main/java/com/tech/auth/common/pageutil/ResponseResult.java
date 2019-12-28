package com.tech.auth.common.pageutil;

import java.io.Serializable;

class ResponseResult<T> implements Serializable {

    private static final long serialVersionUID = 8486468806063544444L;


    private Integer state;


    private String message;

    private T item;

    private ResponseVO responseVO;

    public ResponseResult() {
        super();
    }

    public ResponseResult(Integer state) {
        super();
        this.state = state;
    }

    public ResponseResult(Integer state, String message) {
        super();
        this.state = state;
        this.message = message;
    }

    public ResponseResult(Integer state, Throwable throwable) {
        super();
        this.state = state;
        this.message = throwable.getMessage();
    }

    public ResponseResult(Integer state, T item) {
        super();
        this.state = state;
        this.item = item;
    }

    public ResponseResult(Integer state, String message, T item) {
        super();
        this.state = state;
        this.message = message;
        this.item = item;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getItem() {
        return item;
    }

    public void setItem(T item) {
        this.item = item;
    }

    public ResponseVO getResponseVO() {
        return responseVO;
    }

    public void setResponseVO(ResponseVO responseVO) {
        this.responseVO = responseVO;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((item == null) ? 0 : item.hashCode());
        result = prime * result + ((message == null) ? 0 : message.hashCode());
        result = prime * result + ((state == null) ? 0 : state.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        ResponseResult<?> other = (ResponseResult<?>) obj;
        if (item == null) {
            if (other.item != null) {
                return false;
            }
        } else if (!item.equals(other.item)) {
            return false;
        }
        if (message == null) {
            if (other.message != null) {
                return false;
            }
        } else if (!message.equals(other.message)) {
            return false;
        }
        if (state == null) {
            if (other.state != null) {
                return false;
            }
        } else if (!state.equals(other.state)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ResponseResult [state=" + state + ", message=" + message + ", item=" + item
              + ",response" + responseVO + " ]";
    }
}
