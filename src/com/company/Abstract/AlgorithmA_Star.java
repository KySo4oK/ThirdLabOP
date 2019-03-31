package com.company.Abstract;


import com.company.Controller.ReadAndChangeFunctions;
import com.company.POJO.Cell;
import com.company.POJO.MyQueerWithPriority;

import java.util.ArrayList;
import java.util.List;


public class AlgorithmA_Star {
    private int numberOfSteps = 0;
    private Cell last;
    private Cell start;

    private List<Cell> alreadyVisited = new ArrayList<>();
    private MyQueerWithPriority<Cell> allCells = new MyQueerWithPriority<>();
    private List<Cell> pathOfCell = new ArrayList<>();

    public AlgorithmA_Star(int xStart, int yStart, int xEnd, int yEnd, int[][] cells) {
        this.last = new Cell(xEnd, yEnd);
        last.setWeight(0);
        this.start = new Cell(xStart, yStart);
        start.setWeight(calculateD(start));
        fillQueueOfAllCells(cells); // fill our queue with priority with cell of our graph

    }

    public List<Cell> search() {
        MyQueerWithPriority<Cell> willBeVisited = new MyQueerWithPriority<>();
        willBeVisited.push(start, start.getWeight());
        Cell current;
        MyQueerWithPriority<Cell> neighbors;

        while (willBeVisited.getSize() != 0) {
            current = getMinWeight(willBeVisited); // find the best direction from queue of available
            if (current.getIdX() == last.getIdX() && current.getIdY() == last.getIdY()) { // we found our path
                buildPath(start, current);// function that build your path
                return pathOfCell;
            } else {
                willBeVisited.remove(current, current.getWeight()); // deletes current node from "has`t visited " list
                alreadyVisited.add(current);
                neighbors = findNeighbors(current);
                boolean markForBetterPath;
                Cell myNeighbor;
                int size = neighbors.getSize();
                for (int i = 0; i < size; i++) {
                    myNeighbor = (Cell) neighbors.pop().getItem();
                    if (isThere(myNeighbor, alreadyVisited) == true) { // if we have already be in this node before we pass it
                        continue;
                    } else {
                        if (isAdded(willBeVisited, myNeighbor) == false) {
                            willBeVisited.push(myNeighbor, myNeighbor.getWeight()); // we have never had access to this node
                            markForBetterPath = true;
                        } else {
                            if (calculateD(myNeighbor) > current.getWeight()) {
                                markForBetterPath = true;
                            } else {
                                markForBetterPath = false;
                            }

                        }

                        if (markForBetterPath == true) {
                            myNeighbor.setParent(current);
                            myNeighbor.setWeight(calculateD(myNeighbor));

                        }
                    }


                }
            }


        }

        return pathOfCell;
    }


    public MyQueerWithPriority findNeighbors(Cell current) { // method that finds neighbors of current node
        MyQueerWithPriority<Cell> newAllCells = new MyQueerWithPriority<>();
        MyQueerWithPriority<Cell> border = new MyQueerWithPriority();
        int size = allCells.getSize();
        Cell element;

        for (int i = 0; i < size; i++) {
            element = (Cell) allCells.pop().getItem();
            if ((Math.abs(element.getIdX() - current.getIdX()) == 1 && element.getIdY() == current.getIdY()) ||
                    (Math.abs(element.getIdY() - current.getIdY()) == 1 && element.getIdX() == current.getIdX())) {
                border.push(element, element.getWeight());
            }
            newAllCells.push(element, element.getWeight());
        }


        allCells = newAllCells;
        return border;
    }


    private int calculateD(Cell current) { // method that calculate distance(weight for current node)
        return numberOfSteps + functionToCalculateFromCurrentToLast(current);
    }

    private boolean isThere(Cell current, List<Cell> list) { // method that checks if we have been in this node before
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getIdX() == current.getIdX() && list.get(i).getIdY() == current.getIdY()) {
                return true;
            }
        }
        return false;
    }

    public void buildPath(Cell start, Cell last) {// method that builds pass from end
        Cell temp = last;
        while (temp != start) {
            pathOfCell.add(temp);
            temp = temp.getParent();
        }
        pathOfCell.add(start);
        int size = pathOfCell.size();
        int startFillInt = size;
        temp = last;
        while (temp != start.getParent()) {
            setValueOfCell(startFillInt, temp);
            temp = temp.getParent();
            startFillInt--;
        }
    }

    private boolean isAdded(MyQueerWithPriority<Cell> queue, Cell element) {// method that checks if we have had access
        // to  this node before
        MyQueerWithPriority<Cell> newQ = new MyQueerWithPriority<>();
        int size = queue.getSize();
        Cell current;
        boolean mark = false;
        for (int i = 0; i < size; i++) {
            current = (Cell) queue.pop().getItem();
            if (current == element) {
                mark = true;
            }
            newQ.push(current, current.getWeight());

        }

        Cell newCurrent;
        for (int i = 0; i < size; i++) {
            newCurrent = (Cell) newQ.pop().getItem();
            queue.push(newCurrent, newCurrent.getWeight());
        }
        return mark;
    }

    void setValueOfCell(int a, Cell temp) {
        ReadAndChangeFunctions.matrixOfGraph[temp.getIdX()][temp.getIdY()] = a;
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

    private Cell getMinWeight(MyQueerWithPriority<Cell> queue) {
        MyQueerWithPriority<Cell> newQ = new MyQueerWithPriority<>();
        int size = queue.getSize();
        Cell minimum = (Cell) queue.pop().getItem();
        Cell current = minimum;
        boolean mark = false;
        for (int i = 1; i < size; i++) {
            mark = true;
            newQ.push(current, current.getWeight());
            current = (Cell) queue.pop().getItem();
            if (minimum.getWeight() < current.getWeight()) {
                minimum = current;
            }
            newQ.push(current, current.getWeight());

        }
        if (mark == false) {
            newQ.push(current, current.getWeight());
        }

        Cell temp;
        for (int i = 0; i < size; i++) {
            temp = (Cell) newQ.pop().getItem();
            queue.push(temp, temp.getWeight());
        }
        return minimum;
    }


    private int functionToCalculateFromCurrentToLast(Cell current) {
        int pathX = Math.abs(current.getIdX() - last.getIdX());
        int pathY = Math.abs(current.getIdY() - last.getIdY());


        return pathX + pathY;
    }

}