import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class About extends JFrame implements ActionListener {
JButton back;
    About(){

        JLabel heading = new JLabel("About Us");
        heading.setBounds(380,30,200,30);
        heading.setFont(new Font("Arial",Font.BOLD,30));
        add(heading);
        String description = "The Health Care system helps register complete patient information."
                + "It captures and stores the medical history, treatment required, details of their previous visits,"
                + "upcoming appointments if any, reports, insurance details and more."
                + "It helps eliminate the need to get these details on every visit."
                + "This enables the doctor to focus more on the treatment and improves the patient experience.";
        JLabel label = new JLabel("<html>" + description.replaceAll("\\n", "<br>") + "</html>");
        label.setBounds(50,50,600,500);
        add(label);



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
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == back) {
            new Home().setVisible(true);
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new About();
    }
}
