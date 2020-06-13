package com.turing.factory;

import com.turing.enums.EnumReader;
import com.turing.readers.Reader;

import java.lang.reflect.InvocationTargetException;

public class ReaderFactory {

    public static Reader getReader(EnumReader enumReader){
        Reader reader = null;
        try {
            reader = (Reader)Class.forName(enumReader.getClassName()).getConstructor().newInstance();
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return reader;
    }
}
