package com.mitrakova.formatter.writer;


public class WriterException extends Exception {
    public WriterException(Exception e) {
        initCause(e);
    }
}
