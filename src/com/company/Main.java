package com.company;

import com.company.Abstract.AlgorithmA_Star;
import com.company.Controller.*;
import com.company.POJO.*;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        ReadAndChangeFunctions.readAndFillList();

        ReadAndChangeFunctions.fillGraph();
        AlgorithmA_Star aStar = new AlgorithmA_Star(1, 12, 2, 2, ReadAndChangeFunctions.matrixOfGraph);
        printList(aStar.search());


    }

    public static void printList(List<Cell> list){
        Cell element;
        for (int i = 0; i < list.size() ; i++) {
            element = list.get(i);
            System.out.print("( " + element.getIdX() + ", " + element.getIdY() + ")");
        }
        System.out.println();
    }
}
