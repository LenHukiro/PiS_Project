package controller;

/**
 * The interface Controller.
 */
public interface IController {
    /**
     * New game.
     */
    void newGame();

    /**
     * Answer accept.
     */
    void answer_accept();

    /**
     * Answer decline.
     */
    void answer_decline();

    /**
     * Gets time.
     *
     * @return the time
     */
    String getTime();
}
