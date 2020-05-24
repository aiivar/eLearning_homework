package ru.kpfu.itis.j903.cw.minsafin.inf_15.filemanager.commands;

import org.omg.IOP.Encoding;
import ru.kpfu.itis.j903.cw.minsafin.inf_15.filemanager.service.FileManager;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
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

    public boolean startCat(String path) {
        Pattern pathPattern = Pattern.compile("((([a-zA-Z]:)?(\\\\?[a-zA-Z0-9_.-]+)+\\\\?)? ?([a-zA-Z0-9_.-]+)?)?$");
        Matcher matcher = pathPattern.matcher(path);
        if (matcher.find()) {
            Path npath = Paths.get(matcher.group(2)).normalize();
            String encoding = matcher.group(5);
            if (!npath.isAbsolute()) {
                npath = currentFM.getCurrentDirectory().toPath().resolve(npath);
            }
            startCDAbsolute(String.valueOf(npath.getParent()));
            readAndWriteThisFile(new File(String.valueOf(npath)), encoding);
            return true;
        } else {
            return false;
        }
    }

    private void readAndWriteThisFile(File file, String encoding) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file), encoding));
            String line = "";
            StringBuilder str = new StringBuilder();
            while ((line = br.readLine()) != null) {
                str.append(line).append("\n");
            }
            System.out.println("The contents of the file " + "\"" + file.getName() + "\"" + "\n _________");
            System.out.println(str);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean startCopy(String command) {
        Pattern pattern = Pattern.compile("[0-9]+");
        Matcher matcher = pattern.matcher(command);
        if (matcher.find()) {
            command = matcher.group();
        }
        int fileNum = Integer.parseInt(command);
        if (currentFM.getFilesBuffer().add(new File(currentFM.getCurrentDirectory().getAbsolutePath() + "\\" + currentFM.getDirectoryEntries().get(fileNum)))) {
            System.out.println("File is copied");
            return true;
        } else {
            return false;
        }
    }

    public boolean startPaste() {
        for (File f : currentFM.getFilesBuffer()) {
            try {
                Path dest = Paths.get(currentFM.getCurrentDirectory().getAbsolutePath(), f.getName());
                if (Files.exists(dest)) {
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

    public boolean startDelete(String command) {
        Pattern pattern = Pattern.compile("[0-9]+");
        Matcher matcher = pattern.matcher(command);
        if (matcher.find()) {
            command = matcher.group();
        }
        int fileNum = Integer.parseInt(command);
        Path file = Paths.get(currentFM.getCurrentDirectory().getAbsolutePath() + "\\" + currentFM.getDirectoryEntries().get(fileNum));
        if (Files.exists(file)) {
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
        Pattern pathPattern = Pattern.compile(" (([a-zA-Z]:)?(\\\\?[a-zA-Z0-9_.-]+)+\\\\?)$");
        Matcher matcher = pathPattern.matcher(path);
        if (matcher.find()) {
            Path npath = Paths.get(matcher.group().substring(1)).normalize();
            if (!npath.isAbsolute()) {
                npath = currentFM.getCurrentDirectory().toPath().resolve(npath).normalize();
            }
            File fpath = new File(String.valueOf(npath));
            if (fpath.isDirectory() && !fpath.isFile() && fpath.exists()) {
                return startCDAbsolute(npath.toString());
            } else {
                return false;
            }
        } else {
            return path.length() <= 3;
        }
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
