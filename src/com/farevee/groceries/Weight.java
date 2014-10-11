package com.farevee.groceries;

public class Weight
{
  public Units unit;

  public int amount;
  
  public Weight(Units unit, int amount)
  {
    this.unit = unit;
    this.amount = amount;
  }//Weight
  
  public Units unit()
  {
    return this.unit;
  }//unit()
  
  public int amount()
  {
    return this.amount;
  }//amount()


}//class Weight
