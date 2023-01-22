package view;

import processing.core.PImage;

import java.awt.*;

/**
 * The type Piece.
 */
public class Piece {
    /**
     * The Img.
     */
    PImage img;
    /**
     * The View.
     */
    GameView view;
    /**
     * The Color.
     */
    Color color;
    /**
     * The Type.
     */
    PieceType type;

    /**
     * Instantiates a new Piece.
     *
     * @param view    the view
     * @param type    the type
     * @param isBlack the is black
     */
    Piece(GameView view, PieceType type, boolean isBlack) {
        this.type = type;
        this.color = isBlack ? Color.BLACK : Color.WHITE;
        this.view = view;
        setImage();
    }

    private void setImage() {
        img = view.getImage(type, color);
    }

    /**
     * Gets image.
     *
     * @return the image
     */
    public PImage getImage() {
        return img;
    }
}