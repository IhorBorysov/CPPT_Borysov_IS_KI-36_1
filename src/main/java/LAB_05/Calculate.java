package LAB_05;

public class Calculate {
     // Метод обраховує вираз y=sin(x)/ctg(8x)
    public double execute(int x) throws CalculateException {
        double y, rad;
        y = 0.0;
        rad = Math.toRadians(x);
        //x * Math.PI / 180.0;
        try {
            y = Math.sin(rad) / 1 / (8 * Math.tan(rad));
            //якщо результат не є числом, то генеруємо виключення
            if (y == Double.NEGATIVE_INFINITY || y == Double.POSITIVE_INFINITY || Double.isNaN(y) || x == 180 || x == -180) {
                throw new ArithmeticException("Wrong value of x");
            }
        } catch (ArithmeticException e) {
            // обробка виключення
            // виключення вищого рівня з поясненням причини виникнення помилки
            if (rad == Math.abs(Math.PI / 2.0)) {
                throw new CalculateException("Illegal value of X for cotangent function");
            }
        }
        return y;
    }
}
