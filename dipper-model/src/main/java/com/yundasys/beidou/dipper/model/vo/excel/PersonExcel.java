package com.yundasys.beidou.dipper.model.vo.excel;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.Data;

@Data
public
class PersonExcel {
    private Long id;
    @Excel(name = "姓名", width = 20)
    private String name;
    @Excel(name = "昵称", width = 20)
    private String nameN;
    @Excel(name = "年龄")
    private Integer age;
}
