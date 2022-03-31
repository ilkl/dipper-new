package com.yundasys.beidou.dipper.framework.handler;

import com.yundasys.beidou.dipper.common.result.Result;
import com.yundasys.beidou.dipper.common.result.ResultCode;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * 处理404错误
 */
@RestController
public class RestNotFoundHandler implements ErrorController {

    private static final String ERROR_PATH = "/error";

    @RequestMapping(value = ERROR_PATH)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public Result handleError() {
        return Result.failed(ResultCode.NOT_FOUND_404);
    }
}
