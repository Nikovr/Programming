package com.nikovr;

public class Battle {
    private final int SURRENDER_HP = 20;
    private Creature fighter1;
    private Creature fighter2;
    public Battle(Creature challenger, Creature opponent){
        fighter1 = challenger;
        fighter2 = opponent;
    }

    public Creature start() throws CreatureNotFightableException{
        if (!(fighter1 instanceof Fightable) || !(fighter2 instanceof Fightable)) {
            throw new CreatureNotFightableException("Оппонент не умеет драться");
        }

        int turnOrder = 0;
        do{
            try {
                if (turnOrder % 2 == 0) {
                    turn(fighter1, fighter2);
                } else {
                    turn(fighter2, fighter1);
                }
                turnOrder++;
            }
            catch (FighterDiedException ex) {
                System.out.println(ex.getMessage());
                heal(fighter1.getHp() < fighter2.getHp() ? fighter1 : fighter2);
                return fighter1.getHp() < fighter2.getHp() ? fighter1 : fighter2;
            }
        } while (fighter1.getHp() > SURRENDER_HP && fighter2.getHp() > SURRENDER_HP);

        return fighter1.getHp() >= fighter2.getHp() ? fighter1 : fighter2;
    }
    private void turn(Creature current, Creature next) throws FighterDiedException {
        System.out.println(current + " ударяет по " + next);
        next.setHp(next.getHp() - (int)(Math.random() * current.getAttack()));
        if (next.getHp() < 0) {
            throw new FighterDiedException(next + " не пережил этого удара");
        }
        System.out.println("У " + next + " осталось " + next.getHp() + " здоровья");
    }

    private void heal(Creature wounded) {
        System.out.println("Бой окончен и " + wounded + " оказывают помощь");
        wounded.eat();
    }

}
