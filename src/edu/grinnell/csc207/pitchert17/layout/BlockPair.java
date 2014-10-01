package edu.grinnell.csc207.pitchert17.layout;

public class BlockPair
    implements TextBlock
{
  TextBlock block;
  int height;
  int width;

  public BlockPair(TextBlock tb) throws Exception
  {
    this.block = tb;
  }

  public String row(int i)
    throws Exception
  {
    return this.block.row(i) + this.block.row(i);
  }//row(int)

  public int height()
  {
    return this.block.height();
  }//height()

  public int width()
  {
    return this.block.width() * 2;
  }//width()
}//class BlockPair
