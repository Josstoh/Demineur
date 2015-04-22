/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modele;

import java.util.TimerTask;

/**
 *
 * @author p1203723
 */
public class DemineurTimerTask extends TimerTask{

    public JeuDeDemineur jeu;

    @Override
    public void run() {
        if(!jeu.isGameOver())
            jeu.setTemps(jeu.getTemps()+1);
    }
    
}
