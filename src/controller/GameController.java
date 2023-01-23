package controller;

import model.GameModel;
import model.pieces.Piece;
import view.GameView;
import view.PieceType;

/**
 * The type Game controller.
 */
public class GameController implements IController {
    /**
     * The Model.
     */
    GameModel model;
    /**
     * The View.
     */
    GameView view;

    /**
     * Instantiates a new Game controller.
     *
     * @param view the view
     */
    public GameController(GameView view) {
        this.view = view;
        this.model = new GameModel();
    }

    @Override
    public void newGame() {
        model.newGame();
        view.newGame();
        placePiece(model.getCurrentPiece());
    }

    @Override
    public void answer_accept() {
        model.answer(true);
        view.updateBoard();
    }

    @Override
    public void answer_decline() {
        model.answer(false);
    }

    @Override
    public String getTime() {
        return model.getTime();
    }

    /**
     * Place piece.
     *
     * @param currentPiece the current piece
     */
    public void placePiece(Piece currentPiece) {
        view.placePiece(getPieceTyp(currentPiece),currentPiece.getColor(),currentPiece.getCoordinate().getX(),currentPiece.getCoordinate().getY());
    }

    private PieceType getPieceTyp(Piece currentPiece){
        return PieceType.getValueByString(currentPiece.getClass().getSimpleName().toUpperCase());
    }

    public void updateBoard() {
        placePiece(model.getCurrentPiece());
    }
}
