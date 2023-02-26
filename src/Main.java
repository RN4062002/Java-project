import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JFrame implements ActionListener {
    JButton Login, Register,admin;

    Main() {

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/green.jpg"));
        Image i2 = i1.getImage().getScaledInstance(600,300,Image.SCALE_DEFAULT);
        ImageIcon i3 =  new ImageIcon(i2);
        JLabel l3 = new JLabel(i3);
        l3.setBounds(0,0,600,300);
        add(l3);

        JLabel h1 = new JLabel("Welcome To");
        h1.setBounds(200, 10, 500, 50);
        h1.setForeground(Color.WHITE);
        h1.setFont(new Font("Arial", Font.BOLD, 30));
        l3.add(h1);

        JLabel heading = new JLabel("Health Care Support");
        heading.setBounds(150, 50, 500, 50);
        heading.setForeground(Color.WHITE);
        heading.setFont(new Font("Arial", Font.BOLD, 30));
        l3.add(heading);


        Login = new JButton("Login");
        Login.setBounds(50, 150, 150, 40);
        Login.setFont(new Font("serif", Font.BOLD, 15));
        Login.setBackground(Color.BLACK);
        Login.setForeground(Color.WHITE);
        Login.addActionListener(this);
        l3.add(Login);

        Register = new JButton("Register");
        Register.setBounds(210, 150, 150, 40);
        Register.setFont(new Font("serif", Font.BOLD, 15));
        Register.setBackground(Color.BLACK);
        Register.setForeground(Color.WHITE);
        Register.addActionListener(this);
        l3.add(Register);

        admin = new JButton("Admin Login");
        admin.setBounds(370, 150, 150, 40);
        admin.setFont(new Font("serif", Font.BOLD, 15));
        admin.setBackground(Color.BLACK);
        admin.setForeground(Color.WHITE);
        admin.addActionListener(this);
        l3.add(admin);

        setLayout(null);
        setUndecorated(true);
        setSize(600, 300);
        setLocation(480, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Home");
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == Login) {
            new Login().setVisible(true);
            setVisible(false);
        }else if (e.getSource() == Register){
            new Register().setVisible(true);
            setVisible(false);
        }
        else if(e.getSource() == admin)
        {
            new AdminPanel().setVisible(true);
           setVisible(false);
        }
    }
    public static void main(String[] args) {

        new Main();
    }


}