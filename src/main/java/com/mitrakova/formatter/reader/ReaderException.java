package com.mitrakova.formatter.reader;

/**
 * Created by wolf on 23.04.16.
 */
public class ReaderException extends Exception {
            public ReaderException(Exception e){
                initCause(e);
            }
}
