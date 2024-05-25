package org.example;

import lombok.Getter;

import java.awt.image.BufferedImage;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Comparator;

@Getter
public class Data extends Thread{
    private int sz; // размер блока данных
    private byte[] data; // данные с фрагментом картинки
    private int controlEven; // контрольное число четности
    private int part; // номер фрагмента картинки [0..7]
    private File file;
    public Data(File file) {
        this.file = file;
    }
    public void run() {
        read();
    }
    private void read() {
        try (DataInputStream dis = new DataInputStream(new FileInputStream(file))) {
            sz = dis.readInt();
            data = new byte[sz];
            dis.read(data); // read image data
            controlEven = dis.readInt();
            part = dis.readInt();
            if (!controlEvenParam()) {
                throw new Exception();
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    private boolean controlEvenParam() {
        int count = 0;
        for (int i = 0; i < data.length; ++i) {
            for (int j = 0; j < 8; ++j) {
                count += (data[i] >> j) & 1;
            }
        }
        return (count % 2) == controlEven;
    }
    // (b & (1 << 1)) >> 1
}
