package com.mitrakova.formatter.writer;

/**
 * Exception for IWriter.
 */
public class WriterException extends Exception {
    /**
     * constructor
     * @param e - Exception
     */
    public WriterException(final Exception e) {
        initCause(e);
    }
}
