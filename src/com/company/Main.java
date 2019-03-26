package com.company;

import com.company.Abstract.AlgorithmA_Star;
import com.company.Controller.ReadAndChangeFunctions;
import com.company.POJO.Cell;
import com.company.POJO.MyQueerWithPriority;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ReadAndChangeFunctions.readAndFillList();
        ReadAndChangeFunctions.fillGraph();
        MyQueerWithPriority queerWithPriority = new MyQueerWithPriority();
        Scanner scan = new Scanner(System.in);
        System.out.println("Start X:");
        int startX = scan.nextInt();
        System.out.println("Start Y:");
        int startY = scan.nextInt();
        Cell start = new Cell(startX,startY,true);
        System.out.println("End X:");
        int lastX = scan.nextInt();
        System.out.println("End Y:");
        int lastY = scan.nextInt();
        Cell last = new Cell(lastX,lastY,true);
        AlgorithmA_Star a = new AlgorithmA_Star(last,start,ReadAndChangeFunctions.matrixOfGraph);
        ReadAndChangeFunctions.printMatrix();


    }
}
