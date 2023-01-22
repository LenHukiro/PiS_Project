package model.pieces;

import model.Board;
import model.Coordinate;

import java.awt.*;
import java.util.HashSet;


public class Bishop extends Piece {
    public Bishop(Board board, Color color, Coordinate coordinate) {
        super(board, color, coordinate);
    }

    @Override
    public HashSet<Coordinate> possibleMoves() {
        HashSet<Coordinate> moves = new HashSet<>();
        int[] modifiers = new int[]{1,-1};
        calcValues(moves,modifiers[0],modifiers[0]);
        calcValues(moves,modifiers[0],modifiers[1]);
        calcValues(moves,modifiers[1],modifiers[0]);
        calcValues(moves,modifiers[1],modifiers[1]);
        return moves;
    }

    private void calcValues(HashSet<Coordinate> moves,int xModifier, int yModifier){
        int count = 0;
        boolean isInBounds = true;
        while (isInBounds) {
            int x = coordinate.getX() + (count  * xModifier);
            int y = coordinate.getY() + (count * yModifier);
            isInBounds = board.isCoordniateInBounds(x, y);
            if(coordinate.getX() != x && coordinate.getY() != y &&  isInBounds) moves.add(Coordinate.createCoordinate(x,y));
            count++;
        }

    }

    @Override
    public String getName() {
        return "der " + this.getColorAdverb() + " Laeufer";
    }
}
