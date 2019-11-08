package group144.goldov;

import javax.swing.plaf.nimbus.State;

/** Tic Tac Toe field */
public class TicTacToeField {
    private final int size = 3;

    enum StateOfGame {PLAYING, XWON, OWON, DRAW}

    private enum Players {PLAYER1, PLAYER2}

    private Players currentPlayer;

    private enum StateOfButton {O, X, EMPTY}

    private StateOfButton[][] states = new StateOfButton[size][size];

    public TicTacToeField() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                states[i][j] = StateOfButton.EMPTY;
            }
        }
        currentPlayer = Players.PLAYER1;
    }

    /** Returns size of the field */
    public int getSize() {
        return size;
    }

    /**
     * Checks if the game is over
     * Returns the result of the game or informs that the game isn't over yet
     */
    public StateOfGame isGameOver() {
        boolean isWonByColumn = true;
        boolean isWonByLine = true;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size - 1; j++) {
                if (!(states[i][j] == states[i][j + 1] && states[i][j] == StateOfButton.X)) {
                    isWonByColumn = false;
                }
                if (!(states[j][i] == states[j + 1][i] && states[j][i] == StateOfButton.X)) {
                    isWonByLine = false;
                }
            }
            if (isWonByColumn || isWonByLine) {
                return StateOfGame.XWON;
            }
        }
        isWonByColumn = true;
        isWonByLine = true;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size - 1; j++) {
                if (!(states[i][j] == states[i][j + 1] && states[i][j] == StateOfButton.O)) {
                    isWonByColumn = false;
                }
                if (!(states[j][i] == states[j + 1][i] && states[j][i] == StateOfButton.O)) {
                    isWonByLine = false;
                }
            }
            if (isWonByColumn || isWonByLine) {
                return StateOfGame.OWON;
            }
        }
        boolean isWonByDiag = true;
        for (int i = 0; i < size - 1; i++) {
            if (states[i][i] != states[i + 1][i + 1]) {
                isWonByDiag = false;
            }
        }
        for (int i = 1; i < size - 1; i++) {
            if (states[0][size - 1] == states[i][i] && states[0][size - 1] == states[i + 1][i - 1]) {
                isWonByDiag = false;
            }
        }
        if (isWonByDiag && states[size - 1][size - 1] == StateOfButton.X) {
            return StateOfGame.XWON;
        } else if (isWonByDiag && states[size - 1][size - 1] == StateOfButton.O) {
            return StateOfGame.OWON;
        }
        boolean isDraw = true;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (states[i][j] == StateOfButton.EMPTY) {
                    isDraw = false;
                }
            }
        }
        if (isDraw) {
            return StateOfGame.DRAW;
        }
        return StateOfGame.PLAYING;
    }

    /** Makes turn. Returns false if the board is full */
    public boolean turn(int i, int j) {
        if (states[i][j] == StateOfButton.EMPTY) {
            if (currentPlayer == Players.PLAYER1) {
                states[i][j] = StateOfButton.X;
                currentPlayer = Players.PLAYER2;
            } else if (currentPlayer == Players.PLAYER2) {
                states[i][j] = StateOfButton.O;
                currentPlayer = Players.PLAYER1;
            }
            return true;
        }
        return false;
    }

    /** Returns which turn is right now */
    public String whichPlayer() {
        if (currentPlayer == Players.PLAYER1) {
            return "O";
        } else if (currentPlayer == Players.PLAYER2) {
            return "X";
        }
        return "";
    }
}
