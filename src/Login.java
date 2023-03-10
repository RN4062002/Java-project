import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Login extends JFrame  implements ActionListener {
    JLabel l1, l2;
    JTextField t1;
    JPasswordField t2;
    JButton b1, b2;

    Login() {

        setLayout(null);

        l1 = new JLabel("Username");
        l1.setBounds(40, 20, 100, 30);
        add(l1);

        l2 = new JLabel("Password");
        l2.setBounds(40, 70, 100, 30);
        add(l2);

        t1 = new JTextField();
        t1.setBounds(150, 20, 150, 30);
        add(t1);

        t2 = new JPasswordField();
        t2.setBounds(150, 70, 150, 30);
        add(t2);

        b1 = new JButton("Login");
        b1.setBounds(40, 140, 120, 30);
        b1.setFont(new Font("serif", Font.BOLD, 15));
        b1.addActionListener(this);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        add(b1);

        b2 = new JButton("Cancel");
        b2.setBounds(180, 140, 120, 30);
        b2.setFont(new Font("serif", Font.BOLD, 15));
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.addActionListener(this);
        getContentPane().setBackground(Color.WHITE);
        add(b2);

        setVisible(true);
        setSize(600, 300);
        setLocation(500, 230);

    }

    public static void main(String[] args) {
        new Login();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
         if(e.getSource() == b1){

             String username = t1.getText();
             String password = t2.getText();

             try{
                 Conn c = new Conn();
                 String query = "select * from login where username = '"+username+"' and password = '"+password+"'";
                 ResultSet rs = c.s.executeQuery(query);
                 if (rs.next()) {
                     setVisible(false);
                     new Home();
                 } else {
                     JOptionPane.showMessageDialog(null, "Invalid username or password");
                     setVisible(false);
                 }
             }catch (Exception e1){
                 e1.printStackTrace();
             }
         }
         else
         {
            setVisible(false);
         }
    }
}