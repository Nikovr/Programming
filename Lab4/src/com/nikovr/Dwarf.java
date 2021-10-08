package com.nikovr;

public class Dwarf extends Creature implements Walkable, Fightable {

    private static int amountOfDwarves = 0;

    public void argue(Dwarf dwarf, Topic topic) {
        System.out.println(this + " спорит с " + dwarf + " на тему " + topic);
        int result = (int)(Math.random() * 2);
        if (result == 0) {
            topic.agree();
            System.out.println(this + " и " + dwarf + " пришли к соглашению");
        }
        else {
            topic.disagree();
            System.out.println(this + " и " + dwarf + " не согласны друг с другом.");
            this.fight(dwarf);
        }
    }

    public Dwarf() {
        super("Коротышка" + ++amountOfDwarves);
        setMaxHp(100);
        setHp(100);
        setAttack(30);
    }

    public Dwarf(String name) {
        super(name);
        setMaxHp(100);
        setHp(100);
        setAttack(30);
    }

    public Dwarf(String name, int maxHp, int attack ) {
        super(name);
        setMaxHp(maxHp);
        setHp(maxHp);
        setAttack(attack);
    }


    @Override
    public void eat() {
        setHp(getMaxHp());
        System.out.println(this + " поел картошки и полностью восстановил жизненные силы");
    }

    @Override
    public void walk(Location location) {
        System.out.println(this + " гуляет по локации " + location);
    }

    @Override
    public void fight(Creature opponent) {
        System.out.println("Коротышка " + this + " вызывает " + opponent + " на битву!");
        Creature winner;
        try {
            winner = new Battle(this, opponent).start();
        }
        catch (CreatureNotFightableException ex) {
            System.out.println(ex.getMessage());
            return;
        }
        System.out.println(winner + " одержал победу");
    }
}
