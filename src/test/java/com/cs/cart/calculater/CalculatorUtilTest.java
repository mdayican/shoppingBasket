package com.cs.cart.calculater;

import static com.cs.cart.calculater.CalculatorUtil.multiplyNoScale;
import static org.junit.Assert.*;

import java.math.BigDecimal;
import org.junit.Test;

public class CalculatorUtilTest {


  @Test
  public void multiplyNoScale10x10CorrectValue(){
    assertEquals(new BigDecimal(100),multiplyNoScale(new BigDecimal(10),10));
  }


  @Test
  public void multiplyNoScale2x5CorrectValue(){
    assertEquals(new BigDecimal(10),multiplyNoScale(new BigDecimal(5),2));
  }

  @Test
  public void multiplyNoScaleWrongValue(){
    assertNotEquals(new BigDecimal("100.00"),multiplyNoScale(new BigDecimal(10),10));
  }
}