package com.mitrakova.formatter.formatter;

import com.mitrakova.formatter.formatter.separatesymbols.ISeparator;
import com.mitrakova.formatter.formatter.separatesymbols.impl.SeparateEndL;
import com.mitrakova.formatter.formatter.separatesymbols.impl.SeparateSpace;
import com.mitrakova.formatter.formatter.separatesymbols.impl.SeparateTab;
import com.mitrakova.formatter.formatter.specialsymbols.IHandler;
import com.mitrakova.formatter.formatter.specialsymbols.impl.FormatCloseBrace;
import com.mitrakova.formatter.formatter.specialsymbols.impl.FormatOpenBrace;
import com.mitrakova.formatter.formatter.specialsymbols.impl.FormatSemiColon;

import java.util.HashMap;

/**
 * Created by wolf on 02.07.16.
 */
public class FormatSettings implements IFormatSettings {
    private HashMap<Character, IHandler> tableOfSpecialSymbols = new HashMap<Character, IHandler>();
    private HashMap<Character, ISeparator> tableOfSeparateSymbols = new HashMap<Character, ISeparator>();

    public FormatSettings(){
        tableOfSpecialSymbols.put('{', new FormatOpenBrace());
        tableOfSpecialSymbols.put('}', new FormatCloseBrace());
        tableOfSpecialSymbols.put(';', new FormatSemiColon());
        tableOfSeparateSymbols.put(' ', new SeparateSpace());
        tableOfSeparateSymbols.put('\t', new SeparateTab());
        tableOfSeparateSymbols.put('\n', new SeparateEndL());
    }

    public HashMap <Character, IHandler> getSpecialSymbols(){
        return tableOfSpecialSymbols;
    }

    public HashMap <Character, ISeparator> getSeparateSymbols() {
        return tableOfSeparateSymbols;
    }

}
