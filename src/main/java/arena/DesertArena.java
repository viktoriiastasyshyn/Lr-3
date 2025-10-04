package arena;

import droids.Droid;
import droids.AttackDroid;
import droids.HealerDroid;
import droids.TankDroid;

import java.util.List;

public class DesertArena extends Arena {
    public DesertArena() {
        super("Пустеля");
    }

    @Override
    // Метод застосування ефектів арени на команди
    public void applyEffects(List<Droid> team1, List<Droid> team2) {
        // Для обох команд зменшуємо точність дроїдів на 10%
        for (Droid d : team1) d.setAccuracy(d.getAccuracy() - 10);
        for (Droid d : team2) d.setAccuracy(d.getAccuracy() - 10);
    }
}
