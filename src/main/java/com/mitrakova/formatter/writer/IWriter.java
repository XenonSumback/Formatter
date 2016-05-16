package com.mitrakova.formatter.writer;


/**
 * provides writing of results
 */
public interface IWriter {
    /**
     *
     * @param insert - formatted stringbuffer
     * @throws WriterException -
     */
    void write(StringBuffer insert) throws WriterException;
}
