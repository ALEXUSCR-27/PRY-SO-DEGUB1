/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

import java.util.List;

/**
 *
 * @author Caili
 * Clase para manejar informacion importante en las celdas...
 */
public class Cell {
    
    private String name;
    private String location;
    private Integer startingAddress;
    private Integer endindAddress;
    private Integer index;
    private boolean isReserved;
    private String instructionAH;
    private List<WeightTable> instructions;
    private boolean isOpen;
    private BCP bcp;

    public String getInstructionAH() {
        return instructionAH;
    }

    public void setInstructionAH(String instructionAH) {
        this.instructionAH = instructionAH;
    }
    
    public BCP getBcp() {
        return bcp;
    }

    public void setBcp(BCP bcp) {
        this.bcp = bcp;
    }
    
    public Cell() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
    
    

    public Integer getStartingAddress() {
        return startingAddress;
    }

    public void setStartingAddress(Integer startingAddress) {
        this.startingAddress = startingAddress;
    }

    public Integer getEndindAddress() {
        return endindAddress;
    }

    public void setEndindAddress(Integer endindAddress) {
        this.endindAddress = endindAddress;
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    
    public boolean isIsReserved() {
        return isReserved;
    }

    public void setIsReserved(boolean isReserved) {
        this.isReserved = isReserved;
    }
    
    public List<WeightTable> getInstructions() {
        return instructions;
    }

    public void setInstructions(List<WeightTable> instructions) {
        this.instructions = instructions;
    }

    public boolean isIsOpen() {
        return isOpen;
    }

    public void setIsOpen(boolean isOpen) {
        this.isOpen = isOpen;
    }

    @Override
    public String toString() {
        return "Cell{" + "name=" + name + ", location=" + location + ", startingAddress=" + startingAddress + ", endindAddress=" + endindAddress + ", index=" + index + ", isReserved=" + isReserved + ", instructionAH=" + instructionAH + ", instructions=" + instructions + ", isOpen=" + isOpen + ", bcp=" + bcp + '}';
    }
}
