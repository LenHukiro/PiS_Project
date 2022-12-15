package model;

import java.awt.*;
import java.util.ArrayList;

class Board {
    Piece[][] board;

    ArrayList<Move> moves = new ArrayList<>();

    Board() {
        newGame();
    }

    public void newGame() {
        board = new Piece[8][8];
        initGame();
    }

    private void initGame() {
        board[0][0] = Piece.createPiece(this, PieceType.ROOK, Color.BLACK);
        board[0][7] = Piece.createPiece(this, PieceType.ROOK, Color.BLACK);
        board[0][1] = Piece.createPiece(this, PieceType.KNIGHT, Color.BLACK);
        board[0][6] = Piece.createPiece(this, PieceType.KNIGHT, Color.BLACK);
        board[0][2] = Piece.createPiece(this, PieceType.BISHOP, Color.BLACK);
        board[0][5] = Piece.createPiece(this, PieceType.BISHOP, Color.BLACK);
        board[0][3] = Piece.createPiece(this, PieceType.QUEEN, Color.BLACK);
        board[0][4] = Piece.createPiece(this, PieceType.KING, Color.BLACK);
        for (int i = 0; i < 8; i++) {
            board[1][i] = Piece.createPiece(this, PieceType.PAWN, Color.BLACK);
        }
        board[8][0] = Piece.createPiece(this, PieceType.ROOK, Color.WHITE);
        board[8][7] = Piece.createPiece(this, PieceType.ROOK, Color.WHITE);
        board[8][1] = Piece.createPiece(this, PieceType.KNIGHT, Color.WHITE);
        board[8][6] = Piece.createPiece(this, PieceType.KNIGHT, Color.WHITE);
        board[8][2] = Piece.createPiece(this, PieceType.BISHOP, Color.WHITE);
        board[8][5] = Piece.createPiece(this, PieceType.BISHOP, Color.WHITE);
        board[8][3] = Piece.createPiece(this, PieceType.QUEEN, Color.WHITE);
        board[8][4] = Piece.createPiece(this, PieceType.KING, Color.WHITE);
        for (int i = 0; i < 8; i++) {
            board[7][i] = Piece.createPiece(this, PieceType.PAWN, Color.WHITE);
        }
    }

    void saveMove(Piece piece, Piece pieceOnCoordinate) {
        moves.add(new Move(piece, pieceOnCoordinate, piece.getCoordinate(), pieceOnCoordinate.getCoordinate()));
    }

    void movePiece(Coordinate pieceCoordinate, Coordinate nextCoordinate) {
        Piece piece = board[pieceCoordinate.x()][pieceCoordinate.y()];
        saveMove(piece, board[nextCoordinate.x()][nextCoordinate.y()]);
        board[nextCoordinate.x()][nextCoordinate.y()] = piece;
    }
}
