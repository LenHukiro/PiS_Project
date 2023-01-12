package model.pieces;

import model.Board;
import model.Coordinate;

import java.awt.*;
import java.util.HashSet;

public class Queen extends Piece {
    public Queen(Board board, Color color, Coordinate coordinate) {
        super(board, color,coordinate);
    }

    @Override
    public HashSet<Coordinate> possibleMoves() {
        HashSet<Coordinate> moves = new HashSet<>();
        Rook rook = new Rook(board, color, Coordinate.createCoordinate(0, 7));
        Bishop bishop = new Bishop(board, color, Coordinate.createCoordinate(5, 7));
        moves.addAll(board.simulateMoves(this.coordinate, rook));
        moves.addAll(board.simulateMoves(this.coordinate, bishop));
        return moves;
    }
}
