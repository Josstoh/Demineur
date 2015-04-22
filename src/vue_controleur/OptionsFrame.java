/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package vue_controleur;

import javax.swing.JFrame;
import modele.OptionDeJeu;

/**
 *
 * @author p1203723
 */
public class OptionsFrame extends javax.swing.JDialog {
    
    public OptionDeJeu options;
    /**
     * Creates new form OptionsFrame
     */
    public OptionsFrame(JFrame parent,OptionDeJeu o) {
        super(parent,true);
        
        options = o;
        initComponents();
        setValeurTaille(o.taille);
        setValeurDifficulte(o.difficulte);
        setLocationRelativeTo(parent);
        
    }
    
    private void setValeurTaille(int val) {
        switch(val) {
            case OptionDeJeu.TAILLE_10X10: 
                jRadioButton10x10.doClick();
            break;
            case OptionDeJeu.TAILLE_15X15: 
                jRadioButton20x20.doClick();
            break;
            case OptionDeJeu.TAILLE_20X20: 
                jRadioButton30x30.doClick();
            break;
        }
    }
    
    private void setValeurDifficulte(int val) {
        switch(val) {
            case OptionDeJeu.DIFF_FACILE: 
                jRadioButtonFacile.doClick();
            break;
            case OptionDeJeu.DIFF_MOYEN: 
                jRadioButtonMoyen.doClick();
            break;
            case OptionDeJeu.DIFF_DIFFICILE: 
                jRadioButtonDifficile.doClick();
            break;
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

        buttonGroupTaille = new javax.swing.ButtonGroup();
        buttonGroupDifficulte = new javax.swing.ButtonGroup();
        jPanel2 = new javax.swing.JPanel();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 5));
        jPanel3 = new javax.swing.JPanel();
        jRadioButton10x10 = new javax.swing.JRadioButton();
        jRadioButton20x20 = new javax.swing.JRadioButton();
        jRadioButton30x30 = new javax.swing.JRadioButton();
        jPanel4 = new javax.swing.JPanel();
        jRadioButtonFacile = new javax.swing.JRadioButton();
        jRadioButtonMoyen = new javax.swing.JRadioButton();
        jRadioButtonDifficile = new javax.swing.JRadioButton();
        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        setType(java.awt.Window.Type.UTILITY);
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.PAGE_AXIS));

        jPanel2.setLayout(new javax.swing.BoxLayout(jPanel2, javax.swing.BoxLayout.PAGE_AXIS));
        jPanel2.add(filler1);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Taille de la grille"));
        jPanel3.setLayout(new javax.swing.BoxLayout(jPanel3, javax.swing.BoxLayout.LINE_AXIS));

        buttonGroupTaille.add(jRadioButton10x10);
        jRadioButton10x10.setText("10x10");
        jPanel3.add(jRadioButton10x10);

        buttonGroupTaille.add(jRadioButton20x20);
        jRadioButton20x20.setText("15x15");
        jPanel3.add(jRadioButton20x20);

        buttonGroupTaille.add(jRadioButton30x30);
        jRadioButton30x30.setText("20x20");
        jPanel3.add(jRadioButton30x30);

        jPanel2.add(jPanel3);

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Difficulté"));
        jPanel4.setLayout(new javax.swing.BoxLayout(jPanel4, javax.swing.BoxLayout.LINE_AXIS));

        buttonGroupDifficulte.add(jRadioButtonFacile);
        jRadioButtonFacile.setText("Facile");
        jPanel4.add(jRadioButtonFacile);

        buttonGroupDifficulte.add(jRadioButtonMoyen);
        jRadioButtonMoyen.setText("Moyen");
        jPanel4.add(jRadioButtonMoyen);

        buttonGroupDifficulte.add(jRadioButtonDifficile);
        jRadioButtonDifficile.setText("Difficile");
        jPanel4.add(jRadioButtonDifficile);

        jPanel2.add(jPanel4);

        jPanel1.setLayout(new javax.swing.BoxLayout(jPanel1, javax.swing.BoxLayout.LINE_AXIS));

        jButton1.setText("Ok");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);

        jPanel2.add(jPanel1);

        getContentPane().add(jPanel2);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if(jRadioButton10x10.isSelected()) {
            options.taille = OptionDeJeu.TAILLE_10X10;
        } else if(jRadioButton20x20.isSelected()) {
            options.taille = OptionDeJeu.TAILLE_15X15;
        } else if(jRadioButton30x30.isSelected()) {
            options.taille = OptionDeJeu.TAILLE_20X20;
        }
        
        if(jRadioButtonFacile.isSelected()) {
            options.difficulte = OptionDeJeu.DIFF_FACILE;
        } else if(jRadioButtonMoyen.isSelected()) {
            options.difficulte = OptionDeJeu.DIFF_MOYEN;
        } else if(jRadioButtonDifficile.isSelected()) {
            options.difficulte = OptionDeJeu.DIFF_DIFFICILE;
        }
        
        ((FenetreDemineur) getParent()).jeu.setJeu();
        ((FenetreDemineur) getParent()).resetVue();
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroupDifficulte;
    private javax.swing.ButtonGroup buttonGroupTaille;
    private javax.swing.Box.Filler filler1;
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JRadioButton jRadioButton10x10;
    private javax.swing.JRadioButton jRadioButton20x20;
    private javax.swing.JRadioButton jRadioButton30x30;
    private javax.swing.JRadioButton jRadioButtonDifficile;
    private javax.swing.JRadioButton jRadioButtonFacile;
    private javax.swing.JRadioButton jRadioButtonMoyen;
    // End of variables declaration//GEN-END:variables
}
