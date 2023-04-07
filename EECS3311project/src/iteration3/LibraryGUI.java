package iteration3;



import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LibraryGUI extends JFrame {
    public LibraryGUI() {
        super("Library Information");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);

        // Create a tabbed pane
        JTabbedPane tabbedPane = new JTabbedPane();
        getContentPane().add(tabbedPane);

        // Create a panel for business hours
        JPanel businessHoursPanel = new JPanel();
        businessHoursPanel.setLayout(new GridLayout(7, 1));
        JLabel businessHoursLabel = new JLabel("Business Hours:");
        businessHoursPanel.add(businessHoursLabel);
        businessHoursPanel.add(new JLabel("Monday - Friday: 9:00 AM - 8:00 PM"));
        businessHoursPanel.add(new JLabel("Saturday: 10:00 AM - 6:00 PM"));
        businessHoursPanel.add(new JLabel("Sunday: 12:00 PM - 5:00 PM"));
        tabbedPane.addTab("Business Hours", businessHoursPanel);

        // Create a panel for borrowing process
        JPanel borrowingPanel = new JPanel();
        borrowingPanel.setLayout(new GridLayout(5, 1));
        JLabel borrowingLabel = new JLabel("Borrowing Process:");
        borrowingPanel.add(borrowingLabel);
        borrowingPanel.add(new JLabel("1. Select a book from the library catalog."));
        borrowingPanel.add(new JLabel("2. Bring the book to the circulation desk or use the online services."));
        borrowingPanel.add(new JLabel("3. Provide your library card or ID."));
        borrowingPanel.add(new JLabel("4. Check out the book."));
        tabbedPane.addTab("Borrowing Process", borrowingPanel);

        // Create a panel for booking a computer in study rooms
        JPanel computerBookingPanel = new JPanel();
        computerBookingPanel.setLayout(new GridLayout(5, 1));
        JLabel computerBookingLabel = new JLabel("Booking a Computer in Study Rooms:");
        computerBookingPanel.add(computerBookingLabel);
        computerBookingPanel.add(new JLabel("1. Check the availability of the study room."));
        computerBookingPanel.add(new JLabel("2. Reserve the study room by contacting the circulation desk."));
        computerBookingPanel.add(new JLabel("3. Provide your library card or ID."));
        computerBookingPanel.add(new JLabel("4. The circulation desk will provide you with a passcode."));
        tabbedPane.addTab("Computer Booking", computerBookingPanel);
    }

    public static void main(String[] args) {
        LibraryGUI gui = new LibraryGUI();
        gui.setVisible(true);
    }
}