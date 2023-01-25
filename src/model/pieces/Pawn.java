package model.pieces;

import model.GameModel;
import model.Coordinate;

import java.awt.*;
import java.util.ArrayList;

/**
 * The Piece Pawn.
 */
public class Pawn extends Piece {
    /**
     * Boolean, if the pawn is on a pawn starting position
     */
    private final boolean hasNotMoved;

    /**
     * Instantiates a new Pawn.
     *
     * @param board      the board
     * @param color      the color
     * @param coordinate the coordinate
     */
    public Pawn(GameModel board, Color color, Coordinate coordinate) {
        super(board, color, coordinate);
        hasNotMoved = color == Color.BLACK && coordinate.getY() == 1 || color == Color.WHITE && coordinate.getY() == 6;
    }

    /**
     * Returns the possible moves for the Piece
     *
     * @return the moves
     */
    @Override
    public ArrayList<Coordinate> possibleMoves() {
        ArrayList<Coordinate> moves = new ArrayList<>();
        int modifier = color == Color.BLACK ? 1 : -1;
        if (hasNotMoved)
            moves.add(Coordinate.createCoordinate(coordinate.getX(), coordinate.getY() + 2 * modifier));
        moves.add(Coordinate.createCoordinate(coordinate.getX(), coordinate.getY() + modifier));
        return moves;
    }

    /**
     * Returns the name of the Piece with its article
     *
     * @return The name of the Piece
     */
    @Override
    public String getName() {
        return "der " + this.getColorAdverb() + "  Bauer";
    }
}
