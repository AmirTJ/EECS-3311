


	package iteration3;
	import  iteration1.*;


	import javax.swing.*;
	import java.awt.*;
	import java.awt.event.*;
	import iteration2.*;
	public class ChooseAdminOrStudent extends JFrame {
	    public ChooseAdminOrStudent() {
	        super("Choose one to login");
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        setSize(600, 400);

	        JPanel panel = new JPanel();
	        panel.setLayout(new GridLayout(3, 2));

	        JButton managerButton = new JButton("Manager");
	        managerButton.addActionListener(new ManagerButtonListener());
	        panel.add(managerButton);
	        JButton studentButton = new JButton("Student");
	        studentButton.addActionListener(new StudentButtonListener());
	        panel.add(studentButton);
	        JButton showinformation = new JButton("Library Information");
	        showinformation.addActionListener(new LibraryInfroamtion());
	        panel.add(showinformation);

	        getContentPane().add(panel);
	       

	       
	    }

	    private class ManagerButtonListener implements ActionListener {
	        public void actionPerformed(ActionEvent e) {
	            dispose();
	            AdminLogin adminLogin = new AdminLogin();
	            adminLogin.setVisible(true);
	        }
	    }
	    private class StudentButtonListener implements ActionListener {
	        public void actionPerformed(ActionEvent e) {
	            dispose();
	            ChooseBorrowOrBook studentLogin = new  ChooseBorrowOrBook ();
	            studentLogin.setVisible(true);
	        }
	    }
	    private class LibraryInfroamtion implements ActionListener {
	        public void actionPerformed(ActionEvent e) {
	            dispose();
	            LibraryGUI information = new  LibraryGUI();
	            information.setVisible(true);
	        }
	    }

	    public static void main(String[] args) {
	    	ChooseAdminOrStudent gui = new ChooseAdminOrStudent();
	        gui.setVisible(true);
	    }
	}


