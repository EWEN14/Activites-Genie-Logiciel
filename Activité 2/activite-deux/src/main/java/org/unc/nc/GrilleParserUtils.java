package org.unc.nc;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import org.unc.nc.exceptions.CaractereInterditException;
import org.unc.nc.exceptions.HorsBornesException;
import org.unc.nc.exceptions.ValeurImpossibleException;

/**
 * Classe qui va lire les fichiers txt représentant une grille et les convertir en grille.
 */
public class GrilleParserUtils {

  /**
   * lecture d'un fichier et transformation en grille.
   *
   * @param in fichier reçu
   * @param grille grille
   * @throws IOException erreur de lecture du fichier
   * @throws CaractereInterditException erreur de caractère
   * @throws HorsBornesException erreur de coordonnées
   * @throws ValeurImpossibleException erreur de valeur non valide
   */
  public static GrilleImpl parse(InputStream in, GrilleImpl grille) throws IOException,
          CaractereInterditException, HorsBornesException, ValeurImpossibleException {

    Reader reader = new InputStreamReader(in, StandardCharsets.UTF_8);
    int dimension = grille.getDimension();
    char[] buffer = new char[dimension];

    for (int line = 0; line < dimension; line++) {
      int lus = reader.read(buffer);
      if (lus != dimension) {
        throw new EOFException("format incorrect");
      }

      for (int i = 0; i < dimension; i++) {
        grille.setValue(line, i, buffer[i]);
      }

      lus = reader.read(new char[1]);

      if (lus != 1) {
        throw new EOFException("pas de fin de ligne ? ligne=" + line);
      }
    }
    reader.close();
    return grille;
  }

  /**
   * récupération d'un fichier en paramètre et appelle de la fonction parse ci-dessus.
   *
   * @param f fichier texte
   * @param grille grille
   * @throws IOException erreur de lecture du fichier
   * @throws CaractereInterditException erreur de caractère
   * @throws HorsBornesException erreur de coordonnées
   * @throws ValeurImpossibleException erreur de valeur non valide
   */
  public static GrilleImpl parse(File f, GrilleImpl grille) throws IOException,
          CaractereInterditException, HorsBornesException, ValeurImpossibleException {
    return parse(new FileInputStream(f), grille);
  }
}
