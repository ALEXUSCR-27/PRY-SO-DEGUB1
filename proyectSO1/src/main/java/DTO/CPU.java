/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

import java.util.List;

/**
 *
 * @author asmal
 */
public class CPU {
    List<Cell> loadedBCPS;
    BCP actual = null;
    int cantBCP = 0;
    int operaciones = 5;
    int indexBCP = 0;
    int weight = 0;
    boolean wait = false;
    String[][] process;

    public String[][] getProcess() {
        return process;
    }

    public void setProcess(String[][] process) {
        this.process = process;
    }

    public boolean isWait() {
        return wait;
    }

    public void setWait(boolean wait) {
        this.wait = wait;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
    boolean changeContext = false;

    public boolean isChangeContext() {
        return changeContext;
    }

    public void setChangeContext(boolean changeContext) {
        this.changeContext = changeContext;
    }

    public int getIndexBCP() {
        return indexBCP;
    }

    public void setIndexBCP(int indexBCP) {
        this.indexBCP = indexBCP;
        this.actual = this.loadedBCPS.get(indexBCP).getBcp();
    }


    @Override
    public String toString() {
        return "CPU{" + "loadedBCPS=" + loadedBCPS + ", actual=" + actual + '}';
    }

    public CPU() {
    }

    public List<Cell> getLoadedBCPS() {
        return loadedBCPS;
    }

    public void setLoadedBCPS(List<Cell> loadedBCPS) {
        this.loadedBCPS = loadedBCPS;
        setCantBPC(loadedBCPS.size());
    }

    public int getCantBPC() {
        return cantBCP;
    }

    public void setCantBPC(int cantBPC) {
        this.cantBCP = cantBPC;
    }

    public int getOperaciones() {
        return operaciones;
    }

    public void setOperaciones(int operaciones) {
        this.operaciones = operaciones;
    }


    public BCP getActual() {
        return actual;
    }

    public void setActual(BCP actual) {
        this.actual = actual;
    }
    
    public void setFirstBCP() {
        this.actual = loadedBCPS.get(0).getBcp();
        
    }
    
    public void removeBCP(int i) {
        this.loadedBCPS.remove(i);
        if (this.loadedBCPS.isEmpty()) {
            this.actual = null;
        }
        else {
            this.actual = this.loadedBCPS.get(0).getBcp();
        }
        this.cantBCP = this.loadedBCPS.size();
    }
    
}
