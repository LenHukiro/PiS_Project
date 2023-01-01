package model.pieces;

import model.Board;
import model.Coordinate;
import processing.core.PImage;

import java.awt.*;
import java.util.HashSet;

public class King extends Piece {

    boolean hasMoved = false;
    public King(Board board, Color color) {
        super(board, color);
    }

    public void move() {
        if(!hasMoved) disableCastling();
    }

    private void disableCastling() {
        Rook[] rooks = board.getAllRooks();
        for (Rook rook : rooks) {
            rook.hasRightToCastle= false;
        }
        hasMoved = !hasMoved;
    }

    @Override
    public HashSet<Coordinate> possibleMoves() {
       HashSet<Coordinate> moves = new HashSet<>();
        if (board.getPieceByCoordinate(coordinate.getX(),coordinate.getY() + 1) != null) {
            moves.add(Coordinate.createCoordinate(coordinate.getX(), coordinate.getY() + 1));
        }
        if (board.getPieceByCoordinate(coordinate.getX() + 1,coordinate.getY()) != null) {
            moves.add(Coordinate.createCoordinate(coordinate.getX() + 1, coordinate.getY()));
        }
        if (board.getPieceByCoordinate(coordinate.getX(),coordinate.getY() - 1) != null) {
            moves.add(Coordinate.createCoordinate(coordinate.getX(), coordinate.getY() - 1));
        }
        if (board.getPieceByCoordinate(coordinate.getX() - 1,coordinate.getY()) != null) {
            moves.add(Coordinate.createCoordinate(coordinate.getX() - 1, coordinate.getY()));
        }

       return moves;
    }
}
