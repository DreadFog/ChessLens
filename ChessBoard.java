public class ChessBoard {
    private BoardTile[][] board;
    
    public ChessBoard() {
        ChessColour currColour = ChessColour.BLACK;
        board = new BoardTile[8][8];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                board[i][j] = new BoardTile(currColour, i, j);
                currColour = currColour == ChessColour.BLACK ? ChessColour.WHITE : ChessColour.WHITE;
            }
        }
    }

    public BoardTile getTile(int x, int y) {
        return board[x][y];
    }

    public void printBoard() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }
}
