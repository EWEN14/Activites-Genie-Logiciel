package unc.nc.genielogiciel.model;

public class Exo12_4 {
  public static void main(String[] args) {

    Compteur c1, c2, c3;

    c1 = new Compteur(0);
    c1.incrementer();
    c2 = new Compteur(1);
    c3 = c1;

    if (c1 == c3) {
      System.out.println("c1 et c3 sont égaux"); // ✔️
    } else {
      System.out.println("c1 et C3 ne sont pas égaux");
    }

    if (c1.getValeur() == c2.getValeur()) {
      System.out.println("c1 et c2 ont même valeur"); // ✔️
    } else {
      System.out.println("c1 et c2 n'ont pas la même valeur");
    }

    if (c1 == c2) {
      System.out.println("c1 et c2 sont égaux");
    } else {
      System.out.println("c1 et c2 ne sont pas égaux"); // ✔️
    }

    if (c1.getValeur() == c1.incrementer().getValeur()) {
      System.out.println("c1 et c1 incrémenté ont même valeur");
    } else {
      System.out.println("c1 et c1 incrémenté n'ont pas la même valeur"); // ✔️
    }

    if (c1 == c1.incrementer()) {
      System.out.println("c1 et c1 incrémenté sont égaux"); // ✔️
    } else {
      System.out.println("c1 et c1 incrémenté ne sont pas égaux");
    }
  }

  static class Compteur {
    int x;

    Compteur(int n) {
      x = n;
    }

    Compteur incrementer() {
      x++;
      return this;
    }

    int getValeur() {
      return x;
    }
  }
}
