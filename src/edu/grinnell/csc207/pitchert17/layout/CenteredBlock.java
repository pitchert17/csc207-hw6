package edu.grinnell.csc207.pitchert17.layout;

public class CenteredBlock
    implements TextBlock
{
  // +--------+------------------------------------------------------------
  // | Fields |
  // +--------+
  /*
  * The TextBlock
  */
  TextBlock tb;
  /*
  * The width of the new block
  */
  int width;

  // +-------------+----------------------------------------------------------
  // | Constructors|
  // +-------------+
  /*
  * Creates a new block by centering the given one
  */
  public CenteredBlock(TextBlock tb, int width)
  {
    this.tb = tb;
    this.width = width;
  }//CenteredBlock (TextBlock, int)
  // +-------------+----------------------------------------------------------
  // | Methods |
  // +-------------+

  /**
  * Get one row from the block.
  *
  * @pre 0 <= i < this.height()
  * @exception Exception
  * if the precondition is not met
  */
  public String row(int i)
    throws Exception
  {
    String result;
    String space1;
    String space2;
    if ((i >= 0) & (i <= this.tb.height()))
      {
        if (this.width < this.tb.row(i).length())
          {
            throw new Exception("Invalid Width" + this.width);
          }//if
        else
          {
            space1 = TBUtils.spaces((this.width - this.tb.row(i).length()) / 2);
            space2 =
                TBUtils.spaces(this.width - this.tb.row(i).length()
                               - space1.length());
            result = space1.concat(this.tb.row(i)).concat(space2);
          }//else
      }//if
    else
      {
        throw new Exception("Invalid Row" + i);
      }//else
    return result;
  }//row (int)
  /*
  * Determines how many rows are in the block
  */

  public int height()
  {
    return this.tb.height();
  }//height()
  /*
  * Determines how many columns are in the block
  */

  public int width()
  {
    return this.width;
  }//width()
}//class CenteredBlock