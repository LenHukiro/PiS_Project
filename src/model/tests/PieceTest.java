package model.tests;

import model.Coordinate;
import model.GameModel;
import model.pieces.Piece;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;

import java.util.ArrayList;

public class PieceTest {
    GameModel model;

    @BeforeEach
    void setUp() {
        model = new GameModel();
    }

    @AfterEach
    void tearDown() {
    }

    public void checkPieceMoves(Piece piece, ArrayList<Coordinate> correctMoves) {
        ArrayList<Coordinate> generatedMoves = piece.possibleMoves();
        Assertions.assertEquals(generatedMoves.size(), correctMoves.size());
        for (Coordinate coordinate : generatedMoves) {
            Assertions.assertTrue(correctMoves.stream().anyMatch(correctCoordinate -> correctCoordinate.getX() == coordinate.getX() && correctCoordinate.getY() == coordinate.getY()));
        }
    }
}
