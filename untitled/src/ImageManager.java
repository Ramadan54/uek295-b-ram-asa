import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class ImageManager {
    public static BufferedImage readImage(String path) throws IOException {
        return ImageIO.read(new File(path));
    }

    public static void writeImage(BufferedImage img, String path, String format) throws IOException {
        ImageIO.write(img, format, new File(path));
    }
}
