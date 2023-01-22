package view;

public class Cells {

    Piece piece;
    boolean marked;
    Cells(Piece piece){
        this.piece = piece;
    }

    public void mark(){
        marked = true;
    }

    public void unmark(){
        marked = false;
    }

    public void draw(){

    }
}
