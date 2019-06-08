package group144.goldov;

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
        for (int i = 0; i < size; i++) {
            if (states[i][0] == states[i][1] && states[i][0] == states[i][2] && states[i][0] == StateOfButton.X) {
                    return StateOfGame.XWON;
            } else if (states[i][0] == states[i][1] &&
                    states[i][0] == states[i][2] && states[i][0] == StateOfButton.O) {
                    return StateOfGame.OWON;
                }
        }
        for (int i = 0; i < size; i++) {
            if (states[0][i] == states[1][i] && states[0][i] == states[2][i] && states[0][i] == StateOfButton.X) {
                return StateOfGame.XWON;
            } else if (states[0][i] == states[1][i] && states[0][i] == states[2][i] &&
                    states[0][i] == StateOfButton.O) {
                    return StateOfGame.OWON;
                }
        }
        if ((states[0][0] == states[1][1] && states[0][0] == states[2][2]) ||
                (states[0][2] == states[1][1] && states[0][2]== states[2][0])) {
            if (states[1][1] == StateOfButton.X) {
                return StateOfGame.XWON;
            } else if (states[1][1] == StateOfButton.O) {
                 return StateOfGame.OWON;
            }
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
