package com.mitrakova.formatter.formatter.lexemes;

import com.mitrakova.formatter.formatter.StateContainer;
import com.mitrakova.formatter.formatter.lexemes.impl.CommentLexeme;
import com.mitrakova.formatter.formatter.lexemes.impl.EndOfCommentLexeme;
import com.mitrakova.formatter.formatter.lexemes.impl.ForLexeme;
import com.mitrakova.formatter.formatter.lexemes.impl.OneLineCommentLexeme;

import java.util.HashMap;

/**
 * Created by wolf on 29.06.16.
 */
public class LexFinder {
    private HashMap<String, ILex> tableOfLexemes;
    public LexFinder(){
        tableOfLexemes = new HashMap<String, ILex>();
        tableOfLexemes.put("for", new ForLexeme());
        tableOfLexemes.put("//", new OneLineCommentLexeme());
        tableOfLexemes.put("//*", new CommentLexeme());
        tableOfLexemes.put("*/", new EndOfCommentLexeme());
    }

    public void findLex(StringBuffer lexeme, StringBuffer insert, StateContainer stateContainer){
        String lex = lexeme.toString();
        if(tableOfLexemes.get(lex) != null){
            tableOfLexemes.get(lex).lexemeReaction(stateContainer, insert);
        } else {
            insert.append(lex);
        }
        lexeme.delete(0, lex.length());
    }
}
