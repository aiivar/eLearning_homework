package ru.kpfu.itis.j903.cw.minsafin.inf_15.filemanager;

import ru.kpfu.itis.j903.cw.minsafin.inf_15.filemanager.service.FileManager;

public class FileManagerApp implements App {

    public static void main(String[] args) {
        App app = new FileManagerApp();
        app.init();
        app.start();
    }

    @Override
    public void init() {

    }

    @Override
    public void start() {
        new FileManager().start();
    }
}
