package model.pieces;

import model.Board;
import model.Coordinate;

import java.awt.*;
import java.util.HashSet;

public class Rook extends Piece {
    boolean hasRightToCastle = true;

    public Rook(Board board, Color color, Coordinate coordinate) {
        super(board, color,coordinate);
    }

    public void move() {
        hasRightToCastle = false;
    }

    @Override
    public HashSet<Coordinate> possibleMoves() {
        HashSet<Coordinate> moves = new HashSet<>();
        Coordinate newCoordinate = coordinate; //TODO: fix this ugly mess
        for (int j = 0; j < 8; j++) {
            newCoordinate.setX(newCoordinate.getX() + 1);
            if (coordinate == null) break;
            moves.add(newCoordinate);
        }
        for (int i = 0; i < 8; i++) {
            newCoordinate.setX(newCoordinate.getX() - 1);
            if (coordinate == null) break;
            moves.add(newCoordinate);
        }
        for (int k = 0; k < 8; k++) {
            newCoordinate.setY(newCoordinate.getY() + 1);
            if (coordinate == null) break;
            moves.add(newCoordinate);
        }
        for (int l = 0; l < 8; l++) {
            newCoordinate.setY(newCoordinate.getY() - 1);
            if (coordinate == null) break;
            moves.add(newCoordinate);
        }
        return moves;
    }
}
