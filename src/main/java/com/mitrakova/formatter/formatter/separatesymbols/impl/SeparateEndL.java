package com.mitrakova.formatter.formatter.separatesymbols.impl;

import com.mitrakova.formatter.formatter.StateContainer;
import com.mitrakova.formatter.formatter.lexemes.LexFinder;
import com.mitrakova.formatter.formatter.separatesymbols.ISeparator;

/**
 * Created by wolf on 28.06.16.
 */
public class SeparateEndL implements ISeparator {
    public void separate(StringBuffer insert, StateContainer stateContainer, LexFinder lexFinder, StringBuffer lexeme) {
        if (StateContainer.getInFor()){
            stateContainer.setInFor(false);
        }
        if (StateContainer.getInOneLineComment()){
            stateContainer.setInOneLineComment(false);
        }
        lexFinder.findLex(lexeme, insert, stateContainer);
    }
}
