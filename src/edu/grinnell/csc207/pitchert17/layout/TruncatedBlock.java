package edu.grinnell.csc207.pitchert17.layout;

public class TruncatedBlock
    implements TextBlock
{
  TextBlock block;

  int truncation;

  public TruncatedBlock(TextBlock tb, int width)
  {
    this.block = tb;
    this.truncation = width;
  }//TruncatedBlock(TextTBlock, int)

  public String row(int i)
    throws Exception
  {
    String givenRow = this.block.row(i);
    return givenRow.substring(0, this.truncation);
  }//row(int)

  public int height()
  {
    return this.block.height();
  }//height()

  public int width()
  {
    return this.truncation;
  }//width()
}// class TruncatedBlock

