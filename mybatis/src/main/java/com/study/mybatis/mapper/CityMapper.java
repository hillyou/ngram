/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.study.mybatis.mapper;

import com.study.mybatis.SessionFactory;
import com.study.mybatis.dao.CityDAO;
import java.util.List;
import com.study.mybatis.model.City;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

/**
 *
 * @author Colin.You
 */
public class CityMapper {

    public List<City> getAll() {
        SqlSessionFactory sqlSessionFactory = SessionFactory.getSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        CityDAO cityDAO = sqlSession.getMapper(CityDAO.class);
        return cityDAO.getAll();
    }

}
