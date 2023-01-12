package model.pieces;

import model.Board;
import model.Coordinate;

import java.awt.*;
import java.util.HashSet;

public abstract class Piece {
    Coordinate coordinate;
    Board board;
    Color color;

    public Piece(Board board, Color color,Coordinate coordinate) {
        this.board = board;
        this.color = color;
        this.coordinate = coordinate;
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public void move(Coordinate nextCoordinate){
        this.coordinate = nextCoordinate;
    }

    public Color getColor() {
        return color;
    }

    public abstract HashSet<Coordinate> possibleMoves();

}

