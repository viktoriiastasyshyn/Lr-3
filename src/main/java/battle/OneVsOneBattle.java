package battle;

import droids.Droid;
import java.util.Random;

public class OneVsOneBattle {
    private Droid d1, d2;
    private StringBuilder log = new StringBuilder();

    public OneVsOneBattle(Droid d1, Droid d2) {
        this.d1 = d1;
        this.d2 = d2;
    }

    // Метод проведення бою
    public String fight() {
        Random rand = new Random();
        log.append("Бій: ").append(d1).append(" vs ").append(d2).append("\n");

        while (d1.isAlive() && d2.isAlive()) {
            if (rand.nextBoolean()) {
                d1.attack(d2);
                log.append(d1.getName()).append(" атакує ").append(d2.getName())
                        .append(" (HP=").append(d2.getHealth()).append(")\n");
            } else {
                d2.attack(d1);
                log.append(d2.getName()).append(" атакує ").append(d1.getName())
                        .append(" (HP=").append(d1.getHealth()).append(")\n");
            }
        }

        if (d1.isAlive()) log.append("Переміг: ").append(d1.getName()).append("\n");
        else log.append("Переміг: ").append(d2.getName()).append("\n");

        return log.toString();
    }
}
