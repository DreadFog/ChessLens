import java.awt.Image;
import java.awt.image.ImageObserver;
import java.awt.image.PixelGrabber;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
public final class Util {
    /**
     * Converts a java.awt.Image into an array of pixels
     */
    public static int[] convertToPixels(Image img) {
      int width = img.getWidth(null);
      int height = img.getHeight(null);
      int[] pixel = new int[width * height];

      PixelGrabber pg = new PixelGrabber(img, 0, 0, width, height, pixel, 0, width);
      try {
        pg.grabPixels();
      } catch (InterruptedException e) {
        throw new IllegalStateException("Error: Interrupted Waiting for Pixels");
      }
      if ((pg.getStatus() & ImageObserver.ABORT) != 0) {
        throw new IllegalStateException("Error: Image Fetch Aborted");
      }
      return pixel;
    }

    BufferedImage resizeImage(BufferedImage originalImage, int targetWidth, int targetHeight) throws IOException {
        BufferedImage resizedImage = new BufferedImage(targetWidth, targetHeight, BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics2D = resizedImage.createGraphics();
        graphics2D.drawImage(originalImage, 0, 0, targetWidth, targetHeight, null);
        graphics2D.dispose();
        return resizedImage;
    }
    public static int[][] convertPiecesImagesToPixels(int width, int height, Integer databaseSize) throws IOException {
        int[][] piecesPixels = new int[databaseSize][];
        for (int i = 0; i < databaseSize; i++) {
            piecesPixels[i] = convertToPixels(  ImageIO.read(new File("pieces/" + (i+1) + ".jpg"))
                                                .getScaledInstance(width, height, Image.SCALE_SMOOTH));
        }
        return piecesPixels;
    }

    public static int[][] replicateImage(int[] pixels, int n) {
        int[][] replicated = new int[n][];
        for (int i = 0; i < n; i++) {
            replicated[i] = pixels;
        }
        return replicated;
    }
}