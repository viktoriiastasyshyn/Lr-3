package droids;

public class AttackDroid extends Droid {
    public AttackDroid(String name) {
        super(name, 100, 30);
        this.accuracy = 85;
        this.speed = 7;
        this.energy = 100;
    }
}
