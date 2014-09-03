/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.endeca.index.ngram.core;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Colin.You
 */
public class CleanEmptySegmentFilter implements SegmentFilter {

    @Override
    public String[] doFilter(String[] source) {
        List<String> reValue = new ArrayList<String>();
        for (String value : source) {
            if (value != null && !value.trim().isEmpty()) {
                reValue.add(value);
            }
        }
        String[] array = new String[reValue.size()];
        reValue.toArray(array);
        return array;
    }

}
