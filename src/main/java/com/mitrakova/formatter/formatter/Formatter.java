package com.mitrakova.formatter.formatter;

import com.mitrakova.formatter.formatter.specialsymbols.Braces;
import com.mitrakova.formatter.formatter.specialsymbols.ISpecialSymbol;
import com.mitrakova.formatter.formatter.specialsymbols.impl.FormatCloseBrace;
import com.mitrakova.formatter.formatter.specialsymbols.impl.FormatEndL;
import com.mitrakova.formatter.formatter.specialsymbols.impl.FormatOpenBrace;
import com.mitrakova.formatter.formatter.specialsymbols.impl.FormatSemiColon;
import com.mitrakova.formatter.reader.IReader;
import com.mitrakova.formatter.reader.ReaderException;
import com.mitrakova.formatter.writer.IWriter;
import com.mitrakova.formatter.writer.WriterException;

import java.util.HashMap;

public class Formatter implements IFormatter {

    private StringBuffer insert = new StringBuffer();

    /**
     * formatter for chars
     * @param reader - initial chars
     * @param writer - write results of formatting
     * @throws FormatterException (include Reader & Writer Exceptions)
     */

    public void format(final IReader reader, final IWriter writer) throws FormatterException {
        char symbol;
        HashMap<Character, ISpecialSymbol> tableOfSpecialSymbols = new HashMap<Character, ISpecialSymbol>();
        tableOfSpecialSymbols.put('{', new FormatOpenBrace());
        tableOfSpecialSymbols.put('}', new FormatCloseBrace());
        tableOfSpecialSymbols.put(';', new FormatSemiColon());
        tableOfSpecialSymbols.put('\n', new FormatEndL());
        try {
            while (!reader.isEnd()) {
                symbol = reader.read();
                if (!tableOfSpecialSymbols.keySet().contains(symbol)) {
                    insert.append(symbol);
                }else {
                    tableOfSpecialSymbols.get(symbol).doSomething(insert);
                }
            }
        } catch (ReaderException e) {
            throw new FormatterException(e);
        }
        if (Braces.getOpenedBraces() != Braces.getClosedBraces()) {
            throw new FormatterException("missed close brace '}'");
        }
        try {
            writer.write(insert);
            } catch (WriterException e) {
                throw new FormatterException(e);
            }
    }
}
