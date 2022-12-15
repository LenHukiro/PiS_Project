package model;

import processing.core.PImage;

import java.awt.*;

class Piece {

    PieceType type;
    Coordinate coordinate;
    Board board;
    Color color;
    boolean hasCastleRights = false;
    PImage image;

    private Piece(Board board, PieceType type, Color color) {
        this.board = board;
        this.type = type;
        this.color = color;
    }

    public static Piece createPiece(Board board, PieceType pieceType, Color color) {
        return new Piece(board, pieceType, color);
    }

    void move(Coordinate coordinate) {
        if (canMoveThere(coordinate) && isMoveLegal(coordinate)) {
            board.movePiece(this.coordinate,coordinate);
            this.coordinate = coordinate;
            if(type == PieceType.PAWN){
                if(color == Color.BLACK && coordinate.y() == 0) promote();
                else if(color == Color.WHITE && coordinate.y() == 7) promote();
            }
        }
    }

    private boolean isMoveLegal(Coordinate newCoordinate) {
        return false;
    }

    private boolean canMoveThere(Coordinate newCoordinate) {
        return false;
    }

    Coordinate getCoordinate() {
        return coordinate;
    }
    
     void promote(){
        this.type = PieceType.QUEEN;
        updateImage();
    }

    private void updateImage() {
        this.image = this.type.getImage();
    }

    void setImage(PImage image) {
        this.image = image;
    }
}

