package view;

import java.awt.*;

/**
 * The type Cell.
 */
public class Cell {

    private final Color color;
    int radius = 50;
    /**
     * The Piece.
     */
    Piece piece;
    /**
     * The Marked.
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
     * Mark.
     */
    public void mark() {
        marked = true;
    }

    /**
     * Unmark.
     */
    public void unmark() {
        marked = false;
        this.piece = null;
    }

    public void placePiece(Piece piece){
        this.piece = piece;
    }

    /**
     * Draw.
     *
     * @param view the view
     * @param x    the x
     * @param y    the y
     */
    public void draw(GameView view, int x, int y) {
        view.fill(color.getRGB());
        if (marked) view.fill(Color.RED.getRGB());
        view.rect(x, y, radius, radius);
    }
}
