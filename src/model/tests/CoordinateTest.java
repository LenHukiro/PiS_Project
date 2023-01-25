package model.tests;

import model.Coordinate;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CoordinateTest {

    @Test
    void createCoordinate() {
        Coordinate coordinate = Coordinate.createCoordinate(0,0);
        Assertions.assertEquals(coordinate.getX(),0);
        Assertions.assertEquals(coordinate.getY(),0);

        Coordinate coordinate2 = Coordinate.createCoordinate(10,10);
        Assertions.assertEquals(coordinate2.getX(),-1);
        Assertions.assertEquals(coordinate2.getY(),-1);

        Coordinate coordinate3 = Coordinate.createCoordinate(-40,-40);
        Assertions.assertEquals(coordinate3.getX(),-1);
        Assertions.assertEquals(coordinate3.getY(),-1);
    }

    @Test
    void createRandomCoordinate() {
        Coordinate randomCoordinate1 = Coordinate.createRandomCoordinate();
        Coordinate randomCoordinate2 = Coordinate.createRandomCoordinate();

        Assertions.assertFalse(randomCoordinate1.getX() == randomCoordinate2.getX() && randomCoordinate1.getY()==randomCoordinate2.getY());
    }
    @Test
    void getX() {
        Coordinate coordinate = Coordinate.createCoordinate(0,0);
        Assertions.assertEquals(coordinate.getX(),0);

        Coordinate coordinate1 = Coordinate.createCoordinate(1,0);
        Assertions.assertEquals(coordinate1.getX(),1);

        Coordinate coordinate3 = Coordinate.createCoordinate(-100,0);
        Assertions.assertEquals(coordinate3.getX(),-1);

    }

    @Test
    void getY() {
        Coordinate coordinate = Coordinate.createCoordinate(0,0);
        Assertions.assertEquals(coordinate.getY(),0);

        Coordinate coordinate1 = Coordinate.createCoordinate(0,1);
        Assertions.assertEquals(coordinate1.getY(),1);

        Coordinate coordinate3 = Coordinate.createCoordinate(-100,0);
        Assertions.assertEquals(coordinate3.getY(),-1);
    }

    @Test
    void setX() {
        Coordinate coordinate = Coordinate.createCoordinate(0,0);
        coordinate.setX(1);
        Assertions.assertEquals(coordinate.getX(),1);
        coordinate.setX(40);
        Assertions.assertEquals(coordinate.getX(),1);
    }

    @Test
    void setY() {
        Coordinate coordinate = Coordinate.createCoordinate(0,0);
        coordinate.setY(1);
        Assertions.assertEquals(coordinate.getY(),1);
        coordinate.setY(40);
        Assertions.assertEquals(coordinate.getY(),1);
    }

    @Test
    void getFieldCoordinate() {
        Coordinate coordinate = Coordinate.createCoordinate(0,0);
        Assertions.assertEquals(coordinate.getFieldCoordinate(),"a1");
        coordinate.setX(2);
        Assertions.assertEquals(coordinate.getFieldCoordinate(),"a3");
        coordinate.setY(4);
        Assertions.assertEquals(coordinate.getFieldCoordinate(),"e3");

    }
}