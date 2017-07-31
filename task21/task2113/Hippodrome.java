package com.javarush.task.task21.task2113;

import java.util.ArrayList;
import java.util.List;

public class Hippodrome {
    private static List<Horse> horses;
    static Hippodrome game;

    public static void main(String[] args) throws InterruptedException {
        game = new Hippodrome(new ArrayList<Horse>());
        Horse horse1 = new Horse("Lambo",3d,0d);
        Horse horse2 = new Horse("Jambo",3d,0d);
        Horse horse3 = new Horse("Crambo",3d,0d);
        game.getHorses().add(horse1);
        game.getHorses().add(horse2);
        game.getHorses().add(horse3);
        game.run();
        game.printWinner();
    }

    public Horse getWinner() {
        Horse j=null;
        double u=Double.MIN_VALUE;
        for (Horse h: horses) {
            if (h.distance>u) {
                j=h;
                u=h.distance;
            }
        }
        return j;
    }
    public void printWinner() {
        System.out.println("Winner is "+getWinner().getName()+"!");
    }

    public void run() throws InterruptedException {
        for (int i = 0; i <100 ; i++) {
            move();
            print();
            Thread.sleep(200);
        }

    }

    public void move() {
        for (Horse h:horses) {
            h.move();
        }
    }
    public void print() {
        for (Horse h:horses) {
            h.print();
        }
        for (int i = 0; i <10 ; i++) {
            System.out.println();
        }
    }

    public List<Horse> getHorses() {
        return horses;
    }

    public Hippodrome(List<Horse> horses) {
        this.horses = horses;
    }
}
