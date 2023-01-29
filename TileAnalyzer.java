import java.awt.Image;
import java.io.IOException;
public class TileAnalyzer {
    public static final int TILE_SIZE = 300;
    private PieceImageAssociation pia;
    private Image image;
    int[][] database;

    public TileAnalyzer(){
        this.pia = new PieceImageAssociation();
    }

    public BoardPiece analyzeImage(Image ia) throws IOException {
        System.out.println("Resizing image to " + TILE_SIZE + "x" + TILE_SIZE + "...");
        this.image = ia.getScaledInstance(TILE_SIZE, TILE_SIZE, Image.SCALE_SMOOTH);
        this.database = new int[pia.getDatabaseSize()][];
        this.database = Util.convertPiecesImagesToPixels(this.image.getWidth(null), this.image.getHeight(null), pia.getDatabaseSize());
        System.out.println("Created a matrix of size " + database.length + "x" + database[0].length);
        int[] pixels = Util.convertToPixels(image);
        int[][] replicatedImage = Util.replicateImage(pixels, this.database.length);
        int[][] diff = MatrixOps.subtract(replicatedImage, this.database);
        double[] absoluteSum = MatrixOps.getAbsoluteSum(diff);
        double min = Double.MAX_VALUE;
        int minIndex = -1;
        for (int i = 0; i < absoluteSum.length; i++) {
            if (absoluteSum[i] < min) {
                min = absoluteSum[i];
                minIndex = i;
            }
        }
        //System.out.print("distance matrix:");
        for (int i = 0; i < absoluteSum.length; i++) {
            System.out.print(" " + absoluteSum[i]);
        }
        System.out.println();
        // System.out.println("The closest piece is " + (minIndex+ 1) + " with a difference of " + min);
        System.out.println("Guessed piece: " + pia.getPiece(minIndex + 1) + " with a difference of " + min);
        return pia.getPiece(minIndex + 1);
    }
    
}
