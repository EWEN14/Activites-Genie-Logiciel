package unc.nc.genielogiciel.model;

import java.util.Objects;
import java.util.Vector;

public class MoneyBag {

  private Vector<Money> fMonies = new Vector<Money>();

  public MoneyBag(Money m1, Money m2) {
    appendMoney(m1);
    appendMoney(m2);
  }

  public MoneyBag(Money bag[]) {
    for (int i = 0; i < bag.length; i++) {
      appendMoney(bag[i]);
    }
  }

  private void appendMoney(Money m) {
    if (fMonies.isEmpty()) {
      fMonies.add(m);
    } else {
      int i = 0;

      while ((i < fMonies.size()) && (!(fMonies.get(i).currency().equals(m.currency())))) {
        i++;
      }

      if (i >= fMonies.size()) {
        fMonies.add(m);
      } else {
        fMonies.set(i, new Money(fMonies.get(i).amount() + m.amount(), m.currency()));
      }
    }
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    MoneyBag moneyBag = (MoneyBag) o;
    return fMonies.equals(moneyBag.fMonies);
  }

  @Override
  public int hashCode() {
    return Objects.hash(fMonies);
  }
}
