package quizapplication;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Quiz extends JFrame implements ActionListener {

    String questions[][] = new String[10][5];
    String answers[][] = new String[10][5];
    String useranswers[][] = new String[10][1];
    JLabel qno, question;
    JButton next, lifeline, submit;
    JRadioButton opt1, opt2, opt3, opt4;
    public static int timer = 30;

    public static int ans_given = 0;
    ButtonGroup groupoptions;
    public static int count = 0;
    public static int score = 0;

    String name;

    Quiz(String name) {
        this.name = name;
        setBounds(50, 0, 1400, 850);
        getContentPane().setBackground(Color.white);
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/quiz3.jpeg"));
        Image i2 = i1.getImage().getScaledInstance(1400, 600, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 1400, 390);
        add(image);

        qno = new JLabel();
        qno.setBounds(100, 450, 50, 30);
        qno.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(qno);

        question = new JLabel("This is a question");
        question.setBounds(130, 450, 900, 30);
        question.setFont(new Font("Tahoma", Font.PLAIN, 21));
        add(question);

        questions[0][0] = "What is the time complexity of adding an element to the end of an ArrayList in Java?";
        questions[0][1] = "O(n)";
        questions[0][2] = "O(log n)";
        questions[0][3] = "O(1)";
        questions[0][4] = "O(n^2)";

        questions[1][0] = "Which data structure in Java uses First In First Out (FIFO) ordering?";
        questions[1][1] = "Queue";
        questions[1][2] = "Stack";
        questions[1][3] = "LinkedList";
        questions[1][4] = "TreeMap";

        questions[2][0] = "Which sorting algorithm has the worst-case time complexity of O(n^2) in Java?";
        questions[2][1] = "Bubble Sort";
        questions[2][2] = "Merge Sort";
        questions[2][3] = "Quick Sort";
        questions[2][4] = "Insertion Sort";

        questions[3][0] = "What does HashMap.containsKey(Object key) return if the key is not present in the map?";
        questions[3][1] = "False";
        questions[3][2] = "Null";
        questions[3][3] = "True";
        questions[3][4] = "Throws an Exception";

        questions[4][0] = "Which of the following data structures in Java does not implement the List interface?";
        questions[4][1] = "HashSet";
        questions[4][2] = "LinkedList";
        questions[4][3] = "Arraylist";
        questions[4][4] = "Vector";

        questions[5][0] = "Which search algorithm requires the data to be sorted in Java?";
        questions[5][1] = "Binary Search";
        questions[5][2] = "Linear Search";
        questions[5][3] = "Depth-First Search";
        questions[5][4] = "Breadth-First Search";

        questions[6][0] = "Which of the following statements is true regarding a TreeSet in Java?";
        questions[6][1] = "It allows null elements.";
        questions[6][2] = "It maintains insertion order.";
        questions[6][3] = "It is not synchronized.";
        questions[6][4] = "It allows duplicate elements.";

        questions[7][0] = "What is the time complexity of the contains() method in a HashSet in Java?";
        questions[7][1] = "O(1)";
        questions[7][2] = "O(n)";
        questions[7][3] = "O(log n)";
        questions[7][4] = "O(n^2)";

        questions[8][0] = "Which data structure in Java provides a way to store key-value pairs?";
        questions[8][1] = "TreeMap";
        questions[8][2] = "HashSet";
        questions[8][3] = "Array";
        questions[8][4] = "Stack";

        questions[9][0] = "Which of the following statements is true regarding a LinkedList in Java?";
        questions[9][1] = "It implements the queue interface.";
        questions[9][2] = "It is a synchronized data structure.";
        questions[9][3] = " It allows random access to elements.";
        questions[9][4] = "It uses contiguous memory allocation.";

        answers[0][1] = "O(n)";
        answers[1][1] = "Queue";
        answers[2][1] = "Bubble Sort";
        answers[3][1] = "False";
        answers[4][1] = "HashSet";
        answers[5][1] = "Binary Search";
        answers[6][1] = "It allows null elements.";
        answers[7][1] = "O(1)";
        answers[8][1] = "TreeMap";
        answers[9][1] = "It implements the queue interface.";

        opt1 = new JRadioButton();
        opt1.setBounds(170, 520, 700, 30);
        opt1.setBackground(Color.WHITE);
        opt1.setFont(new Font("Dialog", Font.PLAIN, 18));
        add(opt1);

        opt2 = new JRadioButton();
        opt2.setBounds(170, 570, 700, 30);
        opt2.setBackground(Color.WHITE);
        opt2.setFont(new Font("Dialog", Font.PLAIN, 18));
        add(opt2);

        opt3 = new JRadioButton();
        opt3.setBounds(170, 620, 700, 30);
        opt3.setBackground(Color.WHITE);
        opt3.setFont(new Font("Dialog", Font.PLAIN, 18));
        add(opt3);

        opt4 = new JRadioButton();
        opt4.setBounds(170, 670, 700, 30);
        opt4.setBackground(Color.WHITE);
        opt4.setFont(new Font("Dialog", Font.PLAIN, 18));
        add(opt4);

        groupoptions = new ButtonGroup();
        groupoptions.add(opt1);
        groupoptions.add(opt2);
        groupoptions.add(opt3);
        groupoptions.add(opt4);

        next = new JButton("Next");
        next.setBounds(1100, 500, 200, 40);
        next.setFont(new Font("Tahoma", Font.PLAIN, 19));
        next.setForeground(new Color(52, 168, 235));
        next.addActionListener(this);
        add(next);

        lifeline = new JButton("50-50 Lifeline");
        lifeline.setBounds(1100, 570, 200, 40);
        lifeline.setFont(new Font("Tahoma", Font.PLAIN, 19));
        lifeline.setForeground(new Color(52, 168, 235));
        lifeline.addActionListener(this);
        add(lifeline);

        submit = new JButton("Submit");
        submit.setBounds(1100, 640, 200, 40);
        submit.setFont(new Font("Tahoma", Font.PLAIN, 19));
        submit.setForeground(new Color(52, 168, 235));
        submit.addActionListener(this);
        submit.setEnabled(false);
        add(submit);

        start(count); // question number

        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == next) {
            repaint();
            opt1.setEnabled(true);
            opt2.setEnabled(true);
            opt3.setEnabled(true);
            opt4.setEnabled(true);

            ans_given = 1;

            if (groupoptions.getSelection() == null) {
                useranswers[count][0] = " ";

            } else {
                useranswers[count][0] = groupoptions.getSelection().getActionCommand();
            }

            if (count == 8) {
                next.setEnabled(false);
                submit.setEnabled(true);
            }

            count++;
            start(count);

        } else if (ae.getSource() == lifeline) {
            if (count == 2 || count == 4 || count == 6 || count == 8 || count == 9) {
                opt2.setEnabled(false);
                opt4.setEnabled(false);
            } else {
                opt1.setEnabled(false);
                opt3.setEnabled(false);
            }
            lifeline.setEnabled(false);

        } else if (ae.getSource() == submit) {

            ans_given = 1;
            if (groupoptions.getSelection() == null) {
                useranswers[count][0] = " ";

            } else {
                useranswers[count][0] = groupoptions.getSelection().getActionCommand();
            }
            for (int i = 0; i < useranswers.length; i++) {
                if (useranswers[i][0].equals(answers[i][1])) {
                    score += 10;
                } else {
                    score += 0;
                }
            }
            setVisible(false);
            new Score(name, score);
        }

    }

    public void paint(Graphics g) { // timer
        super.paint(g);

        String time = " Time Left : " + timer + " seconds ";
        g.setColor(Color.red);
        g.setFont(new Font("Tahoma", Font.BOLD, 18));

        if (timer > 0) {
            g.drawString(time, 1100, 500);
        } else {
            g.drawString("Time Over!", 1100, 500);
        }

        timer--;

        try {
            Thread.sleep(1000);
            repaint(); // will decrese the timer by 1 sec

        } catch (Exception e) {

            e.printStackTrace();
        }

        if (ans_given == 1) {
            ans_given = 0;
            timer = 30;
        } else if (timer < 0) {
            timer = 30;
            opt1.setEnabled(true);
            opt2.setEnabled(true);
            opt3.setEnabled(true);
            opt4.setEnabled(true);

            if (count == 8) {
                next.setEnabled(false);
                submit.setEnabled(true);
            }

            if (count == 9) {

                if (groupoptions.getSelection() == null) {
                    useranswers[count][0] = " ";

                } else {
                    useranswers[count][0] = groupoptions.getSelection().getActionCommand();
                }
                for (int i = 0; i < useranswers.length; i++) {
                    if (useranswers[i][0].equals(answers[i][1])) {
                        score += 10;
                    } else {
                        score += 0;
                    }
                }
                setVisible(false);
                new Score(name, score);
                // Score

            } else {

                if (groupoptions.getSelection() == null) {
                    useranswers[count][0] = " ";

                } else {
                    useranswers[count][0] = groupoptions.getSelection().getActionCommand();
                }

                count++;
                start(count);

            }

        }

    }

    public void start(int count) {
        qno.setText("" + (count + 1) + ".");
        question.setText(questions[count][0]);
        opt1.setText(questions[count][1]);
        opt1.setActionCommand(questions[count][1]);

        opt2.setText(questions[count][2]);
        opt2.setActionCommand(questions[count][2]);

        opt3.setText(questions[count][3]);
        opt3.setActionCommand(questions[count][3]);

        opt4.setText(questions[count][4]);
        opt4.setActionCommand(questions[count][4]);

        groupoptions.clearSelection();

    }

    public static void main(String[] args) {
        new Quiz("User");
    }

}
