package LAB_06;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {

            String binFileName = "Lab_6.bin";
            String txtFileName = "Lab_6.txt";

            System.out.print("Enter X (in degrees): ");
            double y = Equation.calculate(scanner.nextDouble());

            CustomFileWriter.writeDoubleAsText(txtFileName, y);
            CustomFileWriter.writeDoubleAsBin(binFileName, y);

            double resTxt = CustomFileWriter.readDoubleAsText(txtFileName);
            double resBin = CustomFileWriter.readDoubleAsBin(binFileName);

            System.out.printf("True result: y = %f\n", y);
            System.out.printf("Txt file result: y_txt = %f\n", resTxt);
            System.out.printf("Bin file result: y_bin = %f\n", resBin);
            /**Виконується в будь якому випадку, незалежно від результатів виконання блоку try */

            /**тип 1 виключення */
        }catch (CalculationException calcException) {
            System.out.println(calcException.getMessage());
            /**тип 2 виключення */
        } catch (FileNotFoundException fileException) {
            System.out.printf("File exception was thrown with reason: %s\n", fileException.getMessage());
            /**тип 3 виключення */
        } catch (IOException ioException) {
            System.out.printf("File exception was thrown with reason: %s\n", ioException.getMessage());
        }
        finally {
            scanner.close();
        }
    }
}

