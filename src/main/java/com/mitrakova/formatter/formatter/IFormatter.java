package com.mitrakova.formatter.formatter;

import com.mitrakova.formatter.reader.IReader;
import com.mitrakova.formatter.writer.IWriter;


public interface IFormatter {
    void format(IReader reader, IWriter writer);
}
