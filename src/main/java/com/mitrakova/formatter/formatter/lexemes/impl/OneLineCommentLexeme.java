package com.mitrakova.formatter.formatter.lexemes.impl;

import com.mitrakova.formatter.formatter.StateContainer;
import com.mitrakova.formatter.formatter.lexemes.ILex;

/**
 * Implementation for one line comment
 */
public class OneLineCommentLexeme implements ILex {
    public void lexemeReaction(StateContainer stateContainer, StringBuffer insert) {
        insert.append("// ");
        stateContainer.setInOneLineComment(true);
    }
}
