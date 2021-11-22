package org.unc.nc;

import org.junit.jupiter.api.Test;
import org.unc.nc.exceptions.CaractereInterditException;
import org.unc.nc.exceptions.HorsBornesException;
import org.unc.nc.exceptions.ValeurImpossibleException;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test de l'implémentation de la Grille de sudoku.
 */
public class GrilleImplTest {

  // grille d'exemple utilisée sur plusieurs test.
  // les setters de chaque test seront cependant indépendants.
  GrilleImpl grilleImpl = new GrilleImpl(9);

  // grilles utilisées pour couvrir tous les cas de dimension de grille du constructeur
  GrilleImpl grilleDim4 = new GrilleImpl(4);
  GrilleImpl grilleDim16 = new GrilleImpl(16);
  GrilleImpl grilleDim25 = new GrilleImpl(25);

  @Test
  public void testGrille() {
    // grille de test
    char[][] grilleTest = new char[4][4];
    // en remplit la grille de test de caractère '@'
    for (char[] grille : grilleTest) {
      Arrays.fill(grille, Grille.EMPTY);
    }
    // on créé un objet GrilleImpl avec une grille de dimension 4
    GrilleImpl grille = new GrilleImpl(4);
    // on vérifie que les tableaux sont formes de String sont égaux
    assertEquals(Arrays.deepToString(grille.grille), Arrays.deepToString(grilleTest),
            "Les deux grilles devraient être identiques");
  }

  @Test
  public void testGrilleBadDimension() {
    final Exception exception = assertThrows(IllegalArgumentException.class, () -> new GrilleImpl(5));
    assertEquals("Dimension de grille incorrecte. Valeur autorisée : 4, 9, 16 et 25.", exception.getMessage(),
            "Le message d'erreur renvoyé n'est pas celui attendu.");
  }

  @Test
  public void testGetDimension() {
    assertEquals(9, this.grilleImpl.getDimension());
  }

  @Test
  public void testSetValueGood() throws ValeurImpossibleException, CaractereInterditException, HorsBornesException {
    // On met un '8' à la case ligne 3 colonne 5.
    this.grilleImpl.setValue(2, 4, '8');

    // on vérifie que la case contient bien la valeur attendue
    assertEquals('8', this.grilleImpl.grille[2][4]);
  }

  @Test
  public void testSetValueAlreadyInRow() throws ValeurImpossibleException, CaractereInterditException,
          HorsBornesException {
    // On met un '8' à la case ligne 3 colonne 5.
    this.grilleImpl.setValue(2, 4, '8');

    // on va tenter d'insérer un 8 alors qu'il y en a déjà un sur la ligne 3
    final Exception exception = assertThrows(
            ValeurImpossibleException.class, () -> this.grilleImpl.setValue(2, 7, '8'));

    assertEquals("Ce caractère est déjà présent dans la ligne de la case visée", exception.getMessage(),
            "Le message d'erreur renvoyé n'est pas celui attendu.");
  }

  @Test
  public void testSetValueAlreadyInColumn() throws ValeurImpossibleException, CaractereInterditException,
          HorsBornesException {
    // On met un '4' à la case ligne 5 colonne 2.
    this.grilleImpl.setValue(6, 3, '4');

    // on va tenter d'insérer un 4 alors qu'il y en a déjà un sur la colonne 2
    final Exception exception = assertThrows(
            ValeurImpossibleException.class, () -> this.grilleImpl.setValue(7, 3, '4'));

    assertEquals("Ce caractère est déjà présent dans la colonne de la case visée", exception.getMessage(),
            "Le message d'erreur renvoyé n'est pas celui attendu.");
  }

  @Test
  public void testSetValueHorsBornesLigne() throws ValeurImpossibleException, CaractereInterditException,
          HorsBornesException {
    // on va tenter de récupérer la valeur à x = 9 (ligne 9)
    // alors que l'index maximum est de 8 (ligne 9).
    final Exception exception = assertThrows(
            HorsBornesException.class, () -> this.grilleImpl.setValue(9, 5, '4'));

    assertEquals("Au moins l'une des deux coordonnées dépasse la dimension de la grille.", exception.getMessage(),
            "Le message d'erreur renvoyé n'est pas celui attendu.");
  }

  @Test
  public void testSetValueHorsBornesColonne() throws ValeurImpossibleException, CaractereInterditException,
          HorsBornesException {
    // on va tenter de récupérer la valeur à y = 9 (colonne 9)
    // alors que l'index maximum est de 8 (colonne 9).
    final Exception exception = assertThrows(
            HorsBornesException.class, () -> this.grilleImpl.setValue(3, 9, '4'));

    assertEquals("Au moins l'une des deux coordonnées dépasse la dimension de la grille.", exception.getMessage(),
            "Le message d'erreur renvoyé n'est pas celui attendu.");
  }

  @Test
  public void testSetValueCaractereInterdit() throws ValeurImpossibleException, CaractereInterditException,
          HorsBornesException {
    // on va tenter d'insérer un 0 dans notre grille de dimension 9,
    // alors qu'on ne peut que rentrer des éléments entre 1 et 9.
    final Exception exception = assertThrows(
            CaractereInterditException.class, () -> this.grilleImpl.setValue(1, 2, '0'));

    assertEquals("Ce caractère n'est pas autorisé dans cette grille.", exception.getMessage(),
            "Le message d'erreur renvoyé n'est pas celui attendu.");
  }

  @Test
  public void testGetValue() throws HorsBornesException {
    // on récupère la valeur ligne 3, colonne 4, qui contient un caractère vide '@'
    assertEquals('@',this.grilleImpl.getValue(2,3),"Les deux caractères ne correspondent pas");
  }

  @Test
  public void testGetValueHorsBornesLigne() throws HorsBornesException {
    // on va tenter de récupérer la valeur à x = 9 (ligne 10)
    // alors que l'index maximum est de 8 (ligne 9).
    final Exception exception = assertThrows(
            HorsBornesException.class, () -> this.grilleImpl.getValue(9, 8));

    assertEquals("Au moins l'une des deux coordonnées dépasse la dimension de la grille.", exception.getMessage(),
            "Le message d'erreur renvoyé n'est pas celui attendu.");
  }

  @Test
  public void testGetValueHorsBornesColonne() throws HorsBornesException {
    // on va tenter de récupérer la valeur à y = 9 (colonne 10)
    // alors que l'index maximum est de 8 (colonne 9).
    final Exception exception = assertThrows(
            HorsBornesException.class, () -> this.grilleImpl.getValue(6, 9  ));

    assertEquals("Au moins l'une des deux coordonnées dépasse la dimension de la grille.", exception.getMessage(),
            "Le message d'erreur renvoyé n'est pas celui attendu.");
  }

  @Test
  public void testCompleteTrue() {
    // on remplit la grille d'éléments (même si elle n'est pas correcte comme ça, c'est juste pour les besoins du test)
    for (char[] grille : this.grilleImpl.grille) {
      Arrays.fill(grille, '1');
    }

    assertTrue(this.grilleImpl.complete());
  }

  @Test
  public void testCompleteFalse() {
    // par défaut la grille n'est pas complète
    assertFalse(this.grilleImpl.complete());
  }
}
