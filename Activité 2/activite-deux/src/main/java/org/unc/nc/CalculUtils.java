package org.unc.nc;

/**
 * Classe effectuant divers types de calculs.
 */
public final class CalculUtils {
  /**
   * Constructeur vide
   */
  private CalculUtils() {}

  /**
   * Calcule la somme de deux entiers.
   *
   * @param entier1 entier
   * @param entier2 entier
   * @return somme des deux entiers
   */
  public static int somme(final int entier1, final int entier2) {
    return entier1 + entier2;
  }

  /**
   * Retourne a / b si b >= 10, sinon retourne juste b.
   *
   * @param entier1 entier
   * @param entier2 entier
   * @return entier
   */
  public static int maFonction(final int entier1, final int entier2) {
    final int dix = 10;
    if (entier2 >= dix) {
      return entier1 / entier2;
    }
    return entier2;
  }

  /**
   * Division de a par b.
   *
   * @param entier1 entier
   * @param entier2 entier
   * @return a / b si b != 0
   * @throw IllegalArgumentException si b == 0
   */
  public static int division(final int entier1, final int entier2) {
    if (entier2 == 0) {
      throw new IllegalArgumentException("b ne doit pas être 0");
    }
    return entier1 / entier2;
  }
}
