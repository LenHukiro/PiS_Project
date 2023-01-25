package model.tests;

import model.Coordinate;
import model.pieces.Knight;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.awt.*;

class KnightTest extends PieceTest {

    @Test
    void possibleMoves() {
    }

    @Test
    void getName() {
        String expectedWhiteName = "der weiße Springer";
        String expectedBlackName = "der schwarze Springer";
        Knight whiteKnight = new Knight(model, Color.WHITE, Coordinate.createCoordinate(-1,-1));
        Assertions.assertEquals(whiteKnight.getName(),expectedWhiteName);
        Knight blackKnight = new Knight(model,Color.BLACK,Coordinate.createCoordinate(-1,-1));
        Assertions.assertEquals(blackKnight.getName(),expectedBlackName);
    }
}