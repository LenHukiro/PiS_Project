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

    public Piece(Board board, Color color) {
        this.board = board;
        this.color = color;
        setImage();
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public abstract void move();

    public Color getColor() {
        return color;
    }


    protected void setImage() {
        String resPath = "resources" + separator + "img" + separator + "pieces" + separator;
        image = board.getView().loadImage(resPath+getClass().getSimpleName().toLowerCase() + "_" + color.toString().toLowerCase() + ".png");
    }

    protected PImage getImage() {
        return image;
    }

    public abstract HashSet<Coordinate> possibleMoves();

}

