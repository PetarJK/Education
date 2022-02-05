package com.training;

import java.io.*;
import java.util.ArrayList;

public class UserInputAndGrid {
    private static final String ALPHABET = "abcdefg";
    private int gridLength = 7;
    private int gridSize = 49;
    private int[] grid = new int[gridSize];
    private int comCount = 0;

    public String getUserInput(String prompt) {
        String inputLine = null;
        System.out.print(prompt + " ");
        try {
            BufferedReader is = new BufferedReader(
                new InputStreamReader(System.in));
            inputLine = is.readLine();
            if (inputLine.length() == 0)
                return null;
        } catch (IOException e) {
            System.out.println("IOException: " + e);
        }
        return inputLine.toLowerCase();
    }

    public ArrayList<String> placeDotCom(int comSize) {
        ArrayList<String> alphabetCells = new ArrayList<>();

        String temp = null;
        int[] coordinates = new int[comSize];
        int attempts = 0;
        boolean success = false;
        int location = 0;

        comCount++;
        int increment = 1;
        if ((comCount % 2) == 1) {
            increment = gridLength;
        }

        while (!success & attempts++ < 200) {
            location = (int) (Math.random() * gridSize);
            //System.out.print("try location" + location);
            int x = 0;
            success = true;
            while (success && x < comSize) {
                if (grid[location] == 0) {
                    coordinates[x++] = location;
                    location += increment;
                    if (location >= gridSize) {
                        success = false;
                    }
                } else {
                    //System.out.print(" used " + location);
                    success = false;
                }
            }
        }

        int x = 0;
        int row = 0;
        int column = 0;
        //System.out.println("\n");
        while (x < comSize) {
            grid[coordinates[x]] = 1;
            row = (int) (coordinates[x] / gridLength);
            column = coordinates[x] % gridLength;
            temp = String.valueOf(ALPHABET.charAt(column));

            alphabetCells.add(temp.concat(Integer.toString(row)));
            x++;
            //System.out.print(" coord " + x + " = " + alphabetCells.get(x - 1));
        }
        //System.out.println("\n");
        return alphabetCells;
    }
}
