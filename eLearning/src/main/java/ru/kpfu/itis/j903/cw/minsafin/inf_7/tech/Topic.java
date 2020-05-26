package ru.kpfu.itis.j903.cw.minsafin.inf_7.tech;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Topic topic = (Topic) o;
        return views == topic.views &&
                Objects.equals(name, topic.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(views, name);
    }
}
