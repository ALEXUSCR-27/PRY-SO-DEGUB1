/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

import java.util.List;
import java.util.Stack;

/**
 *
 * @author asmal
 */
public class BCP {
    String state = "Nuevo";
    String PC;
    Registers programRegisters;
    Stack stack;
    String addressCPU;
    String e_s_State;
    String startupTime;
    String spentTime;
    String nextBCPAdress;
    String ramAddress;
    String endingAdress;
    String priority;
    int size = 0;
    String programName = "";
    int programSize = 0;
    int actualInstruction = 0;
    int cantClics = 1;
    int position = 0;

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public int getCantClics() {
        return cantClics;
    }

    public void setCantClics(int cantClics) {
        this.cantClics = cantClics;
    }
    private List<WeightTable> instructions;
    

    public int getActualInstruction() {
        return actualInstruction;
    }

    public void setActualInstruction(int actualInstruction) {
        this.actualInstruction = actualInstruction;
    }
    

    public List<WeightTable> getInstructions() {
        return instructions;
    }

    public void setInstructions(List<WeightTable> instructions) {
        this.instructions = instructions;
    }

    public int getProgramSize() {
        return programSize;
    }

    public void setProgramSize(int programSize) {
        this.programSize = programSize;
    }

    public String getProgramName() {
        return programName;
    }

    public void setProgramName(String programName) {
        this.programName = programName;
    }

    @Override
    public String toString() {
        return "BCP{" + "state=" + state + ", PC=" + PC + ", programRegisters=" + programRegisters + ", stack=" + stack + ", addressCPU=" + addressCPU + ", e_s_State=" + e_s_State + ", startupTime=" + startupTime + ", spentTime=" + spentTime + ", nextBCPAdress=" + nextBCPAdress + ", ramAddress=" + ramAddress + ", endingAdress=" + endingAdress + ", priority=" + priority + ", size=" + size + ", programName=" + programName + ", programSize=" + programSize + ", actualInstruction=" + actualInstruction + ", instructions=" + instructions + '}';
    }

  

    


    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
    
    public BCP() {}

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPC() {
        return PC;
    }

    public void setPC(String PC) {
        this.PC = PC;
    }

    public Registers getProgramRegisters() {
        return programRegisters;
    }

    public void setProgramRegisters(Registers programRegisters) {
        this.programRegisters = programRegisters;
    }

    public Stack getStack() {
        return stack;
    }

    public void setStack(Stack stack) {
        this.stack = stack;
    }

    public String getAddressCPU() {
        return addressCPU;
    }

    public void setAddressCPU(String addressCPU) {
        this.addressCPU = addressCPU;
    }

    public String getE_s_State() {
        return e_s_State;
    }

    public void setE_s_State(String e_s_State) {
        this.e_s_State = e_s_State;
    }

    public String getStartupTime() {
        return startupTime;
    }

    public void setStartupTime(String startupTime) {
        this.startupTime = startupTime;
    }

    public String getSpentTime() {
        return spentTime;
    }

    public void setSpentTime(String spentTime) {
        this.spentTime = spentTime;
    }

    public String getNextBCPAdress() {
        return nextBCPAdress;
    }

    public void setNextBCPAdress(String nextBCPAdress) {
        this.nextBCPAdress = nextBCPAdress;
    }

    public String getRamAddress() {
        return ramAddress;
    }

    public void setRamAddress(String ramAddress) {
        this.ramAddress = ramAddress;
    }

    public String getEndingAdress() {
        return endingAdress;
    }

    public void setEndingAdress(String endingAdress) {
        this.endingAdress = endingAdress;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    
}
