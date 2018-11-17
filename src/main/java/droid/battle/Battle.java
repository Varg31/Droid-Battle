package droid.battle;

import droid.BattleDroid;
import droid.Droid;

public class Battle {
    private Droid player;
    private Droid enemy;

    public Battle() {

    }

    public Battle(Droid player, Droid enemy) {
        this.player = player;
        this.enemy = enemy;
    }

    public void playerAttack() {
        if (enemy.isAlive()) {
            int hitPoints = player.attack(enemy);
            System.out.println("Player set " + hitPoints + " of damage.\n");

            enemy.defence(hitPoints);
        } else {
            System.out.println("My congratulation, you win!");
        }
    }

    public void playerSuperAttack() {
        if (enemy.isAlive()) {
            int hitPoints = player.superAttack(enemy);
            System.out.println("Player set " + hitPoints + " of damage.");
            System.out.println("Enemy characteristics after course:");

            enemy.defence(hitPoints);
        } else {
            System.out.println("My congratulation, you win!");
        }
    }

    public void enemyAttack() {
        if (enemy.isAlive()) {
            int hitPoints = enemy.attack(player);
            System.out.println("Enemy set " + hitPoints + " of damage.");
            System.out.println("Player characteristics after course:");

            player.defence(hitPoints);
        } else {
            System.out.println("You was defeated");
        }
    }

    public void enemySuperAttack() {
        if (player.isAlive()) {
            int hitPoints = enemy.superAttack(player);
            System.out.println("Enemy set " + hitPoints + " of damage.");
            System.out.println("Player characteristics after course:");

            player.defence(hitPoints);
        } else {
            System.out.println("You was defeated");
        }
    }

    public boolean enemyIsAlive() {
        if (enemy.isAlive()) {
            return true;
        }
        return false;
    }

    public boolean playerIsAlive() {
        if (player.isAlive()) {
            return true;
        }
        return false;
    }
}
