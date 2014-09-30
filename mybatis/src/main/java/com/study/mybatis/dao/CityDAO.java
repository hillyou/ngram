/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.study.mybatis.dao;

import java.util.List;
import com.study.mybatis.model.City;

/**
 *
 * @author Colin.You
 */
public interface CityDAO {

    public List<City> getAll();
}
