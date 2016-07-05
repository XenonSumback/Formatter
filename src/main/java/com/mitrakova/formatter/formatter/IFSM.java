package com.mitrakova.formatter.formatter;

/**
 * Created by wolf on 04.07.16.
 */
public interface IFSM {
    StringBuffer nextState(char c) throws FormatterException;
}
