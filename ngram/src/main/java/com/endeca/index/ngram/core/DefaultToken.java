/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.endeca.index.ngram.core;

import org.apache.log4j.Logger;
import com.endeca.index.ngram.java.CharacterData;

/**
 *
 * @author Colin.You
 */
public class DefaultToken implements Token {

    private static final Logger LOG = Logger.getLogger(DefaultToken.class);
    private static final String ONE_SPACE = " ";
    private static final String MULTI_SPACE_REGEX = "\\s+";
    private final String seperator = MULTI_SPACE_REGEX;

    @Override
    public String generate(String source) {
        StringBuilder tokens = new StringBuilder();
        String noSpaceSource = source.trim().replaceAll(seperator, ONE_SPACE);
        for (int i = 0; i < noSpaceSource.length(); i++) {
            char c = noSpaceSource.charAt(i);
            boolean isIdeographic = CharacterData.of(c).isIdeographic(c);
            if (isIdeographic) {
                tokens.append(ONE_SPACE);
                tokens.append(c);
            } else if (Character.isLetterOrDigit(c) || Character.isSpaceChar(c)) {
                tokens.append(c);
            }
        }
        LOG.debug(tokens.toString().trim().replaceAll(ONE_SPACE, "."));
        return tokens.toString().trim().replaceAll(MULTI_SPACE_REGEX, ONE_SPACE);

    }
}
