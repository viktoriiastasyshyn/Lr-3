package droids;

// Абстрактний клас для всіх дроїдів
public abstract class Droid {
    protected String name;
    protected int health;
    protected int damage;
    protected int accuracy;
    protected int speed;
    protected int energy;

    public Droid(String name, int health, int damage) {
        this.name = name;
        this.health = health;
        this.damage = damage;
        this.accuracy = 80;
        this.speed = 5;
        this.energy = 100;
    }

    // Геттери для доступу до характеристик
    public String getName() { return name; }
    public int getHealth() { return health; }
    public boolean isAlive() { return health > 0; }

    // Метод отримання ушкоджень
    public void takeDamage(int dmg) {
        health -= dmg;
        if (health < 0) health = 0;
    }

    // Метод атаки на іншого дроїда
    public void attack(Droid enemy) {
        if (energy <= 0) {
            System.out.println(name + " втомився і пропускає хід!");
            return;
        }
        int chance = (int) (Math.random() * 100);
        if (chance < accuracy) {
            enemy.takeDamage(damage);
            System.out.println(name + " атакує " + enemy.getName() + " на " + damage + "!");
        } else {
            System.out.println(name + " промахнувся!");
        }

        energy -= 10;
    }

    // Геттери та сеттери
    public int getAccuracy() { return accuracy; }
    public void setAccuracy(int accuracy) { this.accuracy = Math.max(0, Math.min(100, accuracy)); }

    public int getSpeed() { return speed; }
    public void setSpeed(int speed) { this.speed = Math.max(1, speed); }

    public int getEnergy() { return energy; }
    public void setEnergy(int energy) { this.energy = Math.max(0, energy); }

    @Override
    public String toString() {
        return name + " (HP=" + health + ", DMG=" + damage +
                ", ACC=" + accuracy + "%, SPD=" + speed + ", EN=" + energy + ")";
    }
}
