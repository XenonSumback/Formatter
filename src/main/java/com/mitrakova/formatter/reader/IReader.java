package com.mitrakova.formatter.reader;

/**
 * Interface for reading chars from stream
 */
public interface IReader {
    /**
     *
     * @return char from stream
     * @throws ReaderException
     */
    char read() throws ReaderException;

    /**
     * check the end of chain
     * @return - true if reached end of stream
     */
    boolean isEnd();
}
