import java.awt.Color;
import java.awt.image.BufferedImage;

public class PixelUtil {

    public static boolean isBlackOrWhite(Color c) {
        return (c.getRed() == 0 && c.getGreen() == 0 && c.getBlue() == 0)
                || (c.getRed() == 255 && c.getGreen() == 255 && c.getBlue() == 255);
    }

    public static Color averageColorOfNeighbours(BufferedImage img, int x, int y) {
        int width = img.getWidth();
        int height = img.getHeight();

        int sumR = 0, sumG = 0, sumB = 0;
        int count = 0;

        for (int ny = y - 1; ny <= y + 1; ny++) {
            for (int nx = x - 1; nx <= x + 1; nx++) {
                if (nx >= 0 && nx < width && ny >= 0 && ny < height && !(nx == x && ny == y)) {
                    Color neighborColor = new Color(img.getRGB(nx, ny));
                    if (!isBlackOrWhite(neighborColor)) {
                        sumR += neighborColor.getRed();
                        sumG += neighborColor.getGreen();
                        sumB += neighborColor.getBlue();
                        count++;
                    }
                }
            }
        }

        if (count > 0) {
            int avgR = sumR / count;
            int avgG = sumG / count;
            int avgB = sumB / count;
            return new Color(avgR, avgG, avgB);
        } else {
            return new Color(128, 128, 128);
        }
    }
}
