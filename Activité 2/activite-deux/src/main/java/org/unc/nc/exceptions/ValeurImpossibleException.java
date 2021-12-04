package org.unc.nc.exceptions;

/**
 * Exception retournée en cas de valeur qui ne peut pas être rentrée.
 * Car ne respecte pas les conditions
 * (caractère déjà présent sur ligne, colonne ou bloc)
 */
public class ValeurImpossibleException extends Exception {

  public ValeurImpossibleException(String errorMessage) {
    super(errorMessage);
  }
}
