package model.tests;

import model.Coordinate;
import model.pieces.Queen;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.util.ArrayList;

class QueenTest extends PieceTest {


    @Test
    void possibleMoves() {
        Queen queen = new Queen(model, Color.WHITE, Coordinate.createCoordinate(0, 0));
        ArrayList<Coordinate> correctMoves = new ArrayList<>();
        for (int i = 1; i < 8; i++) {
            correctMoves.add(Coordinate.createCoordinate(0, i));
        }
        for (int i = 1; i < 8; i++) {
            correctMoves.add(Coordinate.createCoordinate(i, 0));
        }
        for (int i = 1; i < 8; i++) {
            correctMoves.add(Coordinate.createCoordinate(i, i));
        }
        checkPieceMoves(queen, correctMoves);
    }

    @Test
    void getName() {
        String expectedWhiteName = "die weiße Dame";
        String expectedBlackName = "die schwarze Dame";
        Queen whiteQueen = new Queen(model, Color.WHITE, Coordinate.createCoordinate(-1, -1));
        Assertions.assertEquals(whiteQueen.getName(), expectedWhiteName);
        Queen blackQueen = new Queen(model, Color.BLACK, Coordinate.createCoordinate(-1, -1));
        Assertions.assertEquals(blackQueen.getName(), expectedBlackName);
    }
}