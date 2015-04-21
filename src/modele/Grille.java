package modele;

import java.util.ArrayList;
import java.util.Random;



public class Grille {

  private int longueur;
  private int largeur;
  private int nbBombe;

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
    public int getLongueur() {
        return longueur;
    }

    public int getLargeur() {
        return largeur;
    }

    public int getNbBombe() {
        System.out.println("Nombre de bombes : " + nbBombe);
        return nbBombe;
    }

  

  private void initCases() {
      cases = new Case[longueur][largeur];
      for(int i = 0; i < longueur; i++) {
          for(int j = 0; j < largeur; j++) {
              cases[i][j] = new Case();
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
      ArrayList<Case> list = new ArrayList<>();
      int taille_voisin;
      Case voisin[];
      for(int x = 0; x < longueur; x++) {
          for(int y = 0; y < largeur; y++) {
              if(isInBounds(x, y-1))
                list.add(cases[x][y-1]);
              if(isInBounds(x, y+1))
                list.add(cases[x][y+1]);
              if(isInBounds(x+1, y))
                list.add(cases[x+1][y]);
              if(isInBounds(x-1, y))
                list.add(cases[x-1][y]);
              if(isInBounds(x-1, y-1))
                list.add(cases[x-1][y-1]);
              if(isInBounds(x+1, y+1))
                list.add(cases[x+1][y+1]);
              if(isInBounds(x+1, y-1))
                list.add(cases[x+1][y-1]);
              if(isInBounds(x-1, y+1))
                list.add(cases[x-1][y+1]);
              
              voisin = new Case[list.size()];
              for(int i = 0; i < list.size(); i++) {
                  voisin[i] = list.get(i);
              }
              cases[x][y].setVoisins(voisin);
              list.clear();
          }
      }
  }
  
  private boolean isInBounds(int x, int y) {
      if(x < 0 || x >= longueur)
          return false;
      return !(y < 0 || y >= largeur);
  }
  
  public boolean revelerCase(int x, int y) {
      Case c = cases[x][y];
      if(c.isCachee() || c.isQuestioned()) {
          if(c.getValeur() == 0)
              revelerEnCascade(c);
          c.setEtat(EtatCase.REVELEE);
          //S'il y'a une bombe sur la case
          if(c.getValeur() == -1)
              return true;
          
        }
        return false;
  }

  public void revelerEnCascade(Case c) {
      if(c.isRevelee() || c.getValeur() == -1 || c.isFalged())
          return;
      if(c.getValeur() != 0) {
          c.setEtat(EtatCase.REVELEE);
          return;
      }
      if(c.getValeur() == 0) {
          Case[] v = c.getVoisins();
          c.setEtat(EtatCase.REVELEE);
          for (int i = 0; i < v.length; i++) {
              revelerEnCascade(v[i]);
            }
        }
    }
  
    public void questionnerCase(int x, int y) {
        Case c = cases[x][y];
        if(c.isQuestioned()) {
            c.setCachee();
            return;
        }
        if(c.isFalged()) {
            c.setQuestionned();
            return;
        }
        if(c.isCachee()) {
            c.setFlaged();
        }
    }

   public int nbrCasesCacheesEtFlage()
   {
       int nbr = 0;
       for(Case[] c : cases)
       {
           for(Case ca : c)
            {
                if(ca.isCachee() || ca.isFalged())
                    nbr++;
            }
        }
       System.out.println("Nombre de cases cachées + flagé : " + nbr);
       return nbr;
   }
   
   public void toutReveler()
   {
       for(Case[] c : cases)
       {
           for(Case ca : c)
            {
                if(!ca.isRevelee())
                    ca.revelerCase();
                            
            }
        }
   }
    
    
}