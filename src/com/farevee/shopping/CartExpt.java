package com.farevee.shopping;

import java.util.ArrayList;

import java.io.PrintWriter;

import com.farevee.groceries.BulkContainer;
import com.farevee.groceries.BulkFood;
import com.farevee.groceries.BulkItem;
import com.farevee.groceries.Item;
import com.farevee.groceries.ManyPackages;
import com.farevee.groceries.Package;
import com.farevee.groceries.Units;
import com.farevee.groceries.Weight;
import com.farevee.groceries.NonFood;

public class CartExpt
{

  public static void main(String[] args)
    throws Exception
  {
    PrintWriter pen = new PrintWriter(System.out, true);
    Cart cart = new Cart();
    

    
    // The store has 20 pounds of bananas, priced at 50 cents per pound
    BulkFood bananas = new BulkFood("bananas", Units.POUND, 50, 20);
    // The store has 200 grams of saffron, priced at 1000 cents per gram
    BulkFood saffron = new BulkFood("saffron", Units.GRAM, 1000, 200);
    // The customer adds three pounds of bananas to the cart
    cart.addItem(new BulkItem(bananas, Units.POUND, 3));

    // The customer adds a jar of 3 grams of saffron to the cart
    cart.addItem(new BulkContainer("jar", saffron, Units.GRAM, 3));
    cart.addItem(new BulkContainer("jar", saffron, Units.GRAM, 3));
    // The customer adds a bag of 1 gram of saffron to the cart
    cart.addItem(new BulkItem(saffron, Units.GRAM, 1));

    // The customer adds a can opener to the cart, priced $3.489.
    cart.addItem(new NonFood("can opener", (new Weight(Units.OUNCE, 2)), 349));

    // The customer adds a box of oreos to the cart
    cart.addItem(new Package("oreos", new Weight(Units.OUNCE, 12), 399));
    cart.addItem(new Package("oreos", new Weight(Units.OUNCE, 12), 399));
    cart.addItem(new Package("oreos", new Weight(Units.OUNCE, 12), 399));
    

    // The customer adds five 6oz packages of macncheez to the cart, each 
    // priced at 77 cents.
    cart.addItem(new ManyPackages(new Package("macncheez",
                                              new Weight(Units.OUNCE, 6), 77),
                                  5));

    cart.addItem(new ManyPackages(new Package("macncheez",
                                              new Weight(Units.OUNCE, 6), 77),
                                  10));
    cart.addItem(new ManyPackages(new Package("macncheez",
                                              new Weight(Units.OUNCE, 6), 77),
                                  3));
    cart.addItem(new ManyPackages(new Package("macncheez",
                                              new Weight(Units.OUNCE, 6), 77),
                                  9));

    for (int i = 0; i < cart.size(); i++)
      {
        pen.println(cart.cart.get(i).toString());
      }

    cart.merge();
    

    for (int i = 0; i < cart.size(); i++)
      {
        pen.println(cart.cart.get(i).toString());
      }

  }
}
