package hw_6_tictactoe;

import java.util.Scanner;

public class HW_6_TicTacToe {

    public static char convert(char row) {
        if (row == 'a' || row == 'A') {
            row = '0';
        } else if (row == 'b' || row == 'B') {
            row = '1';
        } else if (row == 'c' || row == 'c') {
            row = '2';
        }
        return row;
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        char play1 = 'x';
        char play2 = 'o';
        int steps = 0;
        boolean isTurn;
        boolean isDraw;
        boolean gameOver;
        boolean playAgain;
        Player player1 = new Player(0);
        Player player2 = new Player(0);
        Board playBoard = new Board(3, 3);
        String answer;

        do {
            playAgain = false;
            isDraw = false;
            gameOver = false;
            steps = 0;
            System.out.println("Hello, let's play!");
            playBoard.printBoard(0, 0, ' ');
            isTurn = true;

            do {
                player1.askInput();
                answer = input.nextLine();

                char row = answer.charAt(0);
                char col = answer.charAt(1);

                playBoard.setRows(Character.getNumericValue(convert(row)));
                playBoard.setColumns(Character.getNumericValue(answer.charAt(1) - 1));

                while (playBoard.isInRange(playBoard.getRows(), playBoard.getColumns())) {

                    System.out.print("You are out of range, give a valid step: ");
                    answer = input.nextLine();
                    row = answer.charAt(0);
                    col = answer.charAt(1);

                    playBoard.setRows(Character.getNumericValue(convert(row)));
                    playBoard.setColumns(Character.getNumericValue(answer.charAt(1) - 1));
                }
                while (playBoard.isTaken(playBoard.getRows(), playBoard.getColumns())) {
                    System.out.print("It's taken, choose an other field: ");
                    answer = input.nextLine();
                    row = answer.charAt(0);
                    col = answer.charAt(1);

                    playBoard.setRows(Character.getNumericValue(convert(row)));
                    playBoard.setColumns(Character.getNumericValue(answer.charAt(1) - 1));

                }
                if (isTurn) {
                    playBoard.printBoard(playBoard.getRows(), playBoard.getColumns(), play1);
                    if (playBoard.isWinner(play1)) {
                        System.out.println("You won! : ");
                        player1.setScore(1);
                        gameOver = !gameOver;
                    }
                    isTurn = !isTurn;

                } else {
                    playBoard.printBoard(playBoard.getRows(), playBoard.getColumns(), play2);
                    if (playBoard.isWinner(play2)) {
                        System.out.println("You won 2222!");
                        player2.setScore(1);
                        gameOver = !gameOver;
                    }
                    isTurn = !isTurn;
                }

                steps++;

                if (steps > 8 && !gameOver) { // if steps>8 && no winner yet, must be draw
                    isDraw = !isDraw;
                    System.out.println("It's a DRAW!!");
                    gameOver = !gameOver;
                }

            } while (!gameOver && steps < 9);

            System.out.println("The score is : \n" + player1.getScore() + " for player 1 \n" + player2.getScore() + " for player 2.");

            if (gameOver) {
                System.out.println("Wanna play again?");
                String soAgain = input.nextLine();
                if (soAgain.equalsIgnoreCase("y") || soAgain.equalsIgnoreCase("yes")) {
                    playAgain = true;
                    System.out.println();
                }
            }
            playBoard.clearBoard();
        } while (playAgain);

    }
}
