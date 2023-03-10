package Itr1;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class StudyRoomBookingGUI extends JFrame {
  private JButton[] roomButtons = new JButton[10];
  private boolean[] roomAvailability = {true, true, true, true, true,true, true, true, true, true};
  private String[] roomBookings = new String[10];

  public StudyRoomBookingGUI() {
    super("Library Study Room Booking System");
    setLayout(new GridLayout(2, 5));

    for (int i = 0; i < 10; i++) {
      roomButtons[i] = new JButton("Room " + (i + 1));
      roomButtons[i].setEnabled(roomAvailability[i]);
      add(roomButtons[i]);

      final int roomIndex = i;
      roomButtons[i].addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          String name = JOptionPane.showInputDialog(StudyRoomBookingGUI.this, "Enter your name:");
          if (name != null && !name.trim().isEmpty()) {
            roomAvailability[roomIndex] = false;
            roomBookings[roomIndex] = name;
            roomButtons[roomIndex].setEnabled(false);
            roomButtons[roomIndex].setText("Booked by " + name);
          }
        }
      });
    }

    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setSize(400, 300);
    setVisible(true);
  }

  public static void main(String[] args) {
    new StudyRoomBookingGUI();
  }
}