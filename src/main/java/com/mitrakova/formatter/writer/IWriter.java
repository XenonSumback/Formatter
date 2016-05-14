package com.mitrakova.formatter.writer;



public interface IWriter {
    void write(StringBuffer insert);
    void close() throws WriterException;
}
