package com.yundasys.beidou.dipper.service;

import com.yundasys.beidou.dipper.model.vo.query.PersonQuery;
import com.yundasys.beidou.dipper.model.vo.req.PersonReq;
import com.yundasys.beidou.dipper.model.vo.res.PersonVo;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

public interface IPersonService {
    /**
     * 查询所有
     * @param query 查询条件
     * @return
     */
    List<PersonVo> getAll(PersonQuery query);

    /**
     * 根据id查询
     * @param id
     * @return
     */
    PersonVo get(Long id);

    /**
     *  添加
     * @param body
     */
    void add(PersonReq body);

    /**
     * 全部更新
     * @param body
     */
    void updatePut(PersonReq body);

    /**
     * 局部更新
     * @param name
     */
    void updatePatch(String name);

    /**
     * 删除
     * @param id
     */
    void delete(Long id);

    /**
     * 导出excel
     * @param response
     */
    void exportAll(HttpServletResponse response);
}
