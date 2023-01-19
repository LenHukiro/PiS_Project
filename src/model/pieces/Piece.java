package model.pieces;

import model.Board;
import model.Coordinate;
import processing.core.PImage;

import java.awt.*;
import java.util.HashSet;

import static java.io.File.separator;

public abstract class Piece {
    Coordinate coordinate;
    Board board;
    Color color;
    PImage image;

    public Piece(Board board, Color color,Coordinate coordinate) {
        this.board = board;
        this.color = color;
        this.coordinate = coordinate;
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }


    public Color getColor() {
        return color;
    }

    public abstract HashSet<Coordinate> possibleMoves();

}

