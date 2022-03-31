package com.yundasys.beidou.dipper.common.exception;


import com.yundasys.beidou.dipper.common.result.IResultCode;

/**
 * 业务报错(参数为枚举)
 */
public class BizException extends RuntimeException {
    private IResultCode serverStateEnum;
    private Throwable cause;

    @Override
    public Throwable getCause() {
        return cause;
    }

    public void setCause(Throwable cause) {
        this.cause = cause;
    }

    public IResultCode getServerStateEnum() {
        return serverStateEnum;
    }

    public void setServerStateEnum(IResultCode serverStateEnum) {
        this.serverStateEnum = serverStateEnum;
    }

    public BizException(IResultCode serverStateEnum) {
        this.serverStateEnum = serverStateEnum;
    }

    public BizException(IResultCode serverStateEnum, Throwable cause) {
        this.serverStateEnum = serverStateEnum;
        this.cause = cause;
    }
}
