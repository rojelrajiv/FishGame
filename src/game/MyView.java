/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import city.cs.engine.UserView;
import city.cs.engine.World;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/**
 *
 * @author Rojel
 */
public class MyView extends UserView {

    private Game game;
    private Game2 game2;
    private Image background;
    private Fish fish;

    /**
     *
     * @param world - A world in which the motion and interaction of a number of rigid bodies is simulated. Bodies are added to the world automatically when they are created
     * @param game - The computer game.
     * @param width - The width of the world
     * @param height - The height of the world
     */
    public MyView(World world, Game game, int width, int height) {
        super(world, width, height);
        this.game = game;
        this.background = new ImageIcon("data/Underwater_Background_5.jpg").getImage();
    }

    /**
     *
     * @param g - assigns a String variable to be drawn to the UserView foreground
     */
    @Override
    protected void paintForeground(Graphics2D g) {

        {
            // 1st player score count
            g.setColor(Color.white);
            g.drawString("Score Count: " + game.getPlayer().getGameScoreCount(), 100, 10);

        }

        {
            //1st player health bar
            g.setColor(Color.white);
            g.drawString("Health: ", 250, 10);
            g.setColor(Color.red);
            g.fillRect(350, 0, 100, 20); //draws healthbar outline
            g.setColor(Color.green);
            g.fillRect(350, 0, game.getPlayer().getHealth(), 20); //draws health
        }

    }

    /**
     *
     * @param level - Is the current level of the game
     */
    public void setBackgroundForLevel(int level) {
        try {
            String filePath = "";
            if (level == 2) {
                filePath = "data/pug.gif";

            }
            if (level == 3) {
                filePath = "data/Underwater_Background_4.jpg";
            }
            if (level == 4) {
                filePath = "data/Underwater_Background_7.jpg";
            }
            if (level == 5) {
                filePath = "data/Underwater_Background_6.jpg";
            }
            background = ImageIO.read(new File(filePath));
        } catch (IOException e) {
            e.printStackTrace();

        }
    }

    /**
     *
     * @param g - assigns a file to be drawn as a background of the UserView
     */
    @Override
    protected void paintBackground(Graphics2D g) {
        g.drawImage(background, 0, 0, this);
    }

}
