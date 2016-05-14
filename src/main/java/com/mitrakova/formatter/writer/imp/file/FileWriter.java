package com.mitrakova.formatter.writer.imp.file;

import com.mitrakova.formatter.writer.IWriter;
import com.mitrakova.formatter.writer.WriterException;

import java.io.*;


/**
 * Writes results of formatting
 */
public class FileWriter implements IWriter {

    PrintWriter out = null;

    public FileWriter() throws WriterException {
        File dir = new File("/home/wolf/IdeaProjects/Formatter/src/main/resources");
        File file = new File(dir, "2.txt");
        try {
            out = new PrintWriter(file.getAbsoluteFile());
        } catch (FileNotFoundException e) {
            throw new WriterException(e);
        }
    }


    public void write( final StringBuffer insert) {
        out.print(insert);

    }

    public void close() throws WriterException {
        out.close();
    }
}
