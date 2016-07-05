package com.mitrakova.formatter.formatter;

import com.mitrakova.formatter.formatter.specialsymbols.Braces;
import com.mitrakova.formatter.reader.IReader;
import com.mitrakova.formatter.reader.ReaderException;
import com.mitrakova.formatter.writer.IWriter;
import com.mitrakova.formatter.writer.WriterException;


public class Formatter implements IFormatter {
    private StringBuffer insert;


    public Formatter() {
        insert = new StringBuffer();
    }

    public void format(IReader reader, IWriter writer, IFSM fsm) throws FormatterException {
        char symbol;
        try {
            while (!reader.isEnd()) {
                symbol = reader.read();
                insert = fsm.nextState(symbol);
                writer.write(insert);
                insert.setLength(0);
            }

        } catch (ReaderException e) {
            throw new FormatterException(e);
        } catch (WriterException e) {
            throw new FormatterException(e);
        }
        Braces.EndOfFormat();

        }
}