package com.mitrakova.formatter.formatter.lexemes;

import com.mitrakova.formatter.formatter.StateContainer;

/**
 * Interface for key lexemes
 */
public interface ILex {
    void lexemeReaction(StateContainer stateContainer, StringBuffer insert);
}
