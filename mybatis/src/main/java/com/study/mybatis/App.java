package com.study.mybatis;

import com.study.mybatis.mapper.CityMapper;
import com.study.mybatis.model.City;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * Hello world!
 *
 */
public class App {

    public static void main(String[] args) throws IOException {
        assert (true==false);
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession session = sqlSessionFactory.openSession();
        assert session != null;
        CityMapper mapper = new CityMapper();
        List<City> cities = mapper.getAll();
        assert (cities.isEmpty());
        System.out.println(cities.get(0).getCOUNTRY_ISO_CODE());
    }
}
