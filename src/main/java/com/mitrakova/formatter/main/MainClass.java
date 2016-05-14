package com.mitrakova.formatter.main;

import com.mitrakova.formatter.formatter.Formatter;
import com.mitrakova.formatter.formatter.FormatterException;
import com.mitrakova.formatter.formatter.IFormatter;
import com.mitrakova.formatter.reader.IReader;
import com.mitrakova.formatter.reader.ReaderException;
import com.mitrakova.formatter.reader.imp.file.FileReader;
import com.mitrakova.formatter.reader.imp.string.StringReader;
import com.mitrakova.formatter.writer.IWriter;
import com.mitrakova.formatter.writer.WriterException;
import com.mitrakova.formatter.writer.imp.file.FileWriter;
import com.mitrakova.formatter.writer.imp.string.StringWriter;

public class MainClass {

    public static void main(final String[] arg) throws ReaderException {
        String string = "qwe(){a = 1; hello; fgh;} dfg;{}";
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
        IReader fileReader = new FileReader();
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
