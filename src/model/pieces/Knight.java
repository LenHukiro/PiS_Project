package model.pieces;

import model.Board;
import model.Coordinate;

import java.awt.*;
import java.util.HashSet;

/**
 * The type Knight.
 */
public class Knight extends Piece {
    /**
     * Instantiates a new Knight.
     *
     * @param board      the board
     * @param color      the color
     * @param coordinate the coordinate
     */
    public Knight(Board board, Color color, Coordinate coordinate) {
        super(board, color,coordinate);
    }

    @Override
    public HashSet<Coordinate> possibleMoves() {
        HashSet<Coordinate> moves = new HashSet<>();
        int[] knightTwoStep = new int[]{2, -2};
        int[] knightOneStep = new int[]{1, -1};
        for (int k = 0; k < 2; k++) {
            for (int j = 0; j < 2; j++) {
                int x = coordinate.getX() + knightTwoStep[j];
                for (int i = 0; i < 2; i++) {
                    int y = coordinate.getY() + knightOneStep[i];
                    Coordinate coordinate1 = Coordinate.createCoordinate(x, y);
                    if (coordinate1.getY() != -1 && coordinate1.getX()!= -1)
                        moves.add(Coordinate.createCoordinate(x, y));
                }
            }
            int[] temp = knightTwoStep;
            knightTwoStep = knightOneStep;
            knightOneStep = temp;
        }
        return moves;
    }

    @Override
    public String getName() {
        return "der " + this.getColorAdverb() + " Springer";
    }
}
