import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Register extends JFrame implements ActionListener {

    JTextField fname, lname, tfaddress, tfusername;
    JPasswordField pass,repass;
    JButton b1,b2;
    Register()
    {
        JLabel heading = new JLabel("Employee Registration");
        heading.setBounds(320, 30, 500, 50);
        heading.setFont(new Font("SAN_SERIF", Font.BOLD, 25));
        add(heading);

        JLabel lfname = new JLabel("First Name");
        lfname.setBounds(50, 150, 150, 30);
        lfname.setFont(new Font("serif", Font.PLAIN, 20));
        add(lfname);

        fname = new JTextField();
        fname.setBounds(200, 150, 150, 30);
        add(fname);

        JLabel llname = new JLabel("Last Name");
        llname.setBounds(400, 150, 150, 30);
        llname.setFont(new Font("serif", Font.PLAIN, 20));
        add(llname);

        lname = new JTextField();
        lname.setBounds(600, 150, 150, 30);
        add(lname);

        JLabel lusername = new JLabel("Username");
        lusername.setBounds(50, 200, 150, 30);
        lusername.setFont(new Font("serif", Font.PLAIN, 20));
        add(lusername);

        tfusername = new JTextField();
        tfusername.setBounds(200,200,150,30);
        add(tfusername);

        JLabel lpassword = new JLabel("Password");
        lpassword.setBounds(400, 200, 150, 30);
        lpassword.setFont(new Font("serif", Font.PLAIN, 20));
        add(lpassword);

        pass = new JPasswordField();
        pass.setBounds(600, 200, 150, 30);
        add(pass);

        JLabel laddress = new JLabel("Address");
        laddress.setBounds(50, 250, 150, 30);
        laddress.setFont(new Font("serif", Font.PLAIN, 20));
        add(laddress);

        tfaddress = new JTextField();
        tfaddress.setBounds(200, 250, 150, 30);
        add(tfaddress);

        JLabel rpassword = new JLabel("Confirm Password");
        rpassword.setBounds(400, 250, 150, 30);
        rpassword.setFont(new Font("serif", Font.PLAIN, 20));
        add(rpassword);

        repass = new JPasswordField();
        repass.setBounds(600, 250, 150, 30);
        add(repass);

        b1 = new JButton("Submit");
        b1.setBounds(250, 550, 150, 40);
        b1.setFont(new Font("serif", Font.BOLD, 15));
        b1.addActionListener(this);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        add(b1);

        b2 = new JButton("Cancel");
        b2.setBounds(450, 550, 150, 40);
        b2.setFont(new Font("serif", Font.BOLD, 15));
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        add(b2);

        b2.addActionListener(this);

        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(900, 700);
        setLocation(300, 50);
        setVisible(true);

    }



    public static void main(String[] args) {

        new Register();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == b1)
        {
            String name = fname.getText();
            String lastName = lname.getText();
            String username = tfusername.getText();
            String address = tfaddress.getText();
            String password = pass.getText();
            String rePassword = repass.getText();

            try{
                Conn c = new Conn();
                String query = "insert into register values('"+name+"','"+lastName+"','"+username+"','"+address+"','"+password+"', '"+rePassword+"')";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Details added successfully");
                setVisible(false);
                new Main();
            }catch(Exception e1){
                e1.printStackTrace();
            }
        }
        else
        {
           setVisible(false);
        }
    }
}
