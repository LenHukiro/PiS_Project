package model.pieces;

import model.GameModel;
import model.Coordinate;

import java.awt.*;
import java.util.HashSet;


/**
 * The type Piece.
 */
public abstract class Piece {
    /**
     * The Coordinate.
     */
    Coordinate coordinate;
    /**
     * The Board.
     */
    GameModel board;
    /**
     * The Color.
     */
    Color color;

    /**
     * Instantiates a new Piece.
     *
     * @param board      the board
     * @param color      the color
     * @param coordinate the coordinate
     */
    public Piece(GameModel board, Color color, Coordinate coordinate) {
        this.board = board;
        this.color = color;
        this.coordinate = coordinate;
    }

    /**
     * Gets coordinate.
     *
     * @return the coordinate
     */
    public Coordinate getCoordinate() {
        return coordinate;
    }

    /**
     * Possible moves hash set.
     *
     * @return the hash set
     */
    public abstract HashSet<Coordinate> possibleMoves();

    /**
     * Gets color.
     *
     * @return the color
     */
    public Color getColor() {
        return color;
    }

    /**
     * Set coordinate.
     *
     * @param coordinate the coordinate
     */
    public void setCoordinate(Coordinate coordinate){ this.coordinate = coordinate;}

    /**
     * Gets name.
     *
     * @return the name
     */
    public abstract String getName();

    /**
     * Gets color adverb.
     *
     * @return the color adverb
     */
    protected String getColorAdverb() {
        return getColor() == Color.BLACK ? "schwarze" : "weiße";
    }
    public Object clone() throws CloneNotSupportedException
    {
        return super.clone();
    }
}

