package com.mitrakova.formatter.reader;

/**
 * Exception for IReader
 */
public class ReaderException extends Exception {
    /**
     * constructor for catch
     * @param e -caught exception
     */
    public ReaderException(final Exception e) {
        initCause(e);
    }

    /**
     * constructor for throw
     * @param s - message
     */
    public ReaderException(final String s) {
        System.err.print(s);
    }
}
