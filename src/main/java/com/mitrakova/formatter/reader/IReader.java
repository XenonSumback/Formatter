package com.mitrakova.formatter.reader;

/**
 * Created by wolf on 22.04.16.
 */
public interface IReader{
    int read(int index) throws ReaderException;
    int getLen() throws ReaderException;
    void close() throws ReaderException;
}
