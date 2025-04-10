import java.awt.Color;
import java.awt.image.BufferedImage;
import java.util.Random;

public class NoiseGenerator {

    public static BufferedImage addNoise(BufferedImage original, double noiseChance) {
        int width = original.getWidth();
        int height = original.getHeight();
        BufferedImage copy = new BufferedImage(width, height, original.getType());

        Random rand = new Random();

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                int rgb = original.getRGB(x, y);
                if (rand.nextDouble() < noiseChance) {
                    if (rand.nextBoolean()) {
                        copy.setRGB(x, y, Color.BLACK.getRGB());
                    } else {
                        copy.setRGB(x, y, Color.WHITE.getRGB());
                    }
                } else {
                    copy.setRGB(x, y, rgb);
                }
            }
        }
        return copy;
    }
}
