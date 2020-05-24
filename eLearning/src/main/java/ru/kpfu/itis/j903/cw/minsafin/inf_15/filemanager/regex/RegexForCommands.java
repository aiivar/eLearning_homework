package ru.kpfu.itis.j903.cw.minsafin.inf_15.filemanager.regex;

import java.util.regex.Pattern;

public enum RegexForCommands {
    CD(Pattern.compile("^cd ?(([a-zA-Z]:)?(\\\\?[a-zA-Z0-9_.-]+)+\\\\?)?")),
    DIR(Pattern.compile("^dir ?(([a-zA-Z]:)?(\\\\?[a-zA-Z0-9_.-]+)+\\\\?)?")),
    CLOSE(Pattern.compile("^close *")),
    COPY(Pattern.compile("^copy [0-9]+")),
    PASTE(Pattern.compile("^paste *")),
    DELETE(Pattern.compile("^delete [0-9]+")),
    CLEARFILEBUFFER(Pattern.compile("^clearfilebuffer *")),
    CAT(Pattern.compile("^cat ?(([a-zA-Z]:)?(\\\\?[a-zA-Z0-9_.-]+)+\\\\?)? ?([a-zA-Z0-9_.-]+)?"))
    ;

    Pattern pattern;
    RegexForCommands(Pattern pattern) {
        this.pattern = pattern;
    }

    public Pattern getPattern() {
        return pattern;
    }
}
