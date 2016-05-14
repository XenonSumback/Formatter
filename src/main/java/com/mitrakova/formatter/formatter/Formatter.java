package com.mitrakova.formatter.formatter;

import com.mitrakova.formatter.reader.IReader;
import com.mitrakova.formatter.reader.ReaderException;
import com.mitrakova.formatter.writer.IWriter;
import com.mitrakova.formatter.writer.WriterException;

public class Formatter implements IFormatter {

    private StringBuffer insert = new StringBuffer();

    /**
     * formatter for chars
     * @param reader - initial chars
     * @param writer - write results of formatting
     * @throws FormatterException (include Reader & Writer Exceptions)
     */

    public void format(final IReader reader, final IWriter writer) throws FormatterException {
        int symbol;

        try {
            for (int i = 0; i < reader.getLen(); i++) {
                symbol = (char) reader.read(i);
                switch (symbol) {
                    case '{':
                        insert.append((char) symbol);
                        insert.append('\n');
                        break;
                    case '}':
                        insert.append((char) symbol);
                        insert.append('\n');
                        break;
                    case ';':
                        insert.append((char) symbol);
                        insert.append('\n');
                        break;
                    case '=':
                        insert.append(" = ");
                        break;
                    default:
                        insert.append((char) symbol);
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