package com.company;

import com.company.Abstract.AlgorithmA_Star;
import com.company.Controller.*;
import com.company.POJO.Cell;

import java.util.List;


public class Main {

    public static void main(String[] args) {
        ReadAndChangeFunctions.readAndFillList();

        ReadAndChangeFunctions.fillGraph();
        AlgorithmA_Star aStar = new AlgorithmA_Star(1, 12, 2, 2, ReadAndChangeFunctions.matrixOfGraph);
        List<Cell> path = aStar.search();
        ReadAndChangeFunctions.printCellList(path);
        System.out.println("Result");
        ReadAndChangeFunctions.fillPath(path);


    }

}
