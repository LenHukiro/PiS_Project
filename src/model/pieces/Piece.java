package model.pieces;

import model.Coordinate;
import model.GameModel;

import java.awt.*;
import java.util.ArrayList;


/**
 * The abstract class, which is being used for every Piece inside the model.
 * Every new property, which affects every piece has to be defined in this class.
 * <p>
 * Since this is an abstract class it cannot be instanciated, though functions are being used outside of this package from this class.
 * Here are some examples on how to use them:
 * setCoordinate(Coordinate coordinate): This function sets the current coordinate of the piece to the given coordinate.
 * getCoordinate(): This function returns the current coordinate of the piece.
 *
 */
public abstract class Piece {

    /**
     * The coordinate of the Piece.
     */
    protected Coordinate coordinate;
    /**
     * The playing model of the Piece.
     */
    protected final GameModel model;
    /**
     * The Color of the model
     */
    protected final Color color;

    /**
     * Instantiates a new Piece.
     *
     * @param board      the model of the Piece
     * @param color      the color of the Piece
     * @param coordinate the coordinate of the Piece
     */
    public Piece(GameModel board, Color color, Coordinate coordinate) {
        this.model = board;
        this.color = color;
        this.coordinate = coordinate;
    }

    /**
     * Gets coordinate of the Piece.
     *
     * @return the coordinate
     */
    public Coordinate getCoordinate() {
        return coordinate;
    }

    /**
     * Set coordinate of the Piece.
     *
     * @param coordinate the coordinate
     */
    public void setCoordinate(Coordinate coordinate) {
        this.coordinate = coordinate;
    }

    /**
     * Returns the possible moves as ArrayList<Coordinate>
     *
     * @return the possible Moves
     */
    public abstract ArrayList<Coordinate> possibleMoves();

    /**
     * Gets color of the Piece
     *
     * @return the color
     */
    public Color getColor() {
        return color;
    }

    /**
     * Gets name of the Piece
     *
     * @return the name
     */
    public abstract String getName();

    /**
     * Gets color adverb of the Piece
     *
     * @return the color adverb
     */
    protected String getColorAdverb() {
        return getColor() == Color.BLACK ? "schwarze" : "weiße";
    }

}

