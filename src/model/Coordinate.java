package model;

import java.util.Random;

/**
 * The type Coordinate.
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
     * Create coordinate coordinate.
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
     * Create random coordinate coordinate.
     *
     * @return the coordinate
     */
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

    /**
     * Gets x.
     *
     * @return the x
     */
    public int getX() {
        return x;
    }

    /**
     * Gets y.
     *
     * @return the y
     */
    public int getY() {
        return y;
    }

    /**
     * Sets x.
     *
     * @param x the x
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * Sets y.
     *
     * @param y the y
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * Get field coordinate string.
     *
     * @return the string
     */
    public String getFieldCoordinate(){
        return getBoardLetter(y)+(x+1);
    }

    /**
     * Returns the correct letter of the board from the given row
     * @param row the row
     * @return The boardLetter
     */
    private String getBoardLetter(int row){
        String[] boardLetter = new String[]{"a","b","c","d","e","f","g","h"};
        return boardLetter[row];
    }
}
