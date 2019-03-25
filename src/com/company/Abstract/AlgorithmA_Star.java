package com.company.Abstract;

import com.company.POJO.Cell;
import com.company.POJO.MyQueerWithPriority;
import com.company.POJO.Node;

import java.util.ArrayList;
import java.util.List;

public class AlgorithmA_Star {
    private int numberOfSteps = 0;
    private Cell last;
    private Cell start;
    private Cell[] border = new Cell[4];

    private List<Cell> alreadyVisited = new ArrayList<>();
    private int[][] allCells;
    private MyQueerWithPriority queer = new MyQueerWithPriority();

    public AlgorithmA_Star(Cell last, Cell start, int[][] cells) {
        this.last = last;
        this.start = start;
        this.allCells = cells;
    }

    public void seach() {
        MyQueerWithPriority borderQueer;
        Cell current = start;
        int previousD;
        while (current != last) {
            previousD = calculateD(current);
            borderQueer = new MyQueerWithPriority();
            for (int i = 0; i < border.length; i++) {
                if(border[i].isPath() == false){
                    continue;
                }
                else {
                borderQueer.push(border[i], calculateD(border[i]));}
            }






        }
    }

    public void fillBorder(int x, int y){
        boolean isPath;
        for (int i = 0; i < 4 ; i++) {
            if(allCells[x][y] == 0){
                isPath = false;
            }
            else {
                isPath = true;
            }
            border[i] = new Cell(x, y, isPath);
        }
    }

    private int calculateD(Cell current) {
        return numberOfSteps + functionToCalculateFromCurrentToLast(current) ;
    }



    private int functionToCalculateFromCurrentToLast(Cell current) {
        int pathX = Math.abs(current.getIdX() - last.getIdX());
        int pathY = Math.abs(current.getIdY() - last.getIdY());
        current.setD(pathX + pathY);

        return current.getD();
    }

}
