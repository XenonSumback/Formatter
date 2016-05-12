package com.mitrakova.formatter.formatter;

import com.mitrakova.formatter.reader.IReader;
import com.mitrakova.formatter.writer.IWriter;

public class Formatter implements IFormatter {
    public void format(IReader reader, IWriter writer) {
        StringBuffer insert = new StringBuffer();
        char symbol = 0;
        for (int i=0; i< reader.getLen(); i++){

            symbol = reader.read(i);
            switch (symbol){
                case '{':
                    insert.append(symbol);
                    insert.append('\n');
                    break;
                case '}':
                    insert.append(symbol);
                    insert.append('\n');
                    break;
                case ';':
                    insert.append(symbol);
                    insert.append('\n');
                    break;
                default: insert.append(symbol);
                    break;

            }
        }
        writer.write(insert);
    }

}
