package com.mitrakova.formatter.formatter.specialsymbols.impl;

import com.mitrakova.formatter.formatter.FormatterException;
import com.mitrakova.formatter.formatter.StateContainer;
import com.mitrakova.formatter.formatter.lexemes.LexFinder;
import com.mitrakova.formatter.formatter.specialsymbols.IHandler;

/**
 * Created by wolf on 28.06.16.
 */
public class FormatFor implements IHandler {
    public void doSomething(StringBuffer insert, StringBuffer lexeme, LexFinder lexFinder, StateContainer stateContainer) throws FormatterException {
        lexFinder.findLex(lexeme, insert, stateContainer);

    }
}
