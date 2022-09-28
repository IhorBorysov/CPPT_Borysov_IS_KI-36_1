package LAB_04;

/** оголошую клас, що реалізує інтерфейс */
public class IMag extends Phone implements iMagInterface {
    public IMag() {
        new Desctop(4608, 1152, 1440);
    }

    public IMag(int width, int height, int frameRate) {
        new Desctop(width, height, frameRate);
    }

    public void addAppsFromAppStore() {
        filler("Add apps from AppStore");
        System.out.println("Add apps from AppStore");
        addApp("Xcode", "Photoshop", "Teams");
    }

}