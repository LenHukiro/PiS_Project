package model.pieces;

import model.GameModel;
import model.Coordinate;

import java.awt.*;
import java.util.ArrayList;

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
    public Queen(GameModel board, Color color, Coordinate coordinate) {
        super(board, color,coordinate);
    }

    /**
     * Returns the possible moves for the Piece
     *
     * @return the moves
     */
    @Override
    public ArrayList<Coordinate> possibleMoves() {
        ArrayList<Coordinate> moves = new ArrayList<>();
        Rook rook = new Rook(model, color, coordinate);
        Bishop bishop = new Bishop(model, color, coordinate);
        moves.addAll(rook.possibleMoves());
        moves.addAll(bishop.possibleMoves());
        return moves;
    }

    /**
     * Returns the name of the Piece with its article
     *
     * @return The name of the Piece
     */
    @Override
    public String getName() {
        return "die " + this.getColorAdverb() + "Dame";
    }
}
