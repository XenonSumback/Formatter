package com.mitrakova.formatter.writer.impl.string;

import com.mitrakova.formatter.formatter.IFormatter;
import com.mitrakova.formatter.writer.IWriter;
import com.mitrakova.formatter.writer.WriterException;



public class StringWriter implements IWriter {

    /**
     * Prints to console
     * @param insert - StringBuffer from Formatter
     */

    public void write(StringBuffer insert) {
        System.out.print(insert);
    }

    public void close()  {

    }
}
