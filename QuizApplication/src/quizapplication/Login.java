package quizapplication;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Login extends JFrame implements ActionListener {
    JButton rules, back;
    JTextField tfname;

    Login() {
        getContentPane().setBackground(Color.white);
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/login.jpeg"));
        JLabel image = new JLabel(i1);
        image.setBounds(0, 0, 600, 500);
        add(image);

        JLabel heading = new JLabel("JavaGenius Quiz");
        heading.setBounds(745, 60, 300, 45);
        heading.setFont(new Font("Arial BOLD", Font.BOLD, 35));
        heading.setForeground(new Color(52, 168, 235));
        add(heading);

        JLabel name = new JLabel("Enter your name");
        name.setBounds(780, 150, 300, 45);
        name.setFont(new Font("Mongolian Baiti", Font.BOLD, 25));
        name.setForeground(new Color(52, 168, 235));
        add(name);

        rules = new JButton("Rules");
        rules.setBounds(735, 280, 120, 35);
        rules.setForeground(new Color(52, 168, 235));
        rules.setFont(new Font("Mongolian Baiti", Font.PLAIN, 16));
        rules.addActionListener(this);
        add(rules);

        back = new JButton("Back");
        back.setBounds(915, 280, 120, 35);
        back.setForeground(new Color(52, 168, 235));
        back.setFont(new Font("Mongolian Baiti", Font.PLAIN, 16));
        back.addActionListener(this);
        add(back);

        tfname = new JTextField();
        tfname.setBounds(735, 210, 300, 35);
        tfname.setFont(new Font("Times New Roman", Font.BOLD, 20));
        add(tfname);

        setSize(1200, 500);
        setLocation(200, 150);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == rules) {
            String name = tfname.getText();
            setVisible(false);
            new Rules(name);

        } else if (ae.getSource() == back) {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new Login();
    }

}
