/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.endeca.index.ngram.core;

/**
 *
 * @author Colin.You
 * @param <T>
 */
public interface FilterChain<T> {

    public static final FilterChain EMPTY = new EmptyFilterChain();

    boolean isEmpty();

    void addFilter(BaseFilter<T> filter);

    T processFilter(T t);
}
