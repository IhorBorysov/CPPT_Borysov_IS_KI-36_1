package LAB_05;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            System.out.print("Enter a file name: ");
            Scanner in = new Scanner(System.in);
            String fileName = in.nextLine();
            if (fileName.length() == 0) {
                fileName = "Lab_05.txt";
            }
            System.out.print("Enter X: ");
            Calculate calculate = new Calculate();
            int res = in.nextInt();

            /**вивід інформації в файл */
            PrintWriter file = new PrintWriter(new File(fileName));

            file.println(calculate.execute(res));
            file.close();
            System.out.println(calculate.execute(res));
        }
        /**тип 1 виключення */
        catch (FileNotFoundException e) {
            //блок перехоплює помилки роботи з файлом
            System.err.println("Can't open file.");
            System.exit(1);
        }
        /**тип 2 виключення */
        catch (CalculateException e) {
            //блок перехоплює помилки обчислень виразу
            System.err.println(e.getMessage());
            System.exit(1);
        }
    }
}
