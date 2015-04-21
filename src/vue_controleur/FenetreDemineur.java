/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package vue_controleur;

import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;
import modele.*;

/**
 *
 * @author p1203723
 */
public class FenetreDemineur extends javax.swing.JFrame {
    
    private OptionsFrame optionsFrame;
    
    public JeuDeDemineur jeu;
    
    /**
     * Creates new form FenetreDemineur
     */
    public FenetreDemineur() {
        jeu = new JeuDeDemineur();
        optionsFrame = new OptionsFrame(this, jeu.options);

        initComponents();
        initCasesVue();
    }
    
    public void resetVue() {
        jPanel1.removeAll();
        initCasesVue();
        jPanel1.updateUI();
        pack();
    }
    
    private void quitter()
    {
        dispose();
    }
    
    private void initCasesVue() {
        int longueur = jeu.grille.getLongueur();
        int largeur = jeu.grille.getLargeur();
        jPanel1.setLayout(new GridLayout(longueur, largeur));
        
        int lo, la = -1;
        for(int i = 0; i < longueur*largeur; i++) {
            lo = i%longueur;
            if(lo == 0)
                la++;
            CaseVue j = new CaseVue(lo, la);
            j.setBorder(new SoftBevelBorder(BevelBorder.RAISED));
            //j.setBackground(Color.LIGHT_GRAY);
            j.addMouseListener(new MouseListener() {

                @Override
                public void mouseClicked(MouseEvent e) {
                    
                }

                @Override
                public void mousePressed(MouseEvent e) {
                    CaseVue c = (CaseVue)e.getComponent();
                    if(SwingUtilities.isLeftMouseButton(e)) {
                        boolean b = jeu.grille.revelerCase(c.coord_x, c.coord_y);
                        // le joueur a découvert une bombe
                        if(b)
                        {
                            int reponse = JOptionPane.showConfirmDialog(null, "Oh oh ! C'était une mine ! Vous avez perdu. Voulez-vous recommencez"
                                    + " une partie ?","Perdu !",JOptionPane.YES_NO_CANCEL_OPTION);
                            switch(reponse)
                            {
                                case JOptionPane.YES_OPTION:
                                    jeu.setJeu();
                                    resetVue();
                                    break;
                                case JOptionPane.NO_OPTION:
                                    quitter();
                                    break;
                            }
                        }
                        else
                        {
                            
                        }
                    }
                    if(SwingUtilities.isRightMouseButton(e)) {
                        jeu.grille.questionnerCase(c.coord_x, c.coord_y);
                    }
                    if(jeu.victoire())
                    {
                        int reponse = JOptionPane.showConfirmDialog(null, "Félicitations ! Vous avez bravé les mines ! Voulez-vous relancer une partie ?","C'est gagné !",JOptionPane.YES_NO_CANCEL_OPTION);
                            switch(reponse)
                            {
                                case JOptionPane.YES_OPTION:
                                    jeu.setJeu();
                                    resetVue();
                                    break;
                                case JOptionPane.NO_OPTION:
                                    quitter();
                                    break;
                            }
                    }
                   
                    
                }

                @Override
                public void mouseReleased(MouseEvent e) {
                }

                @Override
                public void mouseEntered(MouseEvent e) {
                   
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    
                }
            });
            jeu.grille.cases[lo][la].addObserver(j);
            jPanel1.add(j);
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenuNouvellePartie = new javax.swing.JMenu();
        jMenuOptions = new javax.swing.JMenu();
        jMenuQuitter = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 413, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 307, Short.MAX_VALUE)
        );

        jMenuNouvellePartie.setText("Nouvelle Partie");
        jMenuNouvellePartie.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenuNouvellePartieMouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenuNouvellePartie);

        jMenuOptions.setText("Options");
        jMenuOptions.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenuOptionsMouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenuOptions);

        jMenuQuitter.setText("Quitter");
        jMenuQuitter.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenuQuitterMouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenuQuitter);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuQuitterMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuQuitterMouseClicked
        dispose();
    }//GEN-LAST:event_jMenuQuitterMouseClicked

    private void jMenuOptionsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuOptionsMouseClicked
        optionsFrame.setVisible(true);
    }//GEN-LAST:event_jMenuOptionsMouseClicked

    private void jMenuNouvellePartieMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuNouvellePartieMouseClicked
        jeu.setJeu();
    }//GEN-LAST:event_jMenuNouvellePartieMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FenetreDemineur.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FenetreDemineur.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FenetreDemineur.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FenetreDemineur.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FenetreDemineur().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu jMenuNouvellePartie;
    private javax.swing.JMenu jMenuOptions;
    private javax.swing.JMenu jMenuQuitter;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
