package modele;

import java.awt.List;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Random;



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
      for(int i = 0; i < longueur; i++) {
          for(int j = 0; j < largeur; j++) {
              cases[i][j] = new Case();
              cases[i][j].setEtat(EtatCase.CACHEE);
              cases[i][j].setValeur(0);
          }
      }
  }

  public void placerBombes() {
      Random generateur = new Random();
      int c;
      ArrayList<Case> caseLibre = new ArrayList<>();
      for(int i = 0; i < longueur; i++) {
          for(int j = 0; j < largeur; j++) {
              caseLibre.add(cases[i][j]);
          }
      }
      
      for(int nbBombeRestante = nbBombe; nbBombeRestante > 0; nbBombeRestante--) {
          c = generateur.nextInt(caseLibre.size());
          caseLibre.get(c).setValeur(-1);
          caseLibre.remove(c);
          nbBombeRestante--;
          if(caseLibre.isEmpty())
              break;
      }
  }

  public void initValeur() {
      for(int i = 0; i < longueur; i++){
          for(int j = 0; j < largeur; j++) {
              if(cases[i][j].getValeur() != -1) {
                  //i-1 j-1
                  if(isInBounds(i-1, j-1) && cases[i-1][j-1].getValeur() == -1)
                      cases[i][j].setValeur(cases[i][j].getValeur()+1);
                  //i j-1 
                  if(isInBounds(i, j-1) && cases[i][j-1].getValeur() == -1)
                      cases[i][j].setValeur(cases[i][j].getValeur()+1);
                  //i+1 j-1
                  if(isInBounds(i+1, j-1) && cases[i+1][j-1].getValeur() == -1)
                      cases[i][j].setValeur(cases[i][j].getValeur()+1);
                  //i-1 j
                  if(isInBounds(i-1, j) && cases[i-1][j].getValeur() == -1)
                      cases[i][j].setValeur(cases[i][j].getValeur()+1);
                  //i+1 j
                  if(isInBounds(i+1, j) && cases[i+1][j].getValeur() == -1)
                      cases[i][j].setValeur(cases[i][j].getValeur()+1);
                  //i-1 j+1
                  if(isInBounds(i-1, j+1) && cases[i-1][j+1].getValeur() == -1)
                      cases[i][j].setValeur(cases[i][j].getValeur()+1);
                  //i j+1
                  if(isInBounds(i, j+1) && cases[i][j+1].getValeur() == -1)
                      cases[i][j].setValeur(cases[i][j].getValeur()+1);
                  //i+1 j+1
                  if(isInBounds(i+1, j+1) && cases[i+1][j+1].getValeur() == -1)
                      cases[i][j].setValeur(cases[i][j].getValeur()+1);
              }
          }
      }
  }


  public void setVoisins() {
      //pour toutes les cases sauf les bords
      Case[] voisins;
      for(int i = 1; i < (longueur - 1); i++) {
          for(int j = 1; j < (largeur - 1); j++) {
              voisins = new Case[4];
              voisins[0] = cases[i-1][j-1];
              voisins[1] = cases[i-1][j+1];
              voisins[2] = cases[i+1][j-1];
              voisins[3] = cases[i+1][j+1];
              cases[i][j].setVoisins(voisins);
          }
      }
      
      //les coins
      voisins = new Case[2];
      voisins[0] = cases[1][0];
      voisins[1] = cases[0][1];
      cases[0][0].setVoisins(voisins);
      
      voisins = new Case[2];
      voisins[0] = cases[longueur-2][0];
      voisins[1] = cases[longueur-1][1];
      cases[longueur-1][0].setVoisins(voisins);
      
      voisins = new Case[2];
      voisins[0] = cases[1][largeur-1];
      voisins[1] = cases[0][largeur-2];
      cases[0][largeur-1].setVoisins(voisins);
      
      voisins = new Case[2];
      voisins[0] = cases[longueur-2][largeur-1];
      voisins[1] = cases[longueur-1][largeur-2];
      cases[longueur-1][largeur-1].setVoisins(voisins);
      
      //les bords
      for(int i = 1; i < longueur - 1; i++) {
          voisins = new Case[3];
          voisins[0] = cases[i-1][0];
          voisins[1] = cases[i][1];
          voisins[2] = cases[i+1][0];
          cases[i][0].setVoisins(voisins);
          
          voisins = new Case[3];
          voisins[0] = cases[i-1][largeur-1];
          voisins[1] = cases[i][largeur-2];
          voisins[2] = cases[i+1][largeur-1];
          cases[i][largeur-1].setVoisins(voisins);
      }
      
      for(int i = 1; i < largeur - 1; i++) {
          voisins = new Case[3];
          voisins[0] = cases[0][i-1];
          voisins[1] = cases[1][i];
          voisins[2] = cases[0][i+1];
          cases[i][0].setVoisins(voisins);
          
          voisins = new Case[3];
          voisins[0] = cases[longueur-1][i-1];
          voisins[1] = cases[longueur-2][i];
          voisins[2] = cases[longueur-1][i+1];
          cases[i][0].setVoisins(voisins);
      }
      
  }
  
  private boolean isInBounds(int x, int y) {
      if(x < 0 || x >= longueur)
          return false;
      return !(y < 0 || y >= largeur);
  }
  
  public boolean revelerCase(int x, int y) {
      Case c = cases[x][y];
      if(c.getEtat() == EtatCase.CACHEE) {
          c.setEtat(EtatCase.REVELEE);
          //S'il y'a une bombe sur la case
          if(c.getValeur() == -1)
              return true;
          if(c.getValeur() == 0)
              revelerEnCascade(c);
        }
    return false;
  }

  public void revelerEnCascade(Case c) {
      if(c.getEtat() == EtatCase.REVELEE)
          return;
      if(c.getValeur() != 0) {
          c.setEtat(EtatCase.REVELEE);
          return;
      }
      if(c.getValeur() == 0) {
          Case[] v = c.getVoisins();
          for (Case v1 : v) {
              revelerEnCascade(v1);
          }
      }
  }
}