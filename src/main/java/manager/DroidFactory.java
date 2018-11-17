package manager;

import droid.Droid;
import droid.Droideka;
import droid.IG100MagnaGuard;

public class DroidFactory {

    public DroidFactory() {

    }

    public Droid createDroid(int numberOfDroid) {
        switch (numberOfDroid) {
            case 1:
                return new IG100MagnaGuard(100, 40, 30, true, true);
            case 2:
                return new Droideka(100, 30, 40, true, true);
            case 3:
                return new Droideka(100, 30, 40, true, true);
        }
        return null;
    }
}
