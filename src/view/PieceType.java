package view;

import model.pieces.King;

public enum PieceType{
    KING,QUEEN,PAWN,KNIGHT,BISHOP,ROOK;
   public static PieceType getValueByString(String piece){
        switch (piece){
            case "KING" ->{
                return KING;
            }case "QUEEN"->{
                return QUEEN;
            }
            case "KNIGHT"->{
                return KNIGHT;
            }
            case "BISHOP"->{
                return BISHOP;
            }
            case "ROOK"->{
                return ROOK;
            }
            case "PAWN"->{
                return PAWN;
            }
            default -> {
                return null;
            }
        }
    }
}
