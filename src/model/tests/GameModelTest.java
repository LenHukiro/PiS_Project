package model.tests;

import model.Coordinate;
import model.GameModel;
import model.pieces.Piece;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GameModelTest {

    GameModel model;

    @BeforeEach
    void setUp() {
        model = new GameModel();
    }

    @AfterEach
    void tearDown() {
        model = null;
    }

    @Test
    void newGame() {
        model.newGame(400);
        Assertions.assertEquals(model.getCompletedTasks(), 0);
        Assertions.assertEquals(model.getTime(), "6:40");
        newGameTest();

    }

    @org.junit.jupiter.api.Test
    void testNewGame() {
        model.newGame();
        Assertions.assertEquals(model.getCompletedTasks(), 0);
        Assertions.assertEquals(model.getTime(), "8:20");
        newGameTest();
    }

    void newGameTest() {
        Assertions.assertNotNull(model.getCurrentPiece());
        Coordinate pointCoordinate = model.getPointCoordinate();
        Assertions.assertNotNull(pointCoordinate);
        Assertions.assertNotEquals(pointCoordinate.getX(), -1);
        Assertions.assertNotEquals(pointCoordinate.getY(), -1);
    }

    @Test
    void isCoordinateInBounds() {
        Coordinate coordinateInBounds = Coordinate.createCoordinate(0, 0);
        Assertions.assertTrue(model.isCoordinateInBounds(coordinateInBounds.getX(), coordinateInBounds.getY()));

        Coordinate coordinateOutOfBounds = Coordinate.createCoordinate(10, 10);
        Assertions.assertFalse(model.isCoordinateInBounds(coordinateOutOfBounds.getX(), coordinateOutOfBounds.getY()));

        Coordinate coordinateOutOfBounds2 = Coordinate.createCoordinate(-20, -20);
        Assertions.assertFalse(model.isCoordinateInBounds(coordinateOutOfBounds2.getX(), coordinateOutOfBounds2.getY()));
    }

    @Test
    void answerTask() {
        Piece currentPiece = model.getCurrentPiece();
        Coordinate currentMark = model.getPointCoordinate();
        model.answerTask(true);
        Assertions.assertEquals(currentPiece, model.getCurrentPiece());
        Assertions.assertEquals(currentMark, model.getPointCoordinate());

        model.newGame(500);
        model.answerTask(true);
        Assertions.assertNotEquals(currentPiece, model.getCurrentPiece());
        Assertions.assertNotEquals(currentMark, model.getPointCoordinate());

        boolean isInMoves = model.getCurrentPiece().possibleMoves().stream().anyMatch(coordinate -> coordinate.getX() == model.getPointCoordinate().getX() && coordinate.getY() == model.getPointCoordinate().getY());
        while (model.getNumberOfMoves() != 1 && isInMoves) {
            isInMoves = model.getCurrentPiece().possibleMoves().stream().anyMatch(coordinate -> coordinate.getX() == model.getPointCoordinate().getX() && coordinate.getY() == model.getPointCoordinate().getY());
            model.answerTask(false);
        }
        model.answerTask(isInMoves);
    }

    @Test
    void getTime() {
        String time = model.getTime();
        String exampleTime = "0:00";
        Assertions.assertEquals(time, exampleTime);
        model.newGame();
        time = model.getTime();
        String finalTime = time;
        (new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            String newTime = model.getTime();
            Assertions.assertNotEquals(finalTime, newTime);
        })).start();
    }

    @Test
    void getCurrentPiece() {
        Assertions.assertNull(model.getCurrentPiece());
        newGame();
        Assertions.assertNotNull(model.getCurrentPiece());
    }

    @Test
    void getPointCoordinate() {
        Assertions.assertNull(model.getPointCoordinate());
        newGame();
        Assertions.assertNotNull(model.getPointCoordinate());
    }

    @Test
    void getNumberOfMoves() {
        Assertions.assertEquals(model.getNumberOfMoves(), 0);
        newGame();
        Assertions.assertNotEquals(model.getNumberOfMoves(), 0);
    }

    @Test
    void getCompletedTasks() {
        Assertions.assertEquals(model.getCompletedTasks(), 0);
        newGame();
        boolean isInMoves = model.getCurrentPiece().possibleMoves().stream().anyMatch(coordinate -> coordinate.getX() == model.getPointCoordinate().getX() && coordinate.getY() == model.getPointCoordinate().getY());
        while (model.getNumberOfMoves() != 1) {
            isInMoves = model.getCurrentPiece().possibleMoves().stream().anyMatch(coordinate -> coordinate.getX() == model.getPointCoordinate().getX() && coordinate.getY() == model.getPointCoordinate().getY());
            model.answerTask(false);
        }
        model.answerTask(isInMoves);
        Assertions.assertNotEquals(model.getCompletedTasks(), 0);
    }
}