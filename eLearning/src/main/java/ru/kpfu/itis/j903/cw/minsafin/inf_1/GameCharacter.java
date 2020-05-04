package ru.kpfu.itis.j903.cw.minsafin.inf_1;

public class GameCharacter implements Comparable<GameCharacter>{
    private int lvl;

    public GameCharacter(int lvl) {
        this.lvl = lvl;
    }

    @Override
    public int compareTo(GameCharacter o) {
        return lvl - o.lvl;
    }
}
