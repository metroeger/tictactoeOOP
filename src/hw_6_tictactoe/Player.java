package hw_6_tictactoe;

import java.util.Scanner;

public class Player {

    private int score;
    private String name;

    public Player() {

    }

    public Player(int score, String name) {
        this.score = 0;
        this.name = name;
    }

    public static String register(String player) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Hi " + player + ", please type your name: ");
        return sc.nextLine();
    }

    public void askInput() {
        System.out.println("Type your step, " + name + ": ");
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
