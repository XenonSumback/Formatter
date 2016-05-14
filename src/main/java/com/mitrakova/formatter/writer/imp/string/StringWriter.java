package com.mitrakova.formatter.writer.imp.string;

import com.mitrakova.formatter.formatter.IFormatter;
import com.mitrakova.formatter.writer.IWriter;
import com.mitrakova.formatter.writer.WriterException;



public class StringWriter implements IWriter {



    public void write(StringBuffer insert) throws WriterException {
        System.out.print(insert);
    }

    public void close()  {

    }
}
