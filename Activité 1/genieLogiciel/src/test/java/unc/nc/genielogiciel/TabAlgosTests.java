package unc.nc.genielogiciel;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import org.springframework.boot.test.context.SpringBootTest;
import unc.nc.genielogiciel.model.TabAlgosUtils;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class TabAlgosTests {

  @Test
  public void testMax() {
    int[] tab = new int[]{1, 24, 5, 30, 6, 18};
    assertEquals(30, TabAlgosUtils.plusGrand(tab));
  }

  @Test
  public void testMaxNot() {
    int[] tab = new int[]{1, 24, 5, 30, 60, 18};
    assertNotEquals(30, TabAlgosUtils.plusGrand(tab));
  }

  @Test
  public void testMoyenne() {
    int[] tab = new int[]{1, 24, 5, 30, 6, 18};
    assertEquals(14.0, TabAlgosUtils.moyenne(tab));
  }

  @Test
  public void testMoyenneNot() {
    int[] tab = new int[]{1, 24, 5, 30, 6, 18};
    assertNotEquals(11.0, TabAlgosUtils.moyenne(tab));
  }

  @Test
  public void testMoyenneThrow() {
    int[] tab = null;
    Exception exception = assertThrows(IllegalArgumentException.class, () -> TabAlgosUtils.moyenne(tab));
    assertEquals("Le tableau fourni ne doit pas être null ou vide.", exception.getMessage());
  }

  @Test
  public void testMoyenneThrowNot() {
    int[] tab = null;
    Exception exception = assertThrows(IllegalArgumentException.class, () -> TabAlgosUtils.moyenne(tab));
    assertNotEquals("C'est un mauvais tableau", exception.getMessage());
  }

  @Test
  public void testEgaux() {
    int[] tab1 = new int[]{1, 24, 5, 30, 6, 18};
    int[] tab2 = new int[]{1, 24, 5, 30, 6, 18};
    assertTrue(TabAlgosUtils.egaux(tab1, tab2));
  }

  @Test
  public void testEgauxNot() {
    int[] tab1 = new int[]{1, 24, 5, 30, 6, 18};
    int[] tab2 = new int[]{1, 24, 5, 30, 6, 19};
    assertFalse(TabAlgosUtils.egaux(tab1, tab2));
  }

  @Test
  public void testSimilaires() {
    int[] tab1 = new int[]{2, 2, 1, 0, 4};
    int[] tab2 = new int[]{2, 0, 4, 2, 1};
    assertTrue(TabAlgosUtils.similaires(tab1, tab2));
  }

  @Test
  public void testSimilairesFalse() {
    int[] tab1 = new int[]{2, 2, 1, 0, 4};
    int[] tab2 = new int[]{0, 1, 4, 2, 3};
    assertFalse(TabAlgosUtils.similaires(tab1, tab2));
  }
}
