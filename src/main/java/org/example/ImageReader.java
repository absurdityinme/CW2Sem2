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
        threadList.sort((d1, d2) -> d1.compareTo(d2));
        try (FileOutputStream fos = new FileOutputStream(file, true)) {
            threadList.forEach(v -> {
                try {
                    fos.write(v.getData());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });
        }
        catch (IOException e) {
            e.printStackTrace();
        }

    }


}
