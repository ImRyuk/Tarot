package view;

import java.awt.Dimension;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class CardImage extends JPanel {
    private static final long serialVersionUID = 1L;

    BufferedImage image;

    public CardImage(File file) {
        try {
            image = ImageIO.read(file);
            setPreferredSize(new Dimension(image.getWidth()/2, image.getHeight()/2));
            
        } catch (IOException e) {
            // Hide image if an error occurs
            setVisible(false);
        }
    }

    public void paint(Graphics g) {
        g.drawImage(image, 0, 0, 100, 200, null);
    }
    
}