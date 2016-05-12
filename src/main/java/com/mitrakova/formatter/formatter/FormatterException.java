package com.mitrakova.formatter.formatter;


public class FormatterException extends Exception {
    public FormatterException(Exception e) {
        initCause(e);
    }
}
