package ru.kpfu.itis.j903.cw.minsafin.inf_19.n_3;

import java.util.Scanner;

public class Main_19 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String link = sc.nextLine();
        Thread downloader = new Thread(new Downloader(link));
        downloader.start();
    }
}
