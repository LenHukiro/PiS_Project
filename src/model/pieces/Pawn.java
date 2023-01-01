package model.pieces;

import model.Board;
import model.Coordinate;
import processing.core.PImage;

import java.awt.*;
import java.util.HashSet;

public class Pawn extends Piece {

    private boolean hasMoved = false;

    public Pawn(Board board, Color color) {
        super(board, color);
    }

    @Override
    public void move() {
        hasMoved = true;
    }

    @Override
    public HashSet<Coordinate> possibleMoves() {
        HashSet<Coordinate> moves = new HashSet<>();
        int modifier = color == Color.BLACK ? -1 : 1;

        if (board.getPieceByCoordinate(coordinate.getX(), coordinate.getY() + modifier) == null) {
            // Piece is infront of pawn
            moves.add(Coordinate.createCoordinate(coordinate.getX(), coordinate.getY() + modifier));
            if (board.getPieceByCoordinate(coordinate.getX(), coordinate.getY() + 2 * modifier) == null && !hasMoved) // moves 2 Squares at the start
                moves.add(Coordinate.createCoordinate(coordinate.getX(), coordinate.getY() + 2 * modifier));
        }
        if (board.getPieceByCoordinate(coordinate.getX() + 1, coordinate.getY() + modifier) != null) //Piece is infront and right/left of pawn
            moves.add(Coordinate.createCoordinate(coordinate.getX() + 1, coordinate.getY() + modifier));
        if (board.getPieceByCoordinate(coordinate.getX() - 1, coordinate.getY() + modifier) != null) // Piece is infront and right/left of pawn
            moves.add(Coordinate.createCoordinate(coordinate.getX() - 1, coordinate.getY() + modifier));

        Piece piece = board.getLastMovedPiece();
        Piece destPiece = board.getLastMovedPieceDestPiece();
        if (piece instanceof Pawn && Math.abs(destPiece.getCoordinate().getY() - piece.getCoordinate().getY()) == 2) {
            moves.add(Coordinate.createCoordinate(destPiece.getCoordinate().getX(), color == Color.BLACK ? coordinate.getY() + 1 : coordinate.getY() - 1));
        }
        return moves;
    }
}
