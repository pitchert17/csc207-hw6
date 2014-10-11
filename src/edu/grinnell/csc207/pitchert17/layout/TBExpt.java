package edu.grinnell.csc207.pitchert17.layout;

import java.io.PrintWriter;

/**
 * A series of experiments with the text block layout classes.
 * 
 * @author Samuel A. Rebelsky
 * @version 1.2 of September 2014
 */
public class TBExpt
{
  // +------+--------------------------------------------------------------
  // | Main |
  // +------+

  public static void main(String[] args)
    throws Exception
  {
    // Prepare for input and output
    PrintWriter pen = new PrintWriter(System.out, true);

    // Create a block to use
    TextBlock block = new TextLine("Hello");

    // Print out the block
    TBUtils.print(pen, block);

    //Testing Grid
    TextBlock block1 = new BoxedBlock(new Grid(7, 3, '*'));
    pen.println("Grid:");
    TBUtils.print(pen, block1);

    //Testing TruncatedBlock
    TextBlock blocka =
        new VComposition(new TextLine("Hello"), new TextLine("Goodbye"));
    TextBlock blockb = new TruncatedBlock(blocka, 3);
    TBUtils.print(pen, blocka);
    TBUtils.print(pen, blockb);

    //Testing CenteredBlock
    TextBlock centered = new CenteredBlock(blockb, 10);
    TBUtils.print(pen, centered);
   
    //Testing BlockPair
    TextBlock doubled = new BlockPair(blocka);
    TBUtils.print(pen, doubled);
    
    //Testing RightJustified
    TextBlock righted = new RightJustified(new TextLine("righty"), 10);
    
    TBUtils.print(pen, righted);
    //Testing Part B
    TextLine tb1 = new TextLine("Hello");
    TextLine tb2 = new TextLine("World");
    TextBlock compound =
        new BoxedBlock(
                       new CenteredBlock(
                                         new BoxedBlock(
                                                        new CenteredBlock(
                                                                          new VComposition(
                                                                                           tb1,
                                                                                           tb2),
                                                                          7)),
                                         15));
    pen.println("ORIGINAL");
    TBUtils.print(pen, compound);
    tb2.setContents("Someone");
    pen.println("UPDATED");
    TBUtils.print(pen, compound);
    tb1.setContents("Nice to meet you,");
    pen.println("RE-UPDATED");
    TBUtils.print(pen, compound);
    
    // Clean up after ourselves.
    pen.close();
  } // main(String[])

} // class TBExpt
