package model.pieces;

import model.GameModel;
import model.Coordinate;

import java.awt.*;
import java.util.HashSet;

/**
 * The type King.
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
     * @return
     */
    @Override
    public HashSet<Coordinate> possibleMoves() {
        HashSet<Coordinate> moves = new HashSet<>();
        int[] modifiers = new int[]{1, 0, -1};
        for (int i = 0; i <= 2; i++) {
            for (int j = 0; j <= 2; j++) {
                if (board.isCoordniateInBounds(coordinate.getX() + modifiers[i], coordinate.getY() + modifiers[j]) && !(i == j && modifiers[j] == 0)) {
                    moves.add(Coordinate.createCoordinate(coordinate.getX() + modifiers[i], coordinate.getY() + modifiers[j]));
                }
            }
        }
        return moves;
    }

    /**
     * @return
     */
    @Override
    public String getName() {
        return "der " + this.getColorAdverb() + " Koenig";
    }
}
