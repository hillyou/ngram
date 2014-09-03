/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.endeca.index.ngram.core;

import java.util.Collection;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 *
 * @author Colin.You
 * @param <T>
 */
public abstract class AbstractFilterChain<T> implements FilterChain<T> {

    // filter chain 
    protected Collection<BaseFilter<T>> filterList = new ConcurrentLinkedQueue<BaseFilter<T>>();

    @Override
    public void addFilter(BaseFilter<T> filter) {
        filterList.add(filter);
    }

    @Override
    public boolean isEmpty() {
        return filterList.isEmpty();
    }

    public Collection<BaseFilter<T>> getFilterList() {
        return filterList;
    }

    public void setFilterList(Collection<BaseFilter<T>> filterList) {
        this.filterList = filterList;
    }

    @Override
    public abstract T processFilter(T t);

}
