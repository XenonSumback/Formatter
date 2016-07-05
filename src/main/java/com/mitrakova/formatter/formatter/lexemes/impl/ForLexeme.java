package com.mitrakova.formatter.formatter.lexemes.impl;

import com.mitrakova.formatter.formatter.StateContainer;
import com.mitrakova.formatter.formatter.lexemes.ILex;

/**
 * Implementation for "For" statement
 */
public class ForLexeme implements ILex {
    public void lexemeReaction(StateContainer stateContainer, StringBuffer insert) {
        insert.append("for ");
        stateContainer.setInFor(true);

    }
}
