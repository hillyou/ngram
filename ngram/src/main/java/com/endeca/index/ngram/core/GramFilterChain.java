/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.endeca.index.ngram.core;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.apache.log4j.Logger;

/**
 *
 * @author Colin.You
 */
public class GramFilterChain extends AbstractFilterChain<List<GramValue>> {

    private static final Logger LOG = Logger.getLogger(GramFilterChain.class);

    @Override
    public List<GramValue> processFilter(List<GramValue> gramValues) {
        BaseFilter<List<GramValue>> filter;
        List<GramValue> cleanValues = gramValues;
        // apply filters
        Iterator<BaseFilter<List<GramValue>>> filters = filterList.iterator();
        while (filters.hasNext()) {
            if (cleanValues == null || cleanValues.isEmpty()) {
                break;
            }
            filter = filters.next();
            // pass source string through various filters
            List<GramValue> input = Collections.unmodifiableList(cleanValues);
            cleanValues = filter.doFilter(input);
        }
        return cleanValues;
    }

}
