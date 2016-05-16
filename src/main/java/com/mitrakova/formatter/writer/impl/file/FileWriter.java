package com.mitrakova.formatter.writer.impl.file;

import com.mitrakova.formatter.writer.IWriter;
import com.mitrakova.formatter.writer.WriterException;

import java.io.*;


/**
 * Writes results of formatting
 */
public class FileWriter implements IWriter, IClose {

    private OutputStream fileStream;
    private OutputStream bufferedStream;

    /**
     * constructor
     * @throws WriterException - if can`t initialise stream
     */
    public FileWriter() throws WriterException {
        File dir = new File("/home/wolf/IdeaProjects/Formatterr/src/main/resources");
        File file = new File(dir, "2.txt");
        try {
            fileStream = new FileOutputStream(file);
        } catch (FileNotFoundException e) {
            throw new WriterException(e);
        }
        bufferedStream = new BufferedOutputStream(fileStream);
    }

    /**
     * Writes results of formatting in file
     * @param insert - sequence from formatter.format
     * @throws WriterException - if writing failed
     */

    public void write(final StringBuffer insert) throws WriterException {
        String s = insert.toString();
        char[] result = s.toCharArray();
        for (int i = 0; i < result.length; i++) {
            try {
                bufferedStream.write(result[i]);
            } catch (IOException e) {
                throw new WriterException(e);
            }
        }
    }

    /**
     * close buffered output stream
     * @throws WriterException - if can`t close stream
     */
    public void close() throws WriterException {
        try {
            bufferedStream.close();
        } catch (IOException e) {
            throw new WriterException(e);
        }
    }
}
