package TicTacToe;

public class Board {

    private int rows;
    private int columns;
    private char[][] board;

    public Board() {

    }

    public Board(int rows, int columns) {
        board = new char[rows][columns];
    }

    public void printBoard(int row, int col, char player) {

        board[row][col] = player;

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


    public boolean isInRange(int rowInt, int colInt) {
        while (rowInt >= 4 || rowInt < 0 || colInt < 0 || colInt >= 3) {
            return false;
        }
        return true;
    }

    public boolean isTaken(int rowInt, int colInt) {

        if (board[rowInt][colInt] == 'x' || board[rowInt][colInt] == 'o') {
            return true;
        }
        return false;
    }

    public boolean checkDiagonal(char[][] board, char player) {

        if (board[0][0] == player && board[1][1] == player && board[2][2] == player
                || board[0][2] == player && board[1][1] == player && board[2][0] == player) {
            return true;
        }
        return false;
    }

    public boolean checkRows(char[][] board, char player) {

        for (int i = 0; i < board.length; i++) {
            if (board[i][0] == player && board[i][1] == player && board[i][2] == player) {

                return true;
            }
        }
        return false;
    }

    public boolean checkColumns(char[][] board, char player) {

        for (int i = 0; i < board.length; i++) {
            if (board[0][i] == player && board[1][i] == player && board[2][i] == player) {
                return true;
            }
        }
        return false;
    }

    public boolean isWinner(char player) {

        if (checkColumns(board, player) || checkRows(board, player) || checkDiagonal(board, player)) {
            return true;
        }
        return false;
    }

    public void clearBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = ' ';
            }
        }
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getColumns() {
        return columns;
    }

    public void setColumns(int columns) {
        this.columns = columns;
    }

    public char[][] getBoard() {
        return board;
    }

    public void setBoard(char[][] board) {
        this.board = board;
    }

}
