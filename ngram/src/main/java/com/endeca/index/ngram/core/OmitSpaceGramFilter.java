/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.endeca.index.ngram.core;

import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;

/**
 *
 * @author Colin.You
 */
public class OmitSpaceGramFilter implements GramFilter {

    private static final Logger LOG = Logger.getLogger(OmitSpaceGramFilter.class);
    private static final String SPACE = " ";
    private final String seperator = "\\s+";

    @Override
    public List<GramValue> doFilter(List<GramValue> gramValues) {
        List<GramValue> reValue = new ArrayList<GramValue>(gramValues.size());
        for (GramValue gramValue : gramValues) {
            StringBuilder noSpaceValue = new StringBuilder();
            String source = gramValue.getSource();
            String[] elements = source.split(seperator);
            for (String element : elements) {
                LOG.debug("'" + element + "' length is " + element.length());
                if (element.length() > 1) {
                    noSpaceValue.append(SPACE);
                }
                noSpaceValue.append(element);
                if (element.length() > 1) {
                    noSpaceValue.append(SPACE);
                }
            }
            reValue.add(new GramValue(noSpaceValue.toString().replaceAll(seperator, SPACE).trim()));
        }
        return reValue;
    }

}
