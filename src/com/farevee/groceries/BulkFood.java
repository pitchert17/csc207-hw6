package com.farevee.groceries;

public class BulkFood
{
  String name;

  Units unit;

  int supply;

  int pricePerUnit;

  public BulkFood(String name, Units unit, int price, int supply)
  {
    this.name = name;
    this.unit = unit;
    this.pricePerUnit = price;
    this.supply = supply;
  }//BulkFood(String, Unit, int, int)
  
}//class BulkFood
