package LAB_04;

import lombok.Data;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;


public class Phone extends Telefon{
    private final Desctop desctop;
    private final Apps apps;
    private String currentApp;
    private boolean isWorking;

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[43m";
    public static final String ANSI_BLUE = "\u001B[44m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";

    private static final String file = "Lab_04.txt";
    /**конструктор по замовчуванню */
    public Phone() {
        this.desctop = new Desctop();
        this.isWorking = true;
        this.apps = new Apps();
    }

    public Phone(int width, int height, int frameRate, Collection<String> apps) {
        this.desctop = new Desctop(width, height, frameRate);
        this.apps = new Apps(apps);
        this.isWorking = false;
    }
    /**конструктор із  заданням параметрів */
    public Phone(int width, int height, int frameRate) {
        this(width, height, frameRate, Collections.emptyList());
    }
    /**конструктор для копіювання об'єкта */
    public Phone(Phone phone) {
        this.apps = new Apps(phone.apps);
        this.desctop = new Desctop(phone.desctop);
        this.currentApp = phone.currentApp;
        this.isWorking = phone.isWorking;
    }
    /**функція яка нічого не повертає */
    public void turnOn() {
        filler("Turn on Telefon");
        System.out.println(ANSI_CYAN + "Turn on the Telefon" + ANSI_RESET);
        isWorking = true;
    }

    public void turnOff() {
        filler("Turn off Telefon");
        System.out.println(ANSI_CYAN + "Turn off the iPhone" + ANSI_RESET);
        isWorking = false;
    }

    public void isWorking() {
        filler("Is Telefon working: " + isWorking);
        System.out.println("Is Telefon working: " + isWorking);
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
    /**запис тексту в файл */
    protected static void filler(String text) {
        try {
            Files.write(Paths.get(file), (text + "\n").getBytes(), StandardOpenOption.APPEND);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addApp(String... apps) {
        filler("Add apps: " + String.join(", ", apps));
        System.out.println("Add programs: " + String.join(", ", apps));
        Arrays.stream(apps).forEach(this.apps::addApp);
    }
    public void removeApp(String... apps) {
        filler("Remove apps: " + String.join(", ", apps));
        System.out.println("Remove programs: " + String.join(", ", apps));
        Arrays.stream(apps).forEach(this.apps::removeApp);
    }

    public void getApps() {
        filler("Current list of apps: " + String.join(", ", apps.getApps()));
        System.out.println("Current list of programs: " + String.join(", ", apps.getApps()));
    }

    public void setCurrentApp(String currentApp) {
        if (!isWorking) {
            System.err.println("You must turn on Telefon first");
        } else if (!apps.hasApp(currentApp)) {
            System.err.println("");
        } else {
            filler("Set program to " + currentApp);
            System.out.println("Set program to " + currentApp);
            this.currentApp = currentApp;
        }
    }

    public void getCurrentApp() {
        filler("Get the current program: ");
        System.out.println(ANSI_GREEN + "Get the current program: " + ANSI_RESET);
        if (!isWorking) {
            System.err.println("You must turn on Telefon first");
        } else {
            filler("Current program is " + currentApp);
            System.out.println("Current program is " + currentApp);
        }
    }

    public void clearAllApps() {
        if (!isWorking) {
            System.out.println("You must turn on Telefon first");
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
        filler("Get desctop frame rate: " + desctop.getFrameRate());
        System.out.println(ANSI_PURPLE + "Get desctop frame rate: " + desctop.getFrameRate() + ANSI_RESET);
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
        desctop.setFrameRate(frameRate);
    }
}
