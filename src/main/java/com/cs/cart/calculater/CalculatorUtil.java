package com.cs.cart.calculater;

import java.math.BigDecimal;

public class CalculatorUtil {

  private static int SCALE = 0;

  private CalculatorUtil() {
  }

  /**
   * both params must be positive
   * 3for2 x=3 y=2
   * @param num Positive number to divide
   * @param x Positive divisor
   * @param y Positive divisor
   */
  public static long xForY(long num, long x,long y) {
    return ((num / x) )*y + (num % x);
  }

  public static BigDecimal multiplyNoScale(BigDecimal price, long count) {

    return  new BigDecimal(count).multiply(price).setScale(SCALE);
  }


}
