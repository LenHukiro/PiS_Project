package model.tests;

import model.Coordinate;
import model.pieces.King;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

class KingTest extends PieceTest {

    @Test
    void testPossibleMoves() {
        King king = new King(model, Color.WHITE, Coordinate.createCoordinate(0,0));
        ArrayList<Coordinate> correctMoves = new ArrayList<>(Arrays.asList(Coordinate.createCoordinate(0,1),Coordinate.createCoordinate(1,1),Coordinate.createCoordinate(1,0)));
        checkPieceMoves(king,correctMoves);
        king = new King(model, Color.WHITE, Coordinate.createCoordinate(4,4));
        correctMoves = new ArrayList<>(Arrays.asList(Coordinate.createCoordinate(3,3),Coordinate.createCoordinate(4,3),Coordinate.createCoordinate(5,3),
                        Coordinate.createCoordinate(5,4),Coordinate.createCoordinate(5,5),Coordinate.createCoordinate(4,5),Coordinate.createCoordinate(3,5),
                        Coordinate.createCoordinate(3,4)));
        checkPieceMoves(king,correctMoves);
    }


    @Test
    void testGetName() {
        String expectedWhiteName = "der weiße Koenig";
        String expectedBlackName = "der schwarze Koenig";
        King whiteKing = new King(model,Color.WHITE,Coordinate.createCoordinate(-1,-1));
        Assertions.assertEquals(whiteKing.getName(),expectedWhiteName);
        King blackKing = new King(model,Color.BLACK,Coordinate.createCoordinate(-1,-1));
        Assertions.assertEquals(blackKing.getName(),expectedBlackName);
    }
}