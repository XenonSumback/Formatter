package com.mitrakova.formatter.reader.impl;

import com.mitrakova.formatter.reader.IReader;
import com.mitrakova.formatter.reader.ReaderException;
import com.mitrakova.formatter.writer.impl.file.IClose;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by wolf on 20.05.16.
 */
public class HTTPReader implements IReader, IClose {

    private InputStream in;
    private int bufferedChar;
    private boolean endOfFile;

    public void HTTPReader() throws ReaderException {
        try {
            URL url = new URL("https://raw.githubusercontent.com/XenonSumback/Formatter/master/src/main/resources/1.txt");
            URLConnection connection = url.openConnection();
            InputStream in = connection.getInputStream();
            int bufferedChar = in.read();
        } catch (MalformedURLException e) {
            throw new ReaderException(e);
        } catch (IOException e) {
            throw new ReaderException(e);
        }

    }


    public char read() throws ReaderException {
        int result = bufferedChar;
        try {
            bufferedChar = in.read();
            if (bufferedChar == -1) {
                endOfFile = true;
            }
        } catch (IOException e) {
            throw new ReaderException(e);
        }
        return (char) result;
    }

    public boolean isEnd()  {
        return endOfFile;
    }

    public void close() throws ReaderException {
        try {
            in.close();
        } catch (IOException e) {
            throw new ReaderException(e);
        }
    }
}
