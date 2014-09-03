/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.endeca.index.ngram.core;

import java.util.Locale;

/**
 *
 * @author Colin.You
 */
public class LowerCaseSourceFilter implements SourceFilter {

    @Override
    public String doFilter(String source) {
        return source.toLowerCase(Locale.US);
    }

}
