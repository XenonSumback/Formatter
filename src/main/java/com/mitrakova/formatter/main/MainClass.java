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

import java.io.IOException;

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
            stringWriter.write(stringFormatter);
        } catch (FormatterException e){
            e.printStackTrace();
        } catch (WriterException e) {
            e.printStackTrace();
        }
        IReader fileReader = new FileReader();
        IFormatter fileFormatter = new Formatter();
        for (int i=0;i<fileReader.getLen();i++){
            int code = 0;
            while (code != -1){
                code = fileReader.read(i);
                try {
                    IWriter fileWriter = new FileWriter();
                    fileFormatter.format(fileReader, fileWriter);
                    fileWriter.write(fileFormatter);
                    fileWriter.close();
                } catch (FormatterException e) {
                    e.printStackTrace();
                } catch (WriterException e) {
                    e.printStackTrace();
                }
                System.out.print((char)code);
            }
        }
    }
}
