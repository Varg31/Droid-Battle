package droid;

public class Droideka extends Droid implements BattleDroid{
    public static final double ATTACK_SPEED = 2.5;
    public static final double DARK_POWER = 3;  // special droid characteristic interval [0, 5]
    private static final int MINIMAL_DAMAGE = 20;
    private static final int MAXIMAL_DAMAGE = 25;

    private static int attack;

    private int health;
    private boolean armor;
    private int armorValue;
    private double luck;
    private boolean alive;

    private double baseDamage;
    private double attackDefenceModifier;
    private double physicsModifier;

    public double getLuck() {
        return luck;
    }

    public double getDamage() {
        return (MINIMAL_DAMAGE + MAXIMAL_DAMAGE) / 2;
    }

    public boolean isAlive() {
        if (health <= 0) {
            return false;
        }
        return true;
    }

    public Droideka(int health, int attack, int armorValue, boolean alive, boolean armor) {
        super(health, attack, armorValue, alive, armor);
        this.health = health;
        this.attack = attack;
        this.armorValue = armorValue;
        this.armor = armor;
        this.alive = alive;
        luck = generateLuck();
        baseDamage = MINIMAL_DAMAGE + (Math.random() * (MAXIMAL_DAMAGE - MINIMAL_DAMAGE));
    }

    public int superAttack(Droid droid) {
        if (isArmor()) {
            if (attack >= droid.getArmorValue()) {
                attackDefenceModifier = 1 + (attack - droid.getArmorValue()) * 0.05;
            } else {
                attackDefenceModifier = 1 / (1 + (droid.getArmorValue() - attack) * 0.05);
            }
        } else {
            if (attack >= droid.getArmorValue()) {
                attackDefenceModifier = 1 + (attack - droid.getHealth()) * 0.05;
            } else {
                attackDefenceModifier = 1 / (1 + (droid.getHealth() - attack) * 0.05);
            }
        }
        physicsModifier = ATTACK_SPEED * luck * DARK_POWER;
        return (int) (baseDamage * attackDefenceModifier + physicsModifier);
    }

    public int attack(Droid droid) {
        if (droid.isArmor()) {
            if (attack >= droid.getArmorValue()) {
                attackDefenceModifier = 1 + (attack - droid.getArmorValue()) * 0.05;
            } else {
                attackDefenceModifier = 1 / (1 + (droid.getArmorValue() - attack) * 0.05);
            }
        } else {
            if (attack >= droid.getHealth()) {
                attackDefenceModifier = 1 + (attack - droid.getHealth()) * 0.05 * 2;
            } else {
                attackDefenceModifier = 5 / (1 + (droid.getHealth() - attack) * 0.05);
            }
        }
        physicsModifier = ATTACK_SPEED * luck;
        if (Math.random() <= 0.5) {
            return (int) (baseDamage * attackDefenceModifier + physicsModifier);
        } else { return 0; }
    }

    public void defence(int damage) {
        if (isAlive() == true) {
            int HPResult = 0;

            if (isArmor() == false) {
                setArmorValue(0);
                HPResult = getHealth() - damage;
                setHealth(HPResult);
            } else {
                setArmorValue((int)(getArmorValue() - damage * 0.7));
                setHealth((int)(health - damage * 0.3));
            }
            System.out.println(battleInfo());
        } else {
            health = 0;
        }
    }

    public String printDroidInfo() {
        String info = "Type: Droideka\n" + "Model: Lightweight Droid \n" +
                "Health: " + getHealth() + " HP" + "\n" +
                "Armor: " + getArmorValue() + "\n" +
                "Attack: " + getAttack() + "\n" +
                "Middle damage: [" + getDamage() + "\n" +
                "Attack speed: " + ATTACK_SPEED;
        return info;
    }

    private double generateLuck() {
        double luck = 1 + (Math.random() * 10);
        if((luck >= 2) && (luck <= 5)) {
            return luck;
        }
        return 3;
    }

    private String battleInfo() {
        String info = "\tType: Droideka\n" +
                "\tHealth: " + getHealth() + " HP" + "\n" +
                "\tArmor: " + getArmorValue() + "\n";
        return info;
    }
}