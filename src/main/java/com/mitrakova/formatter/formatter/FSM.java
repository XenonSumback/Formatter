package com.mitrakova.formatter.formatter;

import com.mitrakova.formatter.formatter.lexemes.LexFinder;
import com.mitrakova.formatter.formatter.separatesymbols.ISeparator;
import com.mitrakova.formatter.formatter.specialsymbols.IHandler;

import java.util.HashMap;

/**
 * Created by wolf on 04.07.16.
 */
public class FSM implements IFSM {
    private StringBuffer insert;
    private StringBuffer lexeme;
    private HashMap<Character, IHandler> tableOfSpecialSymbols;
    private HashMap <Character, ISeparator> tableOfSeparateSymbols;
    private StateContainer stateContainer;
    private LexFinder lexFinder;

    public FSM(IFormatSettings FormatSettings){
        insert = new StringBuffer();
        lexeme = new StringBuffer();
        stateContainer = new StateContainer();
        lexFinder = new LexFinder();
        tableOfSeparateSymbols = FormatSettings.getSeparateSymbols();
        tableOfSpecialSymbols = FormatSettings.getSpecialSymbols();

    }
    public StringBuffer nextState(char symbol) throws FormatterException {
        if (tableOfSeparateSymbols.get(symbol) != null) {
            tableOfSeparateSymbols.get(symbol).separate(insert, stateContainer, lexFinder, lexeme);
        }else{
            if (tableOfSpecialSymbols.get(symbol) != null) {
                tableOfSpecialSymbols.get(symbol).doSomething(insert, lexeme, lexFinder, stateContainer );
            } else {
                lexeme.append(symbol);
            }
        }
        return insert;
    }
}
