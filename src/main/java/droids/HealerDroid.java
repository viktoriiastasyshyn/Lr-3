package droids;

public class HealerDroid extends Droid {
    private int healPower = 20;

    public HealerDroid(String name) {
        super(name, 90, 10);
        this.accuracy = 75;
        this.speed = 6;
        this.energy = 100;
    }

    // Метод для лікування союзника
    public void heal(Droid ally) {
        if (energy >= 15) {
            ally.health += healPower;
            energy -= 15;
            System.out.println(name + " лікує " + ally.getName() + " +" + healPower + " HP!");
        } else {
            System.out.println(name + " не має енергії для лікування!");
        }
    }

    public int getHealPower() { return healPower; }
    public void setHealPower(int healPower) { this.healPower = healPower; }
}