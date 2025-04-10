import java.awt.Color;
import java.awt.image.BufferedImage;

public class Denoiser {
    public static BufferedImage denoise(BufferedImage noised) {
        int width = noised.getWidth();
        int height = noised.getHeight();
        BufferedImage denoised = new BufferedImage(width, height, noised.getType());

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                int rgb = noised.getRGB(x, y);
                Color currentColor = new Color(rgb);

                if (PixelUtil.isBlackOrWhite(currentColor)) {
                    Color average = PixelUtil.averageColorOfNeighbours(noised, x, y);
                    denoised.setRGB(x, y, average.getRGB());
                } else {

                    denoised.setRGB(x, y, rgb);
                }
            }
        }
        return denoised;
    }
}
