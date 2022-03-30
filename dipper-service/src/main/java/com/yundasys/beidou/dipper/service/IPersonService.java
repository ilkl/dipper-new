package com.yundasys.beidou.dipper.service;

import com.yundasys.beidou.dipper.model.entity.Person;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

public interface IPersonService {
    List<Person> getAll();

    void exportAll(HttpServletResponse response);
}
