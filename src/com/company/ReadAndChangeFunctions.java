package com.company;

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
        String line;
        String graphLine;
        int size;
        for (int i = 1; i < maze.size() - 1; i++) {
            line = maze.get(i);
            graphLine = "";
            size = line.length();
            for (int j = 1; j <= size; j++) {
                if (j == 1 || j == size - 1) {
                    graphLine += " ";
                } else {
                    switch (line.substring(j - 1, j)) {
                        case "X":
                            graphLine += " ";
                            break;
                        case " ":
                            if (!line.substring(j - 2, j + 1).contains("X") ) {
                                graphLine += "X";
                            }
                            else {
                                graphLine+= " ";
                            }

                    }
                }

            }
            graph.add(graphLine);
        }

        printList(graph);

    }

    private static void printList(List<String> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        System.out.println();
    }
}
