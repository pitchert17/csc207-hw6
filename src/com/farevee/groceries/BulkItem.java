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
    return this.amount + "of" + this.food.toString();
  }// toString()
  
  public Weight getWeight()
  {
    return new Weight(this.unit, this. amount);
  }// getWeight()
  
  public int getPrice()
  {
    return (this.amount * this.food.pricePerUnit);
  }
}


