package unc.nc.genielogiciel.model;

public class Compte {

  int solde = 0;

  String nomTitulaire;

  public Compte(String nomTitulaire) {
    this.nomTitulaire = nomTitulaire;
  }

  public void deposer(int montant) {
    solde += montant;
  }

  public void retirer(int montant) {
    solde -= montant;
  }

  public void virerVers(int montant, Compte destination) {
    this.retirer(montant);
    destination.deposer(montant);
  }

  public void afficher() {
    System.out.println("nom titulaire du compte : "+nomTitulaire+". Solde: "+solde);
  }

  public void setNomTitulaire(String nomTitulaire) {
    this.nomTitulaire = nomTitulaire;
  }
}
