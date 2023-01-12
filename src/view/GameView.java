package view;

import controlP5.ControlP5;
import controller.GameController;
import controller.IController;
import processing.core.PApplet;

public class GameView extends PApplet implements IView {

    ControlP5 p5;
    IController controller;

    public static void main(String[] args) {
        PApplet.main(GameView.class);
    }
    public GameView() {
     controller = new GameController();
    }

    @Override
    public void settings() {
        size(800, 800);
    }

    @Override
    public void setup() {
        p5 = new ControlP5(this);
    }

    @Override
    public void draw() {
        super.draw();
    }


}
