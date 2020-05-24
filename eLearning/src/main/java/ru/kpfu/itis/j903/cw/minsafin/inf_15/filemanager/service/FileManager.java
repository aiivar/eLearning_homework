package ru.kpfu.itis.j903.cw.minsafin.inf_15.filemanager.service;

import ru.kpfu.itis.j903.cw.minsafin.inf_15.filemanager.commands.CommandExecutor;
import ru.kpfu.itis.j903.cw.minsafin.inf_15.filemanager.commands.concretecommands.*;
import ru.kpfu.itis.j903.cw.minsafin.inf_15.filemanager.commands.abstracts.AbstractCommand;
import ru.kpfu.itis.j903.cw.minsafin.inf_15.filemanager.regex.RegexForCommands;

import java.io.File;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileManager {
    private Scanner sc;
    private File currentDirectory;
    private List<String> directoryEntries;
    private CommandExecutor executor;
    private List<AbstractCommand> commands;
    private Set<File> filesBuffer;

    public void start() {
        while (true) {
            System.out.println("You're here: \n" + currentDirectory.getAbsolutePath() + "\n ______");
            System.out.println("Enter a command");
            String command = sc.nextLine();
            boolean done = false;
            for (AbstractCommand c : commands) {
                Pattern regex = c.getRegex();
                Matcher m = regex.matcher(command);
                if (m.matches()) {
                    c.setPath(m.group());
                    done = c.execute();
                    break;
                }
            }
            if (!done) {
                System.err.println("Failure!");
            }
        }
    }

    public void fill(File[] files) {
        if (currentDirectory.getParent() != null) {
            directoryEntries.add("..");
        }
        if (files.length != 0) {
            for (File file : files) {
                String fileName = file.getAbsolutePath();
                int i = fileName.length() - 1;
                while (fileName.charAt(i) != '\\' && i > 0) {
                    i--;
                }
                fileName = fileName.substring(i + 1, fileName.length());
                directoryEntries.add(fileName);
            }
        }
    }

    public FileManager() {
        currentDirectory = new File("/");
        executor = new CommandExecutor(this);
        commands = new ArrayList<>();
        commands.add(new CDCommand(currentDirectory.getPath(), RegexForCommands.CD.getPattern(), executor));
        commands.add(new DIRCommand(currentDirectory.getPath(), RegexForCommands.DIR.getPattern(), executor));
        commands.add(new CloseCommand(RegexForCommands.CLOSE.getPattern(), executor));
        commands.add(new CopyCommand(currentDirectory.getPath(), RegexForCommands.COPY.getPattern(), executor));
        commands.add(new PasteCommand(currentDirectory.getPath(), RegexForCommands.PASTE.getPattern(), executor));
        commands.add(new DeleteCommand(currentDirectory.getPath(), RegexForCommands.DELETE.getPattern(), executor));
        commands.add(new ClearFileBufferCommand(currentDirectory.getPath(), RegexForCommands.CLEARFILEBUFFER.getPattern(), executor));
        commands.add(new CatCommand(currentDirectory.getPath(),RegexForCommands.CAT.getPattern(),executor));
        sc = new Scanner(System.in);
        directoryEntries = new ArrayList<>();
        fill(currentDirectory.listFiles());
        filesBuffer = new TreeSet<>();
    }

    public File getCurrentDirectory() {
        return currentDirectory;
    }

    public List<String> getDirectoryEntries() {
        return directoryEntries;
    }

    public void setCurrentDirectory(File currentDirectory) {
        this.currentDirectory = currentDirectory;
    }

    public void setDirectoryEntries(List<String> directoryEntries) {
        this.directoryEntries = directoryEntries;
    }

    public Set<File> getFilesBuffer() {
        return filesBuffer;
    }
}
