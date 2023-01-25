package view;


/**
 * The enum Piece type.
 */
public enum PieceType{
    /**
     * King Piece type.
     */
    KING,
    /**
     * Queen Piece type.
     */
    QUEEN,
    /**
     * Pawn Piece type.
     */
    PAWN,
    /**
     * Knight Piece type.
     */
    KNIGHT,
    /**
     * Bishop Piece type.
     */
    BISHOP,
    /**
     * Rook Piece type.
     */
    ROOK;

    /**
     * Get value by string Piece type.
     *
     * @param piece the Piece
     * @return the Piece type
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
