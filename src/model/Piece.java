package model;

import java.awt.*;

class Piece {

    PieceType type;
    Coordiante coordinate;
    Board board;
    Color color;
    boolean hasCastleRights = false;

    private Piece(Board board, PieceType type, Color color) {
        this.board = board;
        this.type = type;
        this.color = color;
    }

    public static Piece createPiece(Board board, PieceType pieceType, Color color) {
        return new Piece(board, pieceType, color);
    }

    public void move(Coordiante coordinate) {
        if (canMoveThere() && isMoveLegal()) {
            this.coordinate = coordinate;
        }
    }

    private boolean isMoveLegal() {
        return false;
    }

    private boolean canMoveThere() {
        return false;
    }

}

