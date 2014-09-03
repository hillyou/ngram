/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.endeca.index.ngram.core;

/**
 *
 * @author Colin.You
 */
public final class EmptyFilterChain extends AbstractFilterChain {

    @Override
    public boolean isEmpty() {
        return true;
    }

    @Override
    public Object processFilter(Object t) {
        throw new UnsupportedOperationException("Empty Chain not support this operation");
    }

    @Override
    public void addFilter(BaseFilter filter) {
        throw new UnsupportedOperationException("Empty Chain not support this operation");
    }

}
