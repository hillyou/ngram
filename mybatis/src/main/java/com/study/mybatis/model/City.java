/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.study.mybatis.model;

import java.io.Serializable;

/**
 *
 * @author Colin.You
 */
public class City implements Serializable {

    private int CITY_ID;
    private String CITY_NAME, COUNTRY, AIRPORT, LANGUAGE, COUNTRY_ISO_CODE;

    public int getCITY_ID() {
        return CITY_ID;
    }

    public void setCITY_ID(int CITY_ID) {
        this.CITY_ID = CITY_ID;
    }

    public String getCITY_NAME() {
        return CITY_NAME;
    }

    public void setCITY_NAME(String CITY_NAME) {
        this.CITY_NAME = CITY_NAME;
    }

    public String getCOUNTRY() {
        return COUNTRY;
    }

    public void setCOUNTRY(String COUNTRY) {
        this.COUNTRY = COUNTRY;
    }

    public String getAIRPORT() {
        return AIRPORT;
    }

    public void setAIRPORT(String AIRPORT) {
        this.AIRPORT = AIRPORT;
    }

    public String getLANGUAGE() {
        return LANGUAGE;
    }

    public void setLANGUAGE(String LANGUAGE) {
        this.LANGUAGE = LANGUAGE;
    }

    public String getCOUNTRY_ISO_CODE() {
        return COUNTRY_ISO_CODE;
    }

    public void setCOUNTRY_ISO_CODE(String COUNTRY_ISO_CODE) {
        this.COUNTRY_ISO_CODE = COUNTRY_ISO_CODE;
    }

}
