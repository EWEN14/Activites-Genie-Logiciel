package org.unc.nc;

import org.unc.nc.exceptions.CaractereInterditException;
import org.unc.nc.exceptions.HorsBornesException;
import org.unc.nc.exceptions.ValeurImpossibleException;

/**
 * Interface de résolution du sudoku.
 */
public interface Resolveur {

  /**
   * Méthode de résolution du sudoku.
   *
   * @return true si le sudoku est complété
   * @throws HorsBornesException erreur bornes
   * @throws ValeurImpossibleException erreur valeur
   * @throws CaractereInterditException erreur caractère
   */
  boolean solve() throws HorsBornesException,
      ValeurImpossibleException, CaractereInterditException;
}
