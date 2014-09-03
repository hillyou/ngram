/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.endeca.index.ngram.core;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.log4j.Logger;

/**
 *
 * @author Colin.You
 */
public class GramValueCombineFilter implements GramFilter {

    private static final Logger LOG = Logger.getLogger(GramValueCombineFilter.class);
    private int minThreshold = 2;
    private int maxThreshold = 100000;

    @Override
    public List<GramValue> doFilter(List<GramValue> gramValues) {
        List<GramValue> uniqValues = new ArrayList<GramValue>(gramValues.size());
        for (GramValue gramValue : gramValues) {
            if (uniqValues.indexOf(gramValue) >= 0) {
                GramValue uniq = uniqValues.get(uniqValues.indexOf(gramValue));
                uniq.increaseCount(gramValue.getCount());
            } else {
                uniqValues.add(gramValue.copy());
            }
        }
        boolean gotoFilter = false;
        if (minThreshold > 0 && maxThreshold > 0 && minThreshold < maxThreshold) {
            gotoFilter = true;
        } else if (minThreshold > 0) {
            gotoFilter = true;
        } else if (maxThreshold > 0) {
            gotoFilter = true;
        }
        if (gotoFilter) {
            for (Iterator<GramValue> iterator = uniqValues.iterator(); iterator.hasNext();) {
                GramValue gramValue = iterator.next();
                if ((minThreshold > 0 && gramValue.getCount() <= minThreshold) || (maxThreshold > 0 && gramValue.getCount() >= maxThreshold)) {
                    iterator.remove();
                }
            }
        }
        return new ArrayList(uniqValues);
    }

    public int getMinThreshold() {
        return minThreshold;
    }

    public void setMinThreshold(int minThreshold) {
        this.minThreshold = minThreshold;
    }

    public int getMaxThreshold() {
        return maxThreshold;
    }

    public void setMaxThreshold(int maxThreshold) {
        this.maxThreshold = maxThreshold;
    }

}
