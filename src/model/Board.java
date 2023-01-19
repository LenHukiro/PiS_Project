package model;

import model.pieces.*;

import java.awt.*;
import java.util.Random;

public class Board {

    Piece[][] board;
    Clock clock;
    boolean game = false;
    Coordinate pointCoordinate;


    public Board() {
        clock = new Clock(this);
    }

    public void newGame() {
        board = new Piece[8][8];
        generateTask();
        clock.start();
    }


    public Piece getPieceByCoordinate(int x, int y) {
        if (x < 0 || x > 8 || y < 0 || y > 8) return null;
        return board[y][x];
    }

    private void generateTask() {
        if (game) {
            Coordinate pieceCoordinate = Coordinate.createRandomCoordinate();
            Piece randomPiece = getRandomPiece(pieceCoordinate);
            board[pieceCoordinate.getX()][pieceCoordinate.getY()] = randomPiece;
            while(pointCoordinate.getX() == pieceCoordinate.getX() || pieceCoordinate.getY() == pieceCoordinate.getY()) {
                pointCoordinate = Coordinate.createRandomCoordinate();
            }
            System.out.println("Kann die Figur "+randomPiece.getClass().getSimpleName()+" welches auf dem Feld" +);
        }
    }

    private Piece getRandomPiece(Coordinate coordinate) {
        Random random = new Random();
        int pieceNumber = random.nextInt(0, 6);
        Color color = random.nextBoolean() ? Color.WHITE : Color.BLACK;
        switch (pieceNumber) {
            case 0 -> {
                return new King(this, color, coordinate);
            }
            case 1 -> {
                return new Queen(this, color, coordinate);
            }
            case 2 -> {
                return new Pawn(this, color, coordinate);
            }
            case 3 -> {
                return new Bishop(this, color, coordinate);
            }
            case 4 -> {
                return new Rook(this, color, coordinate);
            }
            case 5 -> {
                return new Knight(this, color, coordinate);
            }
            default -> throw new IllegalStateException("Unexpected value: " + random);
        }
    }

    public void stopGame() {
        game = false;
        printDoneTaskNumber();
    }

    public void answer(boolean answer){

    }

    private void printDoneTaskNumber() {
    }
}

