/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.ErrorFail;
import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author chuck.a
 */
public class Files {
    AnalyticSintax lexer= new AnalyticSintax();
    
    //Delete Files
    public boolean deleteFile(String archive){
        return new File(archive).delete();
    }
    //Count Programs
    public int countProgram(String archive){
        int count = 0;
        for (File file: new File(archive).listFiles()) {
            if (file.isFile()) {
                count++;
            }
        }
        return count;
    }
    
    //Count Lines from path
    public int countLines(String archive){
        long lines = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(archive))) {
            while (reader.readLine() != null) lines++;
        } catch (IOException e) {
            return 0;
        }
        return (int)lines;
    }
    //Create File
    public boolean createFile(String archive){
        try {
            return new File (archive).createNewFile();
        } catch (IOException ioe) {
           return false;
        }
    }
    //Read file
    public void readFile(String archive) throws Exception{
        InputStreamReader isr = new InputStreamReader(new FileInputStream(new File(archive)),
                StandardCharsets.UTF_8.name());
        try (BufferedReader br = new BufferedReader(isr)) {
            String line;
            while((line = br.readLine()) != null){
                //process the line
                System.out.println(line);
            }
        }
    }
    //Write File
    public void writeFile(String archive, String[] lines){
       File fichero = new File(archive);
       if (fichero.exists()) {

           try {
               BufferedWriter bw = new BufferedWriter(new FileWriter(fichero));
               PrintWriter wr = new PrintWriter(bw);
               if(lines.length>0){
                   for (String line : lines) {
                       wr.write(line.concat("\n"));
                   }
               } 
               bw.close();
           } catch (IOException ex) {
               Logger.getLogger(Files.class.getName()).log(Level.SEVERE, null, ex);
           }
       }
    }
    //Open File text editor
    public void openFileEditor(String archive) throws IOException{
        File file = new File(archive);
        if (file.exists()) {
            //first check if Desktop is supported by Platform or not
            if(!Desktop.isDesktopSupported()){
                return;
            }
            Desktop desktop = Desktop.getDesktop();
            if(file.exists()){
                desktop.open(file);
            } 
        }
    }
    
    //Open File
    public void openFile(String archive) throws IOException{
        File file = new File(archive);
        if (file.exists()) {
            try (Scanner openfile = new Scanner(file)) {
                while (openfile.hasNextLine()) {
                    String filedata = openfile.nextLine();
                    System.out.println(filedata);
                }
            }
        }
    }
    
    /**
     * 
     * @return
     * @throws FileNotFoundException 
     */
    public List<String> openFiles() throws FileNotFoundException {
        List<String> routes = new ArrayList<>();
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Seleccione el archivo que deseas ejecutar");
        File root = new File(System.getProperty("user.dir"));
        fileChooser.setCurrentDirectory(root);

        // Filtra los tipos de archivos permitidos
        FileNameExtensionFilter filter = new FileNameExtensionFilter("ASM CODE", "asm");
        fileChooser.setFileFilter(filter);
        fileChooser.setMultiSelectionEnabled(true);

        // Abre el explorador de archivos y espera a que el usuario seleccione uno o varios archivos
        int result = fileChooser.showOpenDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            File[] selectedFiles = fileChooser.getSelectedFiles();
            
            if (selectedFiles.length > 0) {
                // Procesa los archivos seleccionados
                String msg = "ERRORS\n";
                for (File archive : selectedFiles) {
                    msg = syntaxAnalysis(archive, msg);

                    if (!msg.equals(" ")) {
                        JOptionPane.showMessageDialog(new JFrame(), msg, "ERROR", JOptionPane.ERROR_MESSAGE);
                    }
                    else {
                        routes.add(archive.getAbsolutePath());
                    } 
                    msg = "ERRORS\n";  
                }
            }
            else {
                String message = "ERROR => [NINGÚN DOCUMENTO SELECCIONADO]";
                JOptionPane.showMessageDialog(new JFrame(), message, "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        }
        else {
            String message = "ERROR => [NINGÚN DOCUMENTO SELECCIONADO]";
            JOptionPane.showMessageDialog(new JFrame(), message, "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return routes;
    }
    
    /**
     * 
     * @param archive
     * @param msg
     * @return
     * @throws FileNotFoundException 
     */
    public String syntaxAnalysis(File archive, String msg) throws FileNotFoundException {
        msg+="Archivo: "+ archive.getName()+"\n";
        if (isASM(archive)) {
            List<ErrorFail> errors = lexer.getErrors(archive.getAbsolutePath());
            if (errors.isEmpty()) msg = " ";
            for (int i = 0;i<errors.size();i++) {
                if (errors.get(i).isIsError()) {
                    msg+=" Linea: "+errors.get(i).getNumLine();
                    msg+=" => "+errors.get(i).getInstruction();
                    msg+= " | "+errors.get(i).getMessage()+"\n";            
                }
            }
        }
        else {
            msg+="[ERROR] => [DOCUMENTO INVALIDO, EXTENCIONES PERMITIDAS (asm)]";
        }
        return msg;
    }
    
    /**
     * 
     * @param archive
     * @return 
     */
    //Validate extension ASM
    public boolean isASM(File archive){
        return archive.getAbsolutePath().toLowerCase().endsWith(".asm");
    }
}
