public class BoardTile {
    private ChessColour colour;
    private ChessPiece piece;
    private int x;
    private int y;
    
    // Constructor
    public BoardTile(ChessColour colour, int x, int y) {
        this.piece = ChessPiece.None;
        this.colour = colour;
        this.x = x;
        this.y = y;
    }

    // Getters
    public ChessColour getColour() {
        return colour;
    }
    public ChessPiece getPiece() {
        return piece;
    }

    public void putPiece(ChessPiece piece) {
        this.piece = piece;
    }
    public void removePiece() {
        this.piece = null;
    }

    // toString
    @Override
    public String toString() {
        return "BoardTile{" +
                "colour=" + colour +
                ", piece=" + piece +
                ", x=" + x +
                ", y=" + y +
                '}';
    }

}
