package com.mitrakova.formatter.formatter;

import com.mitrakova.formatter.reader.IReader;
import com.mitrakova.formatter.reader.ReaderException;
import com.mitrakova.formatter.writer.IWriter;
import com.mitrakova.formatter.writer.WriterException;

public class Formatter implements IFormatter {

    private StringBuffer insert = new StringBuffer();
    private String tabulation = "    ";
    /**
     * formatter for chars
     * @param reader - initial chars
     * @param writer - write results of formatting
     * @throws FormatterException (include Reader & Writer Exceptions)
     */

    public void format(final IReader reader, final IWriter writer) throws FormatterException {
        int openedBraces = 0;
        int closedBraces = 0;
        char symbol;
        try {
            while (!reader.isEnd()) {
                symbol = reader.read();
                switch (symbol) {
                    case '{':
                        openedBraces++;
                        insert.append(symbol);
                        insert.append('\n');
                        for (int tab = 0; tab < openedBraces; tab++) {
                            insert.append(tabulation);
                        }
                        break;
                    case '}':
                        if (openedBraces < closedBraces) {
                            throw new FormatterException("Missed open Brace '{'");
                        }
                        openedBraces--;
                        insert.append(symbol);
                        insert.append('\n');
                        for (int tab = 0; tab < openedBraces; tab++) {
                            insert.append(tabulation);
                        }
                        break;
                    case ';':
                        insert.append(symbol);
                        insert.append('\n');
                        for (int tab = 0; tab < openedBraces; tab++) {
                            insert.append(tabulation);
                        }
                        break;
                    case '\n':
                        insert.append("");
                        for (int tab = 0; tab < openedBraces; tab++) {
                            insert.append(tabulation);
                        }
                        break;
                    default:
                        insert.append(symbol);
                        break;
                }
            }
        } catch (ReaderException e) {
            throw new FormatterException(e);
        }
        if (openedBraces != closedBraces) {
            throw new FormatterException("missed close brace '}'");
        }
        try {
            writer.write(insert);
            } catch (WriterException e) {
                throw new FormatterException(e);
            }


    }
}