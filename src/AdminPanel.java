import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminPanel extends JFrame implements ActionListener {
JButton add,view;
    AdminPanel(){
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/hhhh.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1120, 630, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 1120, 630);
        add(image);

        JLabel heading = new JLabel("Health Care Support System");
        heading.setBounds(300, 20, 400, 40);
        heading.setFont(new Font("Raleway", Font.BOLD, 25));
        image.add(heading);

        add = new JButton("Employee Details");
        add.setBounds(620, 80, 150, 40);
        add.addActionListener(this);
        image.add(add);

        view = new JButton("Patient Details");
        view.setBounds(620, 130, 150, 40);
        view.addActionListener(this);
        image.add(view);

        setSize(900, 700);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocation(300, 50);
        setVisible(true);
    }
    public static void main(String[] args) {
        new AdminPanel();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == view)
        {
            new ViewDetails().setVisible(true);
            setVisible(false);
        } else if (e.getSource() == add) {

        }
    }
}
