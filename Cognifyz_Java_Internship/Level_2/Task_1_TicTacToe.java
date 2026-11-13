package Level_2;
import java.util.Scanner;
public class Task_1_TicTacToe {
    static char[][] board = new char[3][3];
    public static void initializeBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = '-';
            }
        }
    }
    public static void displayBoard() {
        System.out.println("\n-------------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " | ");
            }
            System.out.println("\n-------------");
        }
    }
    public static boolean checkWin(char player) {
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == player &&
                board[i][1] == player &&
                board[i][2] == player) {
                return true;
            }
        }
        for (int j = 0; j < 3; j++) {
            if (board[0][j] == player &&
                board[1][j] == player &&
                board[2][j] == player) {
                return true;
            }
        }
        if (board[0][0] == player &&
            board[1][1] == player &&
            board[2][2] == player) {
            return true;
        }
        if (board[0][2] == player &&
            board[1][1] == player &&
            board[2][0] == player) {
            return true;
            }

        return false;
    }
    public static boolean checkDraw() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == '-') {
                    return false;
                }
            }
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        initializeBoard();
        char currentPlayer = 'X';
        boolean gameOver = false;
        System.out.println("Welcome to Tic-Tac-Toe!");
        while (!gameOver) {
            displayBoard();
            System.out.println("Player " + currentPlayer);
            System.out.print("Enter position (1-9): ");
            if (!sc.hasNextInt()) {
                System.out.println("Invalid input! Enter a number.");
                sc.next();
                continue;
            }
            int position = sc.nextInt();
            if (position < 1 || position > 9) {
                System.out.println("Invalid position! Try again.");
                continue;
            }
            int row = (position - 1) / 3;
            int col = (position - 1) % 3;
            if (board[row][col] != '-') {
                System.out.println("Position already occupied! Try again.");
                continue;
            }
            board[row][col] = currentPlayer;
            if (checkWin(currentPlayer)) {
                displayBoard();
                System.out.println("Player " + currentPlayer + " wins!");
                gameOver = true;
            }
            else if (checkDraw()) {
                displayBoard();
                System.out.println("Game is a draw!");
                gameOver = true;
            }
            else {
                if (currentPlayer == 'X') {
                    currentPlayer = 'O';
                } else {
                    currentPlayer = 'X';
                }
            }
        }
        System.out.println("Game Over!");
        sc.close();
    }
}
