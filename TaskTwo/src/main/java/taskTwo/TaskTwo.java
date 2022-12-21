package taskTwo;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class TaskTwo {

    public static void main(String[] args) {
        String path = "WorkFile.txt";
        TaskTwo taskTwo = new TaskTwo();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите путь к файлу: ");
        String userPath = scanner.nextLine();
        taskTwo.wordPeriodicity(taskTwo.countWords(taskTwo.listFromTextFile(userPath)));
    }

    public List<String> listFromTextFile(String filePath) {

        List<String> list = new ArrayList<>();
        Scanner input = null;
        try {
            input = new Scanner(new File(filePath));
        } catch (FileNotFoundException e) {
            System.out.println("Фаил не найден");
            e.printStackTrace();
        }
        while (input.hasNext()) {
            String word = input.next();
            list.add(word.replaceAll("\\W", "").toLowerCase(Locale.ROOT));
        }
        if (list.size() == 0){
            System.out.println("Файл пуст");
        }
        return list;
    }

    public Map<String, Integer> countWords(List<String> list) {
        Map<String, Integer> map = new TreeMap<>();
        for (int i = 0; i < list.size(); i++) {
            if (map.containsKey(list.get(i))) {
                int count = map.get(list.get(i));
                map.put(list.get(i), count + 1);
            } else {
                map.put(list.get(i), 1);
            }
        }
        return map;
    }

    public void wordPeriodicity(Map<String, Integer> map) {
        float maxPercent = 0;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            String key = entry.getKey();
            int value = entry.getValue();
            float percent = (float) value / (float) map.size() * 100;
            String res = String.format("%s занимает %.2f", key, percent);
            System.out.println(res + "%");
            if (maxPercent <= percent) maxPercent = percent;
        }
        int max = map.entrySet().stream().max((entry1, entry2)
                -> entry1.getValue() > entry2.getValue() ? 1 : -1).get().getValue();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue().equals(max)) {
                System.out.println("Наиболее встречаемое слово: "
                        + entry.getKey() + "-" + max + " " + maxPercent + "%");
            }
        }
    }

}
