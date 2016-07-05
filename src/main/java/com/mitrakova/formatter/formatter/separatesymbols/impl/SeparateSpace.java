package com.mitrakova.formatter.formatter.separatesymbols.impl;

import com.mitrakova.formatter.formatter.StateContainer;
import com.mitrakova.formatter.formatter.lexemes.LexFinder;
import com.mitrakova.formatter.formatter.separatesymbols.ISeparator;

/**
 * Implementation for space symbol
 */
public class SeparateSpace implements ISeparator {

    public void separate(StringBuffer insert, StateContainer stateContainer, LexFinder lexFinder, StringBuffer lexeme) {
        lexFinder.findLex(lexeme, insert, stateContainer);
    }
}
