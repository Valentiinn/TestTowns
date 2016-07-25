package com.towns.common;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ReadFile {
    ArrayList<String> list = new ArrayList<>();

    public void fillList() {
        try (BufferedReader reader = new BufferedReader(new FileReader(new File("towns.txt")))) {
            String word = null;
            while ((word = reader.readLine()) != null) {
                list.add(word);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public String sendAnswer(String word) {
        char last = word.charAt(word.length() - 1);
        int low = 0;
        int high = list.size() - 1;
        while (low <= high) {
            int medium = high - (high - low) / 2;
            if (list.get(medium).charAt(0) == Character.toUpperCase(last)) return list.get(medium);
            else if (list.get(medium).charAt(0) > Character.toUpperCase(last)) high = medium - 1;
            else low = medium + 1;
        }
        return null;
    }


    public boolean isContains(String city) {
        int low = 0;
        int high = list.size() - 1;
        while (low <= high) {
            int medium = high - (high - low) / 2;
            if (list.get(medium).equalsIgnoreCase(city)) {
                return true;
            } else if (list.get(medium).compareToIgnoreCase(city) > 0) high = medium - 1;
            else low = medium + 1;
        }
        return false;
    }
}
