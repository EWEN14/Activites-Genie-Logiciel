package unc.nc.genielogiciel.model;

import java.util.Objects;

/**
 * Classe Produit représentant un produit avec un prix et une référence.
 */
public class Produit {

  /** Référence du produit. */
  private String reference;

  /** Prix du produit. */
  private double prix;

  /** Représente le taux de la TVA. */
  private static final double TVA = 0.20;

  /** Constructeur par défaut si pas de paramètres passés. */
  public Produit() {
    this.reference = "non référencé";
    this.prix = 0;
  }

  /**
   * Constructeur.
   *
   * @param reference la référence du produit.
   * @param prix le prix du produit.
   */
  public Produit(final String reference, final double prix) {
    this.reference = reference;
    this.prix = prix;
  }

  /**
   * Retourne le prix du produit.
   *
   * @return prix retourné.
   */
  public double getPrix() {
    return prix;
  }

  /**
   * Permet de fixer un nouveau prix au produit.
   *
   * @param prix nouveau prix.
   */
  public void setPrix(final double prix) {
    this.prix = prix;
  }

  /**
   * Permet d'obtenir la référence d'un produit
   *
   * @return la reference si le prix est strict positif, null sinon.
   */
  public final String getReference() {
    if (this.prix > 0) {
      return reference;
    }
    return null;
  }

  /**
   * Permet de changer la référence d'un produit.
   *
   * @param reference la nouvelle référence.
   */
  public void setReference(final String reference) {
    this.reference = reference;
  }

  public double getTva() {
    return TVA;
  }

  /**
   * Compare la référence de deux produits.
   *
   * @param objet objet produit qui sera comparé.
   * @return vrai si références égales, faux sinon.
   */
  @Override
  public boolean equals(final Object objet) {
    if (this == objet) {
      return true;
    }
    if (objet == null || getClass() != objet.getClass()) {
      return false;
    }
    final Produit produit = (Produit) objet; // On fait un cast objet en Produit
    return Objects.equals(reference, produit.reference); // Compare référence des deux produits.
  }

  @Override
  public int hashCode() {
    return Objects.hash(reference);
  }
}
