package com.farevee.groceries;

public class NonFood
  implements Item
{
  String name;
  
  Weight weight;
  
  int price;
  
  public NonFood(String name, Weight weight, int price)
  {
    this.name = name;
    this.weight = weight;
    this.price = price;
  }
  
  public Weight getWeight()
  {
    return this.weight;
  }

  public int getPrice()
  {
    return this.price;
  }
  
  public String toString()
  {
    return this.name;
  }
  
  public boolean getEquals(Package comp)
  {
    if (this.price == comp.price &&
        this.weight == comp.weight &&
        this.name == comp.name)
      {
        return true;
      }//if
    else return false;
  }
}
