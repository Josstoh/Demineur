/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package vue_controleur;

import java.util.Observable;
import java.util.Observer;
import javax.swing.JPanel;
import modele.JeuDeDemineur;

/**
 *
 * @author p1203723
 */
public class InfoPanel extends JPanel implements Observer {

    private javax.swing.Box.Filler filler1;
    private javax.swing.Box.Filler filler2;
    private javax.swing.JFormattedTextField nbBombe;
    private javax.swing.JFormattedTextField nbSeconde;

    public InfoPanel() {
        super();
        setBorder(new javax.swing.border.SoftBevelBorder(5));
        setLayout(new javax.swing.BoxLayout(this, javax.swing.BoxLayout.LINE_AXIS));
        filler2 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 35), new java.awt.Dimension(0, 35), new java.awt.Dimension(0, 35));
        nbBombe = new javax.swing.JFormattedTextField();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(100, 0), new java.awt.Dimension(100, 0), new java.awt.Dimension(100, 0));
        nbSeconde = new javax.swing.JFormattedTextField();
        
        nbBombe.setEditable(false);
        nbBombe.setFocusable(false);
        nbBombe.setMaximumSize(new java.awt.Dimension(100, 30));
        nbBombe.setMinimumSize(new java.awt.Dimension(100, 30));
        nbBombe.setPreferredSize(new java.awt.Dimension(100, 30));
        add(nbBombe);
        add(filler1);

        nbSeconde.setEditable(false);
        nbSeconde.setFocusable(false);
        nbSeconde.setMaximumSize(new java.awt.Dimension(100, 30));
        nbSeconde.setMinimumSize(new java.awt.Dimension(100, 30));
        nbSeconde.setPreferredSize(new java.awt.Dimension(100, 30));
        add(nbSeconde);
    }
    
    
    @Override
    public void update(Observable o, Object arg) {
        if(o instanceof JeuDeDemineur) {
            JeuDeDemineur jeu = (JeuDeDemineur)o;
            nbSeconde.setText(Integer.toString(jeu.getTemps()));
            nbBombe.setText(Integer.toString(jeu.getNbDrapeauDisponible()));
        }
    }
    
}
