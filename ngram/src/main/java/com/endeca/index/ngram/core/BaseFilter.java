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
public interface BaseFilter<T> {

    T doFilter(T t);
}
