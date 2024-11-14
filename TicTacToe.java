import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class TicTacToe implements ActionListener {
    //creating the outside
    private JFrame frame; // full page
    private JPanel panel;// where you can put the buttons
    private JButton[] buttons = new JButton[9]; // for easy access
    private boolean xTurn = true; // just to know whether x is true or no

    public TicTacToe() { // constructor - called when the object is made
        frame = new JFrame("Tic-Tac-Toe");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 

        panel = new JPanel();
        panel.setLayout(new GridLayout(3, 3));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // margins

        for (int i = 0; i < 9; i++) {

            buttons[i] = new JButton();
            buttons[i].setFont(new Font("Arial", Font.PLAIN, 40));
            buttons[i].addActionListener(this); // Need to do this individually
            panel.add(buttons[i]);
        }

        frame.add(panel, BorderLayout.CENTER);
        frame.setSize(400, 400);
        frame.setVisible(true);
    }

    // basically what to do when something happens. you can see it takes an "event" 
    // which is like when you click a button or a key clicked or something. 
    // in this case we make a copy of the button that was clicked
    // ActionEvent e is basically just like any event that occured, and we name it e
    // as a placeholder so we can use it elsewhere
    // e.getSource 
    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton) e.getSource();
        if (xTurn) {
            button.setText("X");
            button.setBackground(new Color(255,0,200));
        } else {
            button.setText("O");
        }
        button.setEnabled(false); // it looks like a panel with text but really its
        // a button for convenience with the enabling turned off. this is useful for 
        // projects when you don't want something to move unless something held, or
        // you've reached the end and want to show the player, etc. 
        xTurn = !xTurn;
        // exclamation point is NOT. it just does the opposite
        checkForWinner();// after every time, it checks for a winner
    }

    public void checkForWinner() {
        // Check rows
        for (int i = 0; i < 9; i += 3) {
            if (buttons[i].getText().equals(buttons[i+1].getText()) && buttons[i].getText().equals(buttons[i+2].getText()) && !buttons[i].isEnabled()) {
                JOptionPane.showMessageDialog(frame, buttons[i].getText() + " wins!"); // pop up!!
                resetGame();
                return;
            }
        }

        // Check columns
        for (int i = 0; i < 3; i++) {
            if (buttons[i].getText().equals(buttons[i+3].getText()) && buttons[i].getText().equals(buttons[i+6].getText()) && !buttons[i].isEnabled()) {
                JOptionPane.showMessageDialog(frame, buttons[i].getText() + " wins!");
                resetGame();
                return;
            }
        }

        // Check diagonals
        if (buttons[0].getText().equals(buttons[4].getText()) && buttons[0].getText().equals(buttons[8].getText()) && !buttons[0].isEnabled()) {
            JOptionPane.showMessageDialog(frame, buttons[0].getText() + " wins!");
            resetGame();
            return;
        }
        if (buttons[2].getText().equals(buttons[4].getText()) && buttons[2].getText().equals(buttons[6].getText()) && !buttons[2].isEnabled()) {
            JOptionPane.showMessageDialog(frame, buttons[2].getText() + " wins!");
            resetGame();
            return;
        }

        // Check for tie
        boolean tie = true;
        for (int i = 0; i < 9; i++) {
            if (buttons[i].isEnabled()) {
                tie = false;
                break;
            }
        }
        if (tie) {
            JOptionPane.showMessageDialog(frame, "Tie game!");
            resetGame();
        }
    }

    public void resetGame() {
        for (int i = 0; i < 9; i++) {
            buttons[i].setText("");
            buttons[i].setBackground(null);
            buttons[i].setEnabled(true);
        }
        xTurn = true;
    }

    public static void main(String[] args) {
        new TicTacToe();
    }
}