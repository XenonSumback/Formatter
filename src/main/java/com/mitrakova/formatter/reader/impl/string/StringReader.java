package com.mitrakova.formatter.reader.impl.string;

import com.mitrakova.formatter.reader.IReader;
import com.mitrakova.formatter.reader.ReaderException;

/**
 * try
 */
public class StringReader implements IReader {
    String string;
    int lenOfString;
    boolean isEndOfString = false;
    int index = 0;
    char bufferedChar;

    public StringReader(final String string) throws ReaderException {
        if (string == null) {
            throw new ReaderException(null);
        }
        this.string = string;
        lenOfString = string.length();
        bufferedChar = string.charAt(index);

    }


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

    public void close() throws ReaderException {

    }

    public boolean isEnd() {
        return isEndOfString;
    }
}
