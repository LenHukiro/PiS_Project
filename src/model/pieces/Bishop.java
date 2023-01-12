package model.pieces;

import model.Board;
import model.Coordinate;

import java.awt.*;
import java.util.HashSet;


public class Bishop extends Piece {
    public Bishop(Board board, Color color, Coordinate coordinate) {
        super(board, color,coordinate);
    }

    @Override
    public HashSet<Coordinate> possibleMoves() {
        HashSet<Coordinate> moves = new HashSet<>();
        Piece piece = this;
        int[] modifiers = new int[]{-1, 1, 1, -1, -1};
        int count = 0;
        for (int i = 0; i <= modifiers.length - 1; i++) {
            while (piece != null) {
                piece = board.getPieceByCoordinate(coordinate.getX() + i * modifiers[count + 1], coordinate.getY() + (i * modifiers[count]));
                moves.add(coordinate);
            }
            count++;
        }
        return moves;
    }
}
