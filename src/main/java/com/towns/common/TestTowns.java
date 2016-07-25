package com.towns.common;

import java.util.HashSet;
import java.util.Scanner;

public class TestTowns {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashSet<String> set = new HashSet<>();
        ReadFile readFile = new ReadFile();
        String input, answer;
        boolean isEnd = true;
        System.out.print("Введите название города: ");
        readFile.fillList();
        while (true) {
            input = scanner.nextLine();
            while (readFile.isContains(input)) {
                answer = readFile.sendAnswer(input);
                if (answer == null) {
                    System.out.println("Город не найден! Игра окночена");
                    isEnd = true;
                    break;
                } else {
                    if (set.contains(answer)) {
                        readFile.list.remove(answer);
                        readFile.sendAnswer(answer);
                    }
                    System.out.print("Ответа компьютера - " + answer + "\n" + "Введите ваш вариант - ");
                    set.add(answer);
                    input = scanner.nextLine();
                }
            }

            if (isEnd) break;

            System.out.println("Такого города в списке нет. Введите снова");
        }
    }

}

