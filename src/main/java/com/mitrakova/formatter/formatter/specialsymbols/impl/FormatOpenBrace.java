package com.mitrakova.formatter.formatter.specialsymbols.impl;

import com.mitrakova.formatter.formatter.specialsymbols.Braces;
import com.mitrakova.formatter.formatter.specialsymbols.ISpecialSymbol;
import com.mitrakova.formatter.formatter.specialsymbols.Tabulation;

/**
 *
 */
public class FormatOpenBrace implements ISpecialSymbol {

    public void doSomething(final StringBuffer insert) {
        Braces.incrementOpenedBraces();
        insert.append("{" + "\n");
        for (int tab = 0; tab < Braces.getOpenedBraces() ; tab++) {
            insert.append(Tabulation.tabulate());
        }
    }
}
