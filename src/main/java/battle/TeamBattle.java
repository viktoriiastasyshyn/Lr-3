package battle;

import droids.Droid;
import droids.HealerDroid;

import java.util.*;

public class TeamBattle {
    private List<Droid> team1, team2;
    private StringBuilder log = new StringBuilder();
    private Random rand = new Random();

    public TeamBattle(List<Droid> team1, List<Droid> team2) {
        this.team1 = new ArrayList<>(team1);
        this.team2 = new ArrayList<>(team2);
    }

    // Метод проведення бою
    public String fight() {
        log.append("Бій команда на команду!\n");

        while (!team1.isEmpty() && !team2.isEmpty()) {
            action(team1, team2);
            if (team2.isEmpty()) break;
            action(team2, team1);
        }

        if (team1.isEmpty()) log.append("Перемогла команда 2!\n");
        else log.append("Перемогла команда 1!\n");

        return log.toString();
    }

    // Метод для одного ходу дії команди
    private void action(List<Droid> attackers, List<Droid> defenders) {
        Droid actor = attackers.get(rand.nextInt(attackers.size()));

        // Якщо дроїд Цілитель і випадково вирішує лікувати
        if (actor instanceof HealerDroid healer && rand.nextBoolean()) {
            // Обираємо союзника з найменшим HP, або самого себе, якщо немає інших
            Droid ally = attackers.stream()
                    .filter(Droid::isAlive)
                    .min(Comparator.comparingInt(Droid::getHealth))
                    .orElse(actor);

            healer.heal(ally);
            log.append(actor.getName())
                    .append(" лікує ")
                    .append(ally.getName())
                    .append(" (HP=")
                    .append(ally.getHealth())
                    .append(")\n");
            return;
        }

        // Якщо дроїд атакує, обираємо випадкову ціль з ворогів
        Droid target = defenders.get(rand.nextInt(defenders.size()));
        actor.attack(target);
        log.append(actor.getName())
                .append(" атакує ")
                .append(target.getName())
                .append(" (HP=")
                .append(target.getHealth())
                .append(")\n");

        if (!target.isAlive()) {
            defenders.remove(target);
            log.append(target.getName()).append(" вибув!\n");
        }
    }
}


