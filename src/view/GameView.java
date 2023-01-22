package view;

import controlP5.*;
import controlP5.Button;
import controller.GameController;
import controller.IController;
import processing.core.PApplet;
import processing.core.PImage;

import java.awt.*;
import java.util.HashMap;

import static controlP5.ControlP5Constants.ACTION_RELEASE;

public class GameView extends PApplet implements IView {

    ControlP5 p5;
    IController controller;

    HashMap<String,PImage> images;

    public GameView() {
        controller = new GameController();
    }

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
        Textfield timer = p5.addTextfield(controller.getTime());

        newGameBtn.addListenerFor(ACTION_RELEASE, callbackEvent -> controller.newGame());
        yesBtn.addListenerFor(ACTION_RELEASE, callbackEvent -> controller.answer_accept());
        noBtn.addListenerFor(ACTION_RELEASE, callbackEvent -> controller.answer_decline());
    }

    @Override
    public void draw() {
        super.draw();
    }

    private void loadImages(){
        String[] pieceNames = new String[]{"bishop_black","bishop_white","king_black","king_white","knight_black","knight_white","pawn_black","pawn_white","queen_black","queen_white","rook_black","rook_white"};
        for (String pieceName : pieceNames) {
            images.put(pieceName, loadImage(pieceName + ".png"));
        }
    }
    public PImage getImage(PieceType type, Color color){
        String key =type.toString().toLowerCase()+"_"+color.toString().toLowerCase();
        return images.get(key);
    }
}
