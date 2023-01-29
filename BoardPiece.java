public class BoardPiece {
    private ChessColour color;
    private ChessPiece chessPiece;

    // basic constructor
    public BoardPiece(ChessColour c, ChessPiece p){
        this.color = c;
        this.chessPiece = p;
    }

    // getters
    public ChessColour getColor(){
        return this.color;
    }
    public ChessPiece getPiece(){
        return this.chessPiece;
    }
    
    // printer
    @Override
    public String toString(){
        return this.color + " " + this.chessPiece;
    }
}
