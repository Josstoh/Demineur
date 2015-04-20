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
public class JeuDeDemineur {
    public OptionDeJeu options;
    public Grille grille;
    //public int score;
    //TODO ajouter le temps
    
    public JeuDeDemineur() {
        options = new OptionDeJeu();
        setJeu();
    }
    
    final public void setJeu() {
        // on met le score et le temps a 0
        initGrille();
    }
    private void initGrille() {
        grille = new Grille(options.taille, options.taille, options.getNbBombes());
    }
    
    //TODO : gérer victoire et score avec un compteur de case non révélée par exemple
}
