package droids;

public class TankDroid extends Droid {
    public TankDroid(String name) {
        super(name, 150, 15);
        this.accuracy = 70;
        this.speed = 3;
        this.energy = 120;
    }
}
