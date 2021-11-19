package org.unc.nc;

public class Grille {
  /**
   * Caractère de case vide
   */
  final char EMPTY = '@';

  /**
   * Caractère possible à mettre dans la grille.
   * Pour une grille 4x4 : 1..4
   * Pour une grille 9x9 : 1..9
   * Pour une grille 16x16: 0..9-a..f
   * Pour une grille 25x25: 0..9-a..o
   */
  final char[] possible = new char[]{
          '1', '2', '3', '4', '5', '6', '7', '8', '9', '0',
          'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j',
          'k', 'l', 'm', 'n', 'o'
  };

  /**
   * @return largeur/hauteur de la grille
   */
  int getDimension() {
    return 0;
  }

  /**
   * Affecte une valeur dans la grille
   *
   * @param x     position x dans la grille
   * @param y     position y dans la grille
   * @param value valeur a mettre dans la case
   * @throw HorsBornesException si x ou y sont hors bornes (0-8)
   * @throw ValeurImpossibleException si la valeur est interdite aux vues des autres valeurs de la grille
   * @throw CaractereInterditException si value n'est pas un caractere autorise ('1',...,'9')
   */
  void setValue(final int x, final int y, final char value) throws HorsBornesException, ValeurImpossibleException,
          CaractereInterditException {

  }

  /**
   * Récupère une valeur de la grille
   *
   * @param x position x dans la grille
   * @param y position y dans la grille
   * @return valeur dans la case x,y
   * @throw HorsBornesException si x ou y sont hors bornes (0-8)
   */
  char getValue(int x, int y) throws HorsBornesException {
    return '0';
  }

  /**
   * Test si une grille est terminée
   *
   * @return true si la grille est complete
   */
  boolean complete() {
    return true;
  }

  /**
   * Test si une valeur est possible dans la grille par rapport a ce qu'elle
   * contient deja
   *
   * @param x     position x dans la grille
   * @param y     position y dans la grille
   * @param value valeur à mettre dans la case
   * @throw HorsBornesException si x ou y sont hors bornes (0-8)
   * @throw CaractereInterditException si value n'est pas un caractère autorise ('1', ..., '9', ...)
   */
  boolean possible(int x, int y, char value) throws HorsBornesException, CaractereInterditException {
    return true;
  }
}
