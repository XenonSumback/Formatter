package com.mitrakova.formatter.formatter.lexemes.impl;

import com.mitrakova.formatter.formatter.StateContainer;
import com.mitrakova.formatter.formatter.lexemes.ILex;

/**
 * Implementation for end of comment lexeme
 */
public class EndOfCommentLexeme implements ILex {
    public void lexemeReaction(StateContainer stateContainer, StringBuffer insert) {
        insert.append("*/"+"\n");

        stateContainer.setInComment(false);

    }
}
