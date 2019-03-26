package com.company.POJO;

public class Cell {
    private int idX;
    private int idY;
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
    }


    public int getIdX() {
        return idX;
    }


    public int getIdY() {
        return idY;
    }

}
