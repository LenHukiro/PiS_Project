package view;

import java.awt.*;

/**
 * The interface View.
 */
public interface IView {
    /**
     * Updates the viewable board.
     */
    void updateBoard();

    /**
     * Marks the Piece on the viewable board
     * @param x the x coordinate on the board
     * @param y the y coordinate on the board
     */
    void markPiece(int x, int y);

    /**
     * resets the board
     */
    void resetBoard();

    /**
     * Updates the number of completed tasks
     * @param count the number of completed tasks
     */
    void updateDoneCount(int count);

    /**
     * Sets the viewable timer
     * @param time The time
     */
    void setTimer(String time);

    /**
     * Starts a new game
     */
    void newGame();

    /**
     * Updates the viewable component to show the number of currently available moves
     * @param numberOfMoves the number of moves
     */
    void updateNumberOfAttempts(int numberOfMoves);

    /**
     * Places a Piece into the correct cell
     * @param pieceTyp The PieceType(King,Pawn,..etc) of the Piece
     * @param color the color of the Piece
     * @param x the x coordinate of the Piece
     * @param y the y coordinate of the Piece
     */
    void placePiece(PieceType pieceTyp, Color color, int x, int y);

    /**
     * Enables the Buttons to answer the task
     */
    void enableBtns();
}
