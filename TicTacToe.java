import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class TicTacToe implements ActionListener {
    //creating the outside, need instance variables


    public TicTacToe() { // constructor - called when the object is made
        

    }

    // basically what to do when something happens. you can see it takes an "event" 
    // which is like when you click a button or a key clicked or something. 
    // in this case we make a copy of the button that was clicked
    // ActionEvent e is basically just like any event that occured, and we name it e
    // as a placeholder so we can use it elsewhere
    // e.getSource 
    public void actionPerformed(ActionEvent e) {
        
    }

    public void checkForWinner() {      // exactly what it says it does!
        // Check rows
        

        // Check columns
        

        // Check diagonals
        

        // Check for tie
        
    }

    public void resetGame() {
        
    }

    public static void main(String[] args) {
        // a main method so we can play our game!
    }
}