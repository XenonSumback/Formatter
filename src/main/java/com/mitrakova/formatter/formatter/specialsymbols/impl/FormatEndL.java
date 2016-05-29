package com.mitrakova.formatter.formatter.specialsymbols.impl;

import com.mitrakova.formatter.formatter.specialsymbols.Braces;
import com.mitrakova.formatter.formatter.specialsymbols.ISpecialSymbol;
import com.mitrakova.formatter.formatter.specialsymbols.Tabulation;

/**
 * Created by wolf on 27.05.16.
 */
public class FormatEndL implements ISpecialSymbol {

    public void doSomething(final StringBuffer insert) {
        insert.append("\n");
        for (int tab = 0; tab < Braces.getOpenedBraces() ; tab++) {
            insert.append(Tabulation.tabulate());
        }
    }
}
