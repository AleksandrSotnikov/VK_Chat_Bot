package ru.sotnikov.test;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Screenshot {
    public static void main(String[] args) throws IOException, AWTException {
        BufferedImage image = new Robot().createScreenCapture(new Rectangle(new Point(1, 1), new Dimension(1, 1)));
        ImageIO.write(image, "png", new File("screenshot.png"));
    }
}
