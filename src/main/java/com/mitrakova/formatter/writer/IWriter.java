package com.mitrakova.formatter.writer;



public interface IWriter {
    void write(StringBuffer insert) throws WriterException;
    void close() throws WriterException;
}
