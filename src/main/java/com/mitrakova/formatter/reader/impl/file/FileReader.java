package com.mitrakova.formatter.reader.impl.file;

import com.mitrakova.formatter.reader.IReader;
import com.mitrakova.formatter.reader.ReaderException;

import java.io.*;

/**
 * 1
 */
public class FileReader implements IReader, IClose {

    private InputStream bufferedStream;
    private InputStream fileStream;

    private boolean endOfFile = false;
    private int bufferedChar;

    /**
     * constructor
     * @param nameOfFile - file for reading
     * @throws ReaderException
     */

    public FileReader(final String nameOfFile) throws ReaderException {
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

    /**
     * read char from input stream
     * @return - symbol from stream
     * @throws ReaderException
     */
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
        return (char) result;
    }

    /**
     * close input stream
     * @throws ReaderException
     */
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
