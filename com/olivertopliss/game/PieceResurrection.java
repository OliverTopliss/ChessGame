//class that will handle the logic and GUI for choosing a piece to resurrect
package com.olivertopliss.game;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import com.olivertopliss.pieces.Piece;
public class PieceResurrection extends JFrame
{
  //constructor method
  public PieceResurrection()
  {
    setTitle("Choose a Piece to Ressurect");
    Container contents = getContentPane();
    contents.setLayout(new GridLayout(2, 0));

    JButton chooseRookButton = new JButton("Rook");
    JButton chooseKnightButton = new JButton("Knight");
    JButton chooseBishopButton = new JButton("Bishop");
    JButton chooseQueenButton = new JButton("Queen");

    contents.add(chooseRookButton);
    contents.add(chooseKnightButton);
    contents.add(chooseBishopButton);
    contents.add(chooseQueenButton);

    pack();

  }// PieceResurrection method
}//PieceRessurection Class