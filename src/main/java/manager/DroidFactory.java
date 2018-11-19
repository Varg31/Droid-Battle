package manager;

import droid.BXDroidCommando;
import droid.Droid;
import droid.Droideka;
import droid.IG100MagnaGuard;

public class DroidFactory {

    private Droid droid;

    public DroidFactory() {

    }

    public Droid createDroid(int numberOfDroid) {
        System.out.println("Droid info: ");
        switch (numberOfDroid) {
            case 1:
                droid = new IG100MagnaGuard(100, 40, 50, true, true);
                System.out.println(((IG100MagnaGuard) droid).printDroidInfo());
                return droid;
            case 2:
                droid = new Droideka(100, 40, 30, true, true);
                System.out.println(((Droideka) droid).printDroidInfo());
                return droid;
            case 3:
                droid = new BXDroidCommando(100, 30, 40, true, true);
                System.out.println(((BXDroidCommando) droid).printDroidInfo());
                return droid;
            case 4:
                int random = 1 + (int)(Math.random() * 5);
                createDroid(random);
        }
        return null;
    }
}
