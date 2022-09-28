package LAB_04;

public class Desctop {

    private int width;
    private int height;
    private int frameRate;

    public Desctop() {
        width = 100;
        height = 100;
        frameRate = 60;
    }
    /**конструктор з параметрами */
    public Desctop(int width, int height, int frameRate) {
        if (width < 0 || height < 0 || frameRate < 0) {
            throw new IllegalArgumentException("Desctop width and height must be positive number");
        }
    /**звертаємось до змінних класів */
        this.width = width;
        this.height = height;
        this.frameRate = frameRate;
    }
    /**конструктор для копіювання об'єкту */
    public Desctop(Desctop other) {
        this.width = other.width;
        this.height = other.height;
        this.frameRate = other.frameRate;
    }
    /**методи get i set для задання розміру екрану */
    public int getWidth() { return width; }

    public int getHeight() {
        return height;
    }

    public int getFrameRate() { return frameRate; }
    /**умови задання розмірів екрану з перевіркою */

    public void setWidth(int width) {
        if (width < 0) {
            throw new IllegalArgumentException("Desctop width and height must be positive number");
        }
        this.width = width;
    }

    public void setHeight(int height) {
        if (height < 0) {
            throw new IllegalArgumentException("Desctop width and height must be positive number");
        }
        this.height = height;
    }


    public void setFrameRate(int frameRate) {
        if (frameRate < 0) {
            throw new IllegalArgumentException("Frame rate must be bigger than 0");
        }
        this.frameRate = frameRate;
    }
    /**об'єднання даних і методів роботи з цими даними*/
    public void setResolution(int width, int height) {
        setHeight(height);
        setWidth(width);
    }
}
