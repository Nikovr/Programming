package com.nikovr;

public class Topic {
    private String name;
    private int countAgreed;
    private int countDisagreed;

    public Topic(String name) {
        this.name = name;
    }

    public void disagree() {
        countDisagreed++;
    }

    public void agree() {
        countAgreed++;
    }

    public void showResults() {
        if (countAgreed > countDisagreed) {
            System.out.println("Таким образом, все согласны по поводу темы " + this);
        } else if (countAgreed < countDisagreed) {
            System.out.println("Таким образом, все несогласны по поводу темы " + this);
        } else {
            System.out.println("Никто не знает, как себя чувствовать по поводу темы " + this);
        }
    }

    @Override
    public String toString() {
        return name;
    }
}
