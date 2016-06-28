package com.mitrakova.formatter.formatter.lexemes.impl;

import com.mitrakova.formatter.formatter.StateContainer;
import com.mitrakova.formatter.formatter.lexemes.ILex;

/**
 * Created by wolf on 29.06.16.
 */
public class OneLineCommentLexeme implements ILex {
    public void lexemeReaction(StateContainer stateContainer, StringBuffer insert) {
        insert.append("//");
        stateContainer.setInOneLineComment(true);
    }
}
