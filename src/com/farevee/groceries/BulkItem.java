package com.farevee.groceries;

public class BulkItem
    implements Item
{
  BulkFood food;

  Units unit;

  int amount;
  
  public BulkItem(BulkFood food, Units unit, int amount)
  {
    this.food = food;
    this.unit = unit;
    this.amount = amount;
  }//BulkItem(BulkFood, Units, int)
  
  public String toString()
  {
    return this.amount + " " + this.unit.abbrev + " of " + this.food.name;
  }// toString()
  
  public Weight getWeight()
  {
    return new Weight(this.unit, this. amount);
  }// getWeight()
  
  public int getPrice()
  {
    return (this.amount * this.food.pricePerUnit);
  }//getPrice()
  public BulkFood food()
  {
  
    return this.food;
  } // food()
  
  public Units unit()
  {
  return this.unit;
  } // units()
  
  public int amount()
  {
  return this.amount;
  } // amount()
  
  public boolean getEquals(BulkItem comp)
  {
    if (this.amount == comp.amount &&
        this.unit == comp.unit &&
        this.food == comp.food)
      {
        return true;
      }//if
    else return false;
  }//getEquals(BulkItem)
}//class BulkItem


