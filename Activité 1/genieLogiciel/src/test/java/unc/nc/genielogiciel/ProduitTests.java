package unc.nc.genielogiciel;

import org.junit.jupiter.api.Test;

import org.springframework.boot.test.context.SpringBootTest;
import unc.nc.genielogiciel.model.Produit;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class ProduitTests {

  Produit produit = new Produit("R2D2", 5000.0);
  Produit produit2 = new Produit();

  @Test
  public void produit() {
    produit.setPrix(10000);
    assertEquals(10000, produit.getPrix());
  }

  @Test
  public void produitRef() {
    assertEquals("R2D2", produit.getReference());
  }

  @Test
  public void produit2() {
    assertNull(produit2.getReference());
  }

  @Test
  public void sameProduct() {
    assertNotEquals(produit, produit2);
  }
}
