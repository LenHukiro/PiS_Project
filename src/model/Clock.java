package model;

import java.util.Timer;

public class Clock extends Thread {

    int seconds;
    Board board;
    Clock(Board board){
        this.board = board;
        seconds = 500;
    }

    @Override
    public void run() {
    seconds--;
    if(seconds == 0) board.stopGame();
    }

    public long getTime() {
        return 0;
    }
}
