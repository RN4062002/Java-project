import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class NewPatient extends JFrame implements ActionListener {
    Random ran = new Random();
    int number = ran.nextInt(999999);

    JTextField fname, lname, tfaddress, tfphone, tfaadhar, tfemail, tfage, tfdesignation;
    JDateChooser dcdob;

    JComboBox bgroup;
    JLabel lblempId;
    JButton add, back;

    JRadioButton maleRadioButton, femaleRadioButton;

    NewPatient() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel heading = new JLabel("Add Patient Detail");
        heading.setBounds(320, 30, 500, 50);
        heading.setFont(new Font("SAN_SERIF", Font.BOLD, 25));
        add(heading);

        JLabel labelname = new JLabel("First Name");
        labelname.setBounds(50, 150, 150, 30);
        labelname.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelname);

        fname = new JTextField();
        fname.setBounds(200, 150, 150, 30);
        add(fname);

        JLabel labelfname = new JLabel("Last Name");
        labelfname.setBounds(400, 150, 150, 30);
        labelfname.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelfname);

        lname = new JTextField();
        lname.setBounds(600, 150, 150, 30);
        add(lname);

        JLabel labeldob = new JLabel("Date of Birth");
        labeldob.setBounds(50, 200, 150, 30);
        labeldob.setFont(new Font("serif", Font.PLAIN, 20));
        add(labeldob);

        dcdob = new JDateChooser();
        dcdob.setBounds(200, 200, 150, 30);
        add(dcdob);

        JLabel labelage = new JLabel("Age");
        labelage.setBounds(400, 200, 150, 30);
        labelage.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelage);

        tfage = new JTextField();
        tfage.setBounds(600, 200, 150, 30);
        add(tfage);

        JLabel labeladdress = new JLabel("Address");
        labeladdress.setBounds(50, 250, 150, 30);
        labeladdress.setFont(new Font("serif", Font.PLAIN, 20));
        add(labeladdress);

        tfaddress = new JTextField();
        tfaddress.setBounds(200, 250, 150, 30);
        add(tfaddress);

        JLabel labelphone = new JLabel("Phone");
        labelphone.setBounds(400, 250, 150, 30);
        labelphone.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelphone);

        tfphone = new JTextField();
        tfphone.setBounds(600, 250, 150, 30);
        add(tfphone);

        JLabel labelemail = new JLabel("Email");
        labelemail.setBounds(50, 300, 150, 30);
        labelemail.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelemail);

        tfemail = new JTextField();
        tfemail.setBounds(200, 300, 150, 30);
        add(tfemail);

        JLabel bgroup1 = new JLabel("Blood Group");
        bgroup1.setBounds(400, 300, 150, 30);
        bgroup1.setFont(new Font("serif", Font.PLAIN, 20));
        add(bgroup1);

        String bg[] = {"A", "-A", "B", "-B", "O", "-O", "AB", "-AB"};
        bgroup = new JComboBox(bg);
        bgroup.setBackground(Color.WHITE);
        bgroup.setBounds(600, 300, 150, 30);
        add(bgroup);

        JLabel gender = new JLabel("Gender");
        gender.setBounds(50, 350, 150, 30);
        gender.setFont(new Font("serif", Font.PLAIN, 20));
        add(gender);

        maleRadioButton = new JRadioButton("Male");
        maleRadioButton.setBounds(200, 350, 70, 30);
        maleRadioButton.setBackground(Color.WHITE);
        add(maleRadioButton);

        femaleRadioButton = new JRadioButton("Female");
        femaleRadioButton.setBounds(270, 350, 70, 30);
        femaleRadioButton.setBackground(Color.WHITE);
        add(femaleRadioButton);

        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(maleRadioButton);
        buttonGroup.add(femaleRadioButton);


        JLabel labelaadhar = new JLabel("Aadhar Number");
        labelaadhar.setBounds(400, 350, 150, 30);
        labelaadhar.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelaadhar);

        tfaadhar = new JTextField();
        tfaadhar.setBounds(600, 350, 150, 30);
        add(tfaadhar);

        JLabel labelempId = new JLabel("patient id");
        labelempId.setBounds(50, 400, 150, 30);
        labelempId.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelempId);

        lblempId = new JLabel("" + number);
        lblempId.setBounds(200, 400, 150, 30);
        lblempId.setFont(new Font("serif", Font.PLAIN, 20));
        add(lblempId);

        add = new JButton("Next");
        add.setBounds(250, 550, 150, 40);
        add.addActionListener(this);
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add(add);

        back = new JButton("Back");
        back.setBounds(450, 550, 150, 40);
        back.addActionListener(this);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        add(back);

        setSize(900, 700);
        setLocation(300, 50);
        setVisible(true);
    }

    public static void main(String[] args) {
        new NewPatient();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == add) {



            String name = fname.getText();
            String fname = lname.getText();
            String dob = ((JTextField) dcdob.getDateEditor().getUiComponent()).getText();
            String age = tfage.getText();
            String address = tfaddress.getText();
            String phone = tfphone.getText();
            String email = tfemail.getText();
            String blgroup = (String) bgroup.getSelectedItem();
            String gender = null;
            if (maleRadioButton.isSelected()) {
                gender = "Male";
            } else if (femaleRadioButton.isSelected()) {
                gender = "Female";
            }
            String aadhar = tfaadhar.getText();
            String empId = lblempId.getText();

            try {
                Conn conn = new Conn();
                String query = "insert into newPatient values('" + name + "', '" + fname + "', '" + dob + "', '" + age + "', '" + address + "', '" + phone + "', '" + email + "', '" + blgroup + "', '" + gender + "', '" + aadhar + "', '" + empId + "')";
                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Details added successfully");
                setVisible(false);
                new Diagnosis();
            } catch (Exception ae) {
                ae.printStackTrace();
            }
        } else {
            setVisible(false);
            new Home();
        }
    }
}
