/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package vue_controleur;



import java.util.Observable;
import java.util.Observer;
import javax.swing.JPanel;
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
        }
    }
    
    private void changerCase(Case c) {
        if(c.isRevelee()) {
            setValue(c.getValeur());
        } else if(c.isFalged()) {
            
        } else if(c.isQuestioned()) {
            
        }
            
    }
    
    private void setValue(int v) {
        
    }
}
