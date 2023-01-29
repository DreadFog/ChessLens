import java.util.HashMap;
import java.util.Map;
/*
 * This class is used to associate an image with its corresponding chessPiece.
 */
public class PieceImageAssociation {
    private  Map<Integer, BoardPiece> database = new HashMap<Integer, BoardPiece>();
    
    public PieceImageAssociation() {
        database.put(1, new BoardPiece(ChessColour.BLACK, ChessPiece.PAWN));
        database.put(2, new BoardPiece(ChessColour.BLACK, ChessPiece.PAWN));
        database.put(3, new BoardPiece(ChessColour.WHITE, ChessPiece.PAWN));
        database.put(4, new BoardPiece(ChessColour.WHITE, ChessPiece.PAWN));
        // black bishop on white tile
        database.put(5, new BoardPiece(ChessColour.BLACK, ChessPiece.BISHOP));
        // black bishop on black tile 
        database.put(6, new BoardPiece(ChessColour.BLACK, ChessPiece.BISHOP)); 
        // black bishop on white tile, but tilted
        database.put(7, new BoardPiece(ChessColour.BLACK, ChessPiece.BISHOP)); 
        database.put(8, new BoardPiece(ChessColour.BLACK, ChessPiece.BISHOP));
        database.put(9, new BoardPiece(ChessColour.BLACK, ChessPiece.BISHOP));
        database.put(10, new BoardPiece(ChessColour.BLACK, ChessPiece.BISHOP));
        // black bishop on black tile, but tilted
        database.put(11, new BoardPiece(ChessColour.BLACK, ChessPiece.BISHOP)); 
        database.put(12, new BoardPiece(ChessColour.BLACK, ChessPiece.BISHOP));
        database.put(13, new BoardPiece(ChessColour.BLACK, ChessPiece.BISHOP));
        database.put(14, new BoardPiece(ChessColour.BLACK, ChessPiece.BISHOP));
    }

    public BoardPiece getPiece(Integer key) {
        return database.get(key);
    }

    /*
     * getDatabaseSize() returns the size of the database.
     */
    public int getDatabaseSize() {
        return database.size();
    }
}
