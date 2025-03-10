package LoginPage.Main;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;
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
    ButtonGroup genderGroup = new ButtonGroup(); // Untuk mengelompokan radiobtn
    
    // Save Button
    JButton btnsave = new JButton("Simpan");
    
    // Status btnsave
    JLabel saveStatus = new JLabel("");
    
    // TextArea
    // Baris 10 kolom 30
    JTextArea textArea = new JTextArea(10, 30);
    
    // Convert Button
    JButton btnconvert = new JButton("Convert to .txt");
    
    // Status btnconvert
    JLabel convertStatus = new JLabel("");
    
    // ArrayList untuk menyimpan data
    ArrayList<String> dataList = new ArrayList<>();
    
    public mainPage() {
        setTitle("Halaman Input Data");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Menghentikan program saat frame di close
        setSize(500, 400);
        setLocationRelativeTo(null); // Menengahkan frame
        
        // Panel Utama
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        // mainPanel.setBackground(Color.YELLOW);
        
        gbc.insets = new Insets(2,2,2,2);
         
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST; // Menempatkan posisi di bagian kiri
        mainPanel.add(lfirstName);
        
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        mainPanel.add(llastName, gbc);

        // Panel untuk Input Nama Belakang
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL; // Mengisi seluruh frame ke arah horizontal
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
        gbc.gridwidth = 2; // Mengambil 2 kolom
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
        gbc.anchor = GridBagConstraints.WEST;
        mainPanel.add(saveStatus, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.gridwidth = 2;
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
        gbc.anchor = GridBagConstraints.WEST;
        btnconvert.addActionListener(new actionConvert());
        mainPanel.add(convertStatus, gbc);
        
        // Menambhakan Komponen ke Panel Utama
        add(mainPanel);
        
        setVisible(true);
//        readFile();
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
            try (FileWriter writer = new FileWriter("data_123230072.txt", true)) {
                for (String data : dataList) {
                    writer.write(data); // Menulis data dari ArrayList ke file
                }
                JOptionPane.showMessageDialog(null, "Data Berhasil Disimpan", "Message", JOptionPane.INFORMATION_MESSAGE);
                dataList.clear(); // Mengosongkan ArrayList setelah data disimpan
                textArea.setText(""); // Mengosongkan TextArea
            } catch (IOException er) {
                er.printStackTrace();
            }
        }
    }
        
    public void readFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader("data_123230072.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                dataList.add(line + "\n"); // Membaca data dari file dan menambahkannya ke ArrayList
                textArea.append(line + "\n"); // Menampilkan data di TextArea
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
