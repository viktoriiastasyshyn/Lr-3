package main;

import droids.*;
import battle.*;
import utils.FileManager;
import arena.*;

import java.util.*;

public class Main {
    private static List<Droid> droids = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);
    private static String lastBattleLog = null;

    public static void main(String[] args) {
        while (true) {

            System.out.println("\n МЕНЮ");
            System.out.println("1. Створити дроїда");
            System.out.println("2. Показати список дроїдів");
            System.out.println("3. Бій 1 на 1");
            System.out.println("4. Бій команда на команду");
            System.out.println("5. Записати останній бій у файл");
            System.out.println("6. Відтворити збережені бої");
            System.out.println("7. Вийти");
            System.out.print("Ваш вибір: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1 -> createDroid();
                case 2 -> showDroids();
                case 3 -> fightOneVsOne();
                case 4 -> fightTeamVsTeam();
                case 5 -> saveLastBattle();
                case 6 -> FileManager.replayBattles();
                case 7 -> {
                    return;
                }
                default -> System.out.println("Невірний вибір!");
            }
        }
    }

    // Метод для створення нового дроїда
    private static void createDroid() {
        System.out.println("Оберіть тип дроїда: 1-Атакуючий, 2-Танк, 3-Цілитель");
        int t = sc.nextInt();
        sc.nextLine();
        System.out.print("Введіть ім'я дроїда: ");
        String name = sc.nextLine();

        Droid d = switch (t) {
            case 1 -> new AttackDroid(name);
            case 2 -> new TankDroid(name);
            case 3 -> new HealerDroid(name);
            default -> null;
        };

        if (d != null) {
            droids.add(d);
            System.out.println("Створено: " + d);
        }
    }

    // Метод для відображення всіх дроїдів
    private static void showDroids() {
        if (droids.isEmpty()) System.out.println("Список порожній.");
        else {
            for (int i = 0; i < droids.size(); i++) {
                System.out.println(i + ": " + droids.get(i));
            }
        }
    }

    // Метод для проведення бою один на один
    private static void fightOneVsOne() {
        if (droids.size() < 2) {
            System.out.println("Недостатньо дроїдів!");
            return;
        }

        showDroids();
        System.out.print("Виберіть першого дроїда (індекс): ");
        int i1 = sc.nextInt();
        System.out.print("Виберіть другого дроїда (індекс): ");
        int i2 = sc.nextInt();

        System.out.println("Бій між " + droids.get(i1).getName() + " та " + droids.get(i2).getName());

        OneVsOneBattle battle = new OneVsOneBattle(droids.get(i1), droids.get(i2));
        String log = battle.fight();
        lastBattleLog = log;
        System.out.println(log);
        FileManager.saveBattle(log);
    }

    // Метод для бою команда на команду2

    private static void fightTeamVsTeam() {
        if (droids.size() < 4) {
            System.out.println("Потрібно хоча б 4 дроїди для бою 2 на 2!");
            return;
        }

        showDroids();
        System.out.println("Введіть індекси для команди 1 (через пробіл, напр. 0 1): ");
        int i1 = sc.nextInt();
        int i2 = sc.nextInt();

        System.out.println("Введіть індекси для команди 2 (через пробіл, напр. 2 3): ");
        int j1 = sc.nextInt();
        int j2 = sc.nextInt();

        List<Droid> team1 = Arrays.asList(droids.get(i1), droids.get(i2));
        List<Droid> team2 = Arrays.asList(droids.get(j1), droids.get(j2));

        System.out.println("Оберіть арену: 1 - Пустельна арена, 2 - Болотяна арена");
        int arenaChoice = sc.nextInt();
        Arena arena;
        switch (arenaChoice) {
            case 1 -> arena = new DesertArena();
            case 2 -> arena = new SwampArena();
            default -> {
                System.out.println("Невірний вибір, буде обрана Пустельна арена");
                arena = new DesertArena();
            }
        }

        arena.applyEffects(team1, team2);

        TeamBattle battle = new TeamBattle(team1, team2);
        String log = battle.fight();
        lastBattleLog = log;
        System.out.println(log);
    }

    // Метод для збереження останнього бою у файл
        private static void saveLastBattle() {
            if (lastBattleLog == null) {
                System.out.println("Немає бою для збереження.");
            } else {
                FileManager.saveBattle(lastBattleLog);
                System.out.println("Бій збережено!");
            }
        }
    }















