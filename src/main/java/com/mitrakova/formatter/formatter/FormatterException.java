package com.mitrakova.formatter.formatter;

/**
 * Exception for IFormatter
 */
public class FormatterException extends Exception {
    /**
     * constructor for catch
     * @param e -caught exception
     */
     FormatterException(final Exception e) {
        initCause(e);
    }
    /**
     * constructor for throw
     * @param s - message
     */
    public FormatterException(final String s) {
        System.err.print(s);
    }
}
