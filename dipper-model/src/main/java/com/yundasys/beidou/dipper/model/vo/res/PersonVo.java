package com.yundasys.beidou.dipper.model.vo.res;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "人员信息")
public class PersonVo {
    @ApiModelProperty(value = "id")
    private Long id;
    @ApiModelProperty(value = "姓名")
    private String name;
    @ApiModelProperty(value = "昵称")
    private String nameN;
    @ApiModelProperty(value = "年龄")
    private Integer age;
}
