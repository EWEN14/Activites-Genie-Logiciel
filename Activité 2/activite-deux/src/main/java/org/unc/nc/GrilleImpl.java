package org.unc.nc;

import com.google.common.primitives.Chars;
import org.unc.nc.exceptions.CaractereInterditException;
import org.unc.nc.exceptions.HorsBornesException;
import org.unc.nc.exceptions.ValeurImpossibleException;

import java.util.Arrays;

public class GrilleImpl implements Grille {
  char[][] grille;

  char[] caracteresPossibles;

  /**
   * Constructeur
   *
   * @param dimension dimension de la grille
   */
  public GrilleImpl(int dimension) {
    // on vérifie que la dimension spécifiée fait partie d'une dimension autorisée.
    if (dimension == 4 || dimension == 9 || dimension == 16 || dimension == 25) {
      this.grille = new char[dimension][dimension];
      this.caracteresPossibles = new char[dimension];

      // en remplit la grille de caractère '@'
      for (char[] grille : this.grille) {
        Arrays.fill(grille, Grille.EMPTY);
      }

      // on définit un tableau des valeurs autorisés en copiant les valeurs voulues de GRILLE dans la classe grille
      System.arraycopy(Grille.POSSIBLE, 0, caracteresPossibles, 0, dimension);

    } else { // sinon, on renvoie une erreur
     throw new IllegalArgumentException("Dimension de grille incorrecte. Valeur autorisée : 4, 9, 16 et 25.");
    }
  }

  public int getDimension() {
    return this.grille.length;
  }

  /**
   * Affecte une valeur dans la grille.
   *
   * @param x     position x dans la grille
   * @param y     position y dans la grille
   * @param value valeur à mettre dans la case
   * @throw HorsBornesException si x ou y sont hors bornes (0-8)
   * @throw ValeurImpossibleException si la valeur est interdite aux vues des autres valeurs de la grille
   * @throw CaractereInterditException si value n'est pas un caractere autorise ('1',...,'9')
   */
  public void setValue(int x, int y, char value) throws ValeurImpossibleException, HorsBornesException, CaractereInterditException {
    try {
      // on vérifie que les coordonnées x et y sont cohérentes et que la valeur est acceptable.
      possible(x, y, value);
      // si la ligne de la case que l'on veut set contient déjà cette valeur, on renvoie une erreur.
      if (Chars.contains(this.grille[x], value)) {
        throw new ValeurImpossibleException("Ce caractère est déjà présent dans la ligne de la case visée");
      }
      // si la colonne de la case que l'on veut set contient déjà cette valeur, on renvoie une erreur.
      for (char[] chars : this.grille) {
        if (chars[y] == value) {
          throw new ValeurImpossibleException("Ce caractère est déjà présent dans la colonne de la case visée");
        }
      }
      // si pas d'erreurs, on affecte la valeur à la case
      this.grille[x][y] = value;

    } catch (HorsBornesException hbe) { // catch des Exceptions dans la méthode possible(), qu'on re-throw après.
      throw new HorsBornesException(hbe.getMessage());
    } catch (CaractereInterditException cie) {
      throw new CaractereInterditException(cie.getMessage());
    }
  }

  /**
   * Récupère une valeur de la grille.
   *
   * @param x position x dans la grille
   * @param y position y dans la grille
   * @return valeur dans la case x,y
   * @throw HorsBornesException si x ou y sont hors bornes (0-8)
   */
  public char getValue(int x, int y) throws HorsBornesException {
    if (x > (getDimension() - 1) || y > (getDimension() - 1)) {
      throw new HorsBornesException("Au moins l'une des deux coordonnées dépasse la dimension de la grille.");
    }
    return this.grille[x][y];
  }

  /**
   * Test si une grille est terminée.
   *
   * @return true si la grille est complete
   */
  public boolean complete() {
    // on vérifie sur chacune des lignes qu'elle ne contient aucun caractère vide '@'
    for (char[] ligne: this.grille) {
      if (Chars.contains(ligne, Grille.EMPTY)) {
        return false;
      }
    }
    return true;
  }

  /**
   * Test si une valeur est possible dans la grille par rapport à ce qu'elle contient déjà.
   *
   * @param x     position x dans la grille
   * @param y     position y dans la grille
   * @param value valeur à mettre dans la case
   * @throw HorsBornesException si x ou y sont hors bornes (0-8)
   * @throw CaractereInterditException si value n'est pas un caractère autorise ('1', ..., '9', ...)
   */
  public boolean possible(int x, int y, char value) throws HorsBornesException, CaractereInterditException {
    // si x ou y supérieur aux dimension, on renvoie une erreur.
    if (x > (getDimension() -1) || y > (getDimension() - 1)) {
      throw new HorsBornesException("Au moins l'une des deux coordonnées dépasse la dimension de la grille.");
    }
    // si la valeur n'est pas présente dans les valeurs possibles, on renvoie une erreur
    if (!Chars.contains(this.caracteresPossibles, value)) {
      throw new CaractereInterditException("Ce caractère n'est pas autorisé dans cette grille.");
    }
    // si pas d'erreur on renvoie true
    return true;
  }
}
