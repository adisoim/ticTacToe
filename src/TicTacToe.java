import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class TicTacToe implements ActionListener {
    Random random = new Random();
    JFrame jFrame = new JFrame();
    JPanel titlePanel = new JPanel();
    JPanel buttonPanel = new JPanel();
    JLabel textField = new JLabel();
    JButton[] jButtons = new JButton[9];
    boolean player1Turn;

    TicTacToe() {
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setSize(800, 800);
        jFrame.getContentPane().setBackground(Color.DARK_GRAY);
        jFrame.setLayout(new BorderLayout());
        jFrame.setVisible(true);

        textField.setBackground(Color.BLACK);
        textField.setForeground(Color.GREEN);
        textField.setFont(new Font("Ink Free", Font.BOLD, 75));
        textField.setHorizontalAlignment(JLabel.CENTER);
        textField.setText("Tic-Tac-Toe");
        textField.setOpaque(true);

        titlePanel.setLayout(new BorderLayout());
        titlePanel.setBounds(0, 0, 800, 100);

        buttonPanel.setLayout(new GridLayout(3, 3));
        buttonPanel.setBackground(Color.GRAY);

        for (int i = 0; i < 9; i++) {
            jButtons[i] = new JButton();
            buttonPanel.add(jButtons[i]);
            jButtons[i].setFont(new Font("MV Boli", Font.BOLD, 120));
            jButtons[i].setFocusable(false);
            jButtons[i].addActionListener(this);
        }

        titlePanel.add(textField);
        jFrame.add(titlePanel, BorderLayout.NORTH);
        jFrame.add(buttonPanel);

        firstTurn();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < 9; i++) {
            if (e.getSource() == jButtons[i]) {
                if (player1Turn) {
                    if (jButtons[i].getText().equals("")) {
                        jButtons[i].setForeground(Color.RED);
                        jButtons[i].setText("X");
                        player1Turn = false;
                        textField.setText("O Turn");
                        check();
                    }
                } else {
                    if (jButtons[i].getText().equals("")) {
                        jButtons[i].setForeground(Color.BLUE);
                        jButtons[i].setText("O");
                        player1Turn = true;
                        textField.setText("X Turn");
                        check();
                    }
                }
            }
        }
    }

    public void firstTurn() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        if (random.nextInt(2) == 0) {
            player1Turn = true;
            textField.setText("X Turn");
        } else {
            player1Turn = false;
            textField.setText("O Turn");
        }
    }

    public void check() {
        //x wins
        if (
                (jButtons[0].getText().equals("X")) &&
                        (jButtons[1].getText().equals("X")) &&
                        (jButtons[2].getText().equals("X"))
        ) {
            xWins(0, 1, 2);
        }

        if (
                (jButtons[3].getText().equals("X")) &&
                        (jButtons[4].getText().equals("X")) &&
                        (jButtons[5].getText().equals("X"))
        ) {
            xWins(3, 4, 5);
        }

        if (
                (jButtons[6].getText().equals("X")) &&
                        (jButtons[7].getText().equals("X")) &&
                        (jButtons[8].getText().equals("X"))
        ) {
            xWins(6, 7, 8);
        }

        if (
                (jButtons[0].getText().equals("X")) &&
                        (jButtons[3].getText().equals("X")) &&
                        (jButtons[6].getText().equals("X"))
        ) {
            xWins(0, 3, 6);
        }

        if (
                (jButtons[1].getText().equals("X")) &&
                        (jButtons[4].getText().equals("X")) &&
                        (jButtons[7].getText().equals("X"))
        ) {
            xWins(1, 4, 7);
        }

        if (
                (jButtons[2].getText().equals("X")) &&
                        (jButtons[5].getText().equals("X")) &&
                        (jButtons[8].getText().equals("X"))
        ) {
            xWins(2, 5, 8);
        }

        if (
                (jButtons[0].getText().equals("X")) &&
                        (jButtons[4].getText().equals("X")) &&
                        (jButtons[8].getText().equals("X"))
        ) {
            xWins(0, 4, 8);
        }

        if (
                (jButtons[2].getText().equals("X")) &&
                        (jButtons[4].getText().equals("X")) &&
                        (jButtons[6].getText().equals("X"))
        ) {
            xWins(2, 4, 6);
        }

        //o wins
        if (
                (jButtons[0].getText().equals("O")) &&
                        (jButtons[1].getText().equals("O")) &&
                        (jButtons[2].getText().equals("O"))
        ) {
            oWins(0, 1, 2);
        }

        if (
                (jButtons[3].getText().equals("O")) &&
                        (jButtons[4].getText().equals("O")) &&
                        (jButtons[5].getText().equals("O"))
        ) {
            oWins(3, 4, 5);
        }

        if (
                (jButtons[6].getText().equals("O")) &&
                        (jButtons[7].getText().equals("O")) &&
                        (jButtons[8].getText().equals("O"))
        ) {
            oWins(6, 7, 8);
        }

        if (
                (jButtons[0].getText().equals("O")) &&
                        (jButtons[3].getText().equals("O")) &&
                        (jButtons[6].getText().equals("O"))
        ) {
            oWins(0, 3, 6);
        }

        if (
                (jButtons[1].getText().equals("O")) &&
                        (jButtons[4].getText().equals("O")) &&
                        (jButtons[7].getText().equals("O"))
        ) {
            oWins(1, 4, 7);
        }

        if (
                (jButtons[2].getText().equals("O")) &&
                        (jButtons[5].getText().equals("O")) &&
                        (jButtons[8].getText().equals("O"))
        ) {
            oWins(2, 5, 8);
        }

        if (
                (jButtons[0].getText().equals("O")) &&
                        (jButtons[4].getText().equals("0")) &&
                        (jButtons[8].getText().equals("O"))
        ) {
            oWins(0, 4, 8);
        }

        if (
                (jButtons[2].getText().equals("O")) &&
                        (jButtons[4].getText().equals("O")) &&
                        (jButtons[6].getText().equals("O"))
        ) {
            oWins(2, 4, 6);
        }
    }

    public void xWins(int a, int b, int c) {
        jButtons[a].setBackground(Color.GREEN);
        jButtons[b].setBackground(Color.GREEN);
        jButtons[c].setBackground(Color.GREEN);
        for (int i = 0; i < 9; i++) {
            jButtons[i].setEnabled(false);
        }
        textField.setText("X Wins");
    }

    public void oWins(int a, int b, int c) {
        jButtons[a].setBackground(Color.GREEN);
        jButtons[b].setBackground(Color.GREEN);
        jButtons[c].setBackground(Color.GREEN);
        for (int i = 0; i < 9; i++) {
            jButtons[i].setEnabled(false);
        }
        textField.setText("O Wins");
    }
}