package ru.kpfu.itis.j903.cw.minsafin.inf_15.filemanager.commands.concretecommands;

import ru.kpfu.itis.j903.cw.minsafin.inf_15.filemanager.commands.CommandExecutor;
import ru.kpfu.itis.j903.cw.minsafin.inf_15.filemanager.commands.abstracts.AbstractCommand;

import java.util.regex.Pattern;

public class CloseCommand extends AbstractCommand {
    @Override
    public boolean execute() {
        executor.close();
        return false;
    }

    public CloseCommand(Pattern regex, CommandExecutor executor) {
        super(null, regex, executor);
    }
}
