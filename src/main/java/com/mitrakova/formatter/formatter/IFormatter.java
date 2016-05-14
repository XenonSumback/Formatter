package com.mitrakova.formatter.formatter;

import com.mitrakova.formatter.reader.IReader;
import com.mitrakova.formatter.writer.IWriter;


/**
 * Created by wolf on 23.04.16.
 */
public interface IFormatter {
    void format(IReader reader, IWriter writer) throws FormatterException;
}
