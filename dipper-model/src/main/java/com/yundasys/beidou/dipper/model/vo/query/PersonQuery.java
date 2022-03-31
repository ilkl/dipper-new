package com.yundasys.beidou.dipper.model.vo.query;

import com.yundasys.beidou.dipper.common.base.BaseQuery;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel(value = "查询条件")
@Data
public class PersonQuery extends BaseQuery {
    @ApiModelProperty(value = "姓名")
    private String name;
}
