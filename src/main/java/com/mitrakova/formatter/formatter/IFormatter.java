package com.mitrakova.formatter.formatter;

import com.mitrakova.formatter.reader.IReader;
import com.mitrakova.formatter.writer.IWriter;



public interface IFormatter {
    /**
     * Format initial chars according to rules
     * @param reader - get initial chars
     * @param writer - write format chars
     * @throws FormatterException - method Exception
     */
    void format(IReader reader, IWriter writer) throws FormatterException;
}
