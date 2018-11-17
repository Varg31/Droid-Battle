package engine;

import droid.battle.Battle;
import manager.DroidFactory;

import java.util.Scanner;

public class Engine implements Runnable {
    private Thread thread;
    private boolean running;
    private Battle battle;
    private Menu menu;
    private DroidFactory factory;

    public Engine() {
        running = false;
        menu = new Menu();
        factory = new DroidFactory();
        battle = new Battle();
    }

    public synchronized void start() {
        if(running)
            return;

        running = true;
        thread = new Thread(this);
        thread.start();
    }

    public synchronized void stop() {
        if(!running)
            return;

        running = false;

        try {
            thread.join();
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void run() {
        int choose = menu.createStartMenu();
        switch (choose) {
            case 1:
                battle = new Battle(factory.createDroid(menu.chooseDroidMenu()),
                        factory.createDroid(menu.chooseEnemyMenu()));
                break;
            case 2:
                System.out.println("We working on this:)");
                break;
            case 3:
                thread.stop();
        }

        while (running) {
            int choseTurn = menu.startBattleMenu();

            switch (choseTurn) {
                case 1:
                    battle.playerAttack();
                    break;
                case 2:
                    battle.playerSuperAttack();
                    break;
            }

            System.out.println("Now is enemy turn...");

            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if (Math.random() >= 0.7) {
                battle.enemySuperAttack();
            } else {
                battle.enemyAttack();
            }

            if (battle.enemyIsAlive() != true || battle.playerIsAlive() != true) {
                System.out.println("Game over");
                thread.stop();
            }
        }
    }
}