package com.mitrakova.formatter.reader;

public interface IReader{
    char read(int index);
    void close();

    int getLen();
}
