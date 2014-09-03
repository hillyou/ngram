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
public class SpaceSourceFilter implements SourceFilter {

    private Token token = new DefaultToken();

    @Override
    public String doFilter(String source) {
        return token.generate(source);
    }

    public void setToken(Token token) {
        this.token = token;
    }

}
