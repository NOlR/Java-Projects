package com.jh.vlog.exception;

import com.jh.vlog.common.ResultCode;

/**
 * @ClassName Customexception
 * @Description TODO
 * @Author apple
 * @Date 2020/12/19
 **/
public class Customexception extends RuntimeException {

    protected ResultCode resultCode;

    public Customexception(String msg, ResultCode resultCode) {
        super(msg);
        this.resultCode = resultCode;
    }

    public ResultCode getResultCode(){
        return resultCode;
    }
}

