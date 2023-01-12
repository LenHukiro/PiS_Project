package model;

import model.pieces.*;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class Board {

    public static void main(String[] args){
        new Board();
    }
    private final ArrayList<Move> moves = new ArrayList<>();
    Piece[][] board;
    boolean game;
    private boolean whiteToMove = false;
    private Piece blackKing;
    private Piece whiteKing;

    public Board() {
        newGame();
        game = true;
        move(Color.WHITE,5,6,5,4);
    }

    public void move(Color color, int fromX, int fromY, int toX, int toY) {
        if (game) {
            Coordinate coordinateFrom = Coordinate.createCoordinate(fromX, fromY);
            Coordinate coordinateTo = Coordinate.createCoordinate(toX, toY);
            if (coordinateFrom == null || coordinateTo == null || !movePiece(coordinateFrom, coordinateTo, color)) {
                System.out.println("Dieser Zug ist ungueltig");
            }
            if (whiteKing == null) printWinner(Color.BLACK);
            else if (blackKing == null) printWinner(Color.WHITE);
        } else {
            System.out.println("Bitte starte ein neues Spiel");
        }
    }

    private void printWinner(Color color) {
        System.out.println(color + " hat gewonnen.");
        game = false;
    }

    public void newGame() {
        board = new Piece[8][8];
        initGame();
    }


    public Piece getPieceByCoordinate(int x, int y) {
        if (x < 0 || x > 8 || y < 0 || y > 8) return null;
        return board[y][x];
    }

    private void initGame() {
        board[0][0] = new Rook(this, Color.BLACK,Coordinate.createCoordinate(0,0));
        board[0][7] = new Rook(this, Color.BLACK,Coordinate.createCoordinate(7,0));
        board[0][1] = new Knight(this, Color.BLACK,Coordinate.createCoordinate(1,0));
        board[0][6] = new Knight(this, Color.BLACK,Coordinate.createCoordinate(6,0));
        board[0][2] = new Bishop(this, Color.BLACK,Coordinate.createCoordinate(2,0));
        board[0][5] = new Bishop(this, Color.BLACK,Coordinate.createCoordinate(5,0));
        board[0][3] = new Queen(this, Color.BLACK,Coordinate.createCoordinate(3,0));
        board[0][4] = new King(this, Color.BLACK,Coordinate.createCoordinate(4,0));
        blackKing = board[0][4];
        for (int i = 0; i < 8; i++) {
            board[1][i] = new Pawn(this, Color.BLACK,Coordinate.createCoordinate(i,1));
        }
        board[7][0] = new Rook(this, Color.WHITE,Coordinate.createCoordinate(0,7));
        board[7][7] = new Rook(this, Color.WHITE,Coordinate.createCoordinate(7,7));
        board[7][1] = new Knight(this, Color.WHITE,Coordinate.createCoordinate(1,7));
        board[7][6] = new Knight(this, Color.WHITE,Coordinate.createCoordinate(6,7));
        board[7][2] = new Bishop(this, Color.WHITE,Coordinate.createCoordinate(2,7));
        board[7][5] = new Bishop(this, Color.WHITE,Coordinate.createCoordinate(5,7));
        board[7][3] = new Queen(this, Color.WHITE,Coordinate.createCoordinate(3,7));
        board[7][4] = new King(this, Color.WHITE,Coordinate.createCoordinate(4,7));
        whiteKing = board[7][4];
        for (int i = 0; i < 8; i++) {
            board[6][i] = new Pawn(this, Color.WHITE,Coordinate.createCoordinate(i,6));
        }
    }

    public HashSet<Coordinate> simulateMoves(Coordinate coordinate, Piece piece) {
        Piece oldPiece = board[coordinate.getY()][coordinate.getX()];
        board[coordinate.getY()][coordinate.getX()] = piece;
        HashSet<Coordinate> moves = piece.possibleMoves();
        board[coordinate.getY()][coordinate.getX()] = oldPiece;
        return moves;
    }

    public Piece getLastMovedPiece() {
        return moves.get(moves.size() - 1).piece();
    }

    public Piece getLastMovedPieceDestPiece() {
        return moves.get(moves.size() - 1).pieceOnCoordinate();
    }

    private void saveMove(Piece piece, Piece pieceOnCoordinate) {
        moves.add(new Move(piece, pieceOnCoordinate, piece.getCoordinate(), pieceOnCoordinate.getCoordinate()));
    }

    boolean movePiece(Coordinate pieceCoordinate, Coordinate nextCoordinate, Color playerColor) {
        Piece piece = board[pieceCoordinate.getY()][pieceCoordinate.getX()];
        if (piece == null || piece.getColor() != playerColor || !canMoveThere(piece, nextCoordinate)) return false;
        saveMove(piece, board[nextCoordinate.getY()][nextCoordinate.getX()]);
        piece.move(nextCoordinate);
        board[nextCoordinate.getY()][nextCoordinate.getX()] = piece;
        whiteToMove = !whiteToMove;
        return true;
    }

    boolean canMoveThere(Piece piece, Coordinate coordinate) {
        return Arrays.asList(piece.possibleMoves().toArray(new Coordinate[0])).contains(coordinate);
    }

    public Rook[] getAllRooks() {
        ArrayList<Rook> rooks = new ArrayList<>();
        for (Piece[] pieces : board) {
            for (Piece piece : pieces) {
                if (piece instanceof Rook) rooks.add((Rook) piece);
            }
        }
        return rooks.toArray(new Rook[0]);
    }
}

