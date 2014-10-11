package com.farevee.groceries;

public class Package
  implements Item
{
  String name;
  
  Weight weight;
  
  int price;
  
  public Package(String name, Weight weight, int price)
  {
    this.name = name;
    this.weight = weight;
    this.price = price;
  }//Package(String, Weight,int)
  
  public String toString()
  {
    return this.weight.amount + " " + this.weight.unit.abbrev + " package of " + this.name;
  }
  
  public Weight getWeight()
  {
    return this.weight;
  }

  public int getPrice()
  {
    return this.price;
  }
  public boolean getEquals(Package comp)
  {
    if (this.price == comp.price &&
        this.weight.unit.equals(comp.weight.unit) &&
        this.weight.amount == comp.weight.amount &&
        this.name.equals(comp.name))
      {
        return true;
      }//if
    else return false;
  }
}//class Package
