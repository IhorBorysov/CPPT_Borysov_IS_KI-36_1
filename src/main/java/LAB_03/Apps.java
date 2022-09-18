package LAB_03;

import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/** зберігання додатків, які відкриті або існують **/
@NoArgsConstructor
public class Apps {
    private final List<String> apps = new ArrayList<>();

    public Apps(Collection<String> apps) {
        this.apps.addAll(apps);
    }

    public Apps(Apps apps) {
        this.apps.addAll(apps.apps);
    }

    public List<String> getApps() {
        return apps;
    }

    public void addApp(String app) {
        if (apps.contains(app)) {
            throw new IllegalArgumentException("This app already at list");
        }
        apps.add(app);
    }

    public void removeApp(String app) {
        if (apps.contains(app)) {
            apps.remove(app);
        } else {
            throw new IllegalArgumentException("No such app at list");
        }

    }

    public boolean hasApp(String app) {
        return apps.contains(app);
    }

    public String clearAll() {
        apps.clear();
        return "No apps";
    }
}
