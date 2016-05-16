package com.mitrakova.formatter.reader;

/**
 * Created by wolf on 22.04.16.
 */
public interface IReader{
    /**
     *
     * @return char from stream
     * @throws ReaderException
     */
    char read() throws ReaderException;

    /**
     * close the stream
     * @throws ReaderException
     */
    void close() throws ReaderException;

    /**
     * check the end of chain
     * @return -
     */
    boolean isEnd();
}
