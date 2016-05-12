package com.mitrakova.formatter.main;

import com.mitrakova.formatter.formatter.Formatter;
import com.mitrakova.formatter.formatter.IFormatter;
import com.mitrakova.formatter.reader.IReader;
import com.mitrakova.formatter.reader.ReaderException;
import com.mitrakova.formatter.reader.imp.string.StringReader;
import com.mitrakova.formatter.writer.IWriter;
import com.mitrakova.formatter.writer.imp.string.StringWriter;

public class MainClass {

    public static void main(final String[] arg){
               String string = "qwe(){a = 1; ghffjkldd; fgh;} dfg;";
        IReader reader = null;
        try {
            reader = new StringReader(string);
        } catch (ReaderException e) {
            e.printStackTrace();
        }
        IWriter writer = new StringWriter();
        IFormatter formatter = new Formatter();
        formatter.format(reader, writer);

    }
}
