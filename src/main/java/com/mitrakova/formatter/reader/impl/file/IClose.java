package com.mitrakova.formatter.reader.impl.file;

import com.mitrakova.formatter.reader.ReaderException;

/**
 * Close Stream
 */

interface IClose {
    /**
     * clse stream
     * @throws ReaderException
     */
    void close() throws ReaderException;
}
