/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LoginPage;

import LoginPage.Main.mainPage;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author HP
 */
public class loginPage extends JFrame implements ActionListener{
    // Username
    private final JTextField fusername = new JTextField(10);
    private JLabel lusername = new JLabel("Username:");
    
    // Password
    private final JTextField fpassword = new JTextField(10);
    private JLabel lpassword = new JLabel("Password:");
    
    // Button
    private JButton btnLogin = new JButton("Login");
    
    // Status
    private JLabel lstatus = new JLabel("");
    
    public loginPage() {
        setTitle("Halaman Login");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        setSize(350, 200);
        
        setLayout(null);
        add(lusername);
        add(fusername);
        add(lpassword);
        add(fpassword);
        add(btnLogin);
        add(lstatus);
        
        lusername.setBounds(10, 10, 120, 20);
        fusername.setBounds(130, 10, 200, 20);
        lpassword.setBounds(10, 35, 120, 20);
        fpassword.setBounds(130, 35, 200, 20);
        btnLogin.setBounds(140, 60, 70, 20);
        lstatus.setBounds(140, 130, 200, 20);
        
        btnLogin.addActionListener(this);
        
        setVisible(true);
    }
    
    public void validateLogin() {
        String username = fusername.getText().trim();
        String password = fpassword.getText().trim();
        
        if (username.equalsIgnoreCase("pbo") && password.equalsIgnoreCase("if-d")) {
            new mainPage(); // Berpindah frame
            dispose(); // Menghilangkan frame login
        } else {
            lstatus.setText("Gagal login");
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        validateLogin();
    }
}
