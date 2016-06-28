package com.mitrakova.formatter.formatter;

/**
 * Created by wolf on 17.06.16.
 */
public class StateContainer {
    private static boolean inComment = false;
    private static boolean inFor = false;
    private static boolean inOneLineComment = false;


    public  void setInFor(boolean inFor) { this.inFor = inFor;
    }

    public  void setInComment(boolean inComment) {
        this.inComment = inComment;
    }
    public void setInOneLineComment(boolean inOneLineComment){this.inOneLineComment = inOneLineComment;}

    public static boolean getInComment(){
        return inComment;
    }

    public static boolean getInFor(){
        return inFor;
    }

    public static boolean getInOneLineComment(){return inOneLineComment;}
}
