package ru.kpfu.itis.j903.cw.minsafin.inf_20;

import java.net.URI;

public class Main_20 {
    static URI uri = URI.create("https://sun7-6.userapi.com/w5u_18QEvGaoLiVFW5W2Zc37UgG4OXyslbrbMQ/Huus4P9Qu-o.jpg");
    static int fileSize = 69001;
    static int downloadedBytes = 0;
    static boolean downloaded = false;

    public static void main(String[] args) {
        Thread listener = new Thread(new Listener());
        listener.start();
    }
}
