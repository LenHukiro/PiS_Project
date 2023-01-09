package model.pieces;

import model.Board;
import model.Coordinate;

import java.awt.*;
import java.util.HashSet;

public class Knight extends Piece {
    public Knight(Board board, Color color) {
        super(board, color);
    }

    @Override
    public void move() {

    }

    @Override
    protected void setImage() {

    }

    @Override
    public HashSet<Coordinate> possibleMoves() {
        HashSet<Coordinate> moves = new HashSet<>();
        int[] longKnightMoves = new int[]{2, -2};
        int[] knightYMoves = new int[]{1, -1};
        for (int k = 0; k < 2; k++) {
            for (int j = 0; j < 2; j++) {
                int x = coordinate.getX() + longKnightMoves[j];
                for (int i = 0; i < 2; i++) {
                    int y = coordinate.getY() + knightYMoves[i];
                    Coordinate coordinate1 = Coordinate.createCoordinate(x, y);
                    if (coordinate1 != null)
                        moves.add(Coordinate.createCoordinate(x, y));
                }
            }
            int[] temp = longKnightMoves;
            longKnightMoves = knightYMoves;
            knightYMoves = temp;
        }
        return moves;
    }
}
