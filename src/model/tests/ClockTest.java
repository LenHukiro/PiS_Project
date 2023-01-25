package model.tests;

import model.Clock;
import model.GameModel;
import model.pieces.Piece;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ClockTest {

    Clock clock;
    @BeforeEach
    void setUp() {
        clock = new Clock(new GameModel(),500);
    }

    @AfterEach
    void tearDown(){
        clock = null;
    }

    @Test
    void run() {
        String timeBefore = clock.getTimeInMinutesAndSeconds();
        clock.start();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        String timeAfter = clock.getTimeInMinutesAndSeconds();
        Assertions.assertNotEquals(timeBefore, timeAfter);
    }

    @Test
    void getTimeInMinutesAndSeconds() {
        String expectedTime500Secs = "8:20";
        Assertions.assertEquals(clock.getTimeInMinutesAndSeconds(),expectedTime500Secs);

        clock = new Clock(new GameModel(),0);
        String expectedTime0Secs = "0:00";
        Assertions.assertEquals(clock.getTimeInMinutesAndSeconds(),expectedTime0Secs);

        clock = new Clock(new GameModel(),5);
        String expectedTime5Secs = "0:05";
        Assertions.assertEquals(clock.getTimeInMinutesAndSeconds(),expectedTime5Secs);

    }

    @Test
    void checkNullSeconds() throws InterruptedException {
        GameModel model = new GameModel();
        clock = new Clock(model,1);
        clock.start();
        Piece currentPiece = model.getCurrentPiece();
        Thread.sleep(1000);
        model.answerTask(true);
        Assertions.assertEquals(currentPiece,model.getCurrentPiece());
    }
}