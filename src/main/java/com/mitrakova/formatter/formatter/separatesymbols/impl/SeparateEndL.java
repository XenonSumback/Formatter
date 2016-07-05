package com.mitrakova.formatter.formatter.separatesymbols.impl;

import com.mitrakova.formatter.formatter.StateContainer;
import com.mitrakova.formatter.formatter.lexemes.LexFinder;
import com.mitrakova.formatter.formatter.separatesymbols.ISeparator;
import com.mitrakova.formatter.formatter.specialsymbols.Braces;
import com.mitrakova.formatter.formatter.specialsymbols.Tabulation;

/**
 * Implementation for end line symbol
 */
public class SeparateEndL implements ISeparator {
    public void separate(StringBuffer insert, StateContainer stateContainer, LexFinder lexFinder, StringBuffer lexeme) {
        if (StateContainer.getInFor()){
            stateContainer.setInFor(false);
        }
        if (StateContainer.getInOneLineComment()){
            stateContainer.setInOneLineComment(false);
            insert.append("\n");
            for (int tab = 0; tab < Braces.getOpenedBraces() ; tab++){
                insert.append(Tabulation.tabulate());
            }
        }
        lexFinder.findLex(lexeme, insert, stateContainer);
    }
}
