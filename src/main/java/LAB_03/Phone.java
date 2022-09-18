package LAB_03;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

/** клас самого об'єкту, який буде використовувати інші класи **/
public class Phone {
    private final Desctop desctop;
    private final Apps apps;
    private String currentApp;
    private boolean working;

    /** зміні які додають кольори в консоль **/
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[43m";
    public static final String ANSI_BLUE = "\u001B[44m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";

    private static final String file = "Lab_03.txt";

    /** конструктор по замовчуванню **/
    public Phone() {
        this.desctop = new Desctop();
        this.working = true;
        this.apps = new Apps();
    }

    /** конструктор із  заданням параметрів **/
    public Phone(int width, int height, int frameRate, Collection<String> apps) {
        this.desctop = new Desctop(width, height, frameRate);
        this.apps = new Apps(apps);
        this.working = false;
    }

    /** конструктор із  заданням параметрів **/
    public Phone(int width, int height, int frameRate) {
        this(width, height, frameRate, Collections.emptyList());
    }

    /** конструктор для копіювання об'єкта **/
    public Phone(Phone Phone) {
        this.apps = new Apps(Phone.apps);
        this.desctop = new Desctop(Phone.desctop);
        this.currentApp = Phone.currentApp;
        this.working = Phone.working;
    }

    /** функція яка нічого не повертає **/
    public void turnOn() {
        filler("Turn on the Phone");
        System.out.println(ANSI_CYAN + "Turn on the Phone" + ANSI_RESET);
        working = true;
    }

    public void turnOff() {
        filler("Turn off the iPhone");
        System.out.println(ANSI_CYAN + "Turn off the iPhone" + ANSI_RESET);
        working = false;
    }

    public void isWorking() {
        filler("Is Phone working: " + working);
    }

    public void settings() {
        filler("                 Current settings                 ");
        System.out.println(ANSI_YELLOW + "                 Current settings                   " + ANSI_RESET);
        getScreenResolution();
        getScreenFrameRate();
        getCurrentApp();
        getApps();
        filler("                                                    ");
        System.out.println(ANSI_BLUE + "                                                    " + ANSI_RESET);
    }

    /** запис тексту в файл **/
    private static void filler(String text) {
        try {
            Files.write(Paths.get(file), (text + "\n").getBytes(), StandardOpenOption.APPEND);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addApp(String... apps) {
        filler("Add programs: " + String.join(", ", apps));
        System.out.println("Add programs: " + String.join(", ", apps));
        Arrays.stream(apps).forEach(this.apps::addApp);
    }

    public void removeApp(String... apps) {
        filler("Remove programs: " + String.join(", ", apps));
        System.out.println("Remove programs: " + String.join(", ", apps));
        Arrays.stream(apps).forEach(this.apps::removeApp);
    }


    public void getApps() {
        filler("Current list of programs: " + String.join(", ", apps.getApps()));
        System.out.println("Current list of programs: " + String.join(", ", apps.getApps()));
    }

    public void setCurrentApp(String currentApp) {
        if (!working) {
            System.err.println("You must turn on Phone first");
        } else if (!apps.hasApp(currentApp)) {
            System.err.println("No such program");
        } else {
            filler("Set program to " + currentApp);
            System.out.println("Set program to " + currentApp);
            this.currentApp = currentApp;
        }
    }

    public void getCurrentApp() {
        filler("Get the current program: ");
        System.out.println(ANSI_GREEN + "Get the current program: " + ANSI_RESET);
        if (!working) {
            System.err.println("You must turn on Phone first");
        } else {
            filler("Current program is " + currentApp);
            System.out.println("Current program is " + currentApp);
        }
    }

    public void clearAllApps() {
        if (!working) {
            System.out.println("You must turn on Phone first");
        } else {
            filler("Go to next app" + apps.clearAll());
            System.out.println("Go to next app" + apps.clearAll());
        }
    }

    public void getScreenResolution() {
        filler("Get desctop resolution: " + "Height: " + desctop.getHeight() + " Width: " + desctop.getWidth());
        System.out.println(ANSI_PURPLE + "Get desctop resolution: " + "Height: " + desctop.getHeight() + " Width: " + desctop.getWidth() + ANSI_RESET);
    }

    public void getScreenFrameRate() {
        filler("Get desctop frame rate: " + desctop.getFPS());
        System.out.println(ANSI_PURPLE + "Get desctop frame rate: " + desctop.getFPS() + ANSI_RESET);
    }

    public void setScreenResolution(int width, int height) {
        filler("Set desctop resolution to: " + height + "x" + width);
        System.out.println(ANSI_PURPLE + "Set desctop resolution to: " + height + "x" + width + ANSI_RESET);
        if (width < 0 || height < 0) {
            System.out.println("Width and height must be bigger than 0");
        } else {
            desctop.setResolution(width, height);
        }
    }

    public void setPhoneFrameRate(int frameRate) {
        desctop.setFPS(frameRate);
    }
}
