package arena;

import droids.Droid;
import java.util.List;

public abstract class Arena {
    protected String name;

    public Arena(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    // Метод, що змінює характеристики дроїдів на початку бою
    public abstract void applyEffects(List<Droid> team1, List<Droid> team2);
}
