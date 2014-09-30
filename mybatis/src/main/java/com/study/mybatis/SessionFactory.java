/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.study.mybatis;

import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 *
 * @author Colin.You
 */
public final class SessionFactory {
    private static SqlSessionFactory SQL_SESSION_FACTORY;

    static {
        InputStream inputStream = null;
        try {
            String resource = "mybatis-config.xml";
            inputStream = Resources.getResourceAsStream(resource);
            SQL_SESSION_FACTORY = new SqlSessionFactoryBuilder().build(inputStream);
        } catch (IOException ex) {
            Logger.getLogger(SessionFactory.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (IOException ex) {
                Logger.getLogger(SessionFactory.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private SessionFactory() {
    }

    public static SqlSessionFactory getSessionFactory() {
        return SQL_SESSION_FACTORY;
    }

}
