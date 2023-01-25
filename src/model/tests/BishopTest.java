package model.tests;

import model.Coordinate;
import model.pieces.Bishop;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.util.ArrayList;

class BishopTest extends PieceTest {

    @Test
    void testPossibleMoves() {
        ArrayList<Coordinate> correctMoves= new ArrayList<>();
        for (int i = 1; i < 8; i++) {
            correctMoves.add(Coordinate.createCoordinate(i,i));
        }
        checkPieceMoves( new Bishop(model,Color.WHITE,Coordinate.createCoordinate(0,0)),correctMoves);
        correctMoves =new ArrayList<>();
        for (int i = 1; i < 7; i++) {
            correctMoves.add(Coordinate.createCoordinate(i,i+1));
        }
        correctMoves.add(Coordinate.createCoordinate(1,0));
        checkPieceMoves( new Bishop(model,Color.WHITE,Coordinate.createCoordinate(0,1)),correctMoves);
    }


    @Test
    public void testSetCoordinate(){
        Bishop bishop = new Bishop(model,Color.WHITE,null);
        Assertions.assertNull(bishop.getCoordinate());
        bishop.setCoordinate(Coordinate.createCoordinate(0,0));
        Assertions.assertNotNull(bishop.getCoordinate());
        bishop.setCoordinate(Coordinate.createCoordinate(3,4));
        Assertions.assertEquals(bishop.getCoordinate().getY(),4);
        Assertions.assertEquals(bishop.getCoordinate().getX(),3);
    }

    @Test
    void getName() {
        String expectedWhiteName = "der weiße Laeufer";
        String expectedBlackName = "der schwarze Laeufer";
        Bishop whiteBishop = new Bishop(model,Color.WHITE,Coordinate.createCoordinate(-1,-1));
        Assertions.assertEquals(whiteBishop.getName(),expectedWhiteName);
        Bishop blackBishop = new Bishop(model,Color.BLACK,Coordinate.createCoordinate(-1,-1));
        Assertions.assertEquals(blackBishop.getName(),expectedBlackName);
    }
}