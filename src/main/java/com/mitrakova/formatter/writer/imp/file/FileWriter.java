package com.mitrakova.formatter.writer.imp.file;

import com.mitrakova.formatter.formatter.IFormatter;
import com.mitrakova.formatter.writer.IWriter;
import com.mitrakova.formatter.writer.WriterException;

import java.io.*;


/**
 * Created by wolf on 11.05.16.
 */
public class FileWriter implements IWriter {
    PrintWriter out = null;
    public FileWriter() throws WriterException {
        File dir = new File("/home/wolf/Downloads/Formatter/src/main/resources");
        File file = new File(dir, "2.txt");
        try {
            out = new PrintWriter(file.getAbsoluteFile());
        } catch (FileNotFoundException e) {
            throw new WriterException(e);
        }
    }


    public void write(IFormatter formatter) throws WriterException {

        out.print(formatter.getResult());

    }


    public void close() {
            out.close();
        }
}
