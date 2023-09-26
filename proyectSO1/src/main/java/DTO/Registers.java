/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Caili
 * Clase para manejar los registros del procesador
 */
public class Registers {
    Map<String, String> register = new HashMap<>();

    public Registers() {
        register.put("AX", "0");
        register.put("BX", "0");
        register.put("CX", "0");
        register.put("DX", "0");
        register.put("AC", "0");
        register.put("AH", "0");
        register.put("AL", "0");
        register.put("PC", "0");
        register.put("IR", "0");
        register.put("FLAG", "false");
    }

    public Map<String, String> getRegister() {
        return register;
    }

    public void setRegister(Map<String, String> register) {
        this.register = register;
    }

    @Override
    public String toString() {
        return "Registers{" + "register=" + register + '}';
    }
}
