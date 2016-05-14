package com.mitrakova.formatter.formatter;

import com.mitrakova.formatter.reader.IReader;
import com.mitrakova.formatter.reader.ReaderException;
import com.mitrakova.formatter.writer.IWriter;
import com.mitrakova.formatter.writer.WriterException;
public class Formatter implements IFormatter {

    private StringBuffer insert;

    public Formatter() {
        insert = new StringBuffer();
    }

    public void format(IReader reader, IWriter writer) throws FormatterException {
        int symbol = 0;
        try {
            for (int i = 0; i < reader.getLen(); i++) {

                symbol = (char) reader.read(i);
                switch (symbol) {
                    case '{':
                        insert.append((char) symbol);
                        insert.append('\n');
                        break;
                    case '}':
                        insert.append((char)symbol);
                        insert.append('\n');
                        break;
                    case ';':
                        insert.append((char)symbol);
                        insert.append('\n');
                        break;
                    case '=':
                        insert.append(" = ");
                        break;
                    default:
                        insert.append((char)symbol);
                        break;
                }
            }
        } catch (ReaderException e) {
            throw new FormatterException(e);
        }
        try {
            writer.write(insert);
        } catch (WriterException e) {
            throw new FormatterException(e);
        }
    }
}