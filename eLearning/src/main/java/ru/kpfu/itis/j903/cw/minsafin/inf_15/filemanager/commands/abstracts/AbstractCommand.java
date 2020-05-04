package ru.kpfu.itis.j903.cw.minsafin.inf_15.filemanager.commands.abstracts;

import ru.kpfu.itis.j903.cw.minsafin.inf_15.filemanager.commands.CommandExecutor;

import java.util.regex.Pattern;

public abstract class AbstractCommand implements Command {
    protected String path;
    protected Pattern regex;
    protected CommandExecutor executor;

    public String getPath() {
        return path;
    }

    public Pattern getRegex() {
        return regex;
    }

    public AbstractCommand(String path, Pattern regex, CommandExecutor executor) {
        this.path = path;
        this.regex = regex;
        this.executor = executor;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
