package view;

import java.awt.*;

public class Board {

    Cell[][] cells;
    GameView view;

    public Board(GameView view) {
        this.view = view;
        cells = new Cell[8][8];
        boolean alternatingColor = false;
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[i].length; j++) {
                cells[i][j] = new Cell(null,alternatingColor?Color.getColor("#eeeed2"):Color.getColor("#769656"));
                alternatingColor = !alternatingColor;
            }
        }
    }
    public void placePiece(PieceType type, Color color, int x, int y){
        cells[y][x] = new Cell(new Piece(view,type,color == Color.BLACK),Color.getColor("#eeeed2"));
    }

    public void draw(){
        for (Cell[] cell : cells) {
            for (Cell innerCell : cell) {
                innerCell.draw(view);
            }
        }
    }
}
