package edu.grinnell.csc207.pitchert17.layout;

import java.io.PrintWriter;

/**
 * A few simple experiments with our utilities.
 */
public class MathExpt 
{
  public static void main(String[] args)
    throws Exception
  {
    PrintWriter pen = new PrintWriter(System.out, true);

    // Print some square roots.
    for (int i = 2; i < 10; i++)
      {
       // double root = MathUtils.squareRoot(i);
        double root1 = MathUtils.squareRoot(Float.valueOf(i));
        pen.println("The square root of " + i + " seems to be " + root1);
        pen.println(root1 + "^2 = " + (root1 * root1));
      } // for i

    
    // We're done. Clean up.
    pen.close();
  } // main(String[])
} // class MathExpt
