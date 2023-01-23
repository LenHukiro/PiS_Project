package model;

/**
 * The type Clock.
 */
public class Clock extends Thread {

    /**
     * The Seconds.
     */
    int seconds;
    /**
     * The Board.
     */
    GameModel board;

    /**
     * Instantiates a new Clock.
     *
     * @param board the board
     */
    Clock(GameModel board) {
        this.board = board;
        seconds = 10;
    }

    @Override
    public void run() {
        while (seconds > 0) {
            try {
                Thread.sleep(1000);
                seconds--;
                System.out.println(getTimeInMinutesAndSeconds());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        board.stopGame();
    }

    /**
     * Gets time in minutes and seconds.
     *
     * @return the time in minutes and seconds
     */
    public String getTimeInMinutesAndSeconds() {
        int minutes = seconds / 60;
        String secondString = String.valueOf(seconds % 60);
        if (seconds < 10) secondString = "0" + secondString;

        return minutes + ":" + secondString;
    }
}
