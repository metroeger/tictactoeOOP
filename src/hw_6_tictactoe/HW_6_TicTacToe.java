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

    public static boolean playTurn(Board playBoard, Player player, boolean gameOver, char play) {
        playBoard.printBoard(playBoard.getRows(), playBoard.getColumns(), play);
        if (playBoard.isWinner(play)) {
            System.out.println("You won! : " + player.getName());
            player.setScore(player.getScore() + 1);
            gameOver = !gameOver;
        }
        return gameOver;
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
        Player player1 = new Player();
        Player player2 = new Player();
        Board playBoard = new Board(3, 3);
        String answer = "";
        char row = ' ';
        char col = ' ';
        int numOfGames = 0;

        player1.setName(player1.register("player1"));
        player2.setName(player2.register("player2"));
        System.out.println();
        
        do {
            playAgain = false;
            isDraw = false;
            gameOver = false;
            isTurn = true;
            steps = 0;
            
            if (numOfGames==0) System.out.println("Hello, let's play!");
            else System.out.println("Round " + numOfGames+1 + "!");
            playBoard.printBoard(0, 0, ' ');
            
            do {
                if (isTurn) {
                    player1.askInput();
                } else {
                    player2.askInput();
                }

                answer = input.nextLine();

                try {
                    row = answer.charAt(0);
                    col = answer.charAt(1);

                    playBoard.setRows(Character.getNumericValue(convert(row)));
                    playBoard.setColumns(Character.getNumericValue(answer.charAt(1) - 1));

                    while (!playBoard.isInRange(playBoard.getRows(), playBoard.getColumns())) {

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
                        gameOver = playTurn(playBoard, player1, gameOver, play1);
                        isTurn = !isTurn;
                    } else {
                        gameOver = playTurn(playBoard, player2, gameOver, play2);
                        isTurn = !isTurn;
                    }
                    steps++;

                } catch (Exception ex) {  // catch (StringIndexOutOfBoundsException ex) {
                    System.out.println("Oops, try again!");
                }
                
                if (steps > 8 && !gameOver) {
                    isDraw = !isDraw;
                    System.out.println("It's a DRAW!!");
                    gameOver = !gameOver;
                }
                if (gameOver)
                    numOfGames++;
                
            } while (!gameOver && steps < 9);

            System.out.println("The score is : \n" + player1.getScore() + " for " + player1.getName() + "\n"
                    + player2.getScore() + " for " + player2.getName());

            if (gameOver) {
                System.out.println("Wanna play again?");
                String soAgain = input.nextLine();
                if (soAgain.equalsIgnoreCase("y") || soAgain.equalsIgnoreCase("yes")) {
                    playAgain = true;
                    System.out.println();
                }
            } else {
                System.out.println("Thanks for playing!");
            }
            playBoard.clearBoard();
        } while (playAgain);

    }
}
