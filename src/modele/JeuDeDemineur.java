/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modele;

import java.util.Observable;
import java.util.Timer;

/**
 *
 * @author p1203723
 */
public class JeuDeDemineur extends Observable{
    public OptionDeJeu options;
    public Grille grille;
    private int temps;
    private Timer t;
    private int nbDrapeauDisponible;
    private boolean gameOver;
    //TODO ajouter le temps
    
    public JeuDeDemineur() {
        
        options = new OptionDeJeu();
        t = new Timer();
        DemineurTimerTask task = new DemineurTimerTask();
        task.jeu = this;
        t.schedule(task, 0, 1000);
        setJeu();
        
    }
    
    public boolean clicGauche(int x, int y) {
        if(gameOver)
            return false;
        gameOver = grille.revelerCase(x, y);
        return gameOver;
    }
    
    public void clicDroit(int x, int y) {
        if(gameOver)
            return;
        if(grille.cases[x][y].isCachee()) {
            if(nbDrapeauDisponible > 0) {
                setNbDrapeauDisponible(nbDrapeauDisponible-1);
                grille.questionnerCase(x, y);
            }
        }
        else if(grille.cases[x][y].isFalged()) {
            setNbDrapeauDisponible(nbDrapeauDisponible+1);
            grille.questionnerCase(x, y);
        } else grille.questionnerCase(x, y);
    }

    public int getTemps() {
        return temps;
    }

    public int getNbDrapeauDisponible() {
        return nbDrapeauDisponible;
    }

    public void setNbDrapeauDisponible(int nbDrapeauDisponible) {
        this.nbDrapeauDisponible = nbDrapeauDisponible;
        setChanged();
        notifyObservers();
    }

    public void setTemps(int temps) {
        this.temps = temps;
        setChanged();
        notifyObservers();
    }
    
    final public void setJeu() {
        initGrille();
        
        setNbDrapeauDisponible(grille.getNbBombe());
        setTemps(0);
        gameOver = false;
    }
    
    private void initGrille() {
        grille = new Grille(options.taille, options.taille, options.getNbBombes());
    }
    
    public boolean victoire()
    {
        boolean b = grille.nbrCasesCacheesEtFlage() == grille.getNbBombe();
        if(!gameOver && b)
            gameOver = true;
        return b;
    }
    //TODO : gérer victoire et score avec un compteur de case non révélée par exemple
    
    public void cancelThread() {
        t.cancel();
    }
    
    public void setGameOver() {
        gameOver = true;
    }
    public boolean isGameOver() {
        return gameOver;
    }
}
