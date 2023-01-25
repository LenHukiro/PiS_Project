package model.pieces;

import model.GameModel;
import model.Coordinate;

import java.awt.*;
import java.util.ArrayList;

/**
 * The Piece King, which is being used in the model
 * <p>
 * The following functions are usually being used:
 * getPossibleMoves() to get the available moves for this piece
 * getName() returns a string with the name of the piece including its article
 *
 */
public class King extends Piece {

    /**
     * Instantiates a new King.
     *
     * @param board      the board
     * @param color      the color
     * @param coordinate the coordinate
     */
    public King(GameModel board, Color color, Coordinate coordinate) {
        super(board, color, coordinate);
    }

    /**
     * Returns the possible moves for the Piece
     *
     * @return the moves
     */
    @Override
    public ArrayList<Coordinate> possibleMoves() {
        ArrayList<Coordinate> moves = new ArrayList<>();
        int[] modifiers = new int[]{1, 0, -1};
        for (int i = 0; i <= 2; i++) {
            for (int j = 0; j <= 2; j++) {
                if (model.isCoordinateInBounds(coordinate.getX() + modifiers[i], coordinate.getY() + modifiers[j]) && !(i == j && modifiers[j] == 0)) {
                    moves.add(Coordinate.createCoordinate(coordinate.getX() + modifiers[i], coordinate.getY() + modifiers[j]));
                }
            }
        }
        return moves;
    }

    /**
     * Returns the name of the Piece with its article
     *
     * @return The name of the Piece
     */
    @Override
    public String getName() {
        return "der " + this.getColorAdverb() + " Koenig";
    }
}
