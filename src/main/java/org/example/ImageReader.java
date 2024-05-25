package org.example;

import java.io.*;
import java.util.List;

public class ImageReader {
    public static void readAllParts(List<Data> threadList) {
        threadList.forEach(Data::start);
    }

    public static void writeAll(File file, List<Data> threadList) throws InterruptedException {
        for (Data data : threadList) {
            data.join();
        }
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
