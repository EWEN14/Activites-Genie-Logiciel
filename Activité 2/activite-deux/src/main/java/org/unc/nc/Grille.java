package org.unc.nc;

import org.unc.nc.exceptions.CaractereInterditException;
import org.unc.nc.exceptions.HorsBornesException;
import org.unc.nc.exceptions.ValeurImpossibleException;

/**
 * Grille de sudoku.
 */
public interface Grille {
  /**
   * Caractère de case vide.
   */
  char EMPTY = '@';

  /**
   * Caractère possible à mettre dans la grille.
   * Pour une grille 4x4 : 1..4
   * Pour une grille 9x9 : 1..9
   * Pour une grille 16x16: 0..9-a..f
   * Pour une grille 25x25: 0..9-a..o
   */
  char[] POSSIBLE = {
      '1', '2', '3', '4', '5', '6', '7', '8', '9', '0',
      'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j',
      'k', 'l', 'm', 'n', 'o'
  };

  /**
   * Retourne l'entier symbolisant la dimension de la grille.
   *
   * @return largeur/hauteur de la grille
   */
  int getDimension();

  /**
   * Affecte une valeur dans la grille.
   *
   * @param x     position x dans la grille
   * @param y     position y dans la grille
   * @param value valeur à mettre dans la case
   * @throw HorsBornesException si x ou y sont hors bornes (0-8)
   * @throw ValeurImpossibleException si la valeur est interdite
   *      aux vues des autres valeurs de la grille
   * @throw CaractereInterditException si value n'est pas
   *      un caractere autorise ('1',...,'9')
   */
  void setValue(final int x, final int y, final char value) throws HorsBornesException,
          ValeurImpossibleException, CaractereInterditException;

  /**
   * Récupère une valeur de la grille.
   *
   * @param x position x dans la grille
   * @param y position y dans la grille
   * @return valeur dans la case x,y
   * @throw HorsBornesException si x ou y sont hors bornes (0-8)
   */
  char getValue(int x, int y) throws HorsBornesException;

  /**
   * Test si une grille est terminée.
   *
   * @return true si la grille est complete
   */
  boolean complete();

  /**
   * Test si une valeur est possible dans la grille
   *     par rapport à ce qu'elle contient déjà.
   *
   * @param x     position x dans la grille
   * @param y     position y dans la grille
   * @param value valeur à mettre dans la case
   * @throw HorsBornesException si x ou y sont hors bornes (0-8)
   * @throw CaractereInterditException si value n'est pas un caractère autorise ('1', ..., '9', ...)
   */
  void possible(int x, int y, char value) throws HorsBornesException, CaractereInterditException;
}
