package model.pieces;

import model.Board;
import model.Coordinate;

import java.awt.*;
import java.util.HashSet;

public class King extends Piece {

    public King(Board board, Color color, Coordinate coordinate) {
        super(board, color, coordinate);
    }

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

    @Override
    public String getName() {
        return "der " + this.getColorAdverb() + " Koenig";
    }
}
