package view;

import java.awt.*;

/**
 * The type Board.
 */
public class Board {

    /**
     * The Cells.
     */
    private final Cell[][] cells;
    /**
     * The View.
     */
    private final GameView view;

    /**
     * The X.
     */
    private int x,
    /**
     * The Y.
     */
    y;

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
     * Place Piece.
     *
     * @param type  the type
     * @param color the color
     * @param x     the x
     * @param y     the y
     */
    public void placePiece(PieceType type, Color color, int x, int y) {
        Cell markedCell = cells[y][x];
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
        x = 10;
        y = 10;
    }

    public void resetBoard() {
        for (Cell[] cell : cells) {
            for (Cell innerCell : cell) {
                innerCell.mark(false);
                innerCell.placePiece(null);
            }
        }
    }

    public void markPiece(int x, int y) {
        cells[x][y].mark(true);
    }
}
