package model;


/**
 * A Clock class to track the available time for a player.
 *<p>
 * The class extends a thread, so it can be started via the start() function.<p></p>
 * To return the current time the function getTimeInMinutesAndSeconds() can be used.
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
    public Clock(GameModel board, int seconds) {
        this.board = board;
        this.seconds = seconds;
    }

    /**
     * Starts the Thread(the clock)
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
    }

    /**
     * Gets time in minutes and seconds.
     *
     * @return the time in the format mm:ss
     */
    public String getTimeInMinutesAndSeconds() {
        String secondString = String.valueOf(seconds % 60);
        if ((seconds % 60) < 10) {
            secondString = "0" + secondString;
        }
        return seconds / 60 + ":" + secondString;
    }
}
