package com.mitrakova.formatter.formatter;

/**
 * Created by wolf on 23.04.16.
 */
public class FormatterException extends Exception {
    public FormatterException(Exception e) {
        initCause(e);
    }
}
