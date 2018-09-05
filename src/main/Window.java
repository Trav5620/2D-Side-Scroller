package main;

import javax.swing.*;
import java.awt.*;

public class Window extends Canvas{

    private static final long serialVersionUID = -4810618286807932601L;

    public Window(int width, int height, String title, Game game){
        JFrame frame = new JFrame(title);

        frame.setPreferredSize(new Dimension(width, height));
        frame.setMaximumSize(new Dimension(width, height));
        frame.setMinimumSize(new Dimension(width, height));

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //if not set up the X button won't stop the thread
        frame.setResizable(false);
        frame.setLocationRelativeTo(null); //Makes window start in the middle instead of the top left
        frame.add(game);
        frame.setVisible(true);
        game.start();
    }
}
