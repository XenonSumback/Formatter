package com.mitrakova.formatter.reader.impl.file;

import com.mitrakova.formatter.reader.IReader;
import com.mitrakova.formatter.reader.ReaderException;

import java.io.*;

/**
 * 1
 */
public class FileReader implements IReader {

    InputStream bufferedStream;
    InputStream fileStream;

    boolean endOfFile = false;
    int bufferedChar;

    public FileReader(String nameOfFile) throws ReaderException {
        File dir = new File("/home/wolf/IdeaProjects/Formatterr/src/main/resources/");
        File file = new File(dir, nameOfFile);
        try {
            fileStream = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            throw new ReaderException(e);
        }
        bufferedStream = new BufferedInputStream(fileStream);
        try {
            bufferedChar = (char) bufferedStream.read();
        } catch (IOException e) {
            throw new ReaderException(e);
        }

    }

    public char read() throws ReaderException {
        int result = bufferedChar;
        try {
            bufferedChar = bufferedStream.read();
            if (bufferedChar == -1) {
                endOfFile = true;
            }
        } catch (IOException e) {
            throw new ReaderException(e);
        }
        return (char)result;
    }

    public void close() throws ReaderException {
        try {
            bufferedStream.close();
        } catch (IOException e) {
            throw new ReaderException(e);
        }
    }
    public boolean isEnd() {
        return endOfFile;
    }
}
