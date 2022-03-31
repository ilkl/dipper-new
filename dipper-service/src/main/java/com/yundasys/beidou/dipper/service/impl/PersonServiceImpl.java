package com.yundasys.beidou.dipper.service.impl;

import com.yundasys.beidou.dipper.common.redis.RedisCache;
import com.yundasys.beidou.dipper.common.utils.ExcelUtils;
import com.yundasys.beidou.dipper.mapper.PersonMapper;
import com.yundasys.beidou.dipper.model.entity.Person;
import com.yundasys.beidou.dipper.model.vo.excel.PersonExcel;
import com.yundasys.beidou.dipper.model.vo.query.PersonQuery;
import com.yundasys.beidou.dipper.model.vo.req.PersonReq;
import com.yundasys.beidou.dipper.model.vo.res.PersonVo;
import com.yundasys.beidou.dipper.service.IPersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@Service
@RequiredArgsConstructor
public class PersonServiceImpl implements IPersonService {
    private final PersonMapper personMapper;
    private final RedisCache redisCache;

    @Override
    public List<PersonVo> getAll(PersonQuery query) {
        List<PersonVo> retList = new ArrayList<>();
        List<Person> list = personMapper.getAllUser();
        list.forEach(o->{
            PersonVo vo = new PersonVo();
            BeanUtils.copyProperties(o, vo);
            retList.add(vo);
        });
        redisCache.set("all", list);
        list = redisCache.get("all");
        return retList;
    }

    @Override
    public PersonVo get(Long id) {
        Person person = personMapper.getOne(id);
        PersonVo vo = new PersonVo();
        BeanUtils.copyProperties(person, vo);
        return vo;
    }

    @Override
    public void add(PersonReq body) {

    }

    @Override
    public void updatePut(PersonReq body) {

    }

    @Override
    public void updatePatch(String name) {

    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public void exportAll(HttpServletResponse response) {
        List<PersonExcel> list = new ArrayList<>();
        try {
            ExcelUtils.exportExcel(list, "title", "sheetName", PersonExcel.class, "测试user.xls", response);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
