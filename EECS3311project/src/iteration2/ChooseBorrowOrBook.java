


	package iteration2;
	import  iteration1.*;
import iteration3.BorrowGUI;

import javax.swing.*;
	import java.awt.*;
	import java.awt.event.*;

	public class ChooseBorrowOrBook extends JFrame {
	    public ChooseBorrowOrBook() {
	        super("Choose one to login");
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        setSize(600, 400);

	        JPanel panel = new JPanel();
	        panel.setLayout(new GridLayout(3, 2));

	        JButton BookRooomrButton = new JButton("Book study room");
	        BookRooomrButton.addActionListener(new BookRoomButtonListener());
	        panel.add(BookRooomrButton);
	        JButton BorrowButton = new JButton("Borrow book");
	        BorrowButton.addActionListener(new StudentButtonListener());
	        panel.add(BorrowButton);
	       
	        getContentPane().add(panel);
	       

	       
	    }

	    private class BookRoomButtonListener implements ActionListener {
	        public void actionPerformed(ActionEvent e) {
	            dispose();
	            StudyRoomBookingGUI adminLogin = new StudyRoomBookingGUI();
	            adminLogin.setVisible(true);
	        }
	    }
	    private class StudentButtonListener implements ActionListener {
	        public void actionPerformed(ActionEvent e) {
	            dispose();
	           BorrowGUI studentLogin = new BorrowGUI();
	           
	        }
	    }
	    
	    

	    public static void main(String[] args) {
	    	ChooseBorrowOrBook gui = new ChooseBorrowOrBook();
	        gui.setVisible(true);
	    }
	}

