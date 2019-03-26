package com.company.Abstract;

import com.company.POJO.Cell;
import com.company.POJO.MyQueerWithPriority;

import java.util.ArrayList;
import java.util.List;

public class AlgorithmA_Star {
    private int numberOfSteps = 0;
    private Cell last;
    private Cell start;
    private Cell[] border = new Cell[4];

    private List<Cell> alreadyVisited = new ArrayList<>();

    private List<Cell> pathMap = new ArrayList<>();
    private MyQueerWithPriority<Cell> allCells;
    private MyQueerWithPriority queer = new MyQueerWithPriority();

    public AlgorithmA_Star(Cell start, Cell last, int [][] matrix) {
        this.start = start;
        this.last = last;
        fillQueueOfAllCells(matrix);
    }

    private void fillQueueOfAllCells(int[][] matrix) {
        Cell current;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 1) {
                    current = new Cell(i, j);
                    current.setWeight(calculateD(current));
                    allCells.push(current, current.getWeight());
                }
            }
        }

    }


    private int calculateD(Cell current) {
        return numberOfSteps + functionToCalculateFromCurrentToLast(current);
    }

    private boolean isVisited(Cell current) {
        boolean mark = false;
        for (int i = 0; i < alreadyVisited.size(); i++) {
            if (alreadyVisited.get(i) == current) {
                mark = true;
                break;
            }
        }
        return mark;

    }


    private int functionToCalculateFromCurrentToLast(Cell current) {
        int pathX = Math.abs(current.getIdX() - last.getIdX());
        int pathY = Math.abs(current.getIdY() - last.getIdY());
        // current.setD(pathX + pathY);

        return pathX + pathY;
    }

}
