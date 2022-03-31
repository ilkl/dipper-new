package com.yundasys.beidou.dipper.model.vo.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@ApiModel(value = "请求实体")
public class PersonReq {
    @ApiModelProperty(value = "主键id", hidden = true)
    private Long id;
    @ApiModelProperty(value = "姓名", required = true)
    @NotBlank(message = "姓名不能为空")
    private String name;
    @ApiModelProperty(value = "昵称")
    private String nameN;
    @ApiModelProperty(value = "年龄", required = true)
    @NotNull(message = "年龄不能为空")
    private Integer age;
    @ApiModelProperty(value = "邮箱", required = true)
    @NotBlank(message = "邮箱不能为空")
    @Email(message = "邮箱格式不正确")
    private String email;
}
