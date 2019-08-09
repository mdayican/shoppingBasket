package com.cs.cart.calculater;

import static com.cs.cart.calculater.CalculatorUtil.multiplyNoScale;
import static com.cs.cart.calculater.CalculatorUtil.xForY;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;

public class PriceCalculator {

  final static public BiFunction<BigDecimal, Long, BigDecimal> basicPriceCalculator =
      (price, count) -> multiplyNoScale(price, count);

  final static public BiFunction<BigDecimal, Long, BigDecimal> buyOneGetOneFreePriceCalculator =
      (price, count) -> multiplyNoScale(price, xForY(count, 2, 1));

  final static public BiFunction<BigDecimal, Long, BigDecimal> threeForTwoPriceCalculator =
      (price, count) -> multiplyNoScale(price, xForY(count, 3, 2));

  private final static Map<String, Item> priceMap= new HashMap<>();


 static {
    priceMap.put("Apple", new Item("Apple", 35, basicPriceCalculator));
    priceMap.put("Banana", new Item("Banana", 20, basicPriceCalculator));
    priceMap.put("Melon", new Item("Melon", 50, buyOneGetOneFreePriceCalculator));
    priceMap.put("Lime", new Item("Lime", 15, threeForTwoPriceCalculator));

  }


  private static Map<String, Long> groupCart(List<String> list) {
    if (list == null) {
      return null;
    }
    return list.stream()
        .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
  }

  public static BigDecimal calculateTotalPrice(List<String> list) {
    if(list==null)
      return BigDecimal.ZERO;

    Map<String, Long> map = groupCart(list);

   return  map.entrySet().stream().filter(e->priceMap.containsKey(e.getKey()))
       .map(e-> callCalculator(e.getKey(),e.getValue())).reduce(BigDecimal::add).orElse(BigDecimal.ZERO);
  }


  private static BigDecimal callCalculator(String key, Long count){
      Item item = priceMap.get(key);
     return  (BigDecimal)item.getCalculater().apply(item.getPrice(),count);
  }

}


