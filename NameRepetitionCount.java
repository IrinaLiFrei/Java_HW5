/* 2. Пусть дан список сотрудников: Иван Иванов, Светлана Петрова, Кристина Белова, Анна Мусина, 
Анна Крутова, Иван Юрин, Петр Лыков, Павел Чернов, Петр Чернышов, Мария Федорова, Марина Светлова, 
Мария Савина, Мария Рыкова, Марина Лугова, Анна Владимирова, Иван Мечников, Петр Петин, Иван Ежов. 
Написать программу, которая найдет и выведет повторяющиеся имена с количеством повторений. 
Отсортировать по убыванию популярности. Для сортировки использовать TreeMap. */
package Java_HW5;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.Map.Entry;


public class NameRepetitionCount {
    public static void main(String[] args) {
        
        String str = "Иван Иванов, Светлана Петрова, Кристина Белова, Анна Мусина, Анна Крутова, Иван Юрин, Петр Лыков, Павел Чернов, Петр Чернышов, Мария Федорова, Марина Светлова, Мария Савина, Мария Рыкова, Марина Лугова, Анна Владимирова, Иван Мечников, Петр Петин, Иван Ежов";
        String[] str2 = str.split(", ");
        ArrayList<String> names = getName(str2);
        TreeMap<String, Integer> nameMap = getMap(names);
        System.out.println(sortByValue(nameMap));
        
    }
    static ArrayList<String> getName(String [] list){
        ArrayList<String> arr = new ArrayList<>();
        for (String el : list) {
            String [] elList = el.split(" ");
            arr.add(elList[0]);
        }
        return arr;
}

static TreeMap<String,Integer> getMap(ArrayList<String> arr){
    TreeMap<String,Integer> tMap = new TreeMap<>();
    for (int i = 0; i < arr.size(); i++) {
        int count = 0;
            for (int j = 0; j < arr.size(); j++){
                if (arr.get(i).equals(arr.get(j))) count += 1;
                }
                if (tMap.containsKey(arr.get(i)) == false) tMap.put(arr.get(i), count);
        }
        return tMap;
    }
    
// ГУГЛ, списано, ничего не поняла
    static <K, V extends Comparable<? super V>> Map<K, V> sortByValue(Map<K, V> map) {
        List<Entry<K, V>> list = new ArrayList<>(map.entrySet());
        list.sort(Entry.comparingByValue());
        Map<K, V> result = new LinkedHashMap<>();
        for (Entry<K, V> entry : list) {
            result.put(entry.getKey(), entry.getValue());
        }
        return result;
    }
}

