/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.endeca.index.ngram.core;

import java.util.concurrent.atomic.AtomicLong;

/**
 *
 * @author Colin.You
 */
public class GramValue {

    private final AtomicLong count;
    private final String source;

    public GramValue(String source) {
        this.source = source;
        this.count = new AtomicLong(1);
    }

    public GramValue(String source, long count) {
        this.source = source;
        this.count = new AtomicLong(count);
    }

    public GramValue copy() {
        return new GramValue(this.getSource(), this.getCount());
    }

    public long increaseCount() {
        return count.addAndGet(1);
    }

    public long increaseCount(long delta) {
        return count.addAndGet(delta);
    }

    public long getCount() {
        return count.get();
    }

    public String getSource() {
        return source;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 11 * hash + (this.source != null ? this.source.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final GramValue other = (GramValue) obj;
        return this.source.equals(other.source);
    }

    @Override
    public String toString() {
        return "GramValue{" + "source=" + source + ", count=" + count + '}';
    }

}
