package view;

import java.awt.*;

/**
 * The Cell class to show a Cell, which is being marked or has a piece inside.
 * <p></p>
 * It is being used inside the Board class to show a Piece or a mark.
 * The draw function is being called by the board, so it doesn't need to be called.
 * It can be used like this:
 * Cell cell = new Cell(Color.RED):
 * placePiece(new Piece(board,PieceType.PAWN,true))
 * mark(true);
 * placePiece(null);
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
