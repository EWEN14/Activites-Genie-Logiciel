package org.unc.nc;

import org.unc.nc.exceptions.CaractereInterditException;
import org.unc.nc.exceptions.ValeurImpossibleException;
import org.unc.nc.exceptions.HorsBornesException;

public interface Resolveur {

  boolean solve() throws HorsBornesException,
  ValeurImpossibleException, CaractereInterditException;;
}
