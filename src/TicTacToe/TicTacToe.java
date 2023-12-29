package TicTacToe;

import java.util.Scanner;

public class TicTacToe {
    private static char[][] board = new char[3][3];
    private static char currentPlayer ='X';

    public static void main(String[] args) {
        initializeBoard();
        printBoard();

        while (true) {
            makeMove();
            printBoard();

            if (isWinner()) {
                System.out.println("Spieler " + currentPlayer + " gewinnt!");
                break;
            } else if (isBoardFull()) {
                System.out.println("Unentschieden!");
                break;
            }

            switchPlayer();
        }
    }

    private static void initializeBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = ' ';
            }
        }
    }

    private static void printBoard() {
        System.out.println("-------------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " | ");
            }
            System.out.println();
            System.out.println("-------------");
        }
    }

    private static void makeMove() {
        Scanner scanner = new Scanner(System.in);
        int row, col;

        do {
            System.out.println("Spieler " + currentPlayer + ", gib die Zeile (0-2) und Spalte (0-2) ein (beide durch Leerzeichen getrennt): ");
            row = scanner.nextInt();
            col = scanner.nextInt();
        } while (row < 0 || row >= 3 || col < 0 || col >= 3 || board[row][col] != ' ');

        board[row][col] = currentPlayer;
    }

    private static void switchPlayer() {
        currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
    }

    private static boolean isWinner() {
        // Überprüfen Sie die Zeilen, Spalten und Diagonalen auf einen Sieg
        for (int i = 0; i < 3; i++) {
            if ((board[i][0] == currentPlayer && board[i][1] == currentPlayer && board[i][2] == currentPlayer) ||
                    (board[0][i] == currentPlayer && board[1][i] == currentPlayer && board[2][i] == currentPlayer)) {
                return true;
            }
        }

        if ((board[0][0] == currentPlayer && board[1][1] == currentPlayer && board[2][2] == currentPlayer) ||
                (board[0][2] == currentPlayer && board[1][1] == currentPlayer && board[2][0] == currentPlayer)) {
            return true;
        }

        return false;
    }

    private static boolean isBoardFull() {
        // Überprüfen Sie, ob das Spielfeld voll ist
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }
}
