package view;


/**
 * Enum containing the possible chess Piece Types
 */
public enum PieceType {
    /**
     * Type representing the Piece King.
     */
    KING,
    /**
     * Type representing the Piece King Queen.
     */
    QUEEN,
    /**
     * Type representing the Piece Pawn.
     */
    PAWN,
    /**
     *  Type representing the Piece Knight.
     */
    KNIGHT,
    /**
     * Type representing the Piece Bishop.
     */
    BISHOP,
    /**
     * Type representing the Piece Rook.
     */
    ROOK;

    /**
     * Gets Value of PieceType for given String or null, if it is not a valid PieceType.
     *
     * @param piece The requested PieceType
     * @return The PieceType
     */
    public static PieceType getValueByString(String piece) {
        switch (piece.toUpperCase()) {
            case "KING" -> {
                return KING;
            }
            case "QUEEN" -> {
                return QUEEN;
            }
            case "KNIGHT" -> {
                return KNIGHT;
            }
            case "BISHOP" -> {
                return BISHOP;
            }
            case "ROOK" -> {
                return ROOK;
            }
            case "PAWN" -> {
                return PAWN;
            }
            default -> {
                return null;
            }
        }
    }
}
