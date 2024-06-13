package sachin.travel.and.tourism;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * 
 * @author SACHIN DUBEY
 */
public class Dashboard extends JFrame implements ActionListener {
    String username;
    JButton addPersonDetails, ViewPersonDetails, UpdatePersonDetails, CheckPackages, BookPackages, ViewPackages, ViewHotels, Destinations, BookHotels, ViewBookedHotels, Payments, Calculator, DeletePersonDetails, Notepad, About;

   Dashboard(String username){
    this.username = username;
    setExtendedState(JFrame.MAXIMIZED_BOTH);
    setLayout(new BorderLayout());

        JPanel p1 = new JPanel();
        p1.setLayout(null);
        p1.setBackground(new Color(0, 0, 102));
        p1.setPreferredSize(new Dimension(getWidth(), 65));
        add(p1, BorderLayout.NORTH);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/dashboard.png"));
        Image i2 = i1.getImage().getScaledInstance(70, 70, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel icon = new JLabel(i3);
        icon.setBounds(5, 0, 70, 70);
        p1.add(icon);

        JLabel heading = new JLabel("Dashboard");
        heading.setBounds(80, 10, 300, 40);
        heading.setForeground(Color.WHITE);
        heading.setFont(new Font("Tahoma", Font.BOLD, 30));
        p1.add(heading);

        JPanel p2 = new JPanel();
        p2.setLayout(new GridLayout(0, 1)); // Use GridLayout to align buttons vertically
        p2.setBackground(new Color(0, 0, 102));
        p2.setPreferredSize(new Dimension(300, 1000));

        JScrollPane scrollPane = new JScrollPane(p2);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        add(scrollPane, BorderLayout.WEST);

        addPersonDetails = new JButton("Add Personal Details");
        styleButton(addPersonDetails, 60);
        p2.add(addPersonDetails);

        UpdatePersonDetails = new JButton("Update Personal Details");
        styleButton(UpdatePersonDetails, 40);
        p2.add(UpdatePersonDetails);

        ViewPersonDetails = new JButton("View Details");
        styleButton(ViewPersonDetails, 140);
        p2.add(ViewPersonDetails);

        DeletePersonDetails = new JButton("Delete Personal Details");
        styleButton(DeletePersonDetails, 40);
        p2.add(DeletePersonDetails);

        CheckPackages = new JButton("Check Packages ");
        styleButton(CheckPackages, 110);
        p2.add(CheckPackages);

        BookPackages = new JButton("Book Package ");
        styleButton(BookPackages, 120);
        p2.add(BookPackages);

        ViewPackages = new JButton("View Package ");
        styleButton(ViewPackages, 120);
        p2.add(ViewPackages);

        ViewHotels = new JButton("View Hotels ");
        styleButton(ViewHotels, 130);
        p2.add(ViewHotels);

        BookHotels = new JButton("Book Hotel ");
        styleButton(BookHotels, 140);
        p2.add(BookHotels);

        ViewBookedHotels = new JButton("View Booked Hotel ");
        styleButton(ViewBookedHotels, 70);
        p2.add(ViewBookedHotels);

        Destinations = new JButton("Destinations");
        styleButton(Destinations, 125);
        p2.add(Destinations);

        Payments = new JButton("Payments");
        styleButton(Payments, 155);
        p2.add(Payments);

        Calculator = new JButton("Calculator ");
        styleButton(Calculator, 145);
        p2.add(Calculator);

        Notepad = new JButton("Notepad ");
        styleButton(Notepad, 155);
        p2.add(Notepad);

        About = new JButton("About ");
        styleButton(About, 175);
        p2.add(About);

        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icons/home.jpg"));
        Image i5 = i4.getImage().getScaledInstance(1650, 1000, Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        JLabel image = new JLabel(i6);
        add(image, BorderLayout.CENTER);

        JLabel Text = new JLabel("Sachin Travel And Tourism");
        Text.setBounds(200,25, 1200, 70);
        Text.setForeground(Color.BLACK);
        Text.setFont(new Font("Tahoma", Font.BOLD, 55));
        image.add(Text);

        setVisible(true);
    }

    private void styleButton(JButton button, int rightMargin) {
        button.setBackground(new Color(0, 0, 102));
        button.setForeground(Color.WHITE);
        button.setFont(new Font("Tahoma", Font.PLAIN, 20));
        button.setMargin(new Insets(0, 0, 0, rightMargin));
        button.addActionListener(this);
    }

    public void actionPerformed(ActionEvent ac) {
        if (ac.getSource() == addPersonDetails) {
            new AddCustomer(username);
        } else if (ac.getSource() == ViewPersonDetails) {
            new ViewCustomer(username);
        } else if (ac.getSource() == UpdatePersonDetails) {
            new UpdateCustomer(username);
        } else if (ac.getSource() == CheckPackages) {
            new CheckPackage(); // Update this as needed
        } else if (ac.getSource() == BookPackages) {
            new BookPackage(username);
        } else if (ac.getSource() == ViewPackages) {
            new ViewPackage(username);
        } else if (ac.getSource() == ViewHotels) {
            new CheckHotels(); // Update this as needed
        } else if (ac.getSource() == Destinations) {
            new Destinations(); // Update this as needed
        } else if (ac.getSource() == BookHotels) {
            new BookHotel(username);
        } else if (ac.getSource() == ViewBookedHotels) {
            new NewBookedHotel(username);
        } else if (ac.getSource() == Payments) {
            new Payment(); // Update this as needed
        } else if (ac.getSource() == Calculator) {
            try {
                Runtime.getRuntime().exec("calc.exe");
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ac.getSource() == Notepad) {
            try {
                Runtime.getRuntime().exec("notepad.exe");
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ac.getSource() == About) {
            new About();
        } else if (ac.getSource() == DeletePersonDetails) {
            new DeleteDetails(username);
        }
    }

    public static void main(String[] args) {
        new Dashboard("Sachindubey_a1");
    }
}
