package org.unc.nc;

import org.junit.jupiter.api.Test;
import org.unc.nc.exceptions.CaractereInterditException;
import org.unc.nc.exceptions.HorsBornesException;
import org.unc.nc.exceptions.ValeurImpossibleException;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

/**
 * test du Parser pour transformer les fichiers textes en grille.
 */
public class GrilleParserUtilsTest {
  public static void main(String[] args) throws CaractereInterditException, IOException, HorsBornesException, ValeurImpossibleException {
    GrilleImpl grille9 = new GrilleImpl(9);
    String path = "src/test/resources/sudoku-9x9.txt";
    File file = new File(path);
    grille9 = GrilleParserUtils.parse(file, grille9);
    System.out.println("Sudoku 9x9 :");
    System.out.println(Arrays.deepToString(grille9.grille));

    GrilleImpl grille16 = new GrilleImpl(16);
    String path2 = "src/test/resources/sudoku-16x16.txt";
    File file2 = new File(path2);
    grille16 = GrilleParserUtils.parse(file2, grille16);
    System.out.println("Sudoku 16x16 :");
    System.out.println(Arrays.deepToString(grille16.grille));

    GrilleImpl grille25 = new GrilleImpl(25);
    String path3 = "src/test/resources/sudoku-25x25.txt";
    File file3 = new File(path3);
    grille25 = GrilleParserUtils.parse(file3, grille25);
    System.out.println("Sudoku 25x25 :");
    System.out.println(Arrays.deepToString(grille25.grille));

    grille9.solve();
    System.out.println("Résolution Sudoku grille 9x9 :");
    System.out.println(Arrays.deepToString(grille9.grille));

    grille16.solve();
    System.out.println("Résolution Sudoku grille 16x16 :");
    System.out.println(Arrays.deepToString(grille16.grille));

    // grille25.solve();
    // System.out.println("Résolution Sudoku grille 25x25 :");
    // System.out.println(Arrays.deepToString(grille25.grille));
  }

  @Test
  public void grille9solve() throws CaractereInterditException, IOException, HorsBornesException, ValeurImpossibleException {
    GrilleImpl grille9 = new GrilleImpl(9);
    String path = "src/test/resources/sudoku-9x9.txt";
    File file = new File(path);
    grille9 = GrilleParserUtils.parse(file, grille9);

    GrilleImpl grille9solved = new GrilleImpl(9);
    String path2 = "src/test/resources/sudoku-9x9-resolu.txt";
    File file2 = new File(path2);
    grille9solved = GrilleParserUtils.parse(file2, grille9solved);

    grille9.solve();

    assertEquals(Arrays.deepToString(grille9.grille), Arrays.deepToString(grille9solved.grille));
  }
}
