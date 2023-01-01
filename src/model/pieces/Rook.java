package model.pieces;

import model.Board;
import model.Coordinate;
import processing.core.PImage;

import java.awt.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.function.Function;

public class Rook extends Piece {
boolean hasRightToCastle = true;
    public Rook(Board board, Color color) {
        super(board, color);
    }

    public void move() {
        hasRightToCastle = false;
    }

    @Override
    public HashSet<Coordinate> possibleMoves() {
        HashSet<Coordinate> moves = new HashSet<>();
        Coordinate newCoordinate = coordinate; //TODO: fix this ugly mess
        for (int j = 0; j < 8; j++) {
            newCoordinate.setX(newCoordinate.getX()+1);
            if(coordinate == null)break;
            moves.add(newCoordinate);
        }
        for (int j = 0; j < 8; j++) {
            newCoordinate.setX(newCoordinate.getX()-1);
            if(coordinate == null)break;
            moves.add(newCoordinate);
        }
        for (int j = 0; j < 8; j++) {
            newCoordinate.setY(newCoordinate.getY()+1);
            if(coordinate == null)break;
            moves.add(newCoordinate);
        }
        for (int j = 0; j < 8; j++) {
            newCoordinate.setY(newCoordinate.getY()-1);
            if(coordinate == null)break;
            moves.add(newCoordinate);
        }
        return moves;
    }
}
