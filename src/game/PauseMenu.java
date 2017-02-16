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
import javax.swing.*;

/**
 *
 * @author Rojel Rajiv
 */
public class PauseMenu extends JPanel implements ActionListener {

    private String name = "Fish Game";
    private Container c;
    private JFrame mainscreen;
    private JButton restartButton;
    private JButton resumeButton;
    private JButton controls;
    private JButton quit;
    private Image image = new ImageIcon("data/Main_Menu_2.jpg").getImage();
    ;
    private GameLevel gameLevel;
    //private SoundClip gameMusic;

    /**
     * A method which adds JButtons to the JPanel
     */
    public PauseMenu() {

        /* try {
        gameMusic = new SoundClip("data/Eminem_-_Untitled_Lyrics_[HD_HQ_.wav");   // Open an audio input stream
        gameMusic.loop();  // Set it to continous playback (looping)
        } catch (UnsupportedAudioFileException|IOException|LineUnavailableException e) {
        System.out.println(e);
        }      */
        mainscreen = new JFrame("Game is Paused");

        resumeButton = new JButton("Pause/Resume");
        restartButton = new JButton("Restart");
        controls = new JButton("Controls");
        quit = new JButton("Quit");

        resumeButton.setPreferredSize(new Dimension(100, 60));
        resumeButton.setBounds(440, 400, 150, 50);
        resumeButton.addActionListener(this);

        restartButton.setPreferredSize(new Dimension(100, 60));
        restartButton.setBounds(340, 400, 150, 50);
        restartButton.addActionListener(this);

        controls.setPreferredSize(new Dimension(100, 60));
        controls.setBounds(240, 400, 150, 50);
        controls.addActionListener(this);

        quit.setPreferredSize(new Dimension(100, 60));
        quit.setBounds(640, 400, 150, 50);
        quit.addActionListener(this);

        mainscreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        c = mainscreen.getContentPane();

        this.setLayout(null);

        this.add(restartButton);
        this.add(resumeButton);
        this.add(controls);
        this.add(quit);

        c.add(this);
        this.setPreferredSize(new Dimension(1000, 500));
        mainscreen.pack();
        mainscreen.setVisible(true);

    }

    /**
     *
     * @param g - assigns a String variable to be drawn to the JPanel
     */
    public void paintComponent(Graphics g) {
        g.drawImage(image, 0, 0, this);
        g.setFont(new Font(name, 10, 50));
        g.setColor(Color.white);
        g.drawString(name, 300, 80);
    }

    /**
     *
     * @param ae - The object on which the Event initially occurred.
     */
    @Override
    public void actionPerformed(ActionEvent ae) {
        Object a = ae.getSource();

        if (a == restartButton) {
            this.mainscreen.dispose();
            new Game();
        }
        if (a == quit) {
            this.mainscreen.dispose();
        }
        if (a == resumeButton) {

            this.mainscreen.dispose();

        }

    }
}
