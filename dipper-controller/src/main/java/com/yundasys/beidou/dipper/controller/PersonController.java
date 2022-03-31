package com.yundasys.beidou.dipper.controller;

import com.yundasys.beidou.dipper.common.result.Result;
import com.yundasys.beidou.dipper.model.vo.query.PersonQuery;
import com.yundasys.beidou.dipper.model.vo.req.PersonReq;
import com.yundasys.beidou.dipper.model.vo.res.PersonVo;
import com.yundasys.beidou.dipper.service.IPersonService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Api(tags = "北斗-人员相关接口")
@RestController
@RequestMapping("/api/person")
@RequiredArgsConstructor
@Validated
public class PersonController {
    private final IPersonService iPersonService;

    @ApiOperation(value = "查询所有人员信息")
    @GetMapping("")
    public Result<List<PersonVo>> getAll(PersonQuery query) {
        return Result.success(iPersonService.getAll(query));
    }

    @ApiOperation(value = "根据id查询人员信息")
    @GetMapping("/{id}")
    public Result<PersonVo> get(@NotNull(message = "id不能为空") @PathVariable(name = "id") Long id, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return Result.failed(bindingResult.getFieldError().getDefaultMessage());
        }
        return Result.success(iPersonService.get(id));
    }

    @ApiOperation(value = "添加人员信息")
    @PostMapping("")
    public Result add(@Valid PersonReq body) {
        iPersonService.add(body);
        return Result.success();
    }

    @ApiOperation(value = "更新人员信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "id", required = true, dataType = "int", paramType = "query")
    })
    @PutMapping("")
    public Result updatePut(@Valid @RequestBody PersonReq body) {
        iPersonService.add(body);
        return Result.success();
    }

    @ApiOperation(value = "更新人员局部信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name", value = "name", required = true, dataType = "String", paramType = "query")
    })
    @PatchMapping("/{name}")
    public Result updatePatch(@NotBlank(message = "name不能为空") @PathVariable("name") String name) {
        iPersonService.updatePatch(name);
        return Result.success();
    }

    @ApiOperation(value = "删除人员信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "id", required = true, dataType = "int", paramType = "query")
    })
    @DeleteMapping("/{id}")
    public Result delete(@NotNull(message = "id不能为空") @PathVariable("id") Long id) {
        iPersonService.delete(id);
        return Result.success();
    }

    @ApiOperation(value = "excel导出")
    @PostMapping("/export")
    public Result export(@NotBlank(message = "Id不能为空") String id, HttpServletResponse response) {
        iPersonService.exportAll(response);
        return Result.success();
    }

    @GetMapping("/test")
    public Object get( String name) {
        return name;
    }
}
