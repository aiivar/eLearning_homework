package ru.kpfu.itis.j903.cw.minsafin.inf_15.filemanager;

import ru.kpfu.itis.j903.cw.minsafin.inf_15.filemanager.commands.concretecommands.CopyCommand;
import ru.kpfu.itis.j903.cw.minsafin.inf_15.filemanager.regex.RegexForCommands;
import ru.kpfu.itis.j903.cw.minsafin.inf_15.filemanager.service.FileManager;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Tester {
    public static void main(String[] args) {
        dotsTest();
    }

    public static void CDTest(){

    }
    static void FMFillTest(){
        FileManager n = new FileManager();
        System.out.println("You're here:\n " + n.getCurrentDirectory().getAbsolutePath() + "\n ______");
        for (String s: n.getDirectoryEntries()) {
            System.out.println(s);
        }
    }

    static void dotsTest(){
        Path path = Paths.get("D:\\Documentation\\..");
        File file = new File(path.normalize().toString());
        System.out.println(file.getAbsolutePath());
    }

    static void bufferTest(){
        FileManager n = new FileManager();
        System.out.println("You're here:\n " + n.getCurrentDirectory().getAbsolutePath() + "\n ______");
        for (String s: n.getDirectoryEntries()) {
            System.out.println(s);
        }
        System.out.println(n.getFilesBuffer());
    }
}
