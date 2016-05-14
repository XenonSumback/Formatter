package com.mitrakova.formatter.reader.imp.string;

import com.mitrakova.formatter.reader.IReader;
import com.mitrakova.formatter.reader.ReaderException;

/**
 * 1
 */
public class StringReader implements IReader {

    private char[] chars;
    private int index = 0;
    private int lenOfChars;

    public StringReader(final String string) throws ReaderException {
        if (string == null) {
            throw new ReaderException(null);
        }
        char [] chars = string.toCharArray();
        this.chars = chars;
        lenOfChars = chars.length;
    }

    public int read(final int index) {
        char symbol;
        this.index = index;
        symbol = chars[index];
        this.index += 1;
        return symbol;
    }

    public int getLen(){
        return lenOfChars;
    }

    public void close() {
    }
}
