import java.awt.image.BufferedImage;
import java.io.IOException;

public class ImageEditing {
    public static void main(String[] args) {
        try {
            BufferedImage originalImage = ImageManager.readImage(Config.INPUT_PATH);
            BufferedImage noisedImage = NoiseGenerator.addNoise(originalImage, Config.NOISE_CHANCE);
            ImageManager.writeImage(noisedImage, Config.NOISE_OUTPUT_PATH, Config.IMAGE_FORMAT);
            BufferedImage denoisedImage = Denoiser.denoise(noisedImage);
            ImageManager.writeImage(denoisedImage, Config.DENOISED_OUTPUT_PATH, Config.IMAGE_FORMAT);
            System.out.println("Vorgang abgeschlossen.");
        } catch (IOException e) {
            System.err.println("Fehler beim Ein- oder Auslesen der Bilddateien: " + e.getMessage());
        }
    }
}
