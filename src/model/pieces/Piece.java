package model.pieces;

import model.Board;
import model.Coordinate;
import processing.core.PImage;

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

    public abstract HashSet<Coordinate> possibleMoves();

    public Color getColor() {
        return color;
    }

    public void setCoordinate(Coordinate coordinate){ this.coordinate = coordinate;}

    public abstract String getName();

    protected String getColorAdverb() {
        return getColor() == Color.BLACK ? "schwarze" : "weiße";
    }
    public Object clone() throws CloneNotSupportedException
    {
        return super.clone();
    }
}

