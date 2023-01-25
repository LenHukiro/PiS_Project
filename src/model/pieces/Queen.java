package model.pieces;

import model.GameModel;
import model.Coordinate;

import java.awt.*;
import java.util.ArrayList;

/**
 * The Piece Queen, which is being used in the model
 * <p>
 * The following functions are usually being used:
 * getPossibleMoves() to get the available moves for this piece
 * getName() returns a string with the name of the piece including its article
 *
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
        moves.addAll(new Rook(model, color, coordinate).possibleMoves());
        moves.addAll(new Bishop(model, color, coordinate).possibleMoves());
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
