package org.unc.nc;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Classe de test de la classe CalculUtils
 */
/* default */ class CalculUtilsTest {
  @Test
  /* default */ void testSomme() {
    assertEquals(5, CalculUtils.somme(2, 3), "2 + 3 vaut bien 5.");
  }

  @Test
  /* default */ void testSommeFalse() {
    assertNotEquals(6, CalculUtils.somme(2, 3), "2 + 3 vaut 5 et non pas 6.");
  }

  @Test
  /* default */ void testMaFonction() {
    assertEquals(2, CalculUtils.maFonction(28, 14), "28 divisé par 14 vaut bien 2.");
  }

  @Test
  /* default */ void testMaFonction2() {
    assertEquals(4, CalculUtils.maFonction(3, 4), "4 est inférieur à 10, donc on attend 4 en retour.");
  }

  @Test
  /* default */ void testDivision() {
    assertEquals(4, CalculUtils.division(8, 2), "8 divisé par 2 vaut bien 4");
  }

  @Test
  /* default */ void testDivisionZero() {
    final Exception exception = assertThrows(IllegalArgumentException.class, () -> CalculUtils.division(4, 0));
    assertEquals("entier2 ne doit pas être égal à 0", exception.getMessage(),
            "On ne peut pas diviser par 0");
  }
}
