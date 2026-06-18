package com.scotputnam.collections;

import java.util.*;

public class CollectionExample {

    public static void main(String[] args) {
        Person p = new Person("Scot", 60, 100);
        Person p1 = new Person("Richard", 65, 105);
        Person p2 = new Person("Kristina", 70, 110);

        List<Person> lst = new ArrayList<>();

        lst.add(p);
        lst.addFirst(p1);
        lst.addFirst(p2);


        for (Person person: lst){
            System.out.println(person.getName());
        }

        Set<Person> personSet = new HashSet<>(lst);
        System.out.println(personSet);

        // Map
        Map<Integer, Person> personMap = new HashMap<>();
        Set<Integer> keySet = personMap.keySet();
        List<Integer> keyList = new ArrayList<>(keySet);

        for (int i =0; i<keyList.size(); i++){
            int key = keyList.get(i);
            System.out.println(key + " = " + personMap.get(key));
        }

        personMap.put(1, p);
        personMap.put(2, p1);
        personMap.put(3, p2);

        for (Integer key: personMap.keySet()){

        }
    }
}
