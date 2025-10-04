package arena;
import droids.Droid;
import droids.AttackDroid;
import droids.HealerDroid;
import droids.TankDroid;

import java.util.List;

public class SwampArena extends Arena {
    public SwampArena() {
        super("Болото");
    }

    @Override
    // Метод застосування ефектів арени на команди
    public void applyEffects(List<Droid> team1, List<Droid> team2) {
        for (Droid d : team1) {
            d.setSpeed(Math.max(1, d.getSpeed() - 2));
            d.setEnergy(Math.max(0, d.getEnergy() - 10));
        }
        for (Droid d : team2) {
            d.setSpeed(Math.max(1, d.getSpeed() - 2));
            d.setEnergy(Math.max(0, d.getEnergy() - 10));
        }
    }
}