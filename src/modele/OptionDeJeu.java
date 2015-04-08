/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modele;

/**
 *
 * @author p1203723
 */
public class OptionDeJeu {
    public final static int DIFF_FACILE = 5;
    public final static int DIFF_MOYEN = 10;
    public final static int DIFF_DIFFICILE = 15;
    
    public final static int TAILLE_10X10 = 10;
    public final static int TAILLE_20X20 = 20;
    public final static int TAILLE_30X30 = 30;
    
    
    public int taille;      //0: 10x10  1: 20x20 2: 30x30
    public int difficulte;  //0: facile 1: moyen 2: difficile
    
    public OptionDeJeu() {
        taille = TAILLE_20X20;
        difficulte = DIFF_MOYEN;
    }
    
    
    public int getNbBombes() {
        return taille*taille*difficulte/100;
    }
}
