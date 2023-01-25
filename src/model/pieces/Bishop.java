package model.pieces;

import model.GameModel;
import model.Coordinate;

import java.awt.*;
import java.util.ArrayList;


/**
 * The Piece Bishop, which is being used in the model
 * <p>
 * The following functions are usually being used:
 * getPossibleMoves() to get the available moves for this piece
 * getName() returns a string with the name of the piece including its article
 *
 */
public class Bishop extends Piece {

    /**
     * Instantiates a new Bishop.
     *
     * @param board      the board
     * @param color      the color
     * @param coordinate the coordinate
     */
    public Bishop(GameModel board, Color color, Coordinate coordinate) {
        super(board, color, coordinate);
    }

    /**
     * Returns the possible moves for the ArrayList
     * @return The moves as ArrayList
     */
    @Override
    public ArrayList<Coordinate> possibleMoves() {
        ArrayList<Coordinate> moves = new ArrayList<>();
        int[] modifiers = new int[]{1,-1};
        calcValues(moves,modifiers[0],modifiers[0]);
        calcValues(moves,modifiers[0],modifiers[1]);
        calcValues(moves,modifiers[1],modifiers[0]);
        calcValues(moves,modifiers[1],modifiers[1]);
        return moves;
    }

    /**
     * Calculates the possible moves for the direction with the given modifiers
     * @param moves The
     * @param xModifier The modifier for the x Coordinates
     * @param yModifier The modifier for the y Coordinates
     */
    private void calcValues(ArrayList<Coordinate> moves,int xModifier, int yModifier){
        int count = 0;
        boolean isInBounds = true;
        while (isInBounds) {
            int x = coordinate.getX() + (count  * xModifier);
            int y = coordinate.getY() + (count * yModifier);
            isInBounds = model.isCoordinateInBounds(x, y);
            if(coordinate.getX() != x && coordinate.getY() != y &&  isInBounds) moves.add(Coordinate.createCoordinate(x,y));
            count++;
        }

    }

    /**
     * Returns the name of the Piece with its article
     *
     * @return The name of the Piece
     */
    @Override
    public String getName() {
        return "der " + this.getColorAdverb() + " Laeufer";
    }
}
