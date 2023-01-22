package controller;

import model.Board;
import model.pieces.Piece;
import view.GameView;
import view.PieceType;

public class GameController implements IController {
    Board model;
    GameView view;

    public GameController(GameView view) {
        this.view = view;
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
    }

    @Override
    public void answer_decline() {
        model.answer(false);
    }

    @Override
    public String getTime() {
        return model.getTime();
    }

    public void placePiece(Piece currentPiece) {
        view.placePiece(getPieceTyp(currentPiece),currentPiece.getColor(),currentPiece.getCoordinate().getX(),currentPiece.getCoordinate().getY());
    }

    private PieceType getPieceTyp(Piece currentPiece){
        return PieceType.getValueByString(currentPiece.getClass().getSimpleName().toUpperCase());
    }
}
