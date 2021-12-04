package org.unc.nc.exceptions;

/**
 * Exception retournée si on tente d'insérer un caractère dans une
 * coordonnée dépassant la grille.
 */
public class HorsBornesException extends Exception {

  public HorsBornesException(String errorMessage)  {
    super(errorMessage);
  }
}
