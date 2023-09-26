/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author Caili
 */
public class JsonMemory {
    private Integer ram;
    private Integer ssd;

    public JsonMemory() {
    }

    public Integer getRam() {
        return ram;
    }

    public void setRam(Integer ram) {
        this.ram = ram;
    }

    public Integer getSsd() {
        return ssd;
    }

    public void setSsd(Integer ssd) {
        this.ssd = ssd;
    }

    @Override
    public String toString() {
        return "JsonMemory{" + "ram=" + ram + ", ssd=" + ssd + '}';
    }
}
