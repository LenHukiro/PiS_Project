package model.pieces;

import model.Board;
import model.Coordinate;
import processing.core.PImage;

import java.awt.*;
import java.util.HashSet;

public class Queen extends Piece {
    public Queen(Board board, Color color) {
        super(board, color);
    }

    @Override
    public void move() {
    }

    @Override
    public HashSet<Coordinate> possibleMoves() {
        HashSet<Coordinate> moves = new HashSet<>();
        Rook rook = new Rook(board,color);
        Bishop bishop = new Bishop(board,color);
        moves.addAll(board.simulateMoves(this.coordinate,rook));
        moves.addAll(board.simulateMoves(this.coordinate,bishop));
        return moves;
    }
}
