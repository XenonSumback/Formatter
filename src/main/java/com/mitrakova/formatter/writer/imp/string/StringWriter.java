package com.mitrakova.formatter.writer.imp.string;

import com.mitrakova.formatter.writer.IWriter;


public class StringWriter implements IWriter {
    public void write(StringBuffer insert) {
        System.out.print(insert);
    }

    public void close() {

    }
}
