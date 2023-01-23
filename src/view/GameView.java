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
    HashMap<String,PImage> images = new HashMap<>();

    boolean updateBoard = false;
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
        loadImages();
        p5 = new ControlP5(this);
        Button newGameBtn = p5.addButton("Neues Spiel").setPosition(420,175);
        Button yesBtn = p5.addButton("Feld ist erreichbar").setWidth(100).setPosition(420,325);
        Button noBtn = p5.addButton("Feld ist nicht erreichbar").setWidth(110).setPosition(420,375);
        timer = p5.addTextfield(controller.getTime()).lock().setPosition(413,10).setWidth(30);
        newGameBtn.addListenerFor(ControlP5Constants.ACTION_RELEASE, callbackEvent ->{ controller.newGame();});
        yesBtn.addListenerFor(ControlP5Constants.ACTION_RELEASE, callbackEvent -> {
            controller.answer_accept();
        });
        noBtn.addListenerFor(ControlP5Constants.ACTION_RELEASE, callbackEvent -> controller.answer_decline());
        board = new Board(this);
        updateBoard = true;
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
        if(updateBoard) {
            board.draw();
            updateBoard = false;
        }
        timer.setValue(controller.getTime());
    }

    private void loadImages(){
        String[] pieceNames = new String[]{"bishop_black","bishop_white","king_black","king_white","knight_black","knight_white","pawn_black","pawn_white","queen_black","queen_white","rook_black","rook_white"};
        for (String pieceName : pieceNames) {
            images.put(pieceName, loadImage("resources/img/pieces/"+pieceName + ".png"));
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
        updateBoard = true;
    }
}
