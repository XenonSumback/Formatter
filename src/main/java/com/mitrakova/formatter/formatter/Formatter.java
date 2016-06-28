package com.mitrakova.formatter.formatter;

import com.mitrakova.formatter.formatter.lexemes.*;
import com.mitrakova.formatter.formatter.separatesymbols.ISeparator;
import com.mitrakova.formatter.formatter.separatesymbols.impl.SeparateEndL;
import com.mitrakova.formatter.formatter.separatesymbols.impl.SeparateSpace;
import com.mitrakova.formatter.formatter.separatesymbols.impl.SeparateTab;
import com.mitrakova.formatter.formatter.specialsymbols.Braces;
import com.mitrakova.formatter.formatter.specialsymbols.IHandler;
import com.mitrakova.formatter.formatter.specialsymbols.impl.FormatCloseBrace;
import com.mitrakova.formatter.formatter.specialsymbols.impl.FormatOpenBrace;
import com.mitrakova.formatter.formatter.specialsymbols.impl.FormatSemiColon;
import com.mitrakova.formatter.reader.IReader;
import com.mitrakova.formatter.reader.ReaderException;
import com.mitrakova.formatter.writer.IWriter;
import com.mitrakova.formatter.writer.WriterException;

import java.util.HashMap;


public class Formatter implements IFormatter {
    private StringBuffer insert;
    StringBuffer lexeme;
    private HashMap<Character, IHandler> tableOfSpecialSymbols;
    private HashMap<Character, ISeparator> tableOfSeparatelSymbols;
    StateContainer stateContainer;
    LexFinder lexFinder;

    public Formatter() {
        insert = new StringBuffer();
        lexeme = new StringBuffer();
        stateContainer = new StateContainer();
        lexFinder = new LexFinder();
        tableOfSpecialSymbols = new HashMap<Character, IHandler>();
        tableOfSpecialSymbols.put('{', new FormatOpenBrace());
        tableOfSpecialSymbols.put('}', new FormatCloseBrace());
        tableOfSpecialSymbols.put(';', new FormatSemiColon());
        tableOfSeparatelSymbols = new HashMap<Character, ISeparator>();
        tableOfSeparatelSymbols.put(' ', new SeparateSpace());
        tableOfSeparatelSymbols.put('\t', new SeparateTab());
        tableOfSeparatelSymbols.put('\n', new SeparateEndL());

    }

    public void format(IReader reader, IWriter writer) throws FormatterException {
        char symbol;
        try {
            while (!reader.isEnd()) {
                symbol = reader.read();
                if (tableOfSeparatelSymbols.get(symbol) != null) {
                    tableOfSeparatelSymbols.get(symbol).separate(insert, stateContainer, lexFinder, lexeme);
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