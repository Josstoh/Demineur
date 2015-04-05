package modele;


enum EtatCase {DRAPEAU, CACHEE, REVELEE, INTEROGATION};
public class Case {

  private int valeur;

  private EtatCase etat;

  private Case[] voisins;

  
  public Case[] getVoisins() {
    return null;
  }

  public void setVoisins(Case[] voisins) {
      this.voisins = voisins;
  }

  public void Case() {
      
  }

    public int getValeur() {
        return valeur;
    }

    public EtatCase getEtat() {
        return etat;
    }

    public void setValeur(int valeur) {
        this.valeur = valeur;
    }

    public void setEtat(EtatCase etat) {
        this.etat = etat;
    }

}