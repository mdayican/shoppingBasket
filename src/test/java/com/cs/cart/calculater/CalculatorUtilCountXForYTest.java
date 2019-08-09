package com.cs.cart.calculater;


import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class CalculatorUtilCountXForYTest {


  @Parameters
  public static Collection<Object[]> data() {
    return Arrays.asList(new Object[][] {
        { 10, 3,2,7}, { 10, 2,1,5 }, { 10, 1,1,10 }, { 10, 10,1,1 },{ 10, 5,1,2 },{ 10, 15,1,10 },{ 10, 4,2,6 }
    });
  }


  private int num;

  //example  4 for 3 price, x=4
  private int x;

  //example  4 for 3 price, y=3
  private int y;

  private int expected;

  public CalculatorUtilCountXForYTest(int inputNum, int inputX,int inputY,int inputExpected) {
    this.num = inputNum;
    this.x =inputX;
    this.y =inputY;
    this.expected = inputExpected;
  }


  @Test
  public void countXforY(){
    assertEquals(expected, CalculatorUtil.xForY(num,x,y));
  }
}



