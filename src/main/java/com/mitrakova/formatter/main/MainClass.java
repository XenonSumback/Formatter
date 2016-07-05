package com.mitrakova.formatter.main;

import com.mitrakova.formatter.formatter.*;
import com.mitrakova.formatter.reader.IReader;
import com.mitrakova.formatter.reader.ReaderException;
import com.mitrakova.formatter.reader.impl.file.FileReader;
import com.mitrakova.formatter.reader.impl.string.StringReader;
import com.mitrakova.formatter.writer.IWriter;
import com.mitrakova.formatter.writer.WriterException;
import com.mitrakova.formatter.writer.impl.file.FileWriter;
import com.mitrakova.formatter.writer.impl.string.StringWriter;

/**
 * Bootstrap
 */
public class MainClass {
    /**
     * Entry point
     * @param arg - arguments
     */
    public static void main(final String[] arg) {
        String string = "qwe()      {a = 1;hello;\n\t\t for (int i=0;       i<n;i++)\n{s=0;} java;" +
                "// one line comment \n  " +
                " \n " +
                " System.out.print(hello);}";
        String nameOfFile = "1.txt";
        IReader stringReader = null;
        try {
            stringReader = new StringReader(string);
        } catch (ReaderException e) {
            e.printStackTrace();
        }
        IFormatSettings formatSettings = new FormatSettings();
        IFSM fsm = new FSM(formatSettings);
        IWriter stringWriter = new StringWriter();
        IFormatter stringFormatter = new Formatter();
        try {
            stringFormatter.format(stringReader, stringWriter, fsm);
        } catch (FormatterException e) {
            e.printStackTrace();
        }
        FileReader fileReader = null;
        try {
            fileReader = new FileReader(nameOfFile);
        } catch (ReaderException e) {
            e.printStackTrace();
        }
        IFormatter fileFormatter = new Formatter();
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter();
        } catch (WriterException e) {
            e.printStackTrace();
        }
        try {
             fileFormatter.format(fileReader, fileWriter, fsm);
        } catch (FormatterException e) {
            e.printStackTrace();
        }
        try {
            fileReader.close();
        } catch (ReaderException e) {
            e.printStackTrace();
        }
        try {
            fileWriter.close();
        } catch (WriterException e) {
            e.printStackTrace();
        }
    }
}
