/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import DAO.Methods;
import DTO.JsonMemory;
import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author asmal
 */
public class Settings extends JDialog{
    private JTextField ssdField;
    private JTextField ramField;
    private boolean ssdValidated;
    private boolean ramValidated;
    Font font = new Font("Arial", Font.BOLD, 20);

    public Settings(JFrame parent) {
        super(parent, "Settings", true);
        setSize(500, 300);
        setResizable(false);
        setLocationRelativeTo(null);
        setUndecorated(true);

        // Configurar el diseño
        setLayout(new BorderLayout());
        
        JLabel title = new JLabel();
        title.setFont(font);
        title.setText("Settings Menu");

        JPanel inputPanel = new JPanel(new GridLayout(6, 2));
        
        JLabel ssdLabel = new JLabel("SSD:");

        ssdLabel.setFont(font);
        ssdField = new JTextField();
        ssdField.setSize(60, 30);
        
        JLabel ramLabel = new JLabel("RAM:");
        ramLabel.setFont(font);

        ramField = new JTextField();
        
        JLabel msg = new JLabel();
        msg.setText("Para utilizar la configuracion DEFAULT deje los espacios en blanco y presione [SAVE]");
        inputPanel.add(title);
        inputPanel.add(ssdLabel);
        inputPanel.add(ssdField);
        inputPanel.add(ramLabel);
        inputPanel.add(ramField);
        inputPanel.add(msg);

        JButton loadButton = new JButton("Load Config File");
        loadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                 try{
                    String systemRoot = System.getProperty("user.dir");
                    JFileChooser fileChooser = new JFileChooser();
                    fileChooser.setDialogTitle("Seleccione el archivo que deseas ejecutar");
                    File root = new File(systemRoot);
                    fileChooser.setCurrentDirectory(root);

                    // Filtra los tipos de archivos permitidos
                    FileNameExtensionFilter filter = new FileNameExtensionFilter("JSON CODE", "json");
                    fileChooser.setFileFilter(filter);
                    fileChooser.setMultiSelectionEnabled(true);
                    
                    // Abre el explorador de archivos y espera a que el usuario seleccione uno o varios archivos
                    int result = fileChooser.showOpenDialog(null);
                    if (result == JFileChooser.APPROVE_OPTION) {
                        File[] selectedFiles = fileChooser.getSelectedFiles();
                        if (selectedFiles==null || selectedFiles.length == 0) {
                            String message = "ERROR => [NINGÚN DOCUMENTO SELECCIONADO]";
                            JOptionPane.showMessageDialog(new JFrame(), message, "ERROR", JOptionPane.ERROR_MESSAGE);
                        }
                        else if(selectedFiles.length > 1) {
                            String message = "ERROR => [HAY VARIOS DOCUMENTOS SELECCIONADOS]";
                            JOptionPane.showMessageDialog(new JFrame(), message, "ERROR", JOptionPane.ERROR_MESSAGE);
                        }else{
                            for (File archive : selectedFiles) {
                                // create Gson instance
                                Gson gson = new Gson();
                                // convert a JSON string to a User object
                                try ( // create a reader
                                        Reader reader = Files.newBufferedReader(Paths.get(archive.getPath()))) {
                                    // convert a JSON string to a JsonMemory object
                                    JsonMemory memory = gson.fromJson(reader,JsonMemory.class);
                                    ssdField.setText(memory.getSsd().toString());
                                    ramField.setText(memory.getRam().toString());
                                    // close reader
                                }
                
                            }
                        }
                    }
                }
                catch (JsonIOException | JsonSyntaxException | HeadlessException | IOException ex) {
                    Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        JButton saveButton = new JButton("Save");
        saveButton.addActionListener((ActionEvent e) -> { Save();});

        add(inputPanel, BorderLayout.CENTER);
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));

        buttonPanel.add(loadButton);
        buttonPanel.add(saveButton);
        
        add(buttonPanel, BorderLayout.SOUTH);
    }

    public String getSSDValue() {
        return ssdField.getText();
    }

    public String getRAMValue() {
        return ramField.getText();
    }
    
    public void Save() {
        Methods methods = new Methods();
        if (!ssdField.getText().equals("")) {
            if (methods.isInt(ssdField.getText())) {
                validateSizeSSD(ssdField.getText());
            }
            else {
                String message = "ERROR DE CONFIGURACION [VALORES SSD INVALIDOS]";
                JOptionPane.showMessageDialog(new JFrame(), message, "ERROR", JOptionPane.ERROR_MESSAGE);
                ssdValidated = false;
            }
        }
        else {
            ssdValidated = true;
        }
            
        if (!ramField.getText().equals("")) {
            if (methods.isInt(ramField.getText())) {
                validateSizeRam(ramField.getText());
            }
            else {
                String message = "ERROR DE CONFIGURACION [VALORES RAM INVALIDOS]";
                JOptionPane.showMessageDialog(new JFrame(), message, "ERROR", JOptionPane.ERROR_MESSAGE);
                ramValidated = false;
            }
        }
        else {
            ramValidated = true;
        }
        validateMemories();
    }
    
    
    public void validateSizeSSD(String num) {
        if (Integer.parseInt(num)<512) {
            String message = "ERROR DE CONFIGURACION [SSD>512]";
            JOptionPane.showMessageDialog(new JFrame(), message, "ERROR", JOptionPane.ERROR_MESSAGE);
            ssdValidated = false;
        }
        else {
            ssdValidated = true;
        }
    }
    
    public void validateSizeRam(String num) {
        if (Integer.parseInt(num)<256) {
            String message = "ERROR DE CONFIGURACION [RAM>256]";
            JOptionPane.showMessageDialog(new JFrame(), message, "ERROR", JOptionPane.ERROR_MESSAGE);
            ramValidated = false;
        }
        else{
            ramValidated = true;
        }
    }
    
    public void validateMemories() {
        if (ssdValidated & ramValidated)
            this.dispose();
    } 
    
}
