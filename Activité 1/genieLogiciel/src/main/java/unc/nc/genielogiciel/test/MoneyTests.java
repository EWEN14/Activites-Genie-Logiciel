package unc.nc.genielogiciel.test;

import org.junit.jupiter.api.Test;
import unc.nc.genielogiciel.model.Money;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MoneyTests {

  Money m12CHF = new Money(12, "CHF");
  Money m14CHF = new Money(14, "CHF");

  @Test
  public void testSimpleAdd() {
    Money expected = new Money(26, "CHF");
    Money result = m12CHF.add(m14CHF);

    assertTrue(expected.equals(result));
  }

  @Test
  public void testEquals() {
    assertTrue(!m12CHF.equals(null));
    assertEquals(m12CHF, m12CHF);
    assertEquals(m12CHF, new Money(12, "CHF"));
    assertTrue(!m12CHF.equals(m14CHF));
  }
}
