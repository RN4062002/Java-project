import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Bill extends JFrame implements ActionListener {
JButton back, tbill;
String t;
JTextField txt1,txt2,txt3,txt4,total;
    Bill()
    {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel heading = new JLabel(" Patient Bill");
        heading.setBounds(320, 30, 500, 50);
        heading.setFont(new Font("SAN_SERIF", Font.BOLD, 25));
        add(heading);

        JLabel l1 = new JLabel("Number of Day patient stayed");
        l1.setBounds(100,100,300,30);
        l1.setFont(new Font("SAN_SERIF", Font.PLAIN, 20));
        add(l1);

        JLabel l2 = new JLabel("Total Ward Charges");
        l2.setBounds(100,150,300,30);
        l2.setFont(new Font("SAN_SERIF", Font.PLAIN, 20));
        add(l2);

        JLabel l3 = new JLabel("Doctor Fees");
        l3.setBounds(100,200,300,30);
        l3.setFont(new Font("SAN_SERIF", Font.PLAIN, 20));
        add(l3);

        JLabel l4 = new JLabel("Services Charges");
        l4.setBounds(100,250,300,30);
        l4.setFont(new Font("SAN_SERIF", Font.PLAIN, 20));
        add(l4);

        JLabel l5 = new JLabel("Total Amount");
        l5.setBounds(100,300,300,30);
        l5.setFont(new Font("SAN_SERIF", Font.PLAIN, 20));
        add(l5);

        txt1 = new JTextField();
        txt1.setBounds(420,100,200,30);
        add(txt1);

        txt2 = new JTextField();
        txt2.setBounds(420,150,200,30);
        add(txt2);

        txt3 = new JTextField();
        txt3.setBounds(420,200,200,30);
        add(txt3);

        txt4 = new JTextField();
        txt4.setBounds(420,250,200,30);
        add(txt4);

        total = new JTextField();
        total.setBounds(420,300,200,30);
        total.setEditable(false);
        total.setBackground(Color.WHITE);
        add(total);


        tbill = new JButton("Total");
        tbill.setBounds(420, 350, 200, 30);
        tbill.setFont(new Font("serif", Font.BOLD, 15));
        tbill.setBackground(Color.BLACK);
        tbill.setForeground(Color.WHITE);
        tbill.addActionListener(this);
        add(tbill);

        back = new JButton("Back");
        back.setBounds(350, 600, 150, 40);
        back.setFont(new Font("serif", Font.BOLD, 15));
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);

        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE );
        setSize(900, 700);
        setLocation(300, 50);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Bill();
    }

    @Override
    public void actionPerformed(ActionEvent e) {


       if(e.getSource() == tbill)
       {

           int b1 = Integer.parseInt((txt1.getText()))* Integer.parseInt(txt2.getText()) + Integer.parseInt(txt3.getText()) + Integer.parseInt(txt4.getText());
            total.setText(Integer.toString(b1));

       }
       else if(e.getSource() == back)
       {
           setVisible(false);
           new Home().setVisible(true);

       }
    }
}
