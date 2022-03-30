package com.yundasys.beidou.dipper.controller;

import com.yundasys.beidou.dipper.common.result.Result;
import com.yundasys.beidou.dipper.service.IPersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.NotBlank;

@RestController
@RequestMapping("/api/person")
@RequiredArgsConstructor
@Validated
public class PersonController {
    private final IPersonService iPersonService;

    @PostMapping("/getAll")
    public Result getAll() {
        return Result.success(iPersonService.getAll());
    }

    @PostMapping("/export")
    public Result export(@NotBlank(message = "报警Id不能为空") String id, HttpServletResponse response) {
        iPersonService.exportAll(response);
        return Result.success();
    }
}
