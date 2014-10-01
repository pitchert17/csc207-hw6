package edu.grinnell.csc207.pitchert17.layout;

public class CenteredBlock
    implements TextBlock
{
  TextBlock block;
  int width;

  public CenteredBlock(TextBlock tb, int width) throws Exception
  {
    if (width < tb.width())
      throw new Exception("Invalid Width");

    this.block = tb;
    this.width = width;
  }//CenteredBlock(TextBlock, int)

  public String row(int i)
    throws Exception
  {
    if (i > this.block.height())
      throw new Exception("Invalid Row " + i);

    int start = (this.width - this.block.width()) / 2;
    int end = this.width - start - this.block.width();
    return TBUtils.spaces(start) + this.block.row(i) + TBUtils.spaces(end);
  }//row(int)

  public int width()
  {
    return this.width;
  }//width()

  public int height()
  {
    return this.block.height();
  }//height()
}//ckass CenteredBlock
