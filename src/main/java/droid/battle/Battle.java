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
        int hitPoints = player.attack(enemy);
        System.out.println("Player set " + hitPoints + " of damage.\n");
        System.out.println("Enemy characteristics after course:");

        enemy.defence(hitPoints);
        if (enemy.isAlive() == false) {
            System.out.println("My congratulation, you win!");
        } else return;
    }

    public void playerSuperAttack() {
        int hitPoints = player.superAttack(enemy);
        System.out.println("Player set " + hitPoints + " of damage.");
        System.out.println("Enemy characteristics after course:");

        enemy.defence(hitPoints);
        if (enemy.isAlive() == false) {
            System.out.println("My congratulation, you win!");
        } else return;
    }

    public void enemyAttack() {
        int hitPoints = enemy.attack(player);
        System.out.println("Enemy set " + hitPoints + " of damage.");
        System.out.println("Player characteristics after course:");
        player.defence(hitPoints);

        if (player.isAlive() == false) {
            System.out.println("You was defeated");
        } else return;
    }

    public void enemySuperAttack() {
        int hitPoints = enemy.superAttack(player);
        System.out.println("Enemy set " + hitPoints + " of damage.");
        System.out.println("Player characteristics after course:");

        player.defence(hitPoints);
        if (player.isAlive() == false) {
            System.out.println("You was defeated");
        } else return;
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
