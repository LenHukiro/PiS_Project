package controller;

import model.GameModel;
import model.IModel;
import model.pieces.Piece;
import view.GameView;
import view.IView;
import view.PieceType;

/**
 * The Game's controller.
 * <p></p>
 * The controller is being used to transmit data between the model and the view and to update the view.
 * It can be used inside the GameView as such:
 *<p></p>
 * GameController controller = new GameController(this);<p></p>
 * and every public method is being used inside the view.
 * A few examples:<p></p>
 * newGame(); Update the GameView to start a new game and creates a new model<p></p>
 * answer(true); passes the answer through the model and updates the view<p></p>
 * startTimer() starts the timer of the view (WARNING:NOT THE TIMER INSIDE THE MODEL, THAT TIMER IS STARTED ON ITS OWN)<p></p>
 * placePiece(Piece currentPiece) places a piece inside the board of the view<p></p>
 *
 */
public class GameController implements IController {

    /**
     * The Model of the game
     */
     private final IModel model;
    /**
     * The View of the game
     */
    private final IView view;

    /**
     * Instantiates a new Game controller.
     *
     * @param view the view
     */
    public GameController(GameView view) {
        this.view = view;
        this.model = new GameModel();
    }

    /**
     * Starts a new game
     */
    @Override
    public void newGame() {
        model.newGame();
        view.newGame();
        view.updateNumberOfAttempts(model.getNumberOfMoves());
        placePiece(model.getCurrentPiece());
    }

    /**
     * Passes the user answer onto the model and updates the view
     *
     * @param userInput The answer by the user
     */
    @Override
    public void answer(boolean userInput) {
        model.answerTask(userInput);
        view.updateBoard();
        view.updateNumberOfAttempts(model.getNumberOfMoves());
        view.updateDoneCount(model.getCompletedTasks());
        placePiece(model.getCurrentPiece());
    }

    /**
     * Returns the time from the model
     * @return the time in the format mm:ss
     */
    @Override
    public String getTime() {
        return model.getTime();
    }

    /**
     * Updates the timer from the model
     */
    @Override
    public void startTimer() {
        new Thread(() -> {
            String time = getTime();
            while (!time.equals("0:00")) {
                view.setTimer(getTime());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }

    /**
     * Place Piece onto the view.
     *
     * @param currentPiece the current Piece
     */
    public void placePiece(Piece currentPiece) {
        view.resetBoard();
        view.placePiece(getPieceTyp(currentPiece),currentPiece.getColor(),currentPiece.getCoordinate().getX(),currentPiece.getCoordinate().getY());
        view.markPiece(model.getPointCoordinate().getX(),model.getPointCoordinate().getY());
    }

    /**
     * Returns the Type of the Piece
     *
     * @param currentPiece the current Piece
     * @return {PieceType}
     */
    private PieceType getPieceTyp(Piece currentPiece){
        return PieceType.getValueByString(currentPiece.getClass().getSimpleName().toUpperCase());
    }
}
