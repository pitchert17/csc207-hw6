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

public class Cart
{

  /**
   * Remove the jth item in the card, putting the last value in 
   * position j.  Return the new length. Credit to Same
   */
  int replace(int j)
  {
    int last = this.cart.size() - 1;
    this.cart.set(j, this.cart.get(last));
    this.cart.remove(last);
    return last;
  } // replace(int)

  ArrayList<Item> cart;

  PrintWriter pen = new PrintWriter(System.out, true);

  public Cart()
  {
    this.cart = new ArrayList<Item>();
  }

  public int size()
  {
    return this.cart.size();
  }

  public void print(PrintWriter pen)
  {
    int len = cart.size();
    for (int i = 0; i < len; i++)
      {
        pen.println(cart.get(i).toString());
      }
  }

  public void addItem(Item item)
  {
    this.cart.add(item);
  }

  public int numEntries()
  {
    return this.cart.size();
  }

  public void printContents()
  {
    int length = this.cart.size();
    for (int i = 0; i < length; i++)
      pen.println(cart.get(i).toString());
    pen.close();
  }

  public int numThings()
  {
    int length = this.cart.size();
    int num = 0;
    for (int i = 0; i < length; i++)
      {
        if (cart.get(i) instanceof ManyPackages)
          num += ((ManyPackages) cart.get(i)).getCount();
        else
          num++;
      }//for
    return num;
  }

  public int getPrice()
  {
    int price = 0;
    for (int i = 0; i < this.cart.size(); i++)
      {
        price += this.cart.get(i).getPrice();
      }
    return price;
  }

  public Weight[] getWeight()
  {
    //Weight[] totalWeight = new Weight[3];
    Weight cartGrams = new Weight(Units.GRAM, 0);
    Weight cartOunces = new Weight(Units.OUNCE, 0);
    Weight cartPounds = new Weight(Units.POUND, 0);
    Weight cartKilograms = new Weight(Units.KILOGRAM, 0);
    for (int i = 0; i < this.cart.size(); i++)
      {
        Weight stuff = this.cart.get(i).getWeight();
        if (stuff.unit == Units.GRAM)
          {
            cartGrams.amount += stuff.amount;
          }
        else if (stuff.unit == Units.OUNCE)
          {
            cartOunces.amount += stuff.amount;
          }
        else if (stuff.unit == Units.POUND)
          {
            cartPounds.amount += stuff.amount;
          }
        else
          {
            cartKilograms.amount += stuff.amount;
          }//else
      }//for
    Weight[] cartWeight = { cartGrams, cartOunces, cartPounds, cartKilograms };
    return cartWeight;
  }//getWeight()

  public void remove(String name)
  {
    int length = this.cart.size();
    for (int i = 0; i < length; i++)
      {
        if (this.cart.get(i).toString() == name)
          cart.remove(i);
      }//for
  }//remove(String)

  public void merge()
  {   
    int length = this.cart.size();
    for (int i = 0; i < length; i++)
      {
        Item box = this.cart.get(i);
        Item comp;

        for (int j = i + 1; j < length; j++)
          {
            comp = this.cart.get(j);

            if (box instanceof Package)
              {
                if (comp instanceof Package)
                  {
                    if (((Package) box).getEquals((Package) comp))
                      {
                        cart.set(i, new ManyPackages((Package) box, 2));
                        length = replace(j);
                        j--;
                        i--;
                        break;
                      }
                  }//if box equals comp
                else if (comp instanceof ManyPackages)
                  {                    
                    ManyPackages comp1 = (ManyPackages) comp;
                    if (((Package) box).getEquals(comp1.getPack()))
                      {                        
                        cart.set(i,
                                 new ManyPackages((Package) box,
                                                  comp1.getCount() + 1));
                        length = replace(j);
                        j--;
                        i--;
                        break;
                      }
                  }//if comp is ManyPackages
              } //if box is Package
            else if (box instanceof ManyPackages)
              {
                ManyPackages box1 = (ManyPackages) box;
                if (comp instanceof ManyPackages)
                  {                    
                    ManyPackages comp1 = (ManyPackages) comp;
                    if (box1.getPack().getEquals(comp1.getPack()))
                      {                      
                        cart.set(i,
                                 new ManyPackages((box1.getPack()), box1.getCount()
                                                               + comp1.getCount()));
                        length = replace(j);
                        --i;
                        --j;
                        break;
                      }
                  }//if box and comp contain the same Packages
                if (comp instanceof Package)
                  {
                    if (box1.getPack().getEquals((Package) comp))
                      {

                        cart.set(i,
                                 new ManyPackages((box1.getPack()), box1.getCount() + 1));
                        length = replace(j);
                        j--;
                        i--;
                        break;
                      }
                  }//if comp is a package
              }//if box is ManyPackages

            else if (box instanceof BulkItem && comp instanceof BulkItem
                     && ((BulkItem) box).getEquals(((BulkItem) comp)))
              {
                cart.set(i,
                         new BulkItem(((BulkItem) box).food(),
                                      ((BulkItem) box).unit(),
                                      ((BulkItem) box).amount()
                                          + ((BulkItem) comp).amount()));
                length = replace(j);
                j--;
                i--;
                break;
              }
          }//for j
      }//for i
  }//merge()

}//class Cart

