package unc.nc.genielogiciel.model;

import java.util.Objects;

public class Money {

  private int fAmount;

  private String fCurrency;

  public Money(int amount, String currency) {
    fAmount = amount;
    fCurrency = currency;
  }

  public int amount() {
    return fAmount;
  }

  public String currency() {
    return fCurrency;
  }

  public Money add(Money m) {
    if (m.currency().equals(this.currency())) {
      return new Money(amount() + m.amount(), currency());
    }
    // return new MoneyBag(this, m);
    return m; // à retirer plus tard
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Money money = (Money) o;
    return fAmount == money.fAmount && fCurrency.equals(money.fCurrency);
  }

  @Override
  public int hashCode() {
    return Objects.hash(fAmount, fCurrency);
  }
}
