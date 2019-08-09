package com.cs.cart.calculater;


import static com.cs.cart.calculater.PriceCalculator.calculateTotalPrice;
import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class PriceCalculatorTest {


  private final BigDecimal expected;
  private final List cartList;


  /**
   * test data
   * this 7 data will run in 7 test
   * @return
   */
  @Parameters
  public static Collection<Object[]> data() {
    return Arrays.asList(new Object[][] {
        { Arrays.asList("Banana", "Apple", "Apple"), new BigDecimal(90)},
        { Arrays.asList("Banana", "Apple", "Apple","Melon","Melon"), new BigDecimal(140) },
        { Arrays.asList("Banana", "Apple", "Apple","Melon","Melon","Lime","Lime","Lime"), new BigDecimal(170) },
        { Arrays.asList("Banana", "Apple", "Apple","Melon","Melon","Lime","Lime","Lime","Melon","Melon"), new BigDecimal(220) },
        { Arrays.asList("Banana", "Apple", "Apple","Melon","Melon","Lime","Lime","Lime","Melon","Melon","Lime","Lime"), new BigDecimal(250) },
        { Arrays.asList("Banana", "Apple", "Apple","Melon","Lime"), new BigDecimal(155)},
        { Arrays.asList("Banana", "Apple", "Apple","Melon","Lime","Lime","Lime"), new BigDecimal(170)},
    });
  }


  public PriceCalculatorTest(List inputCart, BigDecimal inputExpected) {
    this.cartList = inputCart;
    this.expected =inputExpected;
  }

  @Test
  public void priceCalculatorTest(){

    assertEquals(expected,calculateTotalPrice(cartList));

  }

}