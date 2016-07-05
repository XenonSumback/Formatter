package com.mitrakova.formatter.formatter.separatesymbols.impl;

import com.mitrakova.formatter.formatter.StateContainer;
import com.mitrakova.formatter.formatter.lexemes.LexFinder;
import com.mitrakova.formatter.formatter.separatesymbols.ISeparator;

/**
 * Implementation for tabulation symbol
 */
public class SeparateTab implements ISeparator {
    public void separate(StringBuffer insert, StateContainer stateContainer, LexFinder lexFinder, StringBuffer lexeme) {
        lexFinder.findLex(lexeme, insert, stateContainer);
    }
}
