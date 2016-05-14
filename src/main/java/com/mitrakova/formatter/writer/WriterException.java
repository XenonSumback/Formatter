package com.mitrakova.formatter.writer;

/**
 * Created by wolf on 23.04.16.
 */
public class WriterException extends Exception {
    public WriterException(Exception e) {
        initCause(e);
    }
}
