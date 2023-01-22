package view;

import java.awt.*;

public class Cell {

    private final Color color;
    Piece piece;
    boolean marked;
    Cell(Piece piece, Color color){
        this.color = color;
        this.piece = piece;
    }

    public void mark(){
        marked = true;
    }

    public void unmark(){
        marked = false;
    }

    public void draw(GameView view){
        view.rect(0,0,0,0);
    }
}
