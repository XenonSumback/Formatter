package com.mitrakova.formatter.formatter.lexemes;

import com.mitrakova.formatter.formatter.StateContainer;

/**
 * Created by wolf on 29.06.16.
 */
public interface ILex {
    void lexemeReaction(StateContainer stateContainer, StringBuffer insert);
}
