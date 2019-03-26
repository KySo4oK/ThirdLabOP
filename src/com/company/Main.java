package com.company;

import com.company.Controller.ReadAndChangeFunctions;
import com.company.POJO.MyQueerWithPriority;

public class Main {

    public static void main(String[] args) {
        ReadAndChangeFunctions.readAndFillList();

        ReadAndChangeFunctions.fillGraph();
        MyQueerWithPriority queerWithPriority = new MyQueerWithPriority();



    }
}
