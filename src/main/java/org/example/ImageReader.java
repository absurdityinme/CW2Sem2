package org.example;

import java.io.*;
import java.util.List;

public class ImageReader {
    public static void readAllParts(List<Data> threadList) {
        threadList.forEach(Data::start);
    }

    public static void write(File file, List<Data> threadList) {
        try (FileOutputStream fos = new FileOutputStream(file, true)) {
            for (int i = 0; i < threadList.toArray().length; ++i) {
                fos.write(threadList.get(i).getData());
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }

    }


}
