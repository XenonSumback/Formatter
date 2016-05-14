package com.mitrakova.formatter.reader.imp.file;


import com.mitrakova.formatter.reader.IReader;
import com.mitrakova.formatter.reader.ReaderException;

import java.io.*;

/**
 *
 */
public class FileReader implements IReader {
    InputStream bufferedStream;
    InputStream fileStream;


    public FileReader() throws ReaderException {
        File dir = new File("/home/wolf/IdeaProjects/Formatter/src/main/resources/");
        File file = new File(dir, "1.txt");
        try {
            fileStream = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            throw new ReaderException(e);
        }
        bufferedStream = new BufferedInputStream(fileStream);
    }


    public int read(final int index) throws ReaderException {
        int c;
        try {
            c = bufferedStream.read();
        } catch (IOException e) {
            throw new ReaderException(e);
        }
        return c;
    }


    public void close() throws ReaderException {
        try {
            bufferedStream.close();
        } catch (IOException e) {
            throw new  ReaderException(e);
        }
    }

    public int getLen() throws ReaderException {

        try {
            return fileStream.available();
        } catch (IOException e) {
            throw new ReaderException(e);
        }
    }
}
