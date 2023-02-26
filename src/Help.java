import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Help extends JFrame implements ActionListener {
    JButton back;
    Help(){


        JLabel heading = new JLabel("Help");
        heading.setBounds(380,30,200,30);
        heading.setFont(new Font("Arial",Font.BOLD,30));
        add(heading);

        JLabel l1 = new JLabel("1 >> Add New Patient Record       | A new patient file can be created by using this module. " );
        l1.setBounds(100,90,800,30);
//        l1.setFont(new Font("Arial",Font.PLAIN,20));
        add(l1);

        JLabel l2 = new JLabel("2 >> Add Diagnosis Information   | Adding day-to-day evaluation of the patient or the diagnosis report in the existing file.   " );
        l2.setBounds(100,120,800,30);
//        l2.setFont(new Font("Arial",Font.PLAIN,20));
        add(l2);

        JLabel l3 = new JLabel("3 >> History of the Patient            | Check the previous or existing details of particular patient by using their file name.  " );
        l3.setBounds(100,150,800,30);
//        l3.setFont(new Font("Arial",Font.PLAIN,20));
        add(l3);

        JLabel l4 = new JLabel("4 >> Bill of the patient                   | Generates the bill of the patient with displaying the details.  " );
        l4.setBounds(100,180,800,30);
//        l4.setFont(new Font("Arial",Font.PLAIN,20));
        add(l4);

        JLabel l5 = new JLabel("5 >> Help                                         | Provide the help documentation." );
        l5.setBounds(100,210,800,30);
//        l5.setFont(new Font("Arial",Font.PLAIN,20));
        add(l5);

        JLabel l6 = new JLabel("6 >> Exit                                          | Exits the application." );
        l6.setBounds(100,240,800,30);
//        l6.setFont(new Font("Arial",Font.PLAIN,20));
        add(l6);

        back = new JButton("Back");
        back.setBounds(390, 600, 150, 40);
        back.setFont(new Font("serif", Font.BOLD, 15));
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);

        setSize(900, 700);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocation(300, 50);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Help();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == back){
            new Home().setVisible(true);
            setVisible(false);
        }
    }
}
