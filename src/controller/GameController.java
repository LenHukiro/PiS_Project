package controller;

import model.GameModel;
import model.pieces.Piece;
import view.GameView;
import view.IView;
import view.PieceType;

/**
 * The type Game controller.
 */
public class GameController implements IController {

    /**
     * The Model.
     */
     private final GameModel model;
    /**
     * The View.
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
        model.answer(userInput);
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
