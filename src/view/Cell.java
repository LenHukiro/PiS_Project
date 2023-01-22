package view;

import java.awt.*;

/**
 * The type Cell.
 */
public class Cell {

    private final Color color;
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
     * @param piece the piece
     * @param color the color
     */
    Cell(Piece piece, Color color){
        this.color = color;
        this.piece = piece;
    }

    /**
     * Mark.
     */
    public void mark(){
        marked = true;
    }

    /**
     * Unmark.
     */
    public void unmark(){
        marked = false;
    }

    /**
     * Draw.
     *
     * @param view the view
     * @param x    the x
     * @param y    the y
     */
    public void draw(GameView view, int x, int y){
        view.rect(0,0,0,0);
    }
}
