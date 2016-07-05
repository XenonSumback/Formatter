package com.mitrakova.formatter.formatter.separatesymbols;

import com.mitrakova.formatter.formatter.StateContainer;
import com.mitrakova.formatter.formatter.lexemes.LexFinder;

/**
 * Interface for Separation symbols
 */
public interface ISeparator {
    void separate(StringBuffer insert, StateContainer stateContainer, LexFinder lexFinder, StringBuffer lexeme);
}
