package unc.nc.genielogiciel.model;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import unc.nc.genielogiciel.test.MoneyBagTests;
import unc.nc.genielogiciel.test.MoneyTests;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = { MoneyTests.class, MoneyBagTests.class })
public class AllMoneyTests {

}
