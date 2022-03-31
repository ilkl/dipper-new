package com.yundasys.beidou.dipper.common.exception;

import com.yundasys.beidou.dipper.common.result.IResultCode;
import lombok.NoArgsConstructor;

/**
 * 通用错误枚举（可传递自定义消息内容）
 */
@NoArgsConstructor
public enum CommonErrorEnum implements IResultCode {
    COMMON_ERROR("1", "通用错误");

    private String code;

    private String msg;

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String getMsg() {
        return msg;
    }

    CommonErrorEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    /**
     * 自定义错误枚举
     *
     * @param msg 消息内容
     * @return
     */
    public CommonErrorEnum setError(String msg) {
        this.msg = msg;
        CommonErrorEnum commonError = CommonErrorEnum.COMMON_ERROR;
        return commonError;
    }
}
