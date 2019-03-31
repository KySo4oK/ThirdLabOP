package com.company.POJO;

public class Cell {
    private int idX;
    private int idY;
    private Cell parent;
    private int weight;
    private String name = " ";

    public void setIdX(int idX) {
        this.idX = idX;
    }

    public void setIdY(int idY) {
        this.idY = idY;
    }

    public Cell getParent() {
        return parent;
    }

    public void setParent(Cell parent) {
        this.parent = parent;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }


    public Cell(int idX, int idY) {
        this.idX = idX;
        this.idY = idY;

    }


    public int getIdX() {
        return idX;
    }


    public int getIdY() {
        return idY;
    }

}
