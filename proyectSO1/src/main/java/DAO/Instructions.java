/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.Cell;
import DTO.Memory;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Caili
 */
public class Instructions {
    
    
    /**
     * 
     * @param register
     * @param instruction
     * @return 
     */
    //Carga el valor al AC proveniente de un registro
    public Map<String, String> load(Map<String, String> register, String instruction){
        String[] instr = instruction.split(" ");
        
        if(instr[0].equalsIgnoreCase("LOAD")){
            String value = register.get(instr[1]);
            register.replace("AC", value);
        }
        
        return register;
    }
    
    /**
     * 
     * @param register
     * @param instruction
     * @return 
     */
    //Almacena el valor del AC a un registro destino 
    public Map<String, String> store(Map<String, String> register, String instruction){
        String[] instr = instruction.split(" ");
        if(instr[0].equalsIgnoreCase("STORE")){
            String value = register.get("AC");
            register.replace(instr[1], value);
        }
        return register;
    }
    
    /**
     * Metodo para validar si es numerico
     * Utilizado en el funcion de reconocer codigo
     * @param register
     * @return 
     */
    private boolean isNumeric(String register){
	try {
            Integer.valueOf(register);
            return true;
	} catch (NumberFormatException nfe){
            return false;
	}
    }
    
    /**
     * 
     * @param register
     * @param instruction
     * @return 
     */
    //Movimiento de los valores a un destino. 
    // 1- MOV reg_destino, reg_origen
    // 2- MOV reg_destino, valor
    public Map<String, String> mov(Map<String, String> register, String instruction){
        String[] instr = instruction.split(" ");
        if(instr[0].equalsIgnoreCase("MOV")){
            String [] reg = instr[1].split(",");
            
            //validar si es registro de origen o contiene valor
            boolean isValue = isNumeric(reg[1]);
            if(isValue){
                register.replace(reg[0], reg[1]);
            }
            if(!isValue){
                if(reg[1].equalsIgnoreCase("AX")||
                reg[1].equalsIgnoreCase("BX")||
                reg[1].equalsIgnoreCase("CX")||
                reg[1].equalsIgnoreCase("DX")){
                    String value = register.get(reg[1]);
                    register.replace(reg[0], value);
                }else{
                    if(reg[0].equalsIgnoreCase("DX")){
                        register.replace(reg[0], reg[1]);
                    }
                    else if(reg[0].equalsIgnoreCase("AL")){
                        register.replace(reg[0], reg[1]);
                    }
                    else if(reg[0].equalsIgnoreCase("AH")){
                        if(reg[1].equalsIgnoreCase("3CH")||
                            reg[1].equalsIgnoreCase("3DH")||
                            reg[1].equalsIgnoreCase("4DH")||
                            reg[1].equalsIgnoreCase("40H")||
                            reg[1].equalsIgnoreCase("41H")){
                            register.replace(reg[0], reg[1]);
                        }
                    }
                }
            }
        }
        return register;
    }
    
    //Instruccion para crear, abrir, leer, escribir, eliminar
    //Se almacena en registro AL el contenido
    //Se guarda en celda de N memoria mientras haya espacio es la memoria no reservada......
    //opc 1-Crear 2- Abrir 3- Leer 4- Escribir 5-Eliminar
    //En almacenamiento
    public Memory int21H(Map<String, String> register, String instruction, Memory memory){
        if(instruction.equalsIgnoreCase("INT 21H")){
            String getOperationAh = register.get("AH");
            //Obtenemos el fin de la ultima linea que seria el inicio de la siguiente celda se le suma 1
            Integer startLine = memory.getCellsReserved().get(memory.getCellsReserved().size()-1).getEndindAddress()+1;
            Integer spaceMemory = memory.getUserMemSize()-(startLine-1);
            String valueDX = register.get("DX");
            String valueAL = register.get("AL");
            if(startLine<spaceMemory){
                if(getOperationAh.equalsIgnoreCase("3CH")){
                    Cell create = new Cell();
                    create.setIndex(startLine);
                    create.setName(valueDX);
                    create.setInstructionAH("");
                    create.setStartingAddress(startLine);
                    create.setEndindAddress(startLine);
                    create.setIsOpen(false);
                    memory.getCellsReserved().add(create);
                    memory.setUserMemSize(memory.getUserMemSize()-1);
                }  
                else if(getOperationAh.equalsIgnoreCase("3DH")){
                    memory.getCellsReserved().forEach(x->{
                        if(x.getName().equalsIgnoreCase(valueDX)){
                            x.setInstructionAH(valueDX);
                            x.setIsOpen(true);
                        }
                    });
                }  
                else if(getOperationAh.equalsIgnoreCase("4DH")){
                    memory.getCellsReserved().forEach(x->{
                        if(x.getName().equalsIgnoreCase(valueDX)){
                            if(x.isIsOpen()){
                                System.out.println("--DATA--");
                                System.out.println(valueAL);
                            }
                            else{
                                String message = "AVISO! EL ARCHIVO NO ESTA ABIERTO";
                                JOptionPane.showMessageDialog(new JFrame(), message, "ERROR", JOptionPane.INFORMATION_MESSAGE);
                            }
                        }
                    });
                }  
                else if(getOperationAh.equalsIgnoreCase("40H")){
                    memory.getCellsReserved().forEach(x->{
                        if(x.getName().equalsIgnoreCase(valueDX)){
                            if(x.isIsOpen()){
                                x.setInstructionAH(x.getInstructionAH().concat(",").concat(valueAL));
                            }else{
                                String message = "AVISO! EL ARCHIVO NO ESTA ABIERTO";
                                JOptionPane.showMessageDialog(new JFrame(), message, "ERROR", JOptionPane.INFORMATION_MESSAGE);
                            } 
                        }
                    });
                }  
                else if(getOperationAh.equalsIgnoreCase("41H")){
                    int i =0;
                    for(;i<memory.getCellsReserved().size();i++){
                        if(memory.getCellsReserved().get(i).getName().equalsIgnoreCase(valueDX)){
                            if(memory.getCellsReserved().get(i).isIsOpen()){
                                memory.getCellsReserved().remove(i);
                            }
                            else{
                                String message = "AVISO! EL ARCHIVO NO ESTA ABIERTO";
                                JOptionPane.showMessageDialog(new JFrame(), message, "ERROR", JOptionPane.INFORMATION_MESSAGE);
                            }
                        }
                        i++;
                    }
                    memory.setUserMemSize(memory.getUserMemSize()+1);
                }  
            }
            
        }
        return memory;
    }
    
    /**
     * 
     * @param register
     * @param instruction
     * @return 
     */
    //Suma al AC el valor del registro
    public Map<String, String> add(Map<String, String> register, String instruction){
        String[] instr = instruction.split(" ");
        if(instr[0].equalsIgnoreCase("ADD")){
            int ac = Integer.parseInt(register.get("AC"))
                    +Integer.parseInt(register.get(instr[1]));
            register.replace("AC", String.valueOf(ac));
        }
        return register;
    }
    
    /**
     * 
     * @param register
     * @param instruction
     * @return 
     */
    //Resta al AC el valor del registro
    public Map<String, String> sub(Map<String, String> register, String instruction){
        String[] instr = instruction.split(" ");
        if(instr[0].equalsIgnoreCase("SUB")){
            int ac = Integer.parseInt(register.get("AC"))
                    -Integer.parseInt(register.get(instr[1]));
            register.replace("AC", String.valueOf(ac));
        }
        return register;
    }
    
    /**
     * 
     * @param register
     * @param instruction
     * @return 
     */
    //Incrementa
    //1-Incrementa en 1 el valor del AC
    //2-Incrementa en 1 el valor ubicado en el registro 
    public Map<String, String> inc(Map<String, String> register, String instruction){
        if(!instruction.contains(" ") && instruction.equalsIgnoreCase("INC")){
            int ac = Integer.parseInt(register.get("AC"))+1;
            register.replace("AC", String.valueOf(ac));
        }
        if(instruction.contains(" ")){
            String[] instr = instruction.split(" ");
            int regV = Integer.parseInt(register.get(instr[1]))+1;
            register.replace(instr[1], String.valueOf(regV));
        }
        return register;
    }
    
    /**
     * 
     * @param register
     * @param instruction
     * @return 
     */
    //Incrementa
    //1-Decrementa en 1 el valor del AC
    //2-Decrementa en 1 el valor ubicado en el registro 
    public Map<String, String> dec(Map<String, String> register, String instruction){
        if(!instruction.contains(" ") && instruction.equalsIgnoreCase("DEC")){
            int ac = Integer.parseInt(register.get("AC"))-1;
            register.replace("AC", String.valueOf(ac));
        }
        if(instruction.contains(" ")){
            String[] instr = instruction.split(" ");
            int regV = Integer.parseInt(register.get(instr[1]))-1;
            register.replace(instr[1], String.valueOf(regV));
        }
        return register;
    }
    
    /**
     * 
     * @param register
     * @param instruction
     * @return 
     */
    //Intercambian los valores entre los registros
    public Map<String, String> swap(Map<String, String> register, String instruction){
        String[] instr = instruction.split(" ");
        if(instr[0].equalsIgnoreCase("SWAP")){
            String[] regV = instr[1].split(",");
            String valueRegister1 = register.get(regV[0]);            String valueRegister2 = register.get(regV[1]);
            register.replace(regV[0], valueRegister2);
            register.replace(regV[1], valueRegister1);
        }
        return register;
    }
    
    /**
     * 
     * @param instruction
     * @return 
     */
    //Finaliza el programa 
    public boolean exit(String instruction){
        boolean result = false;
        if(instruction.equalsIgnoreCase("INT 20H")){
            result=true;
        }
        return result;
    }
    
    /**
     * 
     * @param register
     * @param instruction 
     */
    //Finaliza el programa se imprime el valor del DX
    public void print(Map<String, String> register, String instruction){
        if(instruction.equalsIgnoreCase("INT 10H")){
            System.out.println("");
            System.out.println(register.get("DX"));
        }
    }
    
    /**
     * 
     * @param register
     * @param instruction
     * @return 
     */
    //Entrada del teclado (solo numérico 0-255), el valor se guarda en el DX, finaliza con un ENTER
    public Map<String, String> read(Map<String, String> register, String instruction){
        Scanner reader = new Scanner(System.in);
        if(instruction.equalsIgnoreCase("INT 09H")){
            System.out.println("Escriba un valor numerico entre 0 a 255: ");
            int numero = reader.nextInt();
            if(numero>255 || numero<0){
                read(register, instruction);
            }
            Scanner input= new Scanner(System.in);
            System.out.println("Presiona la tecla Enter para finalizar");
            String readString = input.nextLine();
            while(readString!=null) {
                System.out.println(readString);
                if (readString.equals("")){
                    System.out.println("Tecla Enter presionada");
                    register.replace("DX", String.valueOf(numero));
                    System.out.println("Se guardado el registro en el DX");
                    return register;
                }     
                if (input.hasNextLine()){
                    readString = input.nextLine();
                }                    
                else{
                    readString = null;
                }                    
            }            
        }
        return register;
    }
    
    /**
     * 
     * @param stack
     * @param register
     * @param instruction
     * @return 
     */
    //Forma de representar los parámetros de entrada. Los valores v1, v2 .. vn serán 
    //numéricos y se guardará en pila. Máximo 3 parámetros de entrada
    public Stack param(Stack stack, Map<String, String> register, String instruction){
        String[] instr = instruction.split(" ");
        if(instr[0].equalsIgnoreCase("PARAM")){
            boolean containsComma = instr[1].contains(",");
            if(!containsComma){
                stack.push(instr[1]);
            }
            if(containsComma){
                String[] regV = instr[1].split(",");
                if(regV.length<4){
                    for (String regV1 : regV) {
                        stack.push(regV1);
                    }
                }
            }
        }
        return stack;
    }
    /**
     * 
     * @param stack
     * @param register
     * @param instruction
     * @return 
     */
    //Guarda en la pila el valor del registro ....
    public Stack push(Stack stack, Map<String, String> register, String instruction){
        String[] instr = instruction.split(" ");
        if(instr[0].equalsIgnoreCase("PUSH") && stack.size()<=5){
            String value = register.get(instr[1]);
            stack.push(value);
        }
        else {
            //retorna mensaje de error de desbordamiento para mostrar al usuario, pensar en usar bandera para mostrar en la interfaz
            //igual para el pop
        }
        
        return stack;
    }
    
    /**
     * Obtiene el primer valor de la pila y lo almacena en el registro indicado
     * @param stack
     * @param register
     * @param instruction
     * @return 
     */
    public Stack pop(Stack stack, Map<String, String> register, String instruction){
        String[] instr = instruction.split(" ");
        if(instr[0].equalsIgnoreCase("POP") && !stack.empty()){
            String registerDestiny = instr[1];
            register.replace(registerDestiny, String.valueOf(stack.pop())); 
        }
        else {
            //retorna mensaje de error de desbordamiento para mostrar al usuario, pensar en usar bandera para mostrar en la interfaz
            //igual para el push
        }
        
        return stack; //revisar que devuelve el pop o dejarlo asi
    }
    
    /**
     * Realiza la comparacion entre los registros y modifica la bandera de salto
     * @param register
     * @param instruction
     * @return 
     */
    public Map<String, String> cmp(Map<String, String> register, String instruction) {
        String[] instr = instruction.split(" ");
        if(instr[0].equalsIgnoreCase("CMP")) {
            boolean containsComma = instr[1].contains(",");
            if (containsComma) {
                String[] registers = instr[1].split(",");
                String value1 = register.get(registers[0]);
                String value2 = register.get(registers[1]);
                if (value1.equals(value2)) {
                    register.replace("FLAG", "true"); //bandera para salto JE(true)
                }
                else {
                    register.replace("FLAG", "false"); //bandera para salto JNE(false)
                }
                return register;
            }
        }
        return register;
    }
    
    public Map<String, String> int09h(Map<String, String> register, String value) {
        int val = Integer.parseInt(value);
        if (val>0 & val<255) {
            register.replace("DX", String.valueOf(value));
        }
        else {
            //imprimir
        }
        return register;
        
    }
    
}
