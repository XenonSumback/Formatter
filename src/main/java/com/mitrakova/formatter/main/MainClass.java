package com.mitrakova.formatter.main;

import com.mitrakova.formatter.formatter.Formatter;
import com.mitrakova.formatter.formatter.FormatterException;
import com.mitrakova.formatter.formatter.IFormatter;
import com.mitrakova.formatter.reader.IReader;
import com.mitrakova.formatter.reader.ReaderException;
import com.mitrakova.formatter.reader.impl.file.FileReader;
import com.mitrakova.formatter.reader.impl.string.StringReader;
import com.mitrakova.formatter.writer.IWriter;
import com.mitrakova.formatter.writer.WriterException;
import com.mitrakova.formatter.writer.impl.file.FileWriter;
import com.mitrakova.formatter.writer.impl.string.StringWriter;

public class MainClass {

    /**
     * Entry point
     * @param arg - arguments
     */
    public static void main(final String[] arg) {
        String string = "qwe(){a = 1;hello;fgh;}dfg;{}";
        String nameOfFile = "1.txt";
        IReader stringReader = null;
        try {
            stringReader = new StringReader(string);
        } catch (ReaderException e) {
            e.printStackTrace();
        }
        IWriter stringWriter = new StringWriter();
        IFormatter stringFormatter = new Formatter();
        try {
            stringFormatter.format(stringReader, stringWriter);
        } catch (FormatterException e) {
            e.printStackTrace();
        }
        IReader fileReader = null;
        try {
            fileReader = new FileReader(nameOfFile);
        } catch (ReaderException e) {
            e.printStackTrace();
        }
        IFormatter fileFormatter = new Formatter();
        IWriter fileWriter = null;
        try {
            fileWriter = new FileWriter();
        } catch (WriterException e) {
            e.printStackTrace();
        }
        try {
             fileFormatter.format(fileReader, fileWriter);
        } catch (FormatterException e) {
            e.printStackTrace();
        }
        try {
            fileWriter.close();
        } catch (WriterException e) {
            e.printStackTrace();
        }
    }
}
