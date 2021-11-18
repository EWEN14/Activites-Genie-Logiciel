package unc.nc.genielogiciel.test;

import org.junit.jupiter.api.Test;
import unc.nc.genielogiciel.model.Money;
import unc.nc.genielogiciel.model.MoneyBag;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MoneyBagTests {


  Money f12CHF = new Money(12, "CHF");
  Money f14CHF = new Money(14, "CHF");
  Money f7USD = new Money(7, "USD");
  Money f21USD = new Money(21, "USD");
  MoneyBag fMB1 = new MoneyBag(f12CHF, f7USD);
  MoneyBag fMB2 = new MoneyBag(f14CHF, f21USD);

  @Test
  public void testBagEquals() {
    assertTrue(!fMB1.equals(null));
    assertEquals(fMB1, fMB1);
    assertTrue(!fMB1.equals(f12CHF));
    assertTrue(!f12CHF.equals(fMB1));
    assertTrue(!fMB1.equals(fMB2));
  }
}
