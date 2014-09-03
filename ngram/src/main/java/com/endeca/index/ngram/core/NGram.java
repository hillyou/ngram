/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.endeca.index.ngram.core;

import java.util.List;

/**
 *
 * @author Colin.You
 */
public interface NGram {
    
    List<GramValue> getGrams(String source); 
    
}
