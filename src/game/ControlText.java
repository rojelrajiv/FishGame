/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
 */
package game;

import city.cs.engine.SoundClip;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;

/**
 *
 * @author Rojel Rajiv
 */
public class ControlText extends JPanel implements ActionListener {

    private final String title = "How To Play";
    private final String description1 = "W/Up Arrow = Move Up";
    private final String description2 = "A/Right Arrow = Move Right";
    private final String description3 = "S/Down Arrow = Move Down";
    private final String description4 = "D/Left Arrow = Move Left";
    private final String description5 = "Collect All The fish Food to Advance to Next Level";
    private final String description6 = "Avoid Poison Bottles and Grenades, THEY WILL KILL YOU";
    private final String description7 = "Go toward the Golden Vault to advance to the next Level";

    private Container c;
    private JFrame mainscreen;
    private JButton mainMenu;
    private JButton quit;
    private Image image = new ImageIcon("data/Main_Menu_2.jpg").getImage();

    /**
     * A method which adds JButtons to the JPanel 
     */
   
    public ControlText() {

        mainscreen = new JFrame("Controls");
        mainMenu = new JButton("Main Menu");
        quit = new JButton("Quit");

        quit.setPreferredSize(new Dimension(100, 60));
        quit.setBounds(640, 400, 150, 50);
        quit.addActionListener(this);

        mainMenu.setPreferredSize(new Dimension(100, 60));
        mainMenu.setBounds(440, 400, 150, 50);
        mainMenu.addActionListener(this);

        mainscreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        c = mainscreen.getContentPane();

        this.setLayout(null);

        this.add(mainMenu);
        this.add(quit);

        c.add(this);
        this.setPreferredSize(new Dimension(1000, 500));
        mainscreen.pack();
        mainscreen.setVisible(true);

    }

    /**
     * This method draws text to the JPanel
     * @param g - assigns a String variable to be drawn to the JPanel
     *  
     */
    public void paintComponent(Graphics g) {
        g.drawImage(image, 0, 0, this);

        {
            g.setFont(new Font(title, 10, 50));
            g.setColor(Color.white);
            g.drawString(title, 300, 80);
        }

        {
            g.setFont(new Font(description1, 10, 30));
            g.setColor(Color.white);
            g.drawString(description1, 10, 150);
        }

        {
            g.setFont(new Font(description2, 10, 30));
            g.setColor(Color.white);
            g.drawString(description2, 10, 200);
        }

        {
            g.setFont(new Font(description3, 10, 30));
            g.setColor(Color.white);
            g.drawString(description3, 10, 250);
        }

        {
            g.setFont(new Font(description4, 10, 30));
            g.setColor(Color.white);
            g.drawString(description4, 10, 300);
        }

        {
            g.setFont(new Font(description5, 10, 20));
            g.setColor(Color.white);
            g.drawString(description5, 450, 200);
        }

        {
            g.setFont(new Font(description6, 10, 20));
            g.setColor(Color.white);
            g.drawString(description6, 450, 250);
        }

        {
            g.setFont(new Font(description7, 10, 20));
            g.setColor(Color.white);
            g.drawString(description7, 450, 300);
        }
    }

    /**
     *
     * @param ae - The object on which the Event initially occurred.

     * This method listens for actions performed on buttons on the JPanel
     */
    @Override
    public void actionPerformed(ActionEvent ae) {
        Object a = ae.getSource();

        if (a == mainMenu) {
            this.mainscreen.dispose();
            new MainMenu();
        }
        if (a == quit) {
            this.mainscreen.dispose();
        }
    }
}
