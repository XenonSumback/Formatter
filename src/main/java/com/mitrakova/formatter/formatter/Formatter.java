package com.mitrakova.formatter.formatter;

import com.mitrakova.formatter.formatter.lexemes.*;
import com.mitrakova.formatter.formatter.separatesymbols.ISeparator;
import com.mitrakova.formatter.formatter.specialsymbols.Braces;
import com.mitrakova.formatter.formatter.specialsymbols.IHandler;
import com.mitrakova.formatter.reader.IReader;
import com.mitrakova.formatter.reader.ReaderException;
import com.mitrakova.formatter.writer.IWriter;
import com.mitrakova.formatter.writer.WriterException;

import java.util.HashMap;


public class Formatter implements IFormatter {
    private StringBuffer insert;
    StringBuffer lexeme;
    HashMap <Character, IHandler> tableOfSpecialSymbols;
    HashMap <Character, ISeparator> tableOfSeparateSymbols;
    StateContainer stateContainer;
    LexFinder lexFinder;

    public Formatter(IFormatSettings FormatSettings) {
        insert = new StringBuffer();
        lexeme = new StringBuffer();
        stateContainer = new StateContainer();
        lexFinder = new LexFinder();
        tableOfSeparateSymbols = FormatSettings.getSeparateSymbols();
        tableOfSpecialSymbols = FormatSettings.getSpecialSymbols();
    }

    public void format(IReader reader, IWriter writer, IFormatSettings formatSettings) throws FormatterException {
        char symbol;
        try {
            while (!reader.isEnd()) {
                symbol = reader.read();
                if (tableOfSeparateSymbols.get(symbol) != null) {
                    tableOfSeparateSymbols.get(symbol).separate(insert, stateContainer, lexFinder, lexeme);
                }else{
                    if (tableOfSpecialSymbols.get(symbol) != null) {
                        tableOfSpecialSymbols.get(symbol).doSomething(insert, lexeme, lexFinder, stateContainer );
                    } else {
                        lexeme.append(symbol);
                    }
                }
            }
            if (Braces.getOpenedBraces() != Braces.getClosedBraces()) {
                throw new FormatterException("missed close brace '}'");
            }
        } catch (ReaderException e) {
            throw new FormatterException(e);
        }
        Braces.EndOfFormat();
            try {
                writer.write(insert);
            } catch (WriterException e) {
                throw new FormatterException(e);
            }
        }
}