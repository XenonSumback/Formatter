package com.mitrakova.formatter.formatter.specialsymbols.impl;

import com.mitrakova.formatter.formatter.StateContainer;
import com.mitrakova.formatter.formatter.lexemes.LexFinder;
import com.mitrakova.formatter.formatter.specialsymbols.Braces;
import com.mitrakova.formatter.formatter.specialsymbols.IHandler;
import com.mitrakova.formatter.formatter.specialsymbols.Tabulation;

/**
 * Created by wolf on 27.05.16.
 */
public class FormatEndL implements IHandler {

    public void doSomething(StringBuffer insert, StringBuffer lexeme, LexFinder lexFinder, StateContainer stateContainer) {
        lexFinder.findLex(lexeme, insert, stateContainer);
        insert.append("\n");
        for (int tab = 0; tab < Braces.getOpenedBraces() ; tab++){
            insert.append(Tabulation.tabulate());
        }
    }
}
