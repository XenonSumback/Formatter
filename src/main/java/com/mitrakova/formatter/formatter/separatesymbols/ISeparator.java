package com.mitrakova.formatter.formatter.separatesymbols;

import com.mitrakova.formatter.formatter.StateContainer;
import com.mitrakova.formatter.formatter.lexemes.LexFinder;

/**
 * Created by wolf on 28.06.16.
 */
public interface ISeparator {
    void separate(StringBuffer insert, StateContainer stateContainer, LexFinder lexFinder, StringBuffer lexeme);
}
