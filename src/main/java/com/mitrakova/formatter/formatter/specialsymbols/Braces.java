package com.mitrakova.formatter.formatter.specialsymbols;

import com.mitrakova.formatter.formatter.FormatterException;

/**
 * Controls number of opened & closed braces
 */
public class Braces {
    private static int openedBraces = 0;
    private static int closedBraces = 0;

    public static void incrementClosedBraces() {
        closedBraces++;
    }

    public static void incrementOpenedBraces() {
        openedBraces++;
    }

    public static int getClosedBraces() {
        return closedBraces;
    }

    public static int getOpenedBraces() {
        return openedBraces;
    }

    public static void EndOfFormat() throws FormatterException {
        if (Braces.getOpenedBraces() != Braces.getClosedBraces()) {
            throw new FormatterException("missed close brace '}'");
        }
        openedBraces = 0;
        closedBraces = 0;
    }
}
