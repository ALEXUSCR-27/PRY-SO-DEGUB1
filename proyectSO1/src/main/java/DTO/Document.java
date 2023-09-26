/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author chuck.a
 * Clase para manejar la informacion de los archivos o documentos
 */
public class Document {
    private int index;
    private String name;
    private String location;
    private int numberLines;

    public Document() {
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
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

    public int getNumberLines() {
        return numberLines;
    }

    public void setNumberLines(int numberLines) {
        this.numberLines = numberLines;
    }

    @Override
    public String toString() {
        return "Document{" + "index=" + index + ", name=" + name + ", location=" + location + ", numberLines=" + numberLines + '}';
    }
}
