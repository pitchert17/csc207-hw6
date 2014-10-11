package com.farevee.groceries;

public class GroceryExpt
{

  public static void main(String[] args)
  {
    // The store has 20 pounds of bananas, priced at 50 cents per pound
    BulkFood bananas = new BulkFood("bananas", Units.POUND, 50, 20);
    // The store has 200 grams of saffron, priced at 1000 cents per gram
    BulkFood saffron = new BulkFood("saffron", Units.GRAM, 1000, 200);
    BulkItem apples = new BulkItem(bananas, Units.POUND, 3);
    
    System.out.println(apples.toString());
  }

}
