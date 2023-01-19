package model.pieces;

import model.Board;
import model.Coordinate;

import java.awt.*;
import java.util.HashSet;

public class King extends Piece {

    public King(Board board, Color color, Coordinate coordinate) {
        super(board, color,coordinate);
    }

    @Override
    public HashSet<Coordinate> possibleMoves() {
        HashSet<Coordinate> moves = new HashSet<>();
        if (board.getPieceByCoordinate(coordinate.getX(), coordinate.getY() + 1) != null) {
            moves.add(Coordinate.createCoordinate(coordinate.getX(), coordinate.getY() + 1));
        }
        if (board.getPieceByCoordinate(coordinate.getX() + 1, coordinate.getY()) != null) {
            moves.add(Coordinate.createCoordinate(coordinate.getX() + 1, coordinate.getY()));
        }
        if (board.getPieceByCoordinate(coordinate.getX(), coordinate.getY() - 1) != null) {
            moves.add(Coordinate.createCoordinate(coordinate.getX(), coordinate.getY() - 1));
        }
        if (board.getPieceByCoordinate(coordinate.getX() - 1, coordinate.getY()) != null) {
            moves.add(Coordinate.createCoordinate(coordinate.getX() - 1, coordinate.getY()));
        }

        return moves;
    }
}
