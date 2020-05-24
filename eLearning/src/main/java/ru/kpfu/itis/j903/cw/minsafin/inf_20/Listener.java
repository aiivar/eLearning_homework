package ru.kpfu.itis.j903.cw.minsafin.inf_20;

import java.util.Scanner;

public class Listener implements Runnable {
    private boolean downloaded;

    @Override
    public void run() {
        execute();
    }

    private void execute() {
        Scanner sc = new Scanner(System.in);
        Thread downloader = new Thread(new Downloader(Main_20.uri));
        while (true) {
            String command = sc.nextLine();
            downloaded = Main_20.downloaded;
            switch (command) {
                case "download":
                    if (downloader.isAlive()) {
                        System.out.println("Already started");
                    } else {
                        if (!downloaded) {
                            downloader.start();
                            System.out.println("Downloading...");
                        } else {
                            System.out.println("File is downloaded. Please, close the program");
                        }
                    }
                    break;
                case "status":
                    if (Main_20.fileSize > Main_20.downloadedBytes) {
                        System.out.println("Downloaded: " + Main_20.downloadedBytes + "/" + Main_20.fileSize + " bytes");
                    } else {
                        System.out.println("File is downloaded");
                    }
                    break;
                case "stop":
                    if (downloader.isAlive()) {
                        downloader.interrupt();
                    } else if (downloader.isInterrupted()) {
                        System.out.println("Already stopped");
                    }
                    break;
                case "close":
                    if (downloader.isAlive()){
                        downloader.interrupt();
                    }
                    System.exit(0);
                    break;
                default:
                    System.out.println("No such command");
            }
        }
    }

    public boolean isDownloaded() {
        return downloaded;
    }

    public void setDownloaded(boolean downloaded) {
        this.downloaded = downloaded;
    }
}
