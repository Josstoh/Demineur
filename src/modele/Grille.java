package modele;

import java.util.Observable;



public class Grille extends Observable {

  protected int longueur;
  protected int largeur;
  protected int nbBombe;

    /**
   * 
   * @element-type Case
   */
  public Case cases[][];

  public Grille(int longueur, int largeur, int nbBombes) {
      this.longueur = longueur;
      this.largeur = largeur;
      this.nbBombe = nbBombes;
      
      initCases();
      placerBombes();
      setVoisins();
      initValeur();
      
  }

  private void initCases() {
      cases = new Case[longueur][largeur];
  }

  public void placerBombes() {
  }

  public void initValeur() {
      
  }

  public boolean revelerCase(int x, int y) {
  return false;
  }

  public void revelerEnCascade(int x, int y) {
  }

  public void setVoisins() {
      
  }

}