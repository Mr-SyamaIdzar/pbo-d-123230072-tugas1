package LoginPage.Main;

import java.awt.FlowLayout;
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
    
    // Simpan 
    JButton btnsave = new JButton("Simpan");
    
    // TextArea
    JTextArea textArea = new JTextArea(10, 30);
    
    // Convert
    JButton btnconvert = new JButton("Convert to .txt");
    
    public mainPage() {
        setTitle("Halaman Input Data");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 400);
        setLocationRelativeTo(null);
        
        // Panel Utama
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        
        // Panel untuk Input Nama
        JPanel namePanel = new JPanel();
        namePanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        namePanel.add(lfirstName);
        namePanel.add(ffirstName);
        namePanel.add(llastName);
        namePanel.add(flastName);
        
        // Panel untuk Jenis Kelamin
        JPanel lgenderPanel = new JPanel();
        lgenderPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        lgenderPanel.add(lgender);
        JPanel genderPanel = new JPanel();
        genderPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(rpria);
        genderGroup.add(rwanita);
        genderPanel.add(rpria);
        genderPanel.add(rwanita);
        
        // TextArea untuk Menampilkan Data 
        textArea.setEditable(true);
        JScrollPane scrollPane = new JScrollPane(textArea);
        
        // Menambhakan Komponen ke Panel Utama
        mainPanel.add(namePanel);
        mainPanel.add(lgenderPanel);
        mainPanel.add(genderPanel);
        mainPanel.add(btnsave);
        mainPanel.add(scrollPane);
        mainPanel.add(btnconvert);
        
        add(mainPanel);
        
        setVisible(true);
    }
}
