package view;

import controlP5.Button;
import controlP5.ControlP5;
import controlP5.ControlP5Constants;
import controlP5.Textfield;
import controller.GameController;
import controller.IController;
import processing.core.PApplet;
import processing.core.PImage;

import java.awt.*;
import java.util.HashMap;

/**
 * The Game's view.
 *<p></p>
 * The view is being used to show a graphical interface of the game to the user.
 * Since the view is extending PApplet(Processing), it is only necessary to call the constructor :
 * GameView view = new GameView();
 * <p></p>
 * Internally GameView calls the settings(),setup() function to set the size of the application and to create the GUI components.
 * After that the draw() is being called 30 times a second, unless the processor is not fast enough to achieve the frame rate.
 */
public class GameView extends PApplet implements IView {

    /**
     * The Controller.
     */
    private final IController controller;

    /**
     * The Images.
     */
    private final HashMap<String, PImage> images = new HashMap<>();

    /**
     * Flag if the boards needs to be updated
     */
    private boolean updateBoard = false;
    /**
     * The Timer.
     */
    private Textfield timer;

    /**
     * The number of correct answers.
     */
    private Textfield doneCount;

    /**
     * The number of available chess moves.
     */
    private Textfield numberOfAttempts;

    /**
     * The visual Board
     */
    private Board board;

    /**
     * Instantiates a new view.
     */
    public GameView() {
        controller = new GameController(this);
    }

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        PApplet.main(GameView.class);
    }

    /**
     * The settings for processing
     */
    @Override
    public void settings() {
        size(800, 500);
    }

    /**
     * THe setup for processing
     */
    @Override
    public void setup() {
        loadImages();

        ControlP5 p5 = new ControlP5(this);
        Button newGameBtn = p5.addButton("Neues Spiel").setPosition(420, 175);
        Button yesBtn = p5.addButton("Feld ist erreichbar").setWidth(100).setPosition(420, 325).setWidth(120);
        Button noBtn = p5.addButton("Feld ist nicht erreichbar").setWidth(110).setPosition(420, 365).setWidth(120);
        timer = p5.addTextfield("clock").setCaptionLabel("").lock().setPosition(413, 10).setWidth(30);
        numberOfAttempts = p5.addTextfield("numberOfAttempts").setCaptionLabel("").setText("Anzahl Zuege:").lock().setPosition(413, 40).setWidth(70);
        doneCount = p5.addTextfield("count").setCaptionLabel("").setText("Anzahl korrekter Antworten: 0").lock().setPosition(413, 70).setWidth(140);

        newGameBtn.addListenerFor(ControlP5Constants.ACTION_RELEASE, callbackEvent -> controller.newGame());
        yesBtn.addListenerFor(ControlP5Constants.ACTION_RELEASE, callbackEvent -> controller.answer(true));
        noBtn.addListenerFor(ControlP5Constants.ACTION_RELEASE, callbackEvent -> controller.answer(false));

        board = new Board(this);

        updateBoard();
    }

    /**
     * Starts a new game
     */
    public void newGame() {
        updateBoard();
        controller.startTimer();
    }

    /**
     * Updates the number of current available moves
     *
     * @param attempts the available attempts
     */
    public void updateNumberOfAttempts(int attempts) {
        numberOfAttempts.setText("Anzahl Zuege: " + attempts);
    }

    /**
     * The draw function of processing
     */
    @Override
    public void draw() {
        if (updateBoard) {
            board.draw();
            updateBoard = false;
        }
        timer.setValue(controller.getTime());
    }

    /**
     * Loads the images of the Pieces
     */
    private void loadImages() {
        String[] pieceNames = new String[]{"bishop_black", "bishop_white", "king_black", "king_white", "knight_black", "knight_white", "pawn_black", "pawn_white", "queen_black", "queen_white", "rook_black", "rook_white"};
        for (String pieceName : pieceNames) {
            images.put(pieceName, loadImage("resources/img/pieces/" + pieceName + ".png"));
        }
    }

    /**
     * Returns the Image for the given PieceType and color
     *
     * @param type  the type of the Piece
     * @param color the color of the Piece
     * @return The Image
     */
    public PImage getImage(PieceType type, Color color) {
        String colorString = (color.equals(Color.BLACK)) ? "black" : "white";
        String key = type.toString().toLowerCase() + "_" + colorString;
        return images.get(key);
    }

    /**
     * Places Piece onto the board
     *
     * @param pieceTyp the Piece typ
     * @param color    the color
     * @param x        the x
     * @param y        the y
     */
    public void placePiece(PieceType pieceTyp, Color color, int x, int y) {
        board.placePiece(pieceTyp, color, x, y);
    }

    /**
     * Flag to update the board on the next draw()
     */
    @Override
    public void updateBoard() {
        updateBoard = true;
    }

    /**
     * Marks the cell on the board
     *
     * @param x the x coordinate of the marked cell
     * @param y the y coordinate of the marked cell
     */
    @Override
    public void markPiece(int x, int y) {
        board.markPiece(x, y);
    }

    /**
     * Resets the board state
     */
    @Override
    public void resetBoard() {
        board.resetBoard();
    }

    /**
     * Updates the count of correctly answered positions
     *
     * @param count The number of correct answers by the user
     */
    @Override
    public void updateDoneCount(int count) {
        doneCount.setText("Anzahl korrekter Antworten: " + count);
    }

    /**
     * Sets the time of the game
     * @param time The time in format mm:ss
     */
    @Override
    public void setTimer(String time) {
        timer.setValue(time);
    }
}
