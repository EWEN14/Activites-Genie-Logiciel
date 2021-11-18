package org.unc.nc;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CalculUtilsTest {
  @Test
  public void testSomme() {
    assertEquals(5, CalculUtils.somme(2, 3));
  }

  @Test
  public void testSommeFalse() {
    assertNotEquals(6, CalculUtils.somme(2, 3));
  }

  @Test
  public void testMaFonction() {
    assertEquals(2, CalculUtils.maFonction(28, 14));
  }

  @Test
  public void testMaFonction2() {
    assertEquals(4, CalculUtils.maFonction(3,4));
  }

  @Test
  public void testDivision() {
    assertEquals(4, CalculUtils.division(8, 2));
  }

  @Test
  public void testDivisionZero() {
    Exception exception = assertThrows(IllegalArgumentException.class, () -> CalculUtils.division(4,0));
    assertEquals("b ne doit pas être 0", exception.getMessage());
  }
}
