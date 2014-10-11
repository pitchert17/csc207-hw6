package edu.grinnell.csc207.pitchert17.layout;

public class RightJustified
    implements TextBlock
{
  TextBlock block;
  int width;
  int height;

  public RightJustified(TextBlock tb, int width)
  {
    this.block = tb;
    this.width = width;
  }

  public String row(int i)
    throws Exception
  {
    if ((i >= 0 && (i <= this.height)))
      {
        return TBUtils.spaces(this.width - this.block.width())
               + this.block.row(i);
      }//if
    else
      {
        throw new Exception("Invalid Row");
      }//else
  }//row(int)

  public int width()
  {
    return width;
  }//width()

  public int height()
  {
    return this.block.height();
  }//height()

}//class RightJustified