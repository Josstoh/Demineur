/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package vue_controleur;



import java.awt.Color;
import java.awt.Font;
import java.util.Observable;
import java.util.Observer;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
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
            add(new JLabel(new ImageIcon( "images/drapeau.png")));
        } else if(c.isQuestioned()) {
            add(new JLabel(new ImageIcon( "images/interrogation.png")));
        }
            
    }
    
    private void setValue(int v) {
        
        setBorder(new EtchedBorder());
        JLabel l;
        switch(v)
        {
            case 0:
                
                break;
            case -1:
                setBorder(new EtchedBorder());
                add(new JLabel(new ImageIcon( "images/mine.png")));
                break;
            case 1:
                l = new JLabel(Integer.toString(v),SwingConstants.CENTER);
                l.setFont(new Font("SansSerif",Font.BOLD,30));
                l.setForeground(Color.BLUE);
                add(l);
                break;
            case 2:
                l = new JLabel(Integer.toString(v),SwingConstants.CENTER);
                l.setFont(new Font("SansSerif",Font.BOLD,30));
                l.setForeground(Color.GREEN);
                add(l);
                break;
            case 3:
                l = new JLabel(Integer.toString(v),SwingConstants.CENTER);
                l.setFont(new Font("SansSerif",Font.BOLD,30));
                l.setForeground(Color.yellow);
                add(l);
                break;
            case 4:
                l = new JLabel(Integer.toString(v),SwingConstants.CENTER);
                l.setFont(new Font("SansSerif",Font.BOLD,30));
                l.setForeground(Color.orange);
                add(l);
                break;
            case 5:
                l = new JLabel(Integer.toString(v),SwingConstants.CENTER);
                l.setFont(new Font("SansSerif",Font.BOLD,30));
                l.setForeground(Color.red);
                add(l);
                break;
            case 6:
                l = new JLabel(Integer.toString(v),SwingConstants.CENTER);
                l.setFont(new Font("SansSerif",Font.BOLD,30));
                l.setForeground(Color.cyan);
                add(l);
                break;
            case 7:
                l = new JLabel(Integer.toString(v),SwingConstants.CENTER);
                l.setFont(new Font("SansSerif",Font.BOLD,30));
                l.setForeground(Color.magenta);
                add(l);
                break;
            case 8:
                l = new JLabel(Integer.toString(v),SwingConstants.CENTER);
                l.setFont(new Font("SansSerif",Font.BOLD,30));
                l.setForeground(Color.BLACK);
                add(l);
                break;
            default:
                l = new JLabel(Integer.toString(v),SwingConstants.CENTER);
                l.setFont(new Font("SansSerif",Font.BOLD,30));
                l.setForeground(Color.BLACK);
                add(l);
                
                
                            
        }
    }
}
