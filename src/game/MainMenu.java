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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;

/**
 *
 * @author Rojel Rajiv
 */
public class MainMenu extends JPanel implements ActionListener {

    private String title = "Fish Game";
    private Container c;
    private JFrame mainscreen;
    private JButton singlePlayer;
    private JButton multiPlayer;
    private JButton controls;
    private JButton quit;
    private Image image = new ImageIcon("data/Main_Menu_2.jpg").getImage();
    private SoundClip gameMusic;

    /**
     * A method which adds JButtons to the JPanel
     */
    
    public MainMenu() {

        try {
            gameMusic = new SoundClip("data/Mariachi.wav");   // Open an audio input stream
            gameMusic.loop();  // Set it to continous playback (looping)
        } catch (UnsupportedAudioFileException | LineUnavailableException e) {
            System.out.println(e);
        } catch (IOException ex) {
            Logger.getLogger(MainMenu.class.getName()).log(Level.SEVERE, null, ex);
        }

        mainscreen = new JFrame("Fish Game");

        singlePlayer = new JButton("Single Player");
        multiPlayer = new JButton("Two Player");
        controls = new JButton("Controls");
        quit = new JButton("Quit");

        multiPlayer.setPreferredSize(new Dimension(100, 60));
        multiPlayer.setBounds(440, 400, 150, 50);
        multiPlayer.addActionListener(this);

        singlePlayer.setPreferredSize(new Dimension(100, 60));
        singlePlayer.setBounds(240, 400, 150, 50);
        singlePlayer.addActionListener(this);

        quit.setPreferredSize(new Dimension(100, 60));
        quit.setBounds(640, 400, 150, 50);
        quit.addActionListener(this);

        controls.setPreferredSize(new Dimension(100, 60));
        controls.setBounds(40, 400, 150, 50);
        controls.addActionListener(this);

        mainscreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        c = mainscreen.getContentPane();

        this.setLayout(null);

        this.add(singlePlayer);
        this.add(multiPlayer);
        this.add(controls);
        this.add(quit);

        c.add(this);
        this.setPreferredSize(new Dimension(1000, 500));
        mainscreen.pack();
        mainscreen.setVisible(true);

    }

    /**
     * This method draws text to the JPanel
     * @param g - assigns a String variable to be drawn to the JPanel
     */
    public void paintComponent(Graphics g) {
        g.drawImage(image, 0, 0, this);
        g.setFont(new Font(title, 10, 50));
        g.setColor(Color.white);
        g.drawString(title, 300, 80);
    }

    /**
     *
     * @param ae - The object on which the Event initially occurred.
     */
    @Override
    public void actionPerformed(ActionEvent ae) {
        Object a = ae.getSource();

        if (a == singlePlayer) {
            this.mainscreen.dispose();
            new Game();
        }
        if (a == quit) {
            this.mainscreen.dispose();
        }
        if (a == multiPlayer) {
            this.mainscreen.dispose();
            new Game2();
        }
        if (a == controls) {
            this.mainscreen.dispose();
            new ControlText();
        }
    }

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        try {
            Thread.sleep(5000);

        } catch (Exception e) {

        }

        new MainMenu();
    }

}
