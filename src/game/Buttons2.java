/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

/**
 *
 * @author Rojel
 */
public class Buttons2 extends javax.swing.JPanel {

    private MyView2 view2;
    private Game2 game2;
    private GameLevel2 gameLevel2;

    /**
     * Creates new form Buttons
     * @param view2 - Used to link the view2 in this class to the view when this method is called
     * @param gameLevel2 - A world with some bodies
     * @param game2 - The computer Game
     */
    public Buttons2(MyView2 view2, GameLevel2 gameLevel2, Game2 game2) {

        this.view2 = view2;
        this.gameLevel2 = gameLevel2;
        this.game2 = game2;

        initComponents();
    }

    /**
     *
     * @param gameLevel2
     */
    public void setWorld(GameLevel2 gameLevel2) {

        this.gameLevel2 = gameLevel2;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Pause = new javax.swing.JButton();
        Quit = new javax.swing.JButton();
        Restart = new javax.swing.JButton();
        Menu = new javax.swing.JButton();

        Pause.setText("Pause");
        Pause.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PauseActionPerformed(evt);
            }
        });

        Quit.setText("Quit");
        Quit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                QuitActionPerformed(evt);
            }
        });

        Restart.setText("Restart");
        Restart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RestartActionPerformed(evt);
            }
        });

        Menu.setText("Menu");
        Menu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Pause)
                .addGap(73, 73, 73)
                .addComponent(Restart)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 79, Short.MAX_VALUE)
                .addComponent(Menu)
                .addGap(67, 67, 67)
                .addComponent(Quit)
                .addGap(29, 29, 29))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Pause)
                    .addComponent(Quit)
                    .addComponent(Restart)
                    .addComponent(Menu))
                .addGap(20, 20, 20))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void PauseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PauseActionPerformed
        // TODO add your handling code here:
        if (gameLevel2.isRunning()) {
            gameLevel2.stop();

        } else {
            gameLevel2.start();

        }
        //new PauseMenu();
    }//GEN-LAST:event_PauseActionPerformed

    private void QuitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_QuitActionPerformed
        // TODO add your handling code here:
        System.out.println("Thanks For Playing");
        System.exit(0);
    }//GEN-LAST:event_QuitActionPerformed

    private void RestartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RestartActionPerformed
        game2.restart();
    }//GEN-LAST:event_RestartActionPerformed

    private void MenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuActionPerformed
        Object a = evt.getSource();

        if (a == Menu) {
            game2.CloseWindow();
            new MainMenu();

        }
    }//GEN-LAST:event_MenuActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Menu;
    private javax.swing.JButton Pause;
    private javax.swing.JButton Quit;
    private javax.swing.JButton Restart;
    // End of variables declaration//GEN-END:variables

}
