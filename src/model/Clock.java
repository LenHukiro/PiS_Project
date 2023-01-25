package model;


/**
 * The type Clock.
 */
public class Clock extends Thread {

    /**
     * The Seconds.
     */
    private int seconds;
    /**
     * The Board.
     */
    private final GameModel board;

    /**
     * Instantiates a new Clock.
     *
     * @param board   the board
     * @param seconds the seconds
     */
    Clock(GameModel board, int seconds) {
        this.board = board;
        this.seconds = seconds;
    }

    /**
     *
     */
    @Override
    public void run() {
        while (seconds > 0) {
            try {
                Thread.sleep(1000);
                seconds--;
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        board.stopGame();
        interrupt();
    }

    /**
     * Gets time in minutes and seconds.
     *
     * @return the time in the format mm:ss
     */
    public String getTimeInMinutesAndSeconds() {
        int minutes = seconds / 60;
        String secondString = String.valueOf(seconds % 60);
        if ((seconds % 60) < 10) {
            secondString = "0" + secondString;
        }
        return minutes + ":" + secondString;
    }
}
