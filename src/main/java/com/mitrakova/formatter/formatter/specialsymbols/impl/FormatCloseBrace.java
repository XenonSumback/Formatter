package com.mitrakova.formatter.formatter.specialsymbols.impl;

import com.mitrakova.formatter.formatter.FormatterException;
import com.mitrakova.formatter.formatter.specialsymbols.Braces;
import com.mitrakova.formatter.formatter.specialsymbols.ISpecialSymbol;
import com.mitrakova.formatter.formatter.specialsymbols.Tabulation;

/**
 * Created by wolf on 27.05.16.
 */
public class FormatCloseBrace  implements ISpecialSymbol {

    public void doSomething(final StringBuffer insert) throws FormatterException {
        Braces.incrementClosedBraces();
        if (Braces.getClosedBraces() > Braces.getOpenedBraces()) {
            throw new FormatterException("Missed open Brace '{'");
        }
        insert.append("}" + "\n");
        for (int tab = 0; tab < Braces.getOpenedBraces() ; tab++) {
            insert.append(Tabulation.tabulate());
        }
    }
}
