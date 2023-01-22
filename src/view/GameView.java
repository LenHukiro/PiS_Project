package view;

import controlP5.*;
import controlP5.Button;
import controller.GameController;
import controller.IController;
import processing.core.PApplet;
import processing.core.PImage;

import java.awt.*;
import java.util.HashMap;

/**
 * The type Game view.
 */
public class GameView extends PApplet implements IView {

    /**
     * The P 5.
     */
    ControlP5 p5;
    /**
     * The Controller.
     */
    IController controller;

    /**
     * The Images.
     */
    HashMap<String,PImage> images;
    /**
     * The Timer.
     */
    Textfield timer;
    /**
     * The Board.
     */
    Board board;

    /**
     * Instantiates a new Game view.
     */
    public GameView() {
        controller = new GameController(this);
        loadImages();
    }

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        PApplet.main(GameView.class);
    }

    @Override
    public void settings() {
        size(800, 800);
    }

    @Override
    public void setup() {
        p5 = new ControlP5(this);
        Button newGameBtn = p5.addButton("NewGameBtn");
        Button yesBtn = p5.addButton("Feld ist erreichbar");
        Button noBtn = p5.addButton("Feld ist nicht erreichbar");
        timer = p5.addTextfield(controller.getTime());
        newGameBtn.addListenerFor(ControlP5Constants.ACTION_RELEASE, callbackEvent -> controller.newGame());
        yesBtn.addListenerFor(ControlP5Constants.ACTION_RELEASE, callbackEvent -> controller.answer_accept());
        noBtn.addListenerFor(ControlP5Constants.ACTION_RELEASE, callbackEvent -> controller.answer_decline());
        board = new Board(this);
    }

    /**
     * New game.
     */
    public void newGame(){
        new Thread(() -> {
            String time = controller.getTime();
            while(!time.equals("0:00")){
                timer.setValue(controller.getTime());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }

    @Override
    public void draw() {
        timer.setValue(controller.getTime());
        board.draw();
    }

    private void loadImages(){
        String[] pieceNames = new String[]{"bishop_black","bishop_white","king_black","king_white","knight_black","knight_white","pawn_black","pawn_white","queen_black","queen_white","rook_black","rook_white"};
        for (String pieceName : pieceNames) {
            images.put(pieceName, loadImage(pieceName + ".png"));
        }
    }

    /**
     * Get image p image.
     *
     * @param type  the type
     * @param color the color
     * @return the p image
     */
    public PImage getImage(PieceType type, Color color){
        String key =type.toString().toLowerCase()+"_"+color.toString().toLowerCase();
        return images.get(key);
    }

    /**
     * Place piece.
     *
     * @param pieceTyp the piece typ
     * @param color    the color
     * @param x        the x
     * @param y        the y
     */
    public void placePiece(PieceType pieceTyp,Color color, int x, int y){
        board.placePiece(pieceTyp,color,x,y);
    }

    @Override
    public void updateBoard() {
        board.
    }
}
