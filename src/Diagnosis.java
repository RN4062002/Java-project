import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class Diagnosis extends JFrame implements ActionListener {
    JTextField dname,symptoms,Medicines,diagnosis;
    JRadioButton yes,no;
    JButton add,back;
    JLabel lblempId;
    Diagnosis(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel heading = new JLabel(" Diagnosis Detail");
        heading.setBounds(320, 30, 500, 50);
        heading.setFont(new Font("SAN_SERIF", Font.BOLD, 25));
        add(heading);

        JLabel l1 = new JLabel("Doctor Appointed");
        l1.setBounds(50, 150, 150, 30);
        l1.setFont(new Font("serif", Font.PLAIN, 20));
        add(l1);

        dname = new JTextField();
        dname.setBounds(200, 150, 150, 30);
        add(dname);

        JLabel l2 = new JLabel("Symptoms");
        l2.setBounds(450, 150, 150, 30);
        l2.setFont(new Font("serif", Font.PLAIN, 20));
        add(l2);

        symptoms = new JTextField();
        symptoms.setBounds(600, 150, 150, 30);
        add(symptoms);

        JLabel l3 = new JLabel("Diagnosis");
        l3.setBounds(50, 200, 150, 30);
        l3.setFont(new Font("serif", Font.PLAIN, 20));
        add(l3);

        diagnosis = new JTextField();
        diagnosis.setBounds(200, 200, 150, 30);
        add(diagnosis);

        JLabel l4 = new JLabel("Medicines");
        l4.setBounds(450, 200, 150, 30);
        l4.setFont(new Font("serif", Font.PLAIN, 20));
        add(l4);

        Medicines = new JTextField();
        Medicines.setBounds(600, 200, 150, 30);
        add(Medicines);

        JLabel l5 = new JLabel("Admission Required");
        l5.setBounds(50, 250, 200, 30);
        l5.setFont(new Font("serif", Font.PLAIN, 20));
        add(l5);

        yes = new JRadioButton("yes");
        yes.setBounds(230, 250, 70, 30);
        yes.setBackground(Color.WHITE);
        add(yes);

        no = new JRadioButton("no");
        no.setBounds(300, 250, 70, 30);
        no.setBackground(Color.WHITE);
        add(no);

        ButtonGroup bg = new ButtonGroup();
        bg.add(yes);
        bg.add(no);

        lblempId = new JLabel("" );
        lblempId.setBounds(200, 400, 150, 30);
        lblempId.setFont(new Font("serif", Font.PLAIN, 20));
        add(lblempId);


        add = new JButton("Submit");
        add.setBounds(250, 550, 150, 40);
        add.addActionListener(this);
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add(add);

        back = new JButton("Cancel");
        back.setBounds(450, 550, 150, 40);
        back.addActionListener(this);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        add(back);

        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE );
        setSize(900, 700);
        setLocation(300, 50);
        setVisible(true);
    }

    public static void main(String[] args) {

        new Diagnosis();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
            if(e.getSource() == add)
            {
                String pid = "121";
               String name = dname.getText();
               String symp = symptoms.getText();
               String medi = Medicines.getText();
               String digno = diagnosis.getText();
                String admission = null;
                if (yes.isSelected()) {
                    admission = "yes";
                } else if (no.isSelected()) {
                    admission = "no";
                }

               try
               {
                   Conn c = new Conn();
                   String query = "insert into diagnosis values('"+name+"','"+symp+"','"+digno+"','"+medi+"','"+admission+"','"+pid+"')";
                   c.s.executeUpdate(query);
                   JOptionPane.showMessageDialog(null, "Details added successfully");
                   setVisible(false);
               } catch (SQLException ex) {
                   throw new RuntimeException(ex);
               }
            }else {
                setVisible(false);
                new Home().setVisible(true);
            }
    }
}
