package com.company.POJO;

public class Cell {
    private int idX;
    private int idY;
<<<<<<< Updated upstream
    private boolean isPath;
    public Cell par;

    public void setD(int d) {
        this.d = d;
    }

    private int d = 0;

    public Cell(int idX, int idY, boolean isPath) {
        this.idX = idX;
        this.idY = idY;
        this.isPath = isPath;
    }

    public int getD() {
        return d;
    }

    public boolean isPath() {
        return isPath;
=======
    private Cell parent;
    private int weight;

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

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }


    public Cell(int idX, int idY) {
        this.idX = idX;
        this.idY = idY;

>>>>>>> Stashed changes
    }


    public int getIdX() {
        return idX;
    }


    public int getIdY() {
        return idY;
    }

}
