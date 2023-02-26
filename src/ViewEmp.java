import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class ViewEmp extends JFrame implements ActionListener {
    JTable td;
    Choice c1;

    JButton back, search;
    ViewEmp()
    {
        JLabel heading = new JLabel("Patient Details");
        heading.setBounds(330,30,400,30);
        heading.setFont(new Font("serif", Font.BOLD, 30));
        add(heading);

        JLabel l = new JLabel("Name");
        l.setBounds(0,125,50,30);
        add(l);

        JLabel l2 = new JLabel("LName");
        l2.setBounds(90,125,50,30);
        add(l2);

        JLabel l3 = new JLabel("Date");
        l3.setBounds(180,125,50,30);
        add(l3);

        JLabel l4 = new JLabel("Age");
        l4.setBounds(270,125,50,30);
        add(l4);

        JLabel l5 = new JLabel("Address");
        l5.setBounds(330,125,50,30);
        add(l5);

        JLabel l6 = new JLabel("Phone");
        l6.setBounds(420,125,50,30);
        add(l6);

        JLabel l7 = new JLabel("Email");
        l7.setBounds(510,125,50,30);
        add(l7);

        JLabel l8 = new JLabel("B Group");
        l8.setBounds(590,125,50,30);
        add(l8);

        JLabel l9 = new JLabel("Gender");
        l9.setBounds(670,125,50,30);
        add(l9);

        JLabel l10 = new JLabel("Aadhaar");
        l10.setBounds(740,125,50,30);
        add(l10);

        JLabel l11 = new JLabel("Id");
        l11.setBounds(830,125,50,30);
        add(l11);


        JLabel h1 = new JLabel("Search Patient");
        h1.setFont(new Font("serif", Font.BOLD, 15));
        h1.setBounds(200,99,100,30);
        add(h1);

        c1 = new Choice();
        c1.setBounds(310,103,150,25);
        add(c1);
        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from newPatient ");
            while(rs.next()){
                c1.add(rs.getString("patientId"));
            }
        }catch
        (Exception e){
            e.printStackTrace();
        }

        td = new JTable();
        td.setBounds(0,150,900,450);
        add(td);

        try{
            Conn conn  = new Conn();
            ResultSet rs = conn.s.executeQuery("select * from newPatient");
            td.setModel(DbUtils.resultSetToTableModel(rs));
        }
        catch(Exception e1)
        {
            e1.printStackTrace();
        }

        search = new JButton("Search");
        search.setBounds(250, 600, 150, 40);
        search.setFont(new Font("serif", Font.BOLD, 15));
        search.setBackground(Color.BLACK);
        search.setForeground(Color.WHITE);
        search.addActionListener(this);
        add(search);

        back = new JButton("Back");
        back.setBounds(410, 600, 150, 40);
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
        new ViewEmp();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == search)
        {
            String query = "select * from newPatient where patientId = '"+c1.getSelectedItem()+"'";
            try
            {
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery(query);
                td.setModel(DbUtils.resultSetToTableModel(rs));
            } catch (Exception e1) {
                e1.printStackTrace();
            }
//        } else if (ae.getSource() == print) {
//            try {
//                table.print();
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        } else if (ae.getSource() == update) {
//            setVisible(false);
//            new UpdateEmployee(cemployeeId.getSelectedItem());
        }
        else
        {
            setVisible(false);
            new Home();
        }

    }
}
