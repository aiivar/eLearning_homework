package ru.kpfu.itis.j903.cw.minsafin.inf_1;

import java.util.Objects;

public class GameCharacter implements Comparable<GameCharacter>{
    private int lvl;

    public GameCharacter(int lvl) {
        this.lvl = lvl;
    }

    @Override
    public int compareTo(GameCharacter o) {
        return lvl - o.lvl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GameCharacter that = (GameCharacter) o;
        return lvl == that.lvl;
    }

    @Override
    public int hashCode() {
        return Objects.hash(lvl);
    }
}
