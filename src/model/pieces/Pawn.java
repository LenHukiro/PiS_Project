package model.pieces;

import model.Board;
import model.Coordinate;

import java.awt.*;
import java.util.HashSet;

/**
 * The type Pawn.
 */
public class Pawn extends Piece {
    private final boolean hasntMoved;

    /**
     * Instantiates a new Pawn.
     *
     * @param board      the board
     * @param color      the color
     * @param coordinate the coordinate
     */
    public Pawn(Board board, Color color, Coordinate coordinate) {
        super(board, color, coordinate);
        hasntMoved = color == Color.BLACK && coordinate.getY() == 1 || color == Color.WHITE && coordinate.getY() == 6;
    }

    @Override
    public HashSet<Coordinate> possibleMoves() {
        HashSet<Coordinate> moves = new HashSet<>();
        int modifier = color == Color.BLACK ? 1 : -1;
        if (hasntMoved)
            moves.add(Coordinate.createCoordinate(coordinate.getX(), coordinate.getY() + 2 * modifier));
        moves.add(Coordinate.createCoordinate(coordinate.getX(), coordinate.getY() + modifier));
        return moves;
    }

    @Override
    public String getName() {
        return "der " + this.getColorAdverb() + "  Bauer";
    }
}
