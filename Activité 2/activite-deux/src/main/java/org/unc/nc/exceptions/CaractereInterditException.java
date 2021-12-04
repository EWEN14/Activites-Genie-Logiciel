package org.unc.nc.exceptions;

/**
 * Exception retournée si on tente d'insérer un caractère non autorisé.
 */
public class CaractereInterditException extends Exception {

  public CaractereInterditException(String errorMessage) {
    super(errorMessage);
  }
}
