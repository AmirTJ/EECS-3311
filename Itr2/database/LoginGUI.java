package Itr2;

import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class LoginGUI extends JFrame {
    private JLabel userLabel, passwordLabel, titleLabel;
    private JTextField userTextField;
    private JPasswordField passwordField;
    private JButton loginButton, resetButton;

    public LoginGUI() {
        super("Login");

        // Create and customize UI components
        titleLabel = new JLabel("Login Form");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);

        userLabel = new JLabel("User ID:");
        userTextField = new JTextField();

        passwordLabel = new JLabel("Password:");
        passwordField = new JPasswordField();

        loginButton = new JButton("Login");
        resetButton = new JButton("Reset");

        // Set layout and add components
        setLayout(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();
        gc.fill = GridBagConstraints.HORIZONTAL;
        gc.gridx = 0;
        gc.gridy = 0;
        gc.gridwidth = 2;
        gc.insets = new Insets(10, 10, 10, 10);
        add(titleLabel, gc);

        gc.gridx = 0;
        gc.gridy = 1;
        gc.gridwidth = 1;
        add(userLabel, gc);

        gc.gridx = 1;
        gc.gridy = 1;
        add(userTextField, gc);

        gc.gridx = 0;
        gc.gridy = 2;
        add(passwordLabel, gc);

        gc.gridx = 1;
        gc.gridy = 2;
        add(passwordField, gc);

        gc.gridx = 0;
        gc.gridy = 3;
        gc.gridwidth = 2;
        add(loginButton, gc);

        gc.gridx = 0;
        gc.gridy = 4;
        gc.gridwidth = 2;
        add(resetButton, gc);

        // Add action listeners
        loginButton.addActionListener(e -> {
            String userId = userTextField.getText();
            String password = new String(passwordField.getPassword());
            // Perform login validation here
        });

        resetButton.addActionListener(e -> {
            userTextField.setText("");
            passwordField.setText("");
        });

        // Set frame properties
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 500);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }

    public static void main(String[] args) {
        new LoginGUI();
    }
}
