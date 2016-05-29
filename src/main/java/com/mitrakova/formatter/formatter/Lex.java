//package com.mitrakova.formatter.formatter;
//
//
//import com.mitrakova.formatter.reader.IReader;
//import com.mitrakova.formatter.reader.ReaderException;
//
//import java.util.HashMap;
//
///**
// * Search for Key words
// */
//public class Lex implements ILex {
//    boolean inFor;
//    boolean inComment;
//
//    HashMap hm;
//    public void Lex(){
//        HashMap <String, Boolean> hm = new HashMap<String, Boolean>();
//        hm.put("for", inFor = true);
//        hm.put("//", inComment = false);
//    }
//
//    public String findKeySequence(IReader reader) {
//        String s = null;
//        try {
//            s = String.valueOf(reader.read());
//            if (s.equals("f") ){
//                s+=reader.read();
//                s+=reader.read();
//            }
//            if (s.equals("/") ){
//                s+= reader.read();
//            }else {
//                return s;
//            }
//        } catch (ReaderException e) {
//            e.printStackTrace();
//        }
//        if (hm.containsKey(s)){
//            hm.get(s);
//        } else {
//            return s;
//        }
//
//
//    }
//}
