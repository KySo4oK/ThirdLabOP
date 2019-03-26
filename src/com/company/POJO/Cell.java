package com.company.POJO;

public class Cell {
    private int idX;
    private int idY;
    private Cell parent;
    private int weight;

    public Cell(int idX, int idY) {
        this.idX = idX;
        this.idY = idY;
    }


    public int getIdX() {
        return idX;
    }

    public void setIdX(int idX) {
        this.idX = idX;
    }

    public int getIdY() {
        return idY;
    }

    public void setIdY(int idY) {
        this.idY = idY;
    }


    public Cell getParent() {
        return parent;
    }

    public void setPerent(Cell perent) {
        this.parent = perent;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}
