package model.pieces;

import model.GameModel;
import model.Coordinate;

import java.awt.*;
import java.util.ArrayList;

/**
 * The type Rook.
 */
public class Rook extends Piece {

    /**
     * Instantiates a new Rook.
     *
     * @param model      the gamemodel
     * @param color      the color of the rook
     * @param coordinate the coordinate of the rook
     */
    public Rook(GameModel model, Color color, Coordinate coordinate) {
        super(model, color, coordinate);
    }

    /**
     * Returns the possible moves for the Piece
     *
     * @return the moves
     */
    @Override
    public ArrayList<Coordinate> possibleMoves() {
        ArrayList<Coordinate> moves = new ArrayList<>();
        Coordinate newCoordinate = Coordinate.createCoordinate(coordinate.getX(),coordinate.getY());
        for (int j = 0; j < 8; j++) {
            newCoordinate.setX(j);
            if (coordinate.getX() == newCoordinate.getX()) continue;
            moves.add(Coordinate.createCoordinate(newCoordinate.getX(), newCoordinate.getY()));
        }
        newCoordinate = Coordinate.createCoordinate(coordinate.getX(),coordinate.getY());
        for (int j = 0; j < 8; j++) {
            newCoordinate.setY(j);
            if (newCoordinate.getY() == coordinate.getY()) continue;
            moves.add(Coordinate.createCoordinate(newCoordinate.getX(), newCoordinate.getY()));
        }

        return moves;
    }

    /**
     * Returns the name of the Piece with its article
     *
     * @return The name of the Piece
     */
    @Override
    public String getName() {
        return "der " + this.getColorAdverb() + " Turm";
    }
}
