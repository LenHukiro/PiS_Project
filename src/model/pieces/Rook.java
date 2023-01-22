package model.pieces;

import model.Board;
import model.Coordinate;

import java.awt.*;
import java.util.HashSet;

public class Rook extends Piece {

    public Rook(Board board, Color color, Coordinate coordinate) {
        super(board, color, coordinate);
    }

    @Override
    public HashSet<Coordinate> possibleMoves() {
        HashSet<Coordinate> moves = new HashSet<>();
        Coordinate newCoordinate = Coordinate.createCoordinate(coordinate.getX(),coordinate.getY());
        for (int j = 0; j < 8; j++) {
            newCoordinate.setX(j);
            if (coordinate.getX() == newCoordinate.getX()) continue;
            moves.add(Coordinate.createCoordinate(newCoordinate.getX(), newCoordinate.getY()));
        }
        newCoordinate = Coordinate.createCoordinate(coordinate.getX(),coordinate.getY());
        for (int j = 0; j < 8; j++) {
            newCoordinate.setY(j);
            if (newCoordinate.getY() == coordinate.getY()) continue;
            moves.add(Coordinate.createCoordinate(newCoordinate.getX(), newCoordinate.getY()));
        }

        return moves;
    }

    @Override
    public String getName() {
        return "der " + this.getColorAdverb() + " Turm";
    }
}
