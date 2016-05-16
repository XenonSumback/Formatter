package com.mitrakova.formatter.writer.impl.string;

import com.mitrakova.formatter.formatter.IFormatter;
import com.mitrakova.formatter.writer.IWriter;
import com.mitrakova.formatter.writer.WriterException;

/**
 * write formatted chars to result string
 */

public class StringWriter implements IWriter {

    /**
     * Prints to console
     * @param insert - StringBuffer from Formatter
     */

    public void write(final StringBuffer insert) {
        System.out.print(insert);
    }

}
