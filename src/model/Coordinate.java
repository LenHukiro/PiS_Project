package model;

import java.util.Random;

/**
 * The coordinate class handles the coordinates for the model.
 * If a coordinate is not inside the bounds, the coordinate has the x and y values of -1;
 * <p>
 * To use this class you either need to call the static createCoordinate(int x, int y) or the static createRandomCoordinate() function, which returns a coordinate with random x and y values.
 * <p>
 * To get the values of this class, getters for x and y can be used and getBoardLetter() to return the current coordinate in Algebraic notation(<a href="https://en.wikipedia.org/wiki/Algebraic_notation_(chess)">...</a>)
 */
public class Coordinate {

    /**
     * The X.
     */
   private int x, /**
     * The Y.
     */
    y;

    /**
     * Static constructor to create a coordinate with the given values
     *
     * @param x the x
     * @param y the y
     * @return the coordinate
     */
    public static Coordinate createCoordinate(int x, int y) {
        if (x <= 7 && x >= 0 && y <= 7 && y >= 0)
            return new Coordinate(x, y);
        return new Coordinate(-1,-1);
    }

    /**
     * Static constructor to create a random coordinate inside the bounds
     *
     * @return the coordinate
     */
    public static Coordinate createRandomCoordinate() {
        Random random = new Random();
        int x = random.nextInt(0, 8);
        int y = random.nextInt(0, 8);
            return new Coordinate(x, y);
    }

    /**
     * internal constructor of the class
     * @param x the x value
     * @param y the y value
     */
    private Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Gets x value.
     *
     * @return the x
     */
    public int getX() {
        return x;
    }

    /**
     * Gets y value.
     *
     * @return the y
     */
    public int getY() {
        return y;
    }

    /**
     * Sets x value.
     *
     * @param x the x
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * Sets y value.
     *
     * @param y the y
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * Gets the coordinates as Algebraic notation(see top of this class for more details)
     *
     * @return the string in AN notation
     */
    public String getFieldCoordinate(){
        return (new String[]{"a","b","c","d","e","f","g","h"}[y])+(x+1);
    }
}
