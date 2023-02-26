import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Admin extends JFrame implements ActionListener {
JPasswordField t2;
JButton b1,b2;
    Admin(){

       JLabel l1 = new JLabel("Admin Login");
        l1.setBounds(150, 20, 200, 30);
        l1.setFont(new Font("serif", Font.BOLD, 25));
        add(l1);

       JLabel l2 = new JLabel("Password");
        l2.setBounds(40, 70, 100, 30);
        add(l2);

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
        add(b2);

        b2.addActionListener(this);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);
        setSize(600, 300);
        setLocation(500, 230);
    }
    public static void main(String[] args) {
        new Admin();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String password = t2.getText();
        if(e.getSource() == b1)
        {
            if (password.equals("admin"))
            {
                new AdminPanel().setVisible(true);
                setVisible(false);
            }else {
                JOptionPane.showMessageDialog(null, "Invalid password");
                setVisible(false);
            }

        }
    else if(e.getSource() == b2)
    {
        setVisible(false);
        new Main().setVisible(true);
    }

    }
}
