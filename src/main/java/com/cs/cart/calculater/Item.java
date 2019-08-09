package com.cs.cart.calculater;

import java.math.BigDecimal;
import java.util.function.BiFunction;

public class Item {

  private final BigDecimal price;
  private final String name;
  private final BiFunction calculater;


  public Item(String name, int price, BiFunction calculator) {
    this.name = name;
    this.price = new BigDecimal(price);
    this.calculater = calculator;
  }


  public BigDecimal getPrice() {
    return price;
  }

  public String getName() {
    return name;
  }

  public BiFunction getCalculater() {
    return calculater;
  }
}
