package com.yundasys.beidou.dipper.mapper;

import com.yundasys.beidou.dipper.model.entity.Person;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PersonMapper {
    List<Person> getAllUser();
    Person getOne(@Param("id") Long id);
}
