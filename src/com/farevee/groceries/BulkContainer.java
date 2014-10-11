package com.farevee.groceries;

public class BulkContainer
extends BulkItem
{
  String string;
  
  public BulkContainer(String string, BulkFood food, Units unit, int amount)
  {
  
    super(food, unit, amount);
    this.string = string;
  }
  
  public String toString()
  {
    return this.string + " of " + this.amount + this.unit.abbrev + " of " + food.name;
  }// toString()
  
  public Weight getWeight()
  {
    return new Weight(this.unit, this. amount);
  }// getWeight()
  
  public int getPrice()
  {
    return (this.amount * this.food.pricePerUnit);
  }
  
  public boolean getEquals(BulkContainer comp)
  {
    if (this.amount == comp.amount &&
        this.unit == comp.unit &&
        this.food == comp.food &&
        this.string == comp.string)
      {
        return true;
      }//if
    else return false;
  }//getEquals(BulkItem)
}
