package ru.kpfu.itis.j903.cw.minsafin.inf_20;

import java.io.*;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Downloader implements Runnable {
    private URI uri;
    private  String downloadingPath = "src\\main\\java\\ru\\kpfu\\itis\\j903\\cw\\minsafin\\inf_20";

    public Downloader(URI uri) {
        this.uri = uri;
    }

    @Override
    public void run() {
        execute();
    }

    private void execute(){
        try {
            InputStream inputStream = uri.toURL().openConnection().getInputStream();
            String filename = uri.getPath().substring(uri.getPath().lastIndexOf('/')+1);
            File newFile = new File(Paths.get(downloadingPath).resolve(filename).toString());
            FileOutputStream outputStream = new FileOutputStream(newFile);
            int reading;
            while ((reading = inputStream.read()) != -1){
                outputStream.write(reading);
                Main_20.downloadedBytes++;
                Thread.sleep(1); // Искусственно замедляю скачивание, потому что файл небольшой
            }
            outputStream.flush();
            outputStream.close();
            Main_20.downloaded = true;
            System.out.println("File is downloaded");
        } catch (InterruptedException e) {
            System.out.println("Download is stopped");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
