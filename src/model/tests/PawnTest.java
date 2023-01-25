package model.tests;

import model.Coordinate;
import model.pieces.Pawn;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

class PawnTest extends PieceTest {

    @Test
    void possibleMoves() {
        Pawn pawn = new Pawn(model, Color.WHITE, Coordinate.createCoordinate(5,5));
        ArrayList<Coordinate> coorectMoves = new ArrayList<>(List.of(Coordinate.createCoordinate(5,4)));
        checkPieceMoves(pawn,coorectMoves);
        pawn = new Pawn(model, Color.WHITE, Coordinate.createCoordinate(5,6));
        coorectMoves = new ArrayList<>(List.of(Coordinate.createCoordinate(5,4),Coordinate.createCoordinate(5,5)));
        checkPieceMoves(pawn,coorectMoves);

        pawn = new Pawn(model, Color.BLACK, Coordinate.createCoordinate(3,1));
        coorectMoves = new ArrayList<>(List.of(Coordinate.createCoordinate(3,2),Coordinate.createCoordinate(3,3)));
        checkPieceMoves(pawn,coorectMoves);
    }

    @Test
    void getName() {
        String expectedWhiteName = "der weiße Bauer";
        String expectedBlackName = "der schwarze Bauer";
        Pawn whitePawn = new Pawn(model,Color.WHITE,Coordinate.createCoordinate(-1,-1));
        Assertions.assertEquals(whitePawn.getName(),expectedWhiteName);
        Pawn blackPawn = new Pawn(model,Color.BLACK,Coordinate.createCoordinate(-1,-1));
        Assertions.assertEquals(blackPawn.getName(),expectedBlackName);
    }
}