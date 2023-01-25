package controller;

/**
 * The interface Controller.
 */
public interface IController {
    /**
     * Starts a new game of the model.
     */
    void newGame();

    /**
     * Accepts the user answer onto the model.
     */
    void answer(boolean userInput);

    /**
     * Gets time from the model
     *
     * @return the time as format mm:ss
     */
    String getTime();

    /**
     * Starts the timer for the view
     */
    void startTimer();
}
