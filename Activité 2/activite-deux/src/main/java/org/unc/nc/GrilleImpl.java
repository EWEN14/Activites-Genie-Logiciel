package org.unc.nc;

import com.google.common.primitives.Chars;
import java.util.Arrays;
import org.unc.nc.exceptions.CaractereInterditException;
import org.unc.nc.exceptions.HorsBornesException;
import org.unc.nc.exceptions.ValeurImpossibleException;

/**
 * Classe implémentant l'interface Grille.
 */
public class GrilleImpl implements Grille, Resolveur {
  char[][] grille;

  char[] caracteresPossibles;

  /**
   * Constructeur.
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

      // on définit un tableau des valeurs autorisés en copiant les valeurs
      // voulues de GRILLE dans la classe grille
      System.arraycopy(Grille.POSSIBLE, 0, caracteresPossibles, 0, dimension);

    } else { // sinon, on renvoie une erreur
      throw new IllegalArgumentException(
              "Dimension de grille incorrecte. Valeur autorisée : 4, 9, 16 et 25.");
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
   * @throw ValeurImpossibleException si la valeur est interdite
   *      aux vues des autres valeurs de la grille
   * @throw CaractereInterditException si value n'est pas un caractere autorise ('1',...,'9')
   */
  public void setValue(int x, int y, char value) throws ValeurImpossibleException,
          HorsBornesException, CaractereInterditException {
    try {
      // on vérifie que les coordonnées x et y sont cohérentes et que la valeur est acceptable.
      possible(x, y, value);
      // si la ligne de la case que l'on veut set contient déjà cette valeur, on renvoie une erreur.
      if (!this.checkLigne(x, y, value)) {
        throw new ValeurImpossibleException(
                "Le caractère " + value + " est déjà présent dans la ligne de la case visée");
      }

      // si la colonne de la case que l'on veut set contient déjà cette valeur,
      // on renvoie une erreur.
      if (!this.checkColumn(x, y, value)) {
        throw new ValeurImpossibleException(
                "Le caractère " + value + " est déjà présent dans la colonne de la case visée");
      }

      if (!this.verifRegion(x, y, value)) {
        throw new ValeurImpossibleException("Le caractère " + value
                + " est déjà présent dans le bloc où vous tentez l'insertion.");
      }
      // si pas d'erreurs, on affecte la valeur à la case
      this.grille[x][y] = value;

    } catch (HorsBornesException hbe) {
      // catch des Exceptions dans la méthode possible(), qu'on re-throw après.
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
      throw new HorsBornesException(
              "Au moins l'une des deux coordonnées dépasse la dimension de la grille.");
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
    for (char[] ligne : this.grille) {
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
  public void possible(int x, int y, char value)
          throws HorsBornesException, CaractereInterditException {
    // si x ou y supérieur aux dimension, on renvoie une erreur.
    if (x > (getDimension() - 1) || y > (getDimension() - 1)) {
      throw new HorsBornesException(
              "Au moins l'une des deux coordonnées dépasse la dimension de la grille.");
    }
    // si la valeur n'est pas présente dans les valeurs possibles,
    // ou que ce n'est pas un caractère vide, on renvoie une erreur.
    if (!Chars.contains(this.caracteresPossibles, value) && value != Grille.EMPTY) {
      throw new CaractereInterditException(
              "Le caractère " + value + " n'est pas autorisé dans cette grille.");
    }
  }

  /**
   * Méthode qui va définir la ligne ou la colonne de départ d'un bloc.
   *
   * @param ligneCol l'entier désignant une coordonnée x ou y
   * @return l'entier représentant la ligne ou colonne initiale.
   */
  public int remisePointZeroRegion(final int ligneCol) {
    final int tailleRegion = (int) Math.sqrt((double) this.getDimension());
    int pointZero = 0;
    // On redéfinit la ligne où la colonne où le bloc commence.
    // On définit chaque cas selon la taille de la grille (4,9,16 et 25)
    if (ligneCol >= tailleRegion && ligneCol < 2 * tailleRegion) {
      pointZero = tailleRegion;
    } else if (ligneCol >= 2 * tailleRegion && ligneCol < 3 * tailleRegion) {
      pointZero = 2 * tailleRegion;
    } else if (ligneCol >= 3 * tailleRegion && ligneCol < 4 * tailleRegion) {
      pointZero = 3 * tailleRegion;
    } else if (ligneCol >= 4 * tailleRegion) {
      pointZero = 4 * tailleRegion;
    }
    return pointZero;
  }

  /**
   * Méthode analysant le bloc dans lequel se trouve la valeur.
   *
   * @param x     coordonnée x
   * @param y     coordonnée y
   * @param value caractère
   * @return booléen
   */
  public boolean verifRegion(final int x, final int y, final char value) {
    boolean valide = true;
    final int tailleRegion = (int) Math.sqrt((double) this.getDimension());
    final int pointZeroLigne = remisePointZeroRegion(x);
    final int pointZeroColonne = remisePointZeroRegion(y);
    // On boucle dans le bloc où se trouve les coordonnées indiquées et on voit si la valeur
    // qu'on veut mettre si trouve déjà.
    for (int i = pointZeroLigne; i < tailleRegion + pointZeroLigne; i++) {
      for (int j = pointZeroColonne; j < tailleRegion + pointZeroColonne; j++) {
        if (this.grille[i][j] == value && value != Grille.EMPTY) {
          valide = false;
          break;
        }
      }
    }
    return valide;
  }

  /**
   * Méthode de résolution de la grille de Sudoku par backtraking.
   *
   * @return boolean indiquant que la grille est résolue
   * @throws HorsBornesException        erreur de bornes
   * @throws ValeurImpossibleException  erreur de valeur
   * @throws CaractereInterditException erreur de caractère
   */
  public boolean solve() throws
          HorsBornesException, ValeurImpossibleException, CaractereInterditException {
    for (int row = 0; row < this.getDimension(); row++) {
      for (int column = 0; column < this.getDimension(); column++) {
        if (this.grille[row][column] == Grille.EMPTY) {
          for (char caracteresPossible : this.caracteresPossibles) {
            if (checkAll(row, column, caracteresPossible)) {
              this.setValue(row, column, caracteresPossible);
              if (solve()) {
                return true;
              } else {
                this.setValue(row, column, Grille.EMPTY);
              }
            }
          }
          return false;
        }
      }
    }
    return true; // sudoku résolu
  }

  /**
   * Méthode vérifiant toutes les conditions.
   *
   * @param x     coordonnée x
   * @param y     coordonnée y
   * @param value caractère
   * @return booléen
   * @throws CaractereInterditException erreur de caractère
   * @throws HorsBornesException        erreur de bornes
   */
  public boolean checkAll(int x, int y, char value) throws
          CaractereInterditException, HorsBornesException {
    return this.possibleBoolean(x, y, value)
            && this.checkLigne(x, y, value)
            && this.checkColumn(x, y, value)
            && this.verifRegion(x, y, value);
  }

  /**
   * Vérifie que l'on peut insérer le caractère dans la ligne voulue.
   *
   * @param x     coordonnée x
   * @param y     coordonnée y
   * @param value caractère
   * @return booléen
   */
  public boolean checkLigne(int x, int y, char value) {
    // si la ligne de la case que l'on veut set contient déjà cette valeur, on renvoie une false.
    // sauf si le cas d'un caractère vide (ex : on "veut remettre à vide" une case)
    return !Chars.contains(this.grille[x], value) || value == Grille.EMPTY;
  }

  /**
   * Vérifie que l'on peut insérer le caractère dans la colonne voulue.
   *
   * @param x     coordonnée x
   * @param y     coordonnée y
   * @param value caractère
   * @return booléen
   */
  public boolean checkColumn(int x, int y, char value) {
    // si la colonne de la case que l'on veut set contient déjà cette valeur,
    // on renvoie false, mais pas si c'est un caractère vide.
    for (char[] chars : this.grille) {
      if (chars[y] == value && value != Grille.EMPTY) {
        return false;
      }
    }
    return true;
  }

  /**
   * Fonction possible, qui renvoie uniquement des booléens, pas d'exceptions.
   *
   * @param x coordonnée x
   * @param y coordonnée y
   * @param value caractère
   * @return booléen
   */
  public boolean possibleBoolean(int x, int y, char value) {
    // si x ou y supérieur aux dimension, on renvoie false.
    if (x > (getDimension() - 1) || y > (getDimension() - 1)) {
      return false;
    }
    // si la valeur n'est pas présente dans les valeurs possibles,
    // ou que ce n'est pas un caractère vide, on renvoie false.
    if (!Chars.contains(this.caracteresPossibles, value) && value != Grille.EMPTY) {
      return false;
    }
    // si pas d'erreur on renvoie true
    return true;
  }
}
