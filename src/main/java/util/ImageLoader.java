package util;

import javax.swing.ImageIcon;
import java.net.URL;

public class ImageLoader {

    /**
     * Safely loads an image from the classpath.
     * @param path The resource path (e.g., "/assets/image.png")
     * @return ImageIcon if resource exists, null otherwise
     */
    public static ImageIcon loadImage(String path) {
        URL resource = ImageLoader.class.getResource(path);
        if (resource != null) {
            return new ImageIcon(resource);
        }
        return null;
    }

    /**
     * Safely loads an image from the classpath with a fallback.
     * @param path The resource path (e.g., "/assets/image.png")
     * @param fallbackText Text to display if image can't be loaded
     * @return ImageIcon if resource exists, null otherwise
     */
    public static ImageIcon loadImage(String path, String fallbackText) {
        ImageIcon icon = loadImage(path);
        if (icon == null) {
            System.out.println("Warning: Could not load image: " + path);
        }
        return icon;
    }
}