package ru.kpfu.itis.j903.cw.minsafin.inf_15.filemanager.commands;

import ru.kpfu.itis.j903.cw.minsafin.inf_15.filemanager.service.FileManager;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CommandExecutor {
    FileManager currentFM;

    public CommandExecutor(FileManager currentFM) {
        this.currentFM = currentFM;
    }

    public boolean startCopy(String command) {
        Pattern pattern = Pattern.compile("[0-9]+");
        Matcher matcher = pattern.matcher(command);
        if (matcher.find()) {
            command = matcher.group();
        }
        int fileNum = Integer.parseInt(command);
        if (currentFM.getFilesBuffer().add(new File(currentFM.getCurrentDirectory().getAbsolutePath() +"\\"+ currentFM.getDirectoryEntries().get(fileNum)))) {
            System.out.println("File is copied");
            return true;
        } else {
            return false;
        }
    }

    public boolean startPaste() {
        for (File f : currentFM.getFilesBuffer()) {
            try {
                Path dest = Paths.get(currentFM.getCurrentDirectory().getAbsolutePath() +"\\"+ f.getName());
                if (Files.exists(dest)){
                    Files.delete(dest);
                }
                Files.copy(f.toPath(), dest);
            } catch (IOException e) {
                e.printStackTrace();
                return false;
            }
        }
        return true;
    }

    public boolean startDelete(String command){
        Pattern pattern = Pattern.compile("[0-9]+");
        Matcher matcher = pattern.matcher(command);
        if (matcher.find()) {
            command = matcher.group();
        }
        int fileNum = Integer.parseInt(command);
        Path file = Paths.get(currentFM.getCurrentDirectory().getAbsolutePath() + "\\" + currentFM.getDirectoryEntries().get(fileNum));
        if (Files.exists(file)){
            try {
                Files.delete(file);
                System.out.println("Deleted");
                return true;
            } catch (IOException e) {
                e.printStackTrace();
                return false;
            }
        } else {
            System.out.println("No such file in directory");
            return false;
        }
    }

    public boolean startClearFileBuffer() {
        currentFM.getFilesBuffer().clear();
        System.out.println("Buffer was cleared");
        return true;
    }

    public boolean startCD(String path) {
        Pattern replaceDoubleSeparator = Pattern.compile("\\\\\\\\");
        Pattern pathPattern = Pattern.compile("(([a-zA-Z]:)?(\\\\[a-zA-Z0-9_.-]+)+\\\\?)");
        Matcher matcher = pathPattern.matcher(path);
        String apath = null;
        if (matcher.find()) {
            path = path.substring(matcher.start(), matcher.end());
            apath = currentFM.getCurrentDirectory().getAbsolutePath() + path;
            if (!Paths.get(path).isAbsolute()) {
                Matcher replaceMatcher = replaceDoubleSeparator.matcher(apath);
                if (replaceMatcher.find()) {
                    apath = replaceMatcher.replaceAll("\\\\");
                }
                Path normal = Paths.get(apath).normalize();
                if (!new File(normal.toString()).isDirectory()) {
                    return noSuchDir();
                }
            } else {
                if (!new File(Paths.get(path).normalize().toString()).isDirectory()) {
                    return noSuchDir();
                }
            }
        } else {
            path = "";
        }
        if (!path.equals("")) {
            if (Paths.get(path).isAbsolute()) {
                return startCDAbsolute(Paths.get(path).normalize().toString());
            } else {
                return startCDAbsolute(Paths.get(apath).normalize().toString());
            }
        }
        return true;
    }


    private boolean startCDAbsolute(String path) {
        currentFM.setCurrentDirectory(new File(path));
        currentFM.getDirectoryEntries().clear();
        currentFM.fill(currentFM.getCurrentDirectory().listFiles());
        return true;
    }


    public boolean startDIR(String path) {
        if (!startCD(path)) {
            return false;
        }
        for (String s : currentFM.getDirectoryEntries()) {
            System.out.printf("%s", s + "\n");
        }
        return true;
    }

    public void close() {
        System.out.println("Closed...");
        System.exit(0);
    }

    private boolean noSuchDir() {
        System.err.println("There is no such directory");
        return false;
    }
}
