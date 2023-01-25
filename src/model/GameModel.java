package model;

import model.pieces.*;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

/**
 * The chess trainer model class.
 * <p></p>
 * The model is can be used like this:
 * GameModel model = new GameModel();
 * <p></p>
 * model.newGame();<p></p>
 * model.answer(true);<p></p>
 * model.answer(false);<p></p>
 * <p></p>
 * You can alternatively use model.newGame(100) to set the internal clock to 100 seconds or any amount of seconds.
 * <p></p>
 * To review the current task again those methods can be used:<p></p>
 * getCompletedTasks(): Returns the number of correct answered tasks.<p></p>
 * getTime(): Returns the current time left for the player.<p></p>
 * getCurrentPiece(): Returns the current piece of the task.<p></p>
 * getNumberOfMoves(): Returns the number of available moves for the piece.<p></p>
 * getPointCoordinate(): Returns the coordinate the current piece has to move to.
 */
public class GameModel implements IModel {

    /**
     * The Clock.
     */
    private Clock clock;

    /**
     * Shows if the game is running.
     */
    private boolean game = false;

    /**
     * The coordinate of the marked field.
     */

    private Coordinate pointCoordinate;

    /**
     * The currently active Piece
     */
    private Piece currentPiece;

    /**
     * The number of allowed moves.
     */
    private int numberOfMoves;

    /**
     * The number of completed tasks.
     */
    private int completedTasks = 0;

    /**
     * Instantiates a new Board.
     */
    public GameModel() {
        clock = new Clock(this, 0);
    }

    /**
     * Starts a new game
     */

    public void newGame() {
        newGame(500);
    }

    /**
     * Starts a new game with the given amount of seconds
     * It is recommended to not use seconds, which are equal or below 0 as the game would be instantly over.
     *
     * @param seconds the seconds
     */

    public void newGame(int seconds) {
        game = true;
        generateTask();
        clock = new Clock(this, seconds);
        clock.start();
    }

    /**
     * Checks if the given coordinate is inside the playing field
     *
     * @param x the x
     * @param y the y
     * @return boolean, true if the coordinate is inside the field
     */
    public boolean isCoordinateInBounds(int x, int y) {
        return x <= 7 && x >= 0 && y <= 7 && y >= 0;
    }

    /**
     * Generates a new Position for the player.
     */
    private void generateTask() {
        if (game) {
            Coordinate pieceCoordinate = Coordinate.createRandomCoordinate();
            currentPiece = getRandomPiece(pieceCoordinate);
            pointCoordinate = Coordinate.createRandomCoordinate();
            while (pointCoordinate.getX() == pieceCoordinate.getX() && pointCoordinate.getY() == pieceCoordinate.getY()) {
                pointCoordinate = Coordinate.createRandomCoordinate();
            }
            numberOfMoves = new Random().nextInt(1, 3);
            System.out.println("Kann die Figur " + currentPiece.getName() + " welches sich auf dem Feld " + currentPiece.getCoordinate().getFieldCoordinate() + " befindet, auf das Feld " + pointCoordinate.getFieldCoordinate() + " in " + numberOfMoves + " Zuegen bewegen?");
        }
    }

    /**
     * Generates a random Piece on a given coordinate
     *
     * @param coordinate The coordinate of the generated Piece
     * @return The generated Piece
     */
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
     * Stops the game and prints the result
     */
    void stopGame() {
        game = false;
        System.out.println("Die Zeit ist abgelaufen.\n" + "Sie haben " + completedTasks + " Aufgaben in der Zeit bearbeitet.");
    }

    /**
     * Answers the current Task and starts a new one
     *
     * @param answer the answer
     */
    public void answerTask(boolean answer) {
        if (!game) return;
        evaluateAnswer(getPieceCoordinates(), answer);
        generateTask();
    }

    /**
     * Returns the allowed possible moves of the current Piece
     *
     * @return a list of possible Coordinates
     */
    private ArrayList<Coordinate> getPieceCoordinates() {
        ArrayList<Coordinate> coordinateStack = new ArrayList<>(currentPiece.possibleMoves());
        ArrayList<Coordinate> tempStack = new ArrayList<>();
        if (numberOfMoves > 1) {
            for (Coordinate coordinate : coordinateStack) {
                currentPiece.setCoordinate(coordinate);
                ArrayList<Coordinate> possibleMoves = currentPiece.possibleMoves();
                for (Coordinate possibleMove : possibleMoves) {
                    if (coordinateStack.stream().noneMatch(visitedCoordinate -> possibleMove.getX() == visitedCoordinate.getX() && possibleMove.getY() == visitedCoordinate.getY())
                            && tempStack.stream().noneMatch(visitedCoordinate -> possibleMove.getX() == visitedCoordinate.getX() && possibleMove.getY() == visitedCoordinate.getY()) &&
                            (possibleMove.getX() != currentPiece.getCoordinate().getX() && possibleMove.getY() != currentPiece.getCoordinate().getY()))
                        tempStack.add(possibleMove);
                }
            }
            coordinateStack.addAll(tempStack);
        }
        return coordinateStack;
    }

    /**
     * Evaluates if the user answered the Task correctly
     *
     * @param coordinateStack The possible moves
     * @param answer          The given userInput
     */
    private void evaluateAnswer(ArrayList<Coordinate> coordinateStack, boolean answer) {
        if (coordinateStack.stream().anyMatch(coordinate -> coordinate.getX() == pointCoordinate.getX() && coordinate.getY() == pointCoordinate.getY())) {
            if (answer) {
                System.out.println("Ihre Antwort war korrekt.");
                completedTasks++;
            }
        } else if (!answer) {
            System.out.println("Ihre Antwort war korrekt.");
            completedTasks++;
        } else {
            System.out.println("Ihre Antwort war nicht korrekt.");
        }
    }

    /**
     * Returns the available time
     *
     * @return the time in format mm:ss
     */
    public String getTime() {
        return clock.getTimeInMinutesAndSeconds();
    }

    /**
     * Returns the currently active Piece on the board
     *
     * @return the Piece
     */
    public Piece getCurrentPiece() {
        return currentPiece;
    }

    /**
     * Returns the current Coordinate of the Piece
     *
     * @return The coordinate
     */
    public Coordinate getPointCoordinate() {
        return pointCoordinate;
    }

    /**
     * Returns the number of available moves for the Piece
     *
     * @return number of moves
     */
    public int getNumberOfMoves() {
        return numberOfMoves;
    }

    /**
     * Returns the number of completedTasks
     *
     * @return number of completed tasks
     */
    public int getCompletedTasks() {
        return completedTasks;
    }
}

