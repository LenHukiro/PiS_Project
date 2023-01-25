package view;

import java.awt.*;

/**
 * The type Board for the view.
 *<p></p>
 * The board is being used to create Cells, which store information on the current Piece of the marked Cell.
 * <p></p>
 * The board can be used like this:<p></p>
 * Board board = new Board(view): Instantiates the board.
 * board.placePiece(view.Piece): PLaces the piece inside the correct cell.
 * board.draw(): THe draw function for processing, to draw the board and its cells.
 * board.resetBoard(): Removes the mark of the cell and the Piece inside the board.
 * board.markPiece(int x, int y): marks the piece on the given x and y coordinate.
 */
public class Board {

    /**
     * The Cells of the board.
     */
    private Cell[][] cells;
    /**
     * The View of the board.
     */
    private final GameView view;

    /**
     * The X position of the board.
     */
    private int x,
    /**
     * The Y position of the board.
     */
    y;

    /**
     * Instantiates a new Board and sets the colors of the cells.
     *
     * @param view the view
     */
    public Board(GameView view) {
        this.view = view;
        createCells();
    }

    /**
     * Creates the cells for the board and sets their color.
     */
    private void createCells() {
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
     * Place Piece inside the board.
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
     * Draws the cells of the board.
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

    /**
     * Resets the marked Cell and the current Piece inside the cells.
     */
    public void resetBoard() {
        for (Cell[] cell : cells) {
            for (Cell innerCell : cell) {
                innerCell.mark(false);
                innerCell.placePiece(null);
            }
        }
    }

    /**
     * Marks a Cell inside the board
     * @param x coordinate of the cell
     * @param y coordinate of the cell
     */
    public void markPiece(int x, int y) {
        cells[x][y].mark(true);
    }
}
