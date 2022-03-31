package com.yundasys.beidou.dipper.common.base;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel(value = "查询条件父类")
@Data
public class BaseQuery {
    @ApiModelProperty(value = "页码")
    private Integer page;
    @ApiModelProperty(value = "每页数量")
    private Integer size;
}
