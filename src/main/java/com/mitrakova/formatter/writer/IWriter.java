package com.mitrakova.formatter.writer;

import com.mitrakova.formatter.formatter.IFormatter;


public interface IWriter {
    void write(StringBuffer insert) throws WriterException;
    void close() throws WriterException;
}
