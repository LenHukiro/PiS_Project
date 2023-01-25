package model.tests;

import model.Coordinate;
import model.pieces.Rook;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.awt.*;

class RookTest extends PieceTest {


    @Test
    void possibleMoves() {
    }

    @Test
    void getName() {
        String expectedWhiteName = "der weiße Turm";
        String expectedBlackName = "der schwarze Turm";
        Rook whiteRook = new Rook(model, Color.WHITE, Coordinate.createCoordinate(-1,-1));
        Assertions.assertEquals(whiteRook.getName(),expectedWhiteName);
        Rook blackRook = new Rook(model,Color.BLACK,Coordinate.createCoordinate(-1,-1));
        Assertions.assertEquals(blackRook.getName(),expectedBlackName);
    }
}