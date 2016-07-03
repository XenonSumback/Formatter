package com.mitrakova.formatter.formatter.specialsymbols;


import com.mitrakova.formatter.formatter.FormatterException;
import com.mitrakova.formatter.formatter.StateContainer;
import com.mitrakova.formatter.formatter.lexemes.LexFinder;

public interface IHandler {
   void doSomething(StringBuffer insert, StringBuffer lexeme, LexFinder lexFinder, StateContainer stateContainer) throws FormatterException;
}
