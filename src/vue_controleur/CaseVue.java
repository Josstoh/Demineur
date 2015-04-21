/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package vue_controleur;



import java.util.Observable;
import java.util.Observer;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;
import modele.Case;


/**
 *
 * @author p1203723
 */
public class CaseVue extends JPanel implements Observer{
    public final int coord_x;
    public final int coord_y;
    
    CaseVue(int x, int y){
        super();
        coord_x = x;
        coord_y = y;
    }

    @Override
    public void update(Observable o, Object o1) {
        if(o instanceof Case) {
            changerCase((Case) o);
            updateUI();
        }
    }
    
    private void changerCase(Case c) {
        removeAll();
        if(c.isRevelee()) {
            setValue(c.getValeur());
        } else if(c.isFalged()) {
            add(new JLabel("!"));
        } else if(c.isQuestioned()) {
            add(new JLabel("?"));
        }
            
    }
    
    private void setValue(int v) {
        if(v == 0) {
            setBorder(new EtchedBorder());
        }
        else {
            setBorder(new EtchedBorder());
            add(new JLabel(Integer.toString(v)));
        }
    }
}
