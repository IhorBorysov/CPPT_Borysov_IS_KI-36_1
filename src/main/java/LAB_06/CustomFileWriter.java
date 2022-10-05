package LAB_06;

import java.io.*;
import java.util.Scanner;

public class CustomFileWriter {
     // Метод читає double як txt з файлу і повертає його

    public static double readDoubleAsText(String fileName) throws FileNotFoundException {
        double res = 0.0d;

        Scanner inFile = new Scanner(new File(fileName));
        res = inFile.nextDouble();
        inFile.close();

        return res;
    }

     // Метод записує double як текстові дані у файл

    public static void writeDoubleAsText(String fileName, double x) throws FileNotFoundException {
        PrintWriter outFile = new PrintWriter(fileName);

        outFile.printf("%f", x);
        outFile.flush();
        outFile.close();
    }

     // метод зчитує double як bin з файлу і повертає його

    public static double readDoubleAsBin(String fileName) throws FileNotFoundException, IOException {
        double res = 0.0d;

        DataInputStream inFile = new DataInputStream(new FileInputStream(fileName));
        res = inFile.readDouble();
        inFile.close();

        return res;
    }

     // метод записує double як bin дані в файл

    public static void writeDoubleAsBin(String fileName, double x) throws FileNotFoundException, IOException {
        DataOutputStream outFile = new DataOutputStream(new FileOutputStream(fileName));

        outFile.writeDouble(x);
        outFile.flush();
        outFile.close();
    }
}
