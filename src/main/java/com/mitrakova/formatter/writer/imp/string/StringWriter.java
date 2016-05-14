package com.mitrakova.formatter.writer.imp.string;

import com.mitrakova.formatter.formatter.IFormatter;
import com.mitrakova.formatter.writer.IWriter;
import com.mitrakova.formatter.writer.WriterException;



public class StringWriter implements IWriter {

    public void write(IFormatter formatter) throws WriterException {
        System.out.print(formatter.getResult());
    }

    public void close()  {

    }
}
