package com.company.Controller;

import com.company.POJO.Cell;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class ReadAndChangeFunctions {
    private static final String nameOfInputFile = "Maze.txt";
    private static List<String> maze = new ArrayList<>();
    private static List<String> graph = new ArrayList<>();
    public static int[][] matrixOfGraph;

    private static final String[] alpha = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o",
            "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};

    public static void readAndFillList() {
        try (Reader reader = new FileReader(nameOfInputFile)) {
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
                        matrixOfGraph[i][j - 1] = 0;
                    } else {
                        switch (line.substring(j - 1, j)) {
                            case "X":
                                graphLine += " ";
                                matrixOfGraph[i][j - 1] = 0;
                                break;
                            case " ":
                                if (!line.substring(j - 2, j + 1).contains("X")) {
                                    graphLine += "X";
                                    matrixOfGraph[i][j - 1] = 1;
                                } else {
                                    graphLine += " ";
                                    matrixOfGraph[i][j - 1] = 0;
                                }

                        }
                    }

                }
            }
            graph.add(graphLine);
        }
        System.out.println("Your graph: ");
        printList(graph);

    }

    public static void printMatrix() {
        for (int i = 0; i < matrixOfGraph.length; i++) {
            for (int j = 0; j < matrixOfGraph[i].length; j++) {
                System.out.print(matrixOfGraph[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static List<Cell> namedPath(List<Cell> path){
        Cell current;
        int j = 0;
        for (int i = 0; i < path.size() ; i++) {
            current = path.get(i);
            if (j < 10) {
                current.setName(Integer.toString(j));
            } else {
                current.setName(alpha[j - 10]);
            }
            j++;


        }
        return path;
    }

    public static void fillPath(List<Cell> path) {
        List<String> newMaze = new ArrayList<>();
        List<Cell> namedPath = namedPath(path);
        String newLine;
        String[] line;
        for (int i = 0; i < maze.size(); i++) {
            line = maze.get(i).split("");
            newLine = "";
            for (int k = 0; k < line.length; k++) {
                switch (line[k]) {
                    case "X":
                        newLine += "X";
                        break;
                    case " ":
                        if (line[k - 1] != "X" && line[k + 1] != "X") {
                            if (findByCor(i, k, path) == true) {
                                newLine += findNameOfCellByCor(i, k, path);

                            }
                            else {
                                newLine+= " ";
                            }
                        } else {
                            newLine += " ";
                        }


                }

            }
            newMaze.add(newLine);
        }
        printList(newMaze);


    }

    private static String findNameOfCellByCor(int x, int y, List<Cell> path){
        String result = " ";
        Cell current;
        for (int i = 0; i < path.size(); i++) {
            current = path.get(i);
            if (current.getIdY() == y && current.getIdX() == x) {
                result = current.getName();
                break;
            }

        }

        return result;
    }

    private static boolean findByCor(int x, int y, List<Cell> path) {
        Cell current;
        Boolean mark = false;
        for (int i = 0; i < path.size(); i++) {
            current = path.get(i);
            if (current.getIdY() == y && current.getIdX() == x) {
                mark = true;
                break;
            }

        }

        return mark;
    }

    private static void printList(List<String> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        System.out.println();
    }

    public static void printCellList(List<Cell> list) {
        Cell element;
        for (int i = 0; i < list.size(); i++) {
            element = list.get(i);
            System.out.print("( " + element.getIdX() + ", " + element.getIdY() + ")");
        }
        System.out.println();
    }
}
