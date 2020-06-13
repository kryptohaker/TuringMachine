package com.turing.main;

import com.turing.factory.ReaderFactory;
import com.turing.machine.Processor;
import com.turing.model.Params;
import com.turing.readers.Reader;
import com.turing.util.DownloaderUtil;
import com.turing.util.FileUtil;
import org.json.simple.parser.ParseException;
import java.io.IOException;


/*
 *
 * https://rawgit.com/rgrisha/secureprog/master/tasks/task4/increment_dec.tmprog.json
 *
 * data/running_ones.tmprog.json
 * data/increment_dec.tmprog.txt
 *
 * data/increment_dec.tmprog.json
 * data/running_ones.tmprog.txt
 *
 */

public class Demo {
    public static void main(String[] args) throws IOException, ParseException {
        String path = "https://rawgit.com/rgrisha/secureprog/master/tasks/task4/increment_dec.tmprog.json"; // or "data/running_ones.tmprog.json|txt"
        if (DownloaderUtil.isURL (path)) {
            path = DownloaderUtil.getFile (path);
        }
        Reader reader = ReaderFactory.getReader(FileUtil.getFileType(path));
        Params params = reader.read(path);
        Processor.start(params);
    }

}
