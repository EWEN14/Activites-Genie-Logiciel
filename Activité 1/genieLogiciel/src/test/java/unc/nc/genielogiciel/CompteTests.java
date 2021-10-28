package unc.nc.genielogiciel;

import unc.nc.genielogiciel.model.Compte;

public class CompteTests {
  public static void main(String[] args) {

    System.out.println("Exercice 2.1.1");

    /* Question 2 : création de 2 comptes et opérations sur ceux-ci */
    System.out.println("Question 2 :");
    Compte compte1 = new Compte("Shulk");
    Compte compte2 = new Compte("Wayne");

    compte1.deposer(500);
    compte2.deposer(1000);
    compte2.retirer(10);
    compte1.virerVers(75, compte2);
    compte1.afficher();
    compte2.afficher();

    /* Question 3 : création de 10 compte */
    System.out.println("/--------------------------/");
    System.out.println("Question 2 :");
    Compte[] tabCompte = new Compte[10];

    for (int i = 0; i < tabCompte.length; i++) {
      tabCompte[i] = new Compte("Individu "+(i+1));
      tabCompte[i].deposer(200 + 100 * i);
    }

    for (int i = 0; i < tabCompte.length; i++) {
      for (int j = i+1; j < tabCompte.length; j++) {
        tabCompte[i].virerVers(20,tabCompte[j]);
      }
    }

    tabCompte[0].setNomTitulaire("Personne 1");

    for (Compte compte: tabCompte) {
      compte.afficher();
    }
  }
}
