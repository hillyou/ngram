/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.endeca.index.ngram.core;

import org.apache.log4j.Logger;

/**
 *
 * @author Colin.You
 */
public class SeperatorSegmentFilter implements SegmentFilter {

    private static final Logger LOG = Logger.getLogger(SeperatorSegmentFilter.class);
    private String seperator = "\\s";

    @Override
    public String[] doFilter(String[] source) {
        String firstEle = source[0];
        return firstEle.split(seperator);
    }

    public String getSeperator() {
        return seperator;
    }

    public void setSeperator(String seperator) {
        this.seperator = seperator;
    }

}
