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
public abstract class AbstractFilterGenerator implements Generator {

    private static final Logger LOG = Logger.getLogger(AbstractFilterGenerator.class);
    private GramConfig gramConfig;
    private FilterChain<String> sourceFilterChain = FilterChain.EMPTY;
    private FilterChain<String[]> segmentFilterChain = FilterChain.EMPTY;
    private FilterChain<List<GramValue>> gramFilterChain = FilterChain.EMPTY;
    private FilterChain<List<GramValue>> combineFilterChain = FilterChain.EMPTY;

    @Override
    public List<GramValue> generate(String source) {
        List<GramValue> reValue = new ArrayList<GramValue>();
        int[] dimensions = gramConfig.getDimensions();
        String filterSource = source.trim();
        if (!sourceFilterChain.isEmpty()) {
            filterSource = sourceFilterChain.processFilter(filterSource);
        }
        String[] sourceArray = new String[]{filterSource};
        String[] filterSourceArray = sourceArray;
        if (!segmentFilterChain.isEmpty()) {
            filterSourceArray = segmentFilterChain.processFilter(filterSourceArray);
        }
        for (int dimension : dimensions) {
            if (dimension > filterSourceArray.length) {
                break;
            }
            List<GramValue> filterValue = getGramPerDimension(dimension, filterSourceArray);
            if (!gramFilterChain.isEmpty() && !filterValue.isEmpty()) {
                filterValue = gramFilterChain.processFilter(filterValue);
            }
            reValue.addAll(filterValue);
        }
        if (!combineFilterChain.isEmpty() && !reValue.isEmpty()) {
            reValue = combineFilterChain.processFilter(reValue);
        }
        return reValue;
    }

    public GramConfig getGramConfig() {
        return gramConfig;
    }

    public void setGramConfig(GramConfig gramConfig) {
        this.gramConfig = gramConfig;
    }

    public FilterChain<String> getSourceFilterChain() {
        return sourceFilterChain;
    }

    public void setSourceFilterChain(FilterChain<String> sourceFilterChain) {
        this.sourceFilterChain = sourceFilterChain;
    }

    public FilterChain<String[]> getSegmentFilterChain() {
        return segmentFilterChain;
    }

    public void setSegmentFilterChain(FilterChain<String[]> segmentFilterChain) {
        this.segmentFilterChain = segmentFilterChain;
    }

    public FilterChain<List<GramValue>> getGramFilterChain() {
        return gramFilterChain;
    }

    public void setGramFilterChain(FilterChain<List<GramValue>> gramFilterChain) {
        this.gramFilterChain = gramFilterChain;
    }

    public FilterChain<List<GramValue>> getCombineFilterChain() {
        return combineFilterChain;
    }

    public void setCombineFilterChain(FilterChain<List<GramValue>> combineFilterChain) {
        this.combineFilterChain = combineFilterChain;
    }

    public abstract List<GramValue> getGramPerDimension(int dimension, String[] sourceArray);

}
