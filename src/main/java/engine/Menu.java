package engine;

import manager.DroidFactory;

import java.util.Scanner;

public class Menu {

    private Scanner scanner;

    public Menu() {
        scanner = new Scanner(System.in);
    }

    public int createStartMenu() {
        System.out.println("This is your daily dose of war!");
        System.out.println("Choose what you want:\n");
        System.out.println("\t1. Start Battle");
        System.out.println("\t2. About developers");
        System.out.println("\t3. Quit\n");
        System.out.print("Print your massage here: ");
        int result = Integer.parseInt(scanner.nextLine());
        System.out.println();
        return result;
    }

    public int startBattleMenu() {
        System.out.println("Lets crash some engine!!!\n");
        System.out.println("\t1. Simple attack");
        System.out.println("\t2. Super attack");
        System.out.print("Print your massage here: ");
        int result = Integer.parseInt(scanner.nextLine());
        System.out.println();
        return result;
    }

    public int chooseDroidMenu() {
        System.out.println("Choose your droid:\n");
        System.out.println("\t1. IG100MagnaGuard");
        System.out.println("\t2. Droideka\n");
        System.out.println("\t3. BXDroidCommando");
        System.out.print("Print your massage here: ");

        int result = Integer.parseInt(scanner.nextLine());
        System.out.println();

        return result;
    }

    public int chooseEnemyMenu() {
        System.out.println("Choose your enemy:\n");
        System.out.println("\t1. IG100MagnaGuard");
        System.out.println("\t2. Droideka");
        System.out.println("\t3. BXDroidCommando");
        System.out.println("\t4. Random droid\n");
        System.out.print("Print your massage here: ");

        int result = Integer.parseInt(scanner.nextLine());
        System.out.println();

        return result;
    }
}
