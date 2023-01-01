package model;

import model.pieces.*;
import processing.core.PApplet;
import view.GameView;
import view.IView;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class Board {
    Piece[][] board;

    private boolean whiteToMove = false;

    private boolean playVsComputer = false;

    private final boolean usesScanner = false;

    private final IView view;

    private Scanner scanner;

    private final ArrayList<Move> moves = new ArrayList<>();

    Board(IView view) {
        this.view = view;
        newGame();
    }


    public void playPlayer(Color color) {
        if (color != Color.BLACK || color != Color.WHITE) return;
        playerTurn(color);
    }

    public static void playAsPlayer() {
        new Board(null);
    }

    public void playVsComputer() {
        playVsComputer = true;
    }

    private void playerTurn(Color color) {
        Coordinate coordinateFrom = getUserCoordinate();
        Coordinate coordinateTo = getUserCoordinate();
        movePiece(coordinateFrom, coordinateTo, color);

    }

    private void playerTurn(Color color, Coordinate coordinateFrom, Coordinate coordinateTo) {
        if (movePiece(coordinateFrom, coordinateTo, color)) {
            if (!playVsComputer) {
                coordinateFrom = getUserCoordinate();
                coordinateTo = getUserCoordinate();
                movePiece(coordinateFrom, coordinateTo, color);
            }
            if (!gameOver()) playerTurn(color == Color.BLACK ? Color.WHITE : Color.BLACK);
            printWinner(color);
        } else {
            System.out.println("Bitte geben Sie einen gültigen Zug ein.");
            playerTurn(color);
        }
    }

    private Coordinate getUserCoordinate() {
        String userInput = scanner.nextLine();
        int x = Integer.parseInt(userInput.split(",")[0]);
        int y = Integer.parseInt(userInput.split(",")[1]);
        return new Coordinate(x, y);
    }

    private boolean gameOver() {
        return false;
    }

    private void printWinner(Color color) {
        System.out.println(color + " hat gewonnen.");
    }

    public void playerComputer() {
        computerTurn();
    }

    private void computerTurn() {
    }

    private void newGame() {
        board = new Piece[8][8];
        initGame();
    }

    public Piece getPieceByCoordinate(int x, int y) {
        if (x < 0 || x > 8 || y < 0 || y > 8) return null;
        return board[y][x];
    }

    private void initGame() {
        board[0][0] = new Rook(this, Color.BLACK);
        board[0][7] = new Rook(this, Color.BLACK);
        board[0][1] = new Knight(this, Color.BLACK);
        board[0][6] = new Knight(this, Color.BLACK);
        board[0][2] = new Bishop(this, Color.BLACK);
        board[0][5] = new Bishop(this, Color.BLACK);
        board[0][3] = new Queen(this, Color.BLACK);
        board[0][4] = new King(this, Color.BLACK);
        for (int i = 0; i < 8; i++) {
            board[1][i] = new Pawn(this, Color.BLACK);
        }


        board[8][0] = new Rook(this, Color.WHITE);
        board[8][7] = new Rook(this, Color.WHITE);
        board[8][1] = new Knight(this, Color.WHITE);
        board[8][6] = new Knight(this, Color.WHITE);
        board[8][2] = new Bishop(this, Color.WHITE);
        board[8][5] = new Bishop(this, Color.WHITE);
        board[8][3] = new Queen(this, Color.WHITE);
        board[8][4] = new King(this, Color.WHITE);
        for (int i = 0; i < 8; i++) {
            board[7][i] = new Pawn(this, Color.WHITE);
        }
    }

    public HashSet<Coordinate> simulateMoves(Coordinate coordinate, Piece piece) {
        Piece oldPiece = board[coordinate.getY()][coordinate.getX()];
        board[coordinate.getY()][coordinate.getX()] = piece;
        HashSet<Coordinate> moves = piece.possibleMoves();
        board[coordinate.getY()][coordinate.getX()] = oldPiece;
        return moves;
    }

    public Piece getLastMovedPiece(){
        return moves.get(moves.size()-1).piece();
    }

    public Piece getLastMovedPieceDestPiece(){
        return moves.get(moves.size()-1).pieceOnCoordinate();
    }

    private void saveMove(Piece piece, Piece pieceOnCoordinate) {
        moves.add(new Move(piece, pieceOnCoordinate, piece.getCoordinate(), pieceOnCoordinate.getCoordinate()));
    }

    boolean movePiece(Coordinate pieceCoordinate, Coordinate nextCoordinate, Color playerColor) {
        Piece piece = board[pieceCoordinate.getY()][pieceCoordinate.getX()];
        if (piece == null || piece.getColor() != playerColor || !canMoveThere(piece, nextCoordinate)) return false;
        saveMove(piece, board[nextCoordinate.getY()][nextCoordinate.getX()]);
        piece.move();
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

    public IView getView() {
        return view;
    }
}

