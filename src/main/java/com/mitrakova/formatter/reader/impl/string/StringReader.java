package com.mitrakova.formatter.reader.impl.string;

import com.mitrakova.formatter.reader.IReader;
import com.mitrakova.formatter.reader.ReaderException;

/**
 * try
 */
public class StringReader implements IReader {

    private String string;
    private int lenOfString;
    private boolean isEndOfString = false;
    private int index = 0;
    private char bufferedChar;

    public StringReader(final String string) throws ReaderException {
        if (string == null) {
            throw new ReaderException("Where is input string?");
        }
        this.string = string;
        lenOfString = string.length();
        bufferedChar = string.charAt(index);
    }

    /**
     * read chars from string
     * @return - char
     * @throws ReaderException
     */
    public char read() throws ReaderException {
        if (index == lenOfString) {
            isEndOfString = true;
            return 0;
        } else {
            char ch = string.charAt(index);
            index++;
            return ch;
        }
    }

    /**
     * checks end of string
     * @return - true, if string over
     */
    public boolean isEnd() {
        return isEndOfString;
    }
}
