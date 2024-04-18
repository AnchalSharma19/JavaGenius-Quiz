package quizapplication;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Score extends JFrame implements ActionListener {

    Score(String name, int score) {

        setBounds(400, 150, 750, 550);
        getContentPane().setBackground(Color.white);
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/score.jpeg"));
        Image i2 = i1.getImage().getScaledInstance(300, 270, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(20, 150, 390, 250);
        add(image);

        JLabel heading = new JLabel(" ThankYou " + name + " for playing JavaGenius ");
        heading.setBounds(160, 50, 700, 30);
        heading.setForeground(new Color(52, 168, 235));
        heading.setFont(new Font("Tahoma", Font.BOLD, 23));
        add(heading);

        JLabel lblscore = new JLabel(" Your Score is " + score);
        lblscore.setBounds(420, 230, 300, 30);
        lblscore.setFont(new Font("Tahoma", Font.BOLD, 23));
        add(lblscore);

        JButton submit = new JButton("Play Again");
        submit.setBounds(420, 300, 120, 40);
        submit.setFont(new Font("Tahoma", Font.PLAIN, 18));
        submit.setForeground(new Color(52, 168, 235));
        submit.addActionListener(this);
        add(submit);

        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae) {
        setVisible(false);
        new Login();
    }

    public static void main(String[] args) {
        new Score("User", 0);
    }

}
