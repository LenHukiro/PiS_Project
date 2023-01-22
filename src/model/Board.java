package model;

import model.pieces.*;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * The type Board.
 */
public class Board {

    /**
     * The Board.
     */
    Piece[][] board;
    /**
     * The Clock.
     */
    Clock clock;
    /**
     * The Game.
     */
    boolean game = true;
    /**
     * The Point coordinate.
     */
    Coordinate pointCoordinate;

    /**
     * The Current piece.
     */
    Piece currentPiece;

    /**
     * The Number of moves.
     */
    int numberOfMoves;
    /**
     * The Completed tasks.
     */
    int completedTasks = 0;


    /**
     * Instantiates a new Board.
     */
    public Board() {
        clock = new Clock(this);
    }

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        new Board().newGame();
    }

    /**
     * New game.
     */
    public void newGame() {
        game = true;
        generateTask();
        //clock.start();
        answer(new Random().nextBoolean());
    }


    /**
     * Is coordniate in bounds boolean.
     *
     * @param x the x
     * @param y the y
     * @return the boolean
     */
    public boolean isCoordniateInBounds(int x, int y) {
        return x <= 7 && x >= 0 && y <= 7 && y >= 0;
    }

    private void generateTask() {
        if (game) {
            board = new Piece[8][8];
            Coordinate pieceCoordinate = Coordinate.createRandomCoordinate();
            currentPiece = getRandomPiece(pieceCoordinate);
            board[pieceCoordinate.getX()][pieceCoordinate.getY()] = currentPiece;
            pointCoordinate = Coordinate.createRandomCoordinate();
            while (pointCoordinate.getX() == pieceCoordinate.getX() && pieceCoordinate.getY() == pieceCoordinate.getY()) {
                pointCoordinate = Coordinate.createRandomCoordinate();
            }
            numberOfMoves = new Random().nextInt(1, 3);
            System.out.println("Kann die Figur " + currentPiece.getName() + " welches auf dem Feld " + currentPiece.getCoordinate().getFieldCoordinate() + " ist, auf das Feld " + pointCoordinate.getFieldCoordinate() + " in " + numberOfMoves + " Zügen bewegen?");
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
                return new Bishop(this, color, coordinate);
            }
            case 3 -> {
                return new Rook(this, color, coordinate);
            }
            case 4 -> {
                return new Knight(this, color, coordinate);
            }
        }
        return new Pawn(this, color, coordinate);
    }

    /**
     * Stop game.
     */
    void stopGame() {
        game = false;
        System.out.println("Die Zeit ist abgelaufen.\n" + "Sie haben " + completedTasks + " Aufgaben in der Zeit bearbeitet.");
    }

    /**
     * Answer.
     *
     * @param answer the answer
     */
    public void answer(boolean answer) {
        ArrayList<Coordinate> coordinateStack = new ArrayList<>(currentPiece.possibleMoves());
        boolean wasCorrect = false;
        do {
            ArrayList<Coordinate> tempStack = new ArrayList<>();
            for (Coordinate coordinate : coordinateStack) {
                currentPiece.setCoordinate(coordinate);
                HashSet<Coordinate> possibleMoves = currentPiece.possibleMoves();
                for (Coordinate possibleMove : possibleMoves) {
                    tempStack = tempStack.stream().filter(coordinate1 -> possibleMove.getX() == coordinate1.getX() && possibleMove.getY() == coordinate1.getY()).collect(Collectors.toCollection(ArrayList::new));
                }
            }
            coordinateStack = tempStack;
            if (coordinateStack.stream().anyMatch(coordinate -> coordinate.getX() == pointCoordinate.getX() && coordinate.getY() == pointCoordinate.getY())) {
                if (answer) {
                    wasCorrect = true;
                    System.out.println("Ihre Anwort war korrekt.");
                    completedTasks++;
                }
                break;
            }
            numberOfMoves--;
        } while (numberOfMoves > 1);
        if (!wasCorrect) System.out.println("Ihre Anwort war nicht korrekt.");
        generateTask();
    }

    /**
     * Gets time.
     *
     * @return the time
     */
    public String getTime() {
        return clock.getTimeInMinutesAndSeconds();
    }

    /**
     * Get current piece piece.
     *
     * @return the piece
     */
    public Piece getCurrentPiece(){
        return currentPiece;
    }
}

