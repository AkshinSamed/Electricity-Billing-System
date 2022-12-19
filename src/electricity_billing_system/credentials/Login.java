package electricity_billing_system.credentials;

import electricity_billing_system.dao.Conn;

import javax.print.attribute.standard.JobOriginatingUserName;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener {

    JLabel l1, l2, l3, l4;
    JTextField tf1;
    JPasswordField pf2;
    JButton b1, b2, b3;
    JPanel p1, p2, p3, p4;
    Choice c1;

    Login(){
        super("Login Page");
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        //Labels
        l1 = new JLabel("Username");
        l1.setBounds(300, 20, 100, 20);
        add(l1);

        l2 = new JLabel("Password");
        l2.setBounds(300, 60, 100, 20);
        add(l2);

        //Text and Password Field
        tf1 = new JTextField(15);
        tf1.setBounds(400, 20, 150, 20);
        add(tf1);

        pf2 = new JPasswordField(15);
        pf2.setBounds(400, 60, 150, 20);
        add(pf2);

        // Panel for select role
        l4 = new JLabel("Logging in as");
        l4.setBounds(300, 100, 100, 20);
        add(l4);

        c1.add("Admin");
        c1.add("Customer");
        c1.setBounds(400,100, 150, 20);
        add(c1);

        //Icons
        ImageIcon ic1 = new ImageIcon(ClassLoader.getSystemResource("icon/login.png"));
        Image i1 = ic1.getImage().getScaledInstance(16, 16, Image.SCALE_DEFAULT);
        b1 = new JButton("Login", new ImageIcon(i1));
        b1.setBounds(330, 160, 100, 20);
        add(b1);

        ImageIcon ic2 = new ImageIcon(ClassLoader.getSystemResource("icon/cancel.jpg"));
        Image i2 = ic2.getImage().getScaledInstance(16, 16, Image.SCALE_DEFAULT);
        b2 = new JButton("Cancel", new ImageIcon(i2));
        b2.setBounds(450, 160, 100, 20);
        add(b2);

        ImageIcon ic3 = new ImageIcon(ClassLoader.getSystemResource("icon/signup.png"));
        Image i3 = ic3.getImage().getScaledInstance(16, 16, Image.SCALE_DEFAULT);
        b3 = new JButton("Signup", new ImageIcon(i1));
        b3.setBounds(380, 160, 100, 20);
        add(b3);

        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);

        ImageIcon ic4 = new ImageIcon(ClassLoader.getSystemResource("icon/second.jpg"));
        Image i4 = ic4.getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT);
        ImageIcon icc4 = new ImageIcon(i4);
        l3 = new JLabel(icc4);
        l3.setBounds(0, 0, 250, 250);
        add(l3);

        setLayout(new BorderLayout());

        setSize(640,300);
        setLocation(600, 300);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == b1){
            try{
                Conn conn = new Conn();
                String username = tf1.getText();
                String password = pf2.getPassword().toString();
                String user = c1.getSelectedItem();
                String query = "SELECT * FROM LOGIN WHERE USERNAME = " + username +
                               " PASSWORD = " + password + " USER = " + user;
                ResultSet resultSet = conn.statement.executeQuery(query);
                if(resultSet.next()){
                    String meter = resultSet.getString("meter_no");
                     new Project(meter, user).setVisible(true);
                     this.setVisible(false);
                }
                else{
                    JOptionPane.showMessageDialog(null, "Bad credentials");
                    tf1.setText("");
                    pf2.setText("");

                }
            }catch (Exception exception){
                exception.printStackTrace();
                System.out.println("Error: " + exception);
            }
        }
        else if(e.getSource() == b2){
            this.setVisible(false);
        }
        else if(e.getSource() == b3){
            this.setVisible(false);
            new Signup().setVisible(true);
        }
    }

    public static void main(String[] args) {
        new Login().setVisible(true);
    }

}