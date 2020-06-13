package com.turing.enums;

import com.turing.readers.JsonReader;
import com.turing.readers.TextReader;

public enum EnumReader {
    JSON_READER(JsonReader.class.getName(), JsonReader.class),
    TEXT_READER(TextReader.class.getName(), TextReader.class);

    private final String className;
    private final Class<?> classType;

    EnumReader(String className, Class<?> classType){
        this.className = className;
        this.classType = classType;
    }

    public String getClassName() {
        return className;
    }

    public Class<?> getClassType() {
        return classType;
    }
}
