package com.mitrakova.formatter.formatter.specialsymbols.impl;

import com.mitrakova.formatter.formatter.FormatterException;
import com.mitrakova.formatter.formatter.StateContainer;
import com.mitrakova.formatter.formatter.lexemes.LexFinder;
import com.mitrakova.formatter.formatter.specialsymbols.Braces;
import com.mitrakova.formatter.formatter.specialsymbols.IHandler;
import com.mitrakova.formatter.formatter.specialsymbols.Tabulation;

/**
 *Implementation for "{" symbols
 */
public class FormatCloseBrace  implements IHandler {

    public void doSomething(StringBuffer insert, StringBuffer lexeme, LexFinder lexFinder, StateContainer stateContainer) throws FormatterException {
        lexFinder.findLex(lexeme, insert, stateContainer);
        Braces.incrementClosedBraces();
        if (Braces.getClosedBraces()>Braces.getOpenedBraces()) {
            throw new FormatterException("Missed open Brace '{'");
        }
        insert.append("}"+"\n");
        for (int tab = 0; tab < Braces.getOpenedBraces() ; tab++){
            insert.append(Tabulation.tabulate());
        }

    }
}
