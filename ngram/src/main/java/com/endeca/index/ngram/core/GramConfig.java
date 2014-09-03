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
public class GramConfig {

    private DimensionParser parser;

    public DimensionParser getParser() {
        return parser;
    }

    public void setParser(DimensionParser parser) {
        this.parser = parser;
    }

    public int[] getDimensions() {
        return parser.getDimensions();
    }

}
