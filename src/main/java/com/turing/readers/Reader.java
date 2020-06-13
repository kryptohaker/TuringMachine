package com.turing.readers;

import com.turing.model.Params;
import org.json.simple.parser.ParseException;

import java.io.IOException;

public interface Reader {
    Params read(String path) throws IOException, ParseException;
}
