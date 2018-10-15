package hw_6_tictactoe;

import java.util.Scanner;

public class HW_6_TicTacToe {

    public static void printBoard(char[][] board) {
        System.out.println();
        System.out.println("    1   2   3  ");
        System.out.println("  -------------");
        System.out.println("A | " + board[0][0] + " | " + board[0][1] + " | " + board[0][2] + " |");
        System.out.println("  |-----------|");
        System.out.println("B | " + board[1][0] + " | " + board[1][1] + " | " + board[1][2] + " |");
        System.out.println("  |-----------|");
        System.out.println("C | " + board[2][0] + " | " + board[2][1] + " | " + board[2][2] + " |");
        System.out.println("  -------------");
    }

    public static boolean isInRange(int row, int col) {
        if (row < 0 || row > 2 || col < 0 || col > 2) {
            return false;
        }
        return true;
    }


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

    public static boolean isTaken(char element) {
        if (element == 'x' || element == 'o') {
            return true;
        }
        return false;
    }

    public static boolean checkDiagonal(char[][] board, char player) {

        if (board[0][0] == player && board[1][1] == player && board[2][2] == player
                || board[0][2] == player && board[1][1] == player && board[2][0] == player) {
            return true;
        }
        return false;
    }

    public static boolean checkRows(char[][] board, char player) {

        for (int i = 0; i < board.length; i++) {
            if (board[i][0] == player && board[i][1] == player && board[i][2] == player) {

                return true;
            }
        }
        return false;
    }

    public static boolean checkColumns(char[][] board, char player) {

        for (int i = 0; i < board.length; i++) {
            if (board[0][i] == player && board[1][i] == player && board[2][i] == player) {

                return true;
            }
        }
        return false;
    }

    public static boolean isWinner(char[][] board, char player) {

        if (checkColumns(board, player) || checkRows(board, player) || checkDiagonal(board, player)) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        char[][] board = new char[3][3];
        char play1 = 'x';
        char play2 = 'o';
        int steps = 0;
        boolean isPlayer = true;
        boolean player1 = false;
        boolean player2 = false;
        boolean isDraw = false;
        boolean gameOver = false;
        boolean playAgain = false;
        int playerOne = 0;
        int playerTwo = 0;

        do {
            System.out.println("Hello, let's play!");

            printBoard(board);

            player1 = true;

            do {
 
                System.out.print("Type your step: ");
                String answer;
                answer = input.nextLine();

                char row = answer.charAt(0);
                char col = answer.charAt(1);

                int rowInt = Character.getNumericValue(convert(row));
                int colInt = Character.getNumericValue(answer.charAt(1) - 1);

                while (rowInt >= 4 || rowInt < 0 || colInt < 0 || colInt >= 3) {

                    System.out.print("You are out of range, give a valid step: ");
                    answer = input.nextLine();
                    row = answer.charAt(0);
                    col = answer.charAt(1);

                    rowInt = Character.getNumericValue(convert(row));
                    colInt = Character.getNumericValue(answer.charAt(1) - 1);

                }
                while (isTaken(board[rowInt][colInt])) {
                    System.out.print("It's taken, choose an other step: ");
                    answer = input.nextLine();
                    row = answer.charAt(0);
                    col = answer.charAt(1);

                    rowInt = Character.getNumericValue(convert(row));
                    colInt = Character.getNumericValue(answer.charAt(1) - 1);

                }
                if (player1) {
                    board[rowInt][colInt] = play1;
                    if (isWinner(board, play1)) {
                        System.out.println("You won! : ");
                        playerOne++;
                        gameOver = !gameOver;
                    }
                    player1 = !player1;
                    player2 = !player2;

                } else if (player2) {
                    board[rowInt][colInt] = play2;
                    if (isWinner(board, play2)) {
                        System.out.println("You won 2222!");
                        playerTwo++;
                        gameOver = !gameOver;
                    }
                    player2 = !player2;
                    player1 = !player1;
                }

                printBoard(board);
                steps++;

                if (steps > 8) {
                    isDraw = !isDraw;
                    System.out.println("It's a DRAW!!");
                    gameOver = !gameOver;
                }

            } while (!gameOver && steps < 9);

            System.out.println("The score is : \n" + playerOne + " for player 1 \n" + playerTwo + " for player 2.");

            if (gameOver) {
                System.out.println("Wanna play again?");
                String soAgain = input.nextLine();
                if (soAgain.equalsIgnoreCase("y") || soAgain.equalsIgnoreCase("yes")) {
                    playAgain = true;
                    System.out.println();
                }
            }

        } while (playAgain);

    }
}
