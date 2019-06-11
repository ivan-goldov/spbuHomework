package group144.goldov;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TicTacToeFieldTest {
    @Test
    public void horizontalWin() {
        TicTacToeField field = new TicTacToeField();
        field.turn(0, 0);
        field.turn(1, 0);
        field.turn(0, 1);
        field.turn(1, 1);
        field.turn(0, 2);
        assertEquals(TicTacToeField.StateOfGame.XWON, field.isGameOver());
    }

    @Test
    public void verticalWin() {
        TicTacToeField field = new TicTacToeField();
        field.turn(0, 0);
        field.turn(0, 1);
        field.turn(1, 0);
        field.turn(0, 2);
        field.turn(2, 0);
        assertEquals(TicTacToeField.StateOfGame.XWON, field.isGameOver());
    }

    @Test
    public void diagonalWin() {
        TicTacToeField field = new TicTacToeField();
        field.turn(2, 0);
        field.turn(1, 1);
        field.turn(1, 0);
        field.turn(2, 2);
        field.turn(0, 2);
        field.turn(0, 0);
        assertEquals(TicTacToeField.StateOfGame.OWON, field.isGameOver());
    }
}