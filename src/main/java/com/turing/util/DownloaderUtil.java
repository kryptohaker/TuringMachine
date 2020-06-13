package com.turing.util;


import java.io.File;
import java.io.IOException;
import java.net.URL;

public final class DownloaderUtil {

    private DownloaderUtil(){}

    public static String getFile (String path) throws IOException {
        String tmpDir = "tmpdata/";
        URL url = new URL(path);
        String tmpPath = tmpDir + "tmpRemoteJson" + ".json";
        File remoteJsonFile = new File(tmpPath);
        remoteJsonFile.deleteOnExit();
        FileUtil.copyURLToFile(url, remoteJsonFile);
        return remoteJsonFile.getPath();
    }

    public static boolean isURL(String url) {
        boolean result = true;
        try {
            (new URL(url)).openStream().close();
        } catch (Exception ex) {
            result = false;
            ex.printStackTrace();
        }
        return result;
    }

}
