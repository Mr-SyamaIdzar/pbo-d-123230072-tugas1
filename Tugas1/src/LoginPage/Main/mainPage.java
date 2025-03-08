package LoginPage.Main;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;

public class mainPage extends JFrame {
    // Nama
    JLabel lfirstName = new JLabel("Nama Depan:");
    JTextField ffirstName = new JTextField(10);
    JLabel llastName = new JLabel("Nama Belakang:");
    JTextField flastName = new JTextField(10);
    
    // Kelamin
    JLabel lgender = new JLabel("Jenis Kelamin:");
    JRadioButton rpria = new JRadioButton("Pria");
    JRadioButton rwanita = new JRadioButton("Wanita");
    ButtonGroup genderGroup = new ButtonGroup();
    
    // Simpan 
    JButton btnsave = new JButton("Simpan");
    
    // Status btnsave
    JLabel saveStatus = new JLabel("");
    
    // TextArea
    JTextArea textArea = new JTextArea(10, 30);
    
    // Convert
    JButton btnconvert = new JButton("Convert to .txt");
    
    // Status btnconvert
    JLabel convertStatus = new JLabel("Status");
    
    public mainPage() {
        setTitle("Halaman Input Data");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 400);
        setLocationRelativeTo(null);
        
        // Panel Utama
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        // mainPanel.setBackground(Color.YELLOW);
        
        gbc.insets = new Insets(2,2,2,2);
         
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        mainPanel.add(lfirstName);
        
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        mainPanel.add(llastName, gbc);

        // Panel untuk Input Nama Belakang
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        mainPanel.add(ffirstName, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        mainPanel.add(flastName, gbc);
        
        // Panel untuk Jenis Kelamin
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.WEST;
        mainPanel.add(lgender, gbc);
        
        JPanel genderPanel = new JPanel();
        genderPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        genderGroup.add(rpria);
        genderGroup.add(rwanita);
        genderPanel.add(rpria);
        genderPanel.add(rwanita);
        
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.CENTER;
        mainPanel.add(genderPanel, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2; // Mengambil 2 kolom
        gbc.fill = GridBagConstraints.HORIZONTAL;
        btnsave.addActionListener(new actionSave());
        mainPanel.add(btnsave, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 2; // Mengambil 2 kolom
        gbc.fill = GridBagConstraints.HORIZONTAL;
        mainPanel.add(saveStatus, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.BOTH;
        JScrollPane scrollPane = new JScrollPane(textArea);
        textArea.setEditable(false);
        mainPanel.add(scrollPane, gbc);
        
        // Tombol Convert
        gbc.gridx = 0;
        gbc.gridy = 7;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        mainPanel.add(btnconvert, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 8;
        gbc.gridwidth = 2; // Mengambil 2 kolom
        gbc.fill = GridBagConstraints.HORIZONTAL;
        btnconvert.addActionListener(new actionConvert());
        mainPanel.add(convertStatus, gbc);
        
        // Menambhakan Komponen ke Panel Utama
        add(mainPanel);
        
        setVisible(true);
        readFile();
    }
    
    class actionSave implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String firstName = ffirstName.getText().trim();
                String lastName = flastName.getText().trim();
                String gender = gender();
                
                if (firstName.isEmpty() || lastName.isEmpty() || gender.isEmpty()) {
                    saveStatus.setText("Data harus lengkap");
                } else {
                    String data = firstName + " " + lastName + " | Gender : " + gender + "\n";
                    textArea.setText(data);
                    ffirstName.setText("");
                    flastName.setText("");
                    genderGroup.clearSelection();
                }
        }   
    }
    
    public String gender() {
                if (rpria.isSelected()) {
                    return "Pria";
                } else if (rwanita.isSelected()) {
                    return "Wanita";
                } else {
                    return "";
                }
            }
    
    class actionConvert implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                textArea.write(new FileWriter("data_123230072.txt", true)); // Memberikan nilai true agar data tidak saling menimpa
                JOptionPane.showMessageDialog(null, "Data Berhasil Disimpan", "Message", JOptionPane.INFORMATION_MESSAGE);
            } catch (IOException er) {}
        }
    }
        
    public void readFile() {
        try {
            textArea.read(new FileReader("data_123230072.txt"), null);
            textArea.write(new OutputStreamWriter(new FileOutputStream("data_123230072.txt")));
        } catch (IOException e) {}
    }
}
