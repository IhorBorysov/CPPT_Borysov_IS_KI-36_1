package LAB_04;

public abstract class Telefon {

    public abstract void turnOn();

    public abstract void turnOff();

    public abstract void isWorking();

    public abstract void settings();

    public abstract void addApp(String... apps);

    public abstract void removeApp(String... apps);

    public abstract void getApps();

    public abstract void setCurrentApp(String currentApp) ;

    public abstract void getCurrentApp();

    public abstract void clearAllApps();

    public abstract void getScreenResolution();

    public abstract void getScreenFrameRate();

    public abstract void setScreenResolution(int width, int height);

    public abstract void setPhoneFrameRate(int frameRate);

}


