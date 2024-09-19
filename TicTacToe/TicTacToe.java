import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class TicTacToe implements ActionListener{

    Random random = new Random();
    JFrame frame = new JFrame("Tic-Tac-Toe");
    JPanel titlePanel = new JPanel();
    JPanel button_panel = new JPanel();
    JLabel textField = new JLabel();
    JButton[] buttons = new JButton[9];
    boolean player1_turn;

    TicTacToe(){

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 800);
        frame.getContentPane().setBackground(new Color(50,150,150));
        frame.setLayout(new BorderLayout());

        
        textField.setBackground(new Color(25,25,25));
        textField.setForeground(new Color(25,255,0));
        textField.setFont(new Font("Ink Free", Font.BOLD, 75));
        textField.setHorizontalAlignment(JLabel.CENTER);
        textField.setText("Tic-Tac-Toe");
        textField.setOpaque(true);

        titlePanel.setLayout(new BorderLayout());
        titlePanel.setBounds(0, 0, 800, 100);

        button_panel.setLayout(new GridLayout(3,3));  
        button_panel.setBackground(new Color(150, 50, 50));

        for(int i = 0; i< 9; i++){
            buttons[i] = new JButton();
            button_panel.add(buttons[i]);
            buttons[i].setFont(new Font("MV Boli", Font.BOLD, 120));
            buttons[i].setFocusable(false);
            buttons[i].addActionListener(this);
        }


        titlePanel.add(textField);
        frame.add(titlePanel, BorderLayout.NORTH);
        frame.add(button_panel);


        frame.setVisible(true);

        firstTurn();

    }// end Constructor


    @Override
    public void actionPerformed(ActionEvent e) {

        for(int i = 0; i< 9; i++){
            if(e.getSource() == buttons[i]){
                if(player1_turn){
                    if(buttons[i].getText() == ""){
                        buttons[i].setForeground(new Color(255,0,0));
                        buttons[i].setText("X");
                        player1_turn = false;
                        textField.setText("O Turn");
                        check();
                    }
                }
                else{
                    if(buttons[i].getText() == ""){
                        buttons[i].setForeground(new Color(255,0,0));
                        buttons[i].setText("O");
                        player1_turn = true;
                        textField.setText("X Turn");
                        check();
                    }
                }
                
            }
        }
      
    }// end ActoinListener

    public void firstTurn(){

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        if(random.nextInt(2) == 0){
            player1_turn = true;
            textField.setText("X Turn");
        }
        else{
            player1_turn = false;
            textField.setText("O turn");
        }

    }

    public void check(){
        // X wins
        if(
            (buttons[0].getText().equals("X"))&&
            buttons[1].getText().equals("X")&&
            buttons[2].getText().equals("X")
            ){
                xWins(0, 1, 2);

        }
        if(
            (buttons[3].getText() .equals("X"))&&
            buttons[4].getText() .equals("X")&&
            buttons[5].getText() .equals("X")
            ){
                xWins(3, 4, 5);

        }
        if(
            (buttons[6].getText() .equals("X"))&&
            buttons[7].getText() .equals("X")&&
            buttons[8].getText() .equals("X")
            ){
                xWins(6, 7, 8);

        }

        if(
            (buttons[0].getText() .equals("X"))&&
            buttons[3].getText() .equals("X")&&
            buttons[6].getText() .equals("X")
            ){
                xWins(0, 3, 6);

        }
        if(
            (buttons[1].getText() .equals("X"))&&
            buttons[4].getText() .equals("X")&&
            buttons[7].getText() .equals("X")
            ){
                xWins(1, 4, 7);

        }
        if(
            (buttons[2].getText() .equals("X"))&&
            buttons[5].getText() .equals("X")&&
            buttons[8].getText() .equals("X")
            ){
                xWins(2, 5, 8);

        }
        if(
            (buttons[0].getText() .equals("X"))&&
            buttons[4].getText() .equals("X")&&
            buttons[7].getText() .equals("X")
            ){
                xWins(0, 4, 7);

        }
        if(
            (buttons[2].getText() .equals("X"))&&
            buttons[4].getText() .equals("X")&&
            buttons[6].getText() .equals("X")
            ){
                xWins(2, 4, 6);

        } 


        // O wins

        if(
            (buttons[0].getText() .equals("O"))&&
            buttons[1].getText() .equals("O")&&
            buttons[2].getText() .equals("O")
            ){
                buttons[0].setBackground(Color.green);
                buttons[1].setBackground(Color.green);
                buttons[2].setBackground(Color.green);
                oWins(0, 1, 2);

        }
        if(
            (buttons[3].getText() .equals("O"))&&
            buttons[4].getText() .equals("O")&&
            buttons[5].getText() .equals("O")
            ){
                buttons[3].setBackground(Color.green);
                buttons[4].setBackground(Color.green);
                buttons[5].setBackground(Color.green);
                oWins(3, 4, 5);

        }
        if(
            (buttons[6].getText() .equals("O"))&&
            buttons[7].getText() .equals("O")&&
            buttons[8].getText() .equals("O")
            ){
                buttons[6].setBackground(Color.green);
                buttons[7].setBackground(Color.green);
                buttons[8].setBackground(Color.green);
                oWins(6, 7, 8);

        }

        if(
            (buttons[0].getText() .equals("O"))&&
            buttons[3].getText() .equals("O")&&
            buttons[6].getText() .equals("O")
            ){
                buttons[0].setBackground(Color.green);
                buttons[3].setBackground(Color.green);
                buttons[6].setBackground(Color.green);
                oWins(0, 3, 6);

        }
        if(
            (buttons[1].getText() .equals("O"))&&
            buttons[4].getText() .equals("O")&&
            buttons[7].getText() .equals("O")
            ){
                buttons[1].setBackground(Color.green);
                buttons[4].setBackground(Color.green);
                buttons[7].setBackground(Color.green);
                oWins(1, 4, 7);

        }
        if(
            (buttons[2].getText() .equals("O"))&&
            buttons[5].getText() .equals("O")&&
            buttons[8].getText() .equals("O")
            ){
                buttons[2].setBackground(Color.green);
                buttons[5].setBackground(Color.green);
                buttons[8].setBackground(Color.green);
                oWins(2, 5, 8);

        }
        if(
            (buttons[0].getText() .equals("O"))&&
            buttons[4].getText() .equals("O")&&
            buttons[7].getText() .equals("O")
            ){
                buttons[0].setBackground(Color.green);
                buttons[4].setBackground(Color.green);
                buttons[7].setBackground(Color.green);
                oWins(0, 4, 7);

        }
        if(
            (buttons[2].getText() .equals("O"))&&
            buttons[4].getText() .equals("O")&&
            buttons[6].getText() .equals("O")
            ){
                buttons[2].setBackground(Color.green);
                buttons[4].setBackground(Color.green);
                buttons[6].setBackground(Color.green);
                oWins(2, 4, 6);

        } 


    }// end check method

    public void xWins(int a, int b, int c){
        // buttons[a].setBackground(Color.green);
        // buttons[b].setBackground(Color.green);
        // buttons[c].setBackground(Color.green);
        textField.setText("X Wins");

        for(int i = 0; i<9; i++){
            buttons[i].setEnabled(false);
        }

    }

    public void oWins(int a, int b, int c){
        buttons[a].setBackground(Color.green);
        buttons[b].setBackground(Color.green);
        buttons[c].setBackground(Color.green);
        textField.setText("O Wins");

        for(int i = 0; i< 9; i++){
            buttons[i].setEnabled(false);
        }
    }

    
}// end class
