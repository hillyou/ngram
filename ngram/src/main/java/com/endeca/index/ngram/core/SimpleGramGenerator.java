/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.endeca.index.ngram.core;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.apache.log4j.Logger;

/**
 *
 * @author Colin.You
 */
public class SimpleGramGenerator extends AbstractFilterGenerator {

    private static final Logger LOG = Logger.getLogger(SimpleGramGenerator.class);
    private static final String SPACE = " ";

    @Override
    public List<GramValue> getGramPerDimension(int dimension, String[] sourceArray) {
        if (sourceArray.length < dimension) {
            return Collections.EMPTY_LIST;
        }
        List<GramValue> reValue = new ArrayList<GramValue>(sourceArray.length + 1 - dimension);
        for (int i = 0; i + dimension <= sourceArray.length; i++) {
            StringBuilder gramValue = new StringBuilder();
            for (int j = i; j < i + dimension; j++) {
                gramValue.append(sourceArray[j]);
                gramValue.append(SPACE);
            }
            reValue.add(new GramValue(gramValue.toString().trim()));
        }
        return reValue;
    }

//    public static void main(String[] args) {
//        DimensionParser parser = new DefaultDimensionParser("2-7");
//        GramConfig config = new GramConfig();
//        config.setParser(parser);
//        SimpleGramGenerator genernator = new SimpleGramGenerator();
//        genernator.setGramConfig(config);
//
//        FilterChain sourceChain = new SourceFilterChain();
//        sourceChain.addFilter(new LowerCaseSourceFilter());
//        sourceChain.addFilter(new SpaceSourceFilter());
//        FilterChain filterChain = new SegmentFilterChain();
//        filterChain.addFilter(new SeperatorSegmentFilter());
//        filterChain.addFilter(new CleanEmptySegmentFilter());
//        FilterChain gramChain = new GramFilterChain();
//        gramChain.addFilter(new OmitSpaceGramFilter());
//        FilterChain combineChain = new GramFilterChain();
//        combineChain.addFilter(new GramValueCombineFilter());
//        genernator.setSourceFilterChain(sourceChain);
//        genernator.setSegmentFilterChain(filterChain);
//        genernator.setGramFilterChain(gramChain);
//        genernator.setCombineFilterChain(combineChain);
//        List<GramValue> gramValues = genernator.generate("sont susceptibles d'être annulés sans préavis sont susceptibles d'être annulés sans préavis");
//        for (GramValue gramValue : gramValues) {
//            System.out.println(gramValue);
//        }
//    }

}
