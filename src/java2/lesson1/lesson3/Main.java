package java2.lesson1.lesson3;


import java.util.*;

public class Main {
    public static void main(String[] args) {

        List<String> list = new ArrayList<>(Arrays.asList("Абрикос", "Кот", "Собака", "Диван", "Кот", "Космос", "Телевизор", "Космос", "Программа", "Android", "Цветок", "Ток", "Торт", "Собака", "Мышь", "Микрофон", "Android", "Geek"));
        String[] str = {"Абрикос", "Кот", "Собака", "Диван", "Кот", "Космос", "Телевизор", "Космос", "Программа", "Android", "Цветок", "Ток", "Торт", "Собака", "Мышь", "Микрофон", "Android", "Geek"};
        Set<String> set = new HashSet<>();
        set.add("Абрикос");
        set.add("Абрикос");
        set.add("Абрикос");
        set.add("Абрикос");
        set.add("Кот");
        set.add("Кот");
        set.add("Кот");
        set.add("Кот");
        set.add("Диван");
        set.add("Диван");
        set.add("Космос");
        set.add("Космос");
        set.add("Космос");
        set.add("Космос");

        System.out.println(set);


        HashMap<String, Integer> ls = new HashMap<>();
        for (String x : list) {
            ls.put(x, ls.getOrDefault(x, 0) + 1);
        }
        System.out.println(ls);

        Phonebook book = new Phonebook();
        book.addContact("Игорь", "544545");
        book.addContact("Иван", "4543545");
        book.addContact("Кристина", "543434");
        book.addContact("Данил", "54656");
        book.addContact("Алекс", "56545");
        book.addContact("Женя", "232323");

        // ищем по имени
        book.findAndPrint("Игорь");
        book.findAndPrint("Кристина");
        book.findAndPrint("Данил");


        Map<Integer, Integer> hm = new HashMap<>();
//
        for (int i = 0; i < 100; i++) {
     //       int num = rand.nextInt(10);
//            Integer currentNum = hm.get(num);
//            hm.put(num, currentNum == null ? 1 : currentNum + 1);
   //         hm.put(num, hm.getOrDefault(num, 0) + 1);
        }
//
        System.out.println(hm);
    }

}



