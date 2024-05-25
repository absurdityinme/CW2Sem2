package org.example;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        List<Data> dataList = new ArrayList<>();
        dataList.add(new Data(new File("v16/3f34934b-9623-451a-b2c4-300a3b6e751e")));
        dataList.add(new Data(new File("v16/047f8619-ff14-47d0-aab0-9ddc1604c46b")));
        dataList.add(new Data(new File("v16/7452eb1e-af21-4f28-bf0d-7a7e026ceaa0")));
        dataList.add(new Data(new File("v16/33291b74-7de7-47a2-978e-ad8e53171e62")));
        dataList.add(new Data(new File("v16/94538268-64d0-45ff-958b-c6775f29bf00")));
        dataList.add(new Data(new File("v16/b7def3e3-b8d5-4a57-9faa-8be4e6aee174")));
        dataList.add(new Data(new File("v16/f405ab15-45c4-4fcc-aa9b-9da977d0aaea")));
        ImageReader.readAllParts(dataList);
        ImageReader.writeAll(new File("v16.png"), dataList);
    }
}