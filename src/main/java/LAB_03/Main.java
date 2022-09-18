package LAB_03;

public class Main {
    public static void main(String[] args) {
        Phone apps = new Phone();

        apps.getCurrentApp();
        apps.turnOn();
        apps.setScreenResolution(1200, 800);
        apps.addApp("Viber", "Telegram", "Safari", "Google");
        apps.removeApp("Viber");
        apps.setCurrentApp("Telegram");
        apps.getApps();
        apps.removeApp("Google");
        apps.setCurrentApp("Safari");
        apps.getCurrentApp();
        apps.getApps();
        apps.settings();

        Phone settin = new Phone(apps);

        settin.setCurrentApp("Telegram");
        settin.clearAllApps();
        settin.getCurrentApp();
        settin.settings();

        Phone setting = new Phone(1080, 1920, 140);
        setting.turnOn();
        setting.setScreenResolution(1080, 1920);
        setting.getScreenResolution();
        setting.setPhoneFrameRate(144);
        setting.settings();
        setting.turnOff();
        setting.isWorking();

    }
}

