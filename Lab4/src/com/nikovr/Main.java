package com.nikovr;

public class Main {

    public static void main(String[] args) {
        Scenario.startScene1();
    }
    static class Scenario{
        static final int AMOUNT_OF_DWARF_ENCOUNTERS = 4;

        public static void startScene1(){
            Topic topic = new Topic("невесомость");

            System.out.println("Жители Цветочного города не уверены в существовании явления " + topic + ", виной всему Незнайка");

            printSeparator();

            Dwarf neznaika = new Dwarf("Незнайка", 100, 40);
            Dwarf gunka = new Dwarf("Гунька", 120, 50);

            neznaika.walk(Location.STREET);
            neznaika.argue(gunka, topic);

            printSeparator();

            for (int i = 0; i < AMOUNT_OF_DWARF_ENCOUNTERS; i++) {
                Dwarf dwarf = new Dwarf();
                dwarf.walk(Location.FLOWER_CITY);
                dwarf.argue(new Dwarf(), topic);
                printSeparator();
            }

            Creature bug = new Creature("Жучок") {
                @Override
                public void eat() {
                    System.out.println(this + " спокойно кушает листик и никого не трогает");
                }
            };

            System.out.println("У Незнайки был очень тяжелый день");
            neznaika.walk(Location.ROAD_TO_HOME);
            bug.eat();
            neznaika.fight(bug);

            printSeparator();

            topic.showResults();
        }

        public static void printSeparator(){
            System.out.println();
            System.out.println("=================================================================================");
            System.out.println();
        }

    }
}

