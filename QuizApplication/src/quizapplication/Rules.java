
package quizapplication;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Rules extends JFrame implements ActionListener {

    String name;
    JButton start, back;

    Rules(String name) {
        this.name = name;
        getContentPane().setBackground(Color.white);
        setLayout(null);

        JLabel heading = new JLabel("Welcome " + name + " to JavaGenius Quiz");
        heading.setBounds(100, 60, 700, 45);
        heading.setFont(new Font("Arial BOLD", Font.BOLD, 30));
        heading.setForeground(new Color(52, 168, 235));
        add(heading);

        JLabel rules = new JLabel();
        rules.setBounds(100, 80, 700, 500);
        rules.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        rules.setText(
                "<html>" +

                        "1. You will have a total of 10 questions on Java" + "<br><br>" +
                        "2. You will be given 30 seconds to answer each question" + "<br><br>" +
                        "3. After selecting an option, you have to click submit" + "<br><br>" +
                        "4. If you don't answer the question within 30 seconds, the quiz will move to the next question"
                        + "<br><br>" +
                        "5. You also have a lifeline called 50-50" + "<br><br>" +
                        "6. Using 50-50 will eliminate two wrong answers, and then you have to choose from the remaining two options"
                        + "<br><br>" +
                        "7. After answering all 10 questions, you have to click the submit button to submit the quiz"
                        + "<br><br>" +
                        "8. After the submission, your score will be displayed on the screen" + "<br><br>" +
                        "ALL THE BEST!" + "<br><br>" +
                        "<html>"

        );
        add(rules);

        back = new JButton("Back");
        back.setBounds(100, 540, 120, 35);
        back.setForeground(new Color(52, 168, 235));
        back.setFont(new Font("Mongolian Baiti", Font.BOLD, 16));
        back.addActionListener(this);
        add(back);

        start = new JButton("Start");
        start.setBounds(550, 540, 120, 35);
        start.setForeground(new Color(52, 168, 235));
        start.setFont(new Font("Mongolian Baiti", Font.BOLD, 16));
        start.addActionListener(this);
        add(start);

        setVisible(true);

        setSize(800, 650);
        setLocation(350, 100);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == start) {
            setVisible(false);
            new Quiz(name);

        } else {
            setVisible(false);
            new Login();
        }
    }

    public static void main(String[] args) {
        new Rules("User");
    }

}
