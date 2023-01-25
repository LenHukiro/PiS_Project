package view;

import java.awt.*;

/**
 * The type Cell.
 */
public class Cell {

    /**
     * The color of the Cell
     */
    private final Color color;

    /**
     * The Piece displayed in the Cell
     */
    Piece piece;

    /**
     * Flag to mark the Cell
     */
    boolean marked;

    /**
     * Instantiates a new Cell.
     *
     * @param color the color
     */
    Cell(Color color) {
        this.color = color;
    }

    /**
     * Sets the flag to mark the Cell
     */
    public void mark(boolean mark) {
        marked = mark;
    }

    /**
     * Inserts a Piece into the cell
     */
    public void placePiece(Piece piece){
        this.piece = piece;
    }

    /**
     * Draws the Cell
     *
     * @param view the view of the game
     * @param x    the x coordinate of the Cell
     * @param y    the y coordinate of the Cell
     */
    public void draw(GameView view, int x, int y) {
        view.fill(color.getRGB());
        if (marked) {
            view.fill(Color.RED.getRGB());}

        int radius = 50;
        view.rect(x, y, radius, radius);
        if(piece != null){
            view.image(piece.getImage(),x,y, radius, radius);
        }

    }
}
