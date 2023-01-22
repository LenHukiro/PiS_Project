package view;

import model.pieces.King;

/**
 * The enum Piece type.
 */
public enum PieceType{
    /**
     * King piece type.
     */
    KING,
    /**
     * Queen piece type.
     */
    QUEEN,
    /**
     * Pawn piece type.
     */
    PAWN,
    /**
     * Knight piece type.
     */
    KNIGHT,
    /**
     * Bishop piece type.
     */
    BISHOP,
    /**
     * Rook piece type.
     */
    ROOK;

    /**
     * Get value by string piece type.
     *
     * @param piece the piece
     * @return the piece type
     */
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
