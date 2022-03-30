package com.yundasys.beidou.dipper.service.impl;

import com.yundasys.beidou.dipper.common.redis.RedisCache;
import com.yundasys.beidou.dipper.mapper.PersonMapper;
import com.yundasys.beidou.dipper.model.entity.Person;
import com.yundasys.beidou.dipper.service.IPersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.util.List;


@Service
@RequiredArgsConstructor
public class PersonServiceImpl implements IPersonService {
    private final PersonMapper personMapper;
    private final RedisCache redisCache;

    @Override
    public List<Person> getAll() {
        List<Person> list = personMapper.getAllUser();
        redisCache.set("all", list);
        list = redisCache.get("all");
        return list;
    }

    @Override
    public void exportAll(HttpServletResponse response) {
       /* List<PersonExcel> list = new ArrayList<>();
        try {
            ExcelUtils.exportExcel(list, "title", "sheetName", PersonExcel.class, "测试user.xls", response);
        } catch (IOException e) {
            e.printStackTrace();
        }*/
    }
}
