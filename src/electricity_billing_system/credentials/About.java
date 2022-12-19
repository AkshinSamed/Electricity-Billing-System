package electricity_billing_system.credentials;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
Step1: created about class
 */
public class About extends JFrame implements ActionListener {

    JButton button;
    JLabel label;
    Font font1, font2, font3;
    TextArea textArea;
    String text;

    public About(){

        setLayout(null);
        JButton exitButton = new JButton("Exit");
        add(exitButton);
        exitButton.setBounds(180, 430, 120, 20);
        exitButton.addActionListener(this);

        Font f = new Font("RALEWAY", Font.BOLD, 180);
        setFont(f);
        text = "Electricity Billing System\n"
                + "Software Application";

        TextArea textArea1 = new TextArea(text, 10, 40, Scrollbar.VERTICAL);
        textArea1.setEditable(false);
        textArea1.setBounds(20, 100, 450, 300);
        add(textArea1);

        Font f1 = new Font("RALEWAY", Font.BOLD, 16);
        setFont(f1);

        Container contentPane = this.getContentPane();
        textArea1 = new TextArea();

        JLabel l1 = new JLabel("About Project");
        add(l1);
        l1.setBounds(170, 10, 180, 80);
        l1.setForeground(Color.red);

        Font f2 = new Font("RALEWAY", Font.BOLD, 20);
        l1.setFont(f2);

        setBounds(700, 220, 500, 550);

        setLayout(null);
        setVisible(true);
    }
    

    @Override
    public void actionPerformed(ActionEvent e) {
        dispose();
    }

    public static void main(String []args){
        new About().setVisible(true);
    }
}
