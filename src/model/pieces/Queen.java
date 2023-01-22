package model.pieces;

import model.Board;
import model.Coordinate;

import java.awt.*;
import java.util.HashSet;

/**
 * The type Queen.
 */
public class Queen extends Piece {
    /**
     * Instantiates a new Queen.
     *
     * @param board      the board
     * @param color      the color
     * @param coordinate the coordinate
     */
    public Queen(Board board, Color color, Coordinate coordinate) {
        super(board, color,coordinate);
    }

    @Override
    public HashSet<Coordinate> possibleMoves() {
        HashSet<Coordinate> moves = new HashSet<>();
        Rook rook = new Rook(board, color, coordinate);
        Bishop bishop = new Bishop(board, color, coordinate);
        moves.addAll(rook.possibleMoves());
        moves.addAll(bishop.possibleMoves());
        return moves;
    }

    @Override
    public String getName() {
        return "die " + this.getColorAdverb() + "Dame";
    }
}
