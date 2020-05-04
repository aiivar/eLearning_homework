package ru.kpfu.itis.j903.cw.minsafin.inf_15.filemanager.commands.concretecommands;

import ru.kpfu.itis.j903.cw.minsafin.inf_15.filemanager.commands.CommandExecutor;
import ru.kpfu.itis.j903.cw.minsafin.inf_15.filemanager.commands.abstracts.AbstractCommand;


import java.util.regex.Pattern;

public class DIRCommand extends AbstractCommand {

    public DIRCommand(String path, Pattern regex, CommandExecutor executor) {
        super(path, regex, executor);
    }

    @Override
    public boolean execute() {
        return executor.startDIR(path);
    }

}
