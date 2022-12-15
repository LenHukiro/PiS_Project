package model;

import processing.core.PImage;

public enum PieceType {
    KING, KNIGHT, QUEEN, BISHOP, ROOK, PAWN;

    public PImage getImage() {// TODO:Implement Images
        switch (this){
            case KING -> {
                return null;
            }
            case KNIGHT -> {
                return null;
            }
            case QUEEN -> {
                return null;
            }
            case BISHOP -> {
                return null;
            }
            case ROOK -> {
                return null;
            }
            default -> {
                return null;
            }
            case PAWN -> {
                return null;
            }
        }
    }
    }
