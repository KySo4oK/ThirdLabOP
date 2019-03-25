package com.company.Controller;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class ReadAndChangeFunctions {
    private static final String nameOfFile = "Maze.txt";
    private static List<String> maze = new ArrayList<>();
    private static List<String> graph = new ArrayList<>();
    private static int[][] matrixOfGraph;

    public static void readAndFillList() {
        try (Reader reader = new FileReader(nameOfFile)) {
            Scanner scanner = new Scanner(reader);
            String line = scanner.nextLine();
            boolean mark = false;

            while (mark == false) {
                maze.add(line);
                if (scanner.hasNext()) {
                    line = scanner.nextLine();
                } else {
                    mark = true;
                }
            }


        } catch (IOException e) {
            e.printStackTrace();
        }



        printList(maze);
    }

    public static void fillGraph() {
        matrixOfGraph = new int[maze.size()][maze.get(0).length()];
        String line;
        String graphLine;
        int size;
        for (int i = 0; i < maze.size(); i++) {
            line = maze.get(i);
            graphLine = "";
            size = line.length();
            for (int j = 1; j <= size; j++) {
                if (i == 0 || i == maze.size() - 1) {
                    matrixOfGraph[i][j - 1] = 0;
                } else {
                    if (j == 1 || j == size - 1) {
                        graphLine += " ";
                        matrixOfGraph[i][j -1] = 0;
                    } else {
                        switch (line.substring(j - 1, j)) {
                            case "X":
                                graphLine += " ";
                                matrixOfGraph[i][j -1] = 0;
                                break;
                            case " ":
                                if (!line.substring(j - 2, j + 1).contains("X")) {
                                    graphLine += "X";
                                    matrixOfGraph[i][j -1] = 1;
                                } else {
                                    graphLine += " ";
                                    matrixOfGraph[i][j -1] = 0;
                                }

                        }
                    }

                }
            }
            graph.add(graphLine);
        }

        printList(graph);
        printMatrix();

    }

    private static void  printMatrix(){
        for (int i = 0; i < matrixOfGraph.length ; i++) {
            for (int j = 0; j < matrixOfGraph[i].length ; j++) {
                System.out.print(matrixOfGraph[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void printList(List<String> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        System.out.println();
    }
}
