package modele;

import java.util.Observable;


enum EtatCase {DRAPEAU, CACHEE, REVELEE, INTEROGATION};
public class Case  extends Observable{

  private int valeur;

  private EtatCase etat;

  private Case[] voisins;

  
  public Case[] getVoisins() {
    return null;
  }

  public void setVoisins(Case[] voisins) {
      this.voisins = voisins;
  }

  public Case() {
      valeur = 0;
      etat = EtatCase.CACHEE;
  }

    public int getValeur() {
        return valeur;
    }

    public void setValeur(int valeur) {
        this.valeur = valeur;
    }

    public void setEtat(EtatCase etat) {
        this.etat = etat;
        setChanged();
        notifyObservers();
    }
    
    public boolean isCachee() {
        return etat == EtatCase.CACHEE;
    }
    
    public boolean isFalged() {
        return etat == EtatCase.DRAPEAU;
    }
    
    public boolean isQuestioned() {
        return etat == EtatCase.INTEROGATION;
    }
    
    public boolean isRevelee() {
        return etat == EtatCase.REVELEE;
    }
}