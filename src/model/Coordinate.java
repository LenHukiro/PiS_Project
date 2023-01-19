package model;

import java.util.Random;

public class Coordinate {

    int x, y;

    public static Coordinate createCoordinate(int x, int y) {
        if (x <= 7 && x >= 0 && y <= 7 && y >= 0)
            return new Coordinate(x, y);
        return null;
    }

    public static Coordinate createRandomCoordinate() {
        Random random = new Random();
        int x = random.nextInt(0, 8);
        int y = random.nextInt(0, 8);
            return new Coordinate(x, y);
    }

    private Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public String getChessNotation(){

        return x+Boardnumbers.class.;
    }
}

enum Boardnumbers{
   1(a),2(b),3,4,5,6,7

    Boardnumbers(int row) {
    }
}
