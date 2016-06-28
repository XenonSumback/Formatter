package com.mitrakova.formatter.formatter.specialsymbols;

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

    public static void EndOfFormat(){
        openedBraces = 0;
        closedBraces = 0;
    }
}
