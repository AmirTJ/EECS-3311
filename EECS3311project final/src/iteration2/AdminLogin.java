package iteration2;
import  iteration1.*;
import iteration3.BookManageGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AdminLogin extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;

    public AdminLogin() {
        super("Login");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 200);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2));

        JLabel usernameLabel = new JLabel("Username:");
        panel.add(usernameLabel);
        usernameField = new JTextField(20);
        panel.add(usernameField);

        JLabel passwordLabel = new JLabel("Password:");
        panel.add(passwordLabel);
        passwordField = new JPasswordField(20);
        panel.add(passwordField);

        JButton loginButton = new JButton("Login");
        loginButton.addActionListener(new LoginButtonListener());
        panel.add(loginButton);

        getContentPane().add(panel);
    }

    private class LoginButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String username = usernameField.getText();
            char[] passwordChars = passwordField.getPassword();
            String password = new String(passwordChars);

            if (username.equals("3311") && password.equals("pass")) {
                dispose();
                BookManageGUI bookGUI = new BookManageGUI();
                bookGUI.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(null, "Invalid username or password.");
            }
        }
    }

    public static void main(String[] args) {
        AdminLogin gui = new AdminLogin();
        gui.setVisible(true);
    }
}
