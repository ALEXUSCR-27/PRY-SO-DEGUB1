/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author Caili
 * Clase que maneja los fallos de las instrucciones contiene mensajes
 */
public class ErrorFail {
    private int numLine;
    private String instruction;
    private String message;
    private boolean isError;

    public ErrorFail() {
    }

    public ErrorFail(int numLine, String instruction, String message, boolean isError) {
        this.numLine = numLine;
        this.instruction = instruction;
        this.message = message;
        this.isError = isError;
    }
    
    

    public int getNumLine() {
        return numLine;
    }

    public void setNumLine(int numLine) {
        this.numLine = numLine;
    }

    public String getInstruction() {
        return instruction;
    }

    public void setInstruction(String instruction) {
        this.instruction = instruction;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isIsError() {
        return isError;
    }

    public void setIsError(boolean isError) {
        this.isError = isError;
    }

    @Override
    public String toString() {
        return "Error{" + "numLine=" + numLine + ", instruction=" + instruction + ", message=" + message + ", isError=" + isError + '}';
    }
}
