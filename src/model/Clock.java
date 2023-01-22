package model;

public class Clock extends Thread {

    int seconds;
    Board board;

    Clock(Board board) {
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

    public String getTimeInMinutesAndSeconds() {
        int minutes = seconds / 60;
        String secondString = String.valueOf(seconds % 60);
        if (seconds < 10) secondString = "0" + secondString;

        return minutes + ":" + secondString;
    }
}
