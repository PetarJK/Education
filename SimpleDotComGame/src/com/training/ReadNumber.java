package com.training;

import java.io.*;

public class ReadNumber {

    public String getUserInput(String prompt) {
        String inputLine = null;
        System.out.print(prompt + " ");

        BufferedReader is = new BufferedReader(
                new InputStreamReader(System.in));
        try {
            inputLine = is.readLine();
            if (inputLine.length() == 0)
                return null;
        } catch (IOException e) {
            System.out.println("IOException: " + e);
        }
        return inputLine;
    }
}
