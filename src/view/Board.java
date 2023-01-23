package view;

import java.awt.*;

/**
 * The type Board.
 */
public class Board {

    /**
     * The Cells.
     */
    Cell[][] cells;
    /**
     * The View.
     */
    GameView view;

    /**
     * The X.
     */
    int x,
    /**
     * The Y.
     */
    y;

    Cell markedCell;

    /**
     * Instantiates a new Board.
     *
     * @param view the view
     */
    public Board(GameView view) {
        this.view = view;
        cells = new Cell[8][8];
        boolean alternatingColor = false;
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[i].length; j++) {
                cells[i][j] = new Cell(alternatingColor ? Color.decode("#eeeed2") : Color.decode("#769656"));
                alternatingColor = !alternatingColor;
            }
            alternatingColor = !alternatingColor;
        }
        x = 10;
        y = 10;
    }

    /**
     * Place piece.
     *
     * @param type  the type
     * @param color the color
     * @param x     the x
     * @param y     the y
     */
    public void placePiece(PieceType type, Color color, int x, int y) {
        if(markedCell != null)
            markedCell.unmark();

        markedCell  = cells[y][x];
        markedCell.placePiece(new Piece(view, type, color == Color.BLACK));
    }

    /**
     * Draw.
     */
    public void draw() {
        int cellX = x;
        for (Cell[] cell : cells) {
            for (Cell innerCell : cell) {
                innerCell.draw(view, cellX, y);
                cellX += 50;
            }
            y += 50;
            cellX = 10;
        }
        x = cellX;
    }
}
