package com.mitrakova.formatter.formatter.specialsymbols;


import com.mitrakova.formatter.formatter.FormatterException;

public interface ISpecialSymbol {
    void doSomething(StringBuffer insert) throws FormatterException;
}
