package LAB_06;

public class Equation {

     // метод повертає y=sin(x)/1/(8*tan(x)) як double

    public static double calculate(double xDegrees) throws CalculationException {
        //виключення вищого рівня з поясненням причини виникнення помилки
        if (xDegrees % 180.0d == 0.0d)
            throw new CalculationException("Degrees have illegal value for equation: y=sin(x)/1/(8*tan(x))");

        double rad = Math.toRadians(xDegrees);
        double y = Math.sin(rad) / 1 / (8 * Math.tan(rad));
        //якщо результат не є числом, генеруємо виключення
        if (y == Double.NaN || Double.isInfinite(y))
            throw new CalculationException("Unknown reason caused throw during calculations");

        return y;
    }
}

