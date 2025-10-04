package utils;

// Імпортуємо класи для роботи з файлами та потоками
import java.io.*;

public class FileManager {
    private static final String FILE = "battle_log.txt";

    // Метод для збереження логу бою у файл
    public static void saveBattle(String log) {
        try (FileWriter fw = new FileWriter(FILE, true)) {
            fw.write(log + "\n---\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Метод для відтворення всіх збережених боїв з файлу
    public static void replayBattles() {
        try (BufferedReader br = new BufferedReader(new FileReader(FILE))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Немає збережених боїв.");
        }
    }
}
