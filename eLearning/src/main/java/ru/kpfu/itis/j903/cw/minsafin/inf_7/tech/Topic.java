package ru.kpfu.itis.j903.cw.minsafin.inf_7.tech;

public class Topic {
    private int views;
    private String name;

    public Topic(int views, String name) {
        this.views = views;
        this.name = name;
    }

    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
