package com.nikovr;

public abstract class Creature {
    private String name;
    private int hp = 30;
    private int maxHp = 30;
    private int attack = 20;

    public abstract void eat();

    public Creature(String name){
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    public int getMaxHp() {
        return maxHp;
    }

    public void setMaxHp(int maxHp) {
        this.maxHp = maxHp;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }
}

