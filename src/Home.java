import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Home extends JFrame implements ActionListener {

    JButton view, add, bill, remove,help,about;

    Home() {
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/h.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1120, 630, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 1120, 630);
        add(image);

        JLabel heading = new JLabel("Health Care Support System");
        heading.setBounds(620, 20, 400, 40);
        heading.setFont(new Font("Raleway", Font.BOLD, 25));
        image.add(heading);

        add = new JButton("Add patient");
        add.setBounds(650, 80, 150, 40);
        add.addActionListener(this);
        image.add(add);

        view = new JButton("patient Details");
        view.setBounds(820, 80, 150, 40);
        view.addActionListener(this);
        image.add(view);

        bill = new JButton("patient Bill");
        bill.setBounds(650, 140, 150, 40);
        bill.addActionListener(this);
        image.add(bill);

        remove = new JButton("discharge patient");
        remove.setBounds(820, 140, 150, 40);
        remove.addActionListener(this);
        image.add(remove);

        help = new JButton("Help");
        help.setBounds(650, 200, 150, 40);
        help.addActionListener(this);
        image.add(help);

        about = new JButton("About US");
        about.setBounds(820, 200, 150, 40);
        about.addActionListener(this);
        image.add(about);

        setSize(1120, 630);
        setLocation(250, 100);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Home();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
      if(e.getSource() == add){
          new NewPatient().setVisible(true);
          setVisible(false);
      } else if (e.getSource() == view) {
             new ViewDetails().setVisible(true);
             setVisible(false);
      } else if (e.getSource() == bill) {
          new Bill().setVisible(true);
          setVisible(false);
      }else if (e.getSource() == help) {
          new Help().setVisible(true);
          setVisible(false);
      }else if (e.getSource() == about) {
          new About().setVisible(true);
          setVisible(false);
      }
    }
}
