package com.company.Abstract;

import com.company.POJO.Cell;
import com.company.POJO.MyQueerWithPriority;
import com.company.POJO.Node;
import com.company.Controller.ReadAndChangeFunctions;

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
    private List<Cell> pathOfCell = new ArrayList<>();

    public AlgorithmA_Star(Cell last, Cell start, int[][] cells) {
        this.last = last;
        this.start = start;
        this.allCells = cells;
    }

    public void search() {
        MyQueerWithPriority borderQueer;
        Cell current = start;
        Cell next = null;
        int previousD;
        int currentD;
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
            Cell temp = next;
            next = (Cell) borderQueer.pop().getItem();
            next.par = temp;

            currentD = calculateD(next);
            if(currentD < previousD && isVisited(next) == false){
                alreadyVisited.add(next);
                numberOfSteps++;
                current = next;
            }
            else {
                if(currentD > previousD){
                    alreadyVisited.add(next);
                }

            }



        }
        buildPath(start, last);
        ReadAndChangeFunctions.printMatrix();
    }

    public void buildPath(Cell start, Cell last){
        Cell temp = last;
        while (temp!=start){
            pathOfCell.add(temp);
            temp = temp.par;
        }
        pathOfCell.add(start);
        int size = pathOfCell.size();
        int startFillInt = size;
        temp = last;
        while (temp!= start.par){
                setValueOfCell(startFillInt, temp);
                temp = temp.par;
                startFillInt--;
        }
    }

    void setValueOfCell(int a, Cell temp) {
        ReadAndChangeFunctions.matrixOfGraph[temp.getIdX()][temp.getIdY()] = a;
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

    private boolean isVisited(Cell current){
        boolean mark = false;
        for (int i = 0; i < alreadyVisited.size() ; i++) {
            if(alreadyVisited.get(i) == current){
                mark = true;
                break;
            }
        }
        return mark;

    }



    private int functionToCalculateFromCurrentToLast(Cell current) {
        int pathX = Math.abs(current.getIdX() - last.getIdX());
        int pathY = Math.abs(current.getIdY() - last.getIdY());
        current.setD(pathX + pathY);

        return current.getD();
    }

}
