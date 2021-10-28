package unc.nc.genielogiciel.model;

public class Exo12_3 {
  public static void main(String[] args) {
    Exo12_3 obj1 = new Exo12_3();
    obj1.x = 1;
    obj1.y = 2;
    obj1.nom = "objet1";

    Exo12_3 obj2 = new Exo12_3();
    obj2.x = 1;
    obj2.y = 4;
    obj2.nom = "objet2";

    obj1.ajouter(obj2);

    obj1.afficher();

    Exo12_3 obj3 = Exo12_3.nouveau(5);

    System.out.println(obj1.plusGrand(obj2));

    System.out.println(Exo12_3.compare(obj1,obj2));
  }

  int x, y;

  String nom;

  void afficher() {
    System.out.println(nom+" "+x+"  "+y);
  }

  void ajouter(Exo12_3 obj) {
    x = x + obj.x;
    y = y + obj.y;
    nom = nom + obj.nom;
  }

  static private Exo12_3 nouveau(int n) {
    Exo12_3 res = new Exo12_3();
    res.x = n;
    res.y = n*2;
    res.nom = "Auto_"+n;
    return res;
  }

  boolean plusGrand(Exo12_3 obj) {
    if (obj.x == x) {
      return y > obj.y;
    } else {
      return x > obj.x;
    }
  }

  static boolean compare(Exo12_3 obj1, Exo12_3 obj2) {
    if (obj1.x == obj2.x) {
      return obj1.y > obj2.y;
    } else {
      return obj1.x > obj2.x;
    }
  }
}
