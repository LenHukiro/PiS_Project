package model;

public class Coordinate {

    int x, y;

    public static Coordinate createCoordinate(int x, int y) {
        if (x <= 8 && x >= 0 && y <= 8 && y >= 0)
            return new Coordinate(x, y);

        return null;
    }

    Coordinate(int x, int y) {
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
}
