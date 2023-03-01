/*1. Реализуйте структуру телефонной книги с помощью HashMap, учитывая, что 1 человек может иметь несколько телефонов. */
package Java_HW5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class PhoneBook {
    public static void main(String[] args) {
        Map<String, ArrayList<Integer>> phoneBook = new HashMap<>();
        addPhoneNum("Ivanov", 45656, phoneBook);
        addPhoneNum("Petrov", 56944, phoneBook);
        addPhoneNum("Sidorov", 753454, phoneBook);
        addPhoneNum("Godunov", 546456, phoneBook);
        addPhoneNum("Petrov", 44564, phoneBook);
        addPhoneNum("Sidorov", 8686, phoneBook);
        addPhoneNum("Petrov", 54649, phoneBook);
        Map<String, ArrayList<Integer>> map = phoneBook;
        System.out.println(map);
        findContact(map);
    }

    static Map<String, ArrayList<Integer>> addPhoneNum(String key, int value, Map<String, ArrayList<Integer>> map){
        if (map.containsKey(key)) {
            map.get(key).add(value);
        } else {
            ArrayList<Integer> list = new ArrayList<>();
            list.add(value);
            map.put(key, list);
        }
        return map;
    }

    static void findContact(Map<String, ArrayList<Integer>> map){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the name of the person whose phone number you are looking for: ");
        String str = sc.nextLine();
        sc.close();
        if (map.containsKey(str)){
            System.out.println(map.get(str));
        }      
    }
}
