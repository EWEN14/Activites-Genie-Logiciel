package unc.nc.genielogiciel.model;

import java.util.Arrays;

/**
 * Classe effectuant diverses opérations arithmétiques.
 */
public final class TabAlgosUtils {
  /**
   * Renvoie le plus grand entier d'un tableau.
   *
   * @return valeur la plus grande d'un tableau.
   */
  public static int plusGrand(final int... tab) {
    int maximum = Integer.MIN_VALUE;
    for (final int element : tab) {
      if (element > maximum) {
        maximum = element;
      }
    }
    return maximum;
  }

  /**
   * Calcul de la moyenne des entiers d'un tableau.
   *
   * @return moyenne des valeurs du tableau.
   * @throw IllegalArgumentException si tab et null ou vide.
   **/
  public static double moyenne(final int... tab) throws IllegalArgumentException {
    if (tab == null || tab.length == 0) {
      throw new IllegalArgumentException("Le tableau fourni ne doit pas être null ou vide.");
    }
    int somme = 0;
    for (final int element : tab) {
      somme += element;
    }
    return somme / (double) tab.length;
  }

  /**
   * Compare le contenu de 2 tableaux en tenant compte de l'ordre.
   *
   * @return true si les 2 tableaux contiennent les mêmes éléments
   *     avec les mêmes nombres d'occurences
   *     (avec les elements dans le meme ordre).
   **/
  public static boolean egaux(final int[] tab1, final int... tab2) {
    for (int i = 0; i < tab1.length; i++) {
      if (tab1[i] != tab2[i]) {
        return false;
      }
    }
    return true;
  }

  /**
   * Compare le contenu de 2 tableaux sans tenir compte de l'ordre.
   *
   * @return true si les 2 tableaux contiennent les mêmes éléments
   *     avec les mêmes nombres d'occurrence
   *     (pas forcément dans le meme ordre).
   **/
  public static boolean similaires(final int[] tab1, final int... tab2) {
    // Tableau qui contiendra les index des éléments du tab2 déjà trouvés.
    int [] tab2FindedIndex = new int[tab1.length];
    // On remplit ce tableau de -1, afin de ne pas être gêné pour l'index 0.
    Arrays.fill(tab2FindedIndex, -1);

    for (int i = 0; i < tab1.length; i++) {
      final int element = tab1[i];
      for (int j = 0; j < tab2.length; j++) {
        final int finalJ = j;
        // Si l'index du tableau 2 est présent dans notre tableau d'index trouvés,
        // On fait un continue car on ne veut pas recomparer un élément déjà trouvé.
        if (Arrays.stream(tab2FindedIndex).anyMatch(k -> k == finalJ)) {
          continue;
        }
        // Si élément du tab1 égal du tab2, on ajoute l'index du tab2 dans
        // tableau d'index trouvé, et on fait un break.
        if (element == tab2[j]) {
          tab2FindedIndex[i] = j;
          break;
        }
        // Si tab2 parcouru sans trouver de correspondance,
        // élément de tab1 n'est pas présent dans tab2, et on retourne false.
        if (j == tab2.length - 1) {
          return false;
        }
      }
    }
    // Si toutes les correspondances sont trouvées, on retourne true.
    return true;
  }

  private TabAlgosUtils() {}
}
