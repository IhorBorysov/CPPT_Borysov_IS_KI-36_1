package LAB_02;

import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

            Scanner scanner = new Scanner(System.in);
            FileWriter fileWriter = new FileWriter("Lab_02.txt");

            System.out.print("Введіть розмір квадратної матриці: ");
            int size = scanner.nextInt();
            char[][] arr = new char[size][];

            for (int i = 0; i < size; i++) {
                arr[i] = new char[size];
            }


            System.out.print("Введіть символ-заповнювач: ");
            String filler = scanner.nextLine();
            filler = scanner.nextLine();
            exit:
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < arr[i].length; j++) {
                    if (filler.length() == 1) {
                        if (i % 2 != 0) {
                            arr[i][j] = (char) filler.codePointAt(0);
                        } else {
                            arr[i][j] = ' ';
                        }
                        System.out.print(arr[i][j] + " ");
                        fileWriter.write(arr[i][j] + " ");
                    } else if (filler.length() == 0) {
                        System.out.println("Не введено символ заповнювач");
                        break exit;
                    } else {
                        System.out.println("Забагато символів заповнювачів");
                        break exit;
                    }
                }
                System.out.print("\n");
                fileWriter.write("\n");
            }
        fileWriter.flush();
        fileWriter.close();
    }
}