package edu.grinnell.csc207.pitchert17.layout;

//generates a width by height grid consisting of character
public class Grid
    implements TextBlock
{
  //Fields
  int width;
  int height;
  char ch;

  //Constructors
  public Grid(int width, int height, char ch)
  {
    this.width = width;
    this.height = height;
    this.ch = ch;
  }

  //Methods
  public int width()
  {
    return this.width;
  }//width()

  public int height()
  {
    return this.height;
  }//height()

  public String row(int i) throws Exception
  {
    if ((i >= 0 && i <= this.height))
      {
        StringBuffer strbuf = new StringBuffer();
        int width = this.width;
        for (i = 0; i < width; i++)
          {
            strbuf.append(this.ch);
          }// loop for each of the rows
        //strbuf.append('\n');
        return strbuf.toString();
      }
    else
      {
        throw new Exception("Invalid row " + i);
      }
  }//row(int)

}//Grid(height, width, char)

