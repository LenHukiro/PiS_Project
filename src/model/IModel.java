package model;

import model.pieces.Piece;

public interface IModel {
    /**
     * Starts a new game
     */
    void newGame();
    /**
     * Starts a new game with the time limit of given seconds
     */
    void newGame(int seconds);

    /**
     * Returns if the coordinate is valid
     * @param x value of coordinate
     * @param y value of coordinate
     * @return The coordinate is inside of bounds
     */
    boolean isCoordinateInBounds(int x, int y);

    /**
     * Answers the current Task
     * @param answer If the task is solvable or not
     */
    void answerTask(boolean answer);

    /**
     * Returns the available time
     * @return the time
     */
    String getTime();

    /**
     * Returns the current Piece
     * @return the Piece
     */
    Piece getCurrentPiece();

    /**
     * Returns the current Coordinate of the current Piece
     * @return the Coordinate
     */
    Coordinate getPointCoordinate();

    /**
     * Returns the available number of moves for the piece
     * @return the number of moves
     */
    int getNumberOfMoves();

    /**
     * Returns the completed number of tasks
     * @return the number of tasks
     */
    int getCompletedTasks();

}