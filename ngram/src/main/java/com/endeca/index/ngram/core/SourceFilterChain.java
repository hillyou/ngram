/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.endeca.index.ngram.core;

import java.util.Iterator;
import org.apache.log4j.Logger;

/**
 *
 * @author Colin.You
 */
public class SourceFilterChain extends AbstractFilterChain<String> {

    private static final Logger LOG = Logger.getLogger(SourceFilterChain.class);

    @Override
    public String processFilter(String source) {
        BaseFilter<String> filter;
        String cleanValue = source;
        // apply filters
        Iterator<BaseFilter<String>> filters = filterList.iterator();
        while (filters.hasNext()) {
            if (cleanValue == null || cleanValue.trim().isEmpty()) {
                break;
            }
            filter = filters.next();
            // pass source string through various filters
            cleanValue = filter.doFilter(cleanValue);
        }
        return cleanValue;
    }
}
