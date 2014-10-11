package com.farevee.groceries;

public class ManyPackages
    implements Item
{
  Package pack;

  int count;

  public ManyPackages(Package pack, int count)
  {
    this.pack = pack;
    this.count = count;
  }

  public int getPrice()
  {
    return this.count * this.pack.price;
  }

  public Weight getWeight()
  {
    int amount = this.pack.weight.amount;
    amount *= this.count;
    return new Weight(this.pack.weight.unit, amount);
  }

  public String toString()
  {
    return this.count + "x" + this.pack.toString();
  }
  
  public Package getPack()
  {
    return this.pack;
  }
  
  public int getCount()
  {
    return this.count;
  }

  public boolean getEquals(ManyPackages comp)
  {
    if (comp == this)
      {
        return true;
      }//if
    else
      return false;
  }


}
