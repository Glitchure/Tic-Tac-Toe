package tictactoe;

import java.util.Scanner;

public class Main {
    static String numbers = "1234567890";
    static Scanner scanner = new Scanner(System.in);
    static char[][] board = new char[3][3];
    static boolean isXTurn = true;

    public static void main(String[] args) {
        String gameState;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = ' ';
            }
        }

        printBoard();
        while (true) {
            move();
            gameState = checkBoard();
            if (gameState.equals("X wins") || gameState.equals("O wins") || gameState.equals("Draw")) {
                printBoard();
                System.out.println(gameState);
                break;
            } else {
                printBoard();
            }
        }
    }

    public static void printBoard() {
        System.out.println("---------");
        for (int i = 0; i < 3; i++) {
            System.out.print("|");
            System.out.print(" ");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j]);
                System.out.print(" ");
            }
            System.out.print("|");
            System.out.println();
        }
        System.out.println("---------");
    }

    public static String checkBoard() {
        int numOfX = 0;
        int numOfO = 0;
        int numOfEmpty = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == 'X') {
                    numOfX++;
                } else if (board[i][j] == 'O') {
                    numOfO++;
                } else {
                    numOfEmpty++;
                }
            }
        }
        if (Math.abs(numOfX - numOfO) > 1) {
            System.out.println("Impossible");
            return "Impossible";
        }

        int numXWins = 0;
        int numOWins = 0;
        for (int i = 0; i < 3; i++) {
            int xCounter = 0;
            int oCounter = 0;
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == 'X') {
                    xCounter++;
                } else if (board[i][j] == 'O') {
                    oCounter++;
                }
            }
            if (xCounter == 3) {
                numXWins++;
            } else if (oCounter == 3) {
                numOWins++;
            }
        }
        for (int i = 0; i < 3; i++) {
            int xCounter = 0;
            int oCounter = 0;
            for (int j = 0; j < 3; j++) {
                if (board[j][i] == 'X') {
                    xCounter++;
                } else if (board[j][i] == 'O') {
                    oCounter++;
                }
            }
            if (xCounter == 3) {
                numXWins++;
            } else if (oCounter == 3) {
                numOWins++;
            }
        }
        for (int i = 0; i < 1; i++) {
            int xCounter = 0;
            int oCounter = 0;
            for (int j = 0; j < 3; j++) {
                if (board[j][j] == 'X') {
                    xCounter++;
                } else if (board[j][j] == 'O') {
                    oCounter++;
                }
            }
            if (xCounter == 3) {
                numXWins++;
            } else if (oCounter == 3) {
                numOWins++;
            }
        }
        for (int i = 0; i < 1; i++) {
            int xCounter = 0;
            int oCounter = 0;
            int firstIndex = 0;
            for (int j = 2; j >= 0; j--) {
                if (board[firstIndex][j] == 'X') {
                    xCounter++;
                } else if (board[firstIndex][j] == 'O') {
                    oCounter++;
                }
                firstIndex++;
            }
            if (xCounter == 3) {
                numXWins++;
            } else if (oCounter == 3) {
                numOWins++;
            }
        }
        if ((Math.abs(numXWins - numOWins) == 0 || Math.abs(numXWins - numOWins) > 1) && (numXWins > 0 || numOWins > 0)) {
            return "Impossible";
        }

        if (numXWins > 0) {
            return "X wins";
        } else if (numOWins > 0) {
            return "O wins";
        } else if (numOfEmpty == 0) {
            return "Draw";
        }
        return "Game not finished";
    }

    public static void move() {
        while (true) {
            boolean shouldContinue = false;
            String tempXCoordinate = scanner.next();

            for (int i = 0; i < tempXCoordinate.length(); i++) {
                if (numbers.indexOf(tempXCoordinate.charAt(i)) == -1) {
                    shouldContinue = true;
                    break;
                }
            }

            String tempYCoordinate = scanner.next();

            for (int i = 0; i < tempYCoordinate.length(); i++) {
                if (numbers.indexOf(tempYCoordinate.charAt(i)) == -1) {
                    shouldContinue = true;
                    break;
                }
            }

            if (shouldContinue) {
                System.out.println("You should enter numbers!");
                continue;
            }

            int xCoordinate = Integer.parseInt(tempXCoordinate);
            int yCoordinate = Integer.parseInt(tempYCoordinate);

            if (xCoordinate > 3 || xCoordinate < 1) {
                System.out.println("Coordinates should be from 1 to 3!");
                continue;
            }
            if (yCoordinate > 3 || yCoordinate < 1) {
                System.out.println("Coordinates should be from 1 to 3!");
                continue;
            }

            if (!(board[xCoordinate - 1][yCoordinate - 1] == ' ')) {
                System.out.println("This cell is occupied!");
                continue;
            }

            if (isXTurn) {
                board[xCoordinate - 1][yCoordinate - 1] = 'X';
            } else {
                board[xCoordinate - 1][yCoordinate - 1] = 'O';
            }
            isXTurn = !isXTurn;
            return;
        }
    }
}