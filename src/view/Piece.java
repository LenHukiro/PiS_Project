package view;

import processing.core.PImage;

import java.awt.*;

public class Piece {
    PImage img;
    GameView view;
    Color color;
    PieceType type;

    Piece(GameView view, PieceType type, boolean isBlack) {
        this.type = type;
        this.color = isBlack ? Color.BLACK : Color.WHITE;
        this.view = view;
        setImage();
    }

    private void setImage() {
        img = view.getImage(type, color);
    }

    public PImage getImage() {
        return img;
    }
}