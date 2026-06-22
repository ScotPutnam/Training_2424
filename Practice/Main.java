
import java.util.*;
import java.util.function.*;


public class Main {

public class TypeConversionPractice {

    public static void main(String[] args) {

        // =====================================================
        // PRIMITIVE -> PRIMITIVE
        // =====================================================

        // int -> double (automatic widening)
        int age = 25;
        double ageDouble = age;

        System.out.println(ageDouble); // 25.0

        // double -> int (casting required)
        double price = 19.99;
        int wholePrice = (int) price;


        System.out.println(wholePrice); // 19

        // int -> long
        int score = 100;
        long bigScore = score;

        System.out.println(bigScore); // 100

        // int -> float
        float scoreFloat = score;

        System.out.println(scoreFloat); // 100.0

        // int -> char (ASCII/Unicode conversion)
        int letterCode = 65;
        char letter = (char) letterCode;

        System.out.println(letter); // A

        // =====================================================
        // STRING -> PRIMITIVE
        // =====================================================

        // String -> int
        String numberString = "123";
        int number = Integer.parseInt(numberString);

        System.out.println(number); // 123

        // String -> double
        String decimalString = "3.14";
        double decimal = Double.parseDouble(decimalString);

        System.out.println(decimal); // 3.14

        // String -> long
        String longString = "1000000";
        long largeNumber = Long.parseLong(longString);

        System.out.println(largeNumber); // 1000000

        // String -> boolean
        String boolString = "true";
        boolean isTrue = Boolean.parseBoolean(boolString);

        System.out.println(isTrue); // true

        // =====================================================
        // PRIMITIVE -> STRING
        // =====================================================

        // int -> String
        int id = 50;
        String idString = String.valueOf(id);

        System.out.println(idString); // "50"

        // double -> String
        double tax = 7.25;
        String taxString = String.valueOf(tax);

        System.out.println(taxString); // "7.25"

        // Integer -> String
        Integer points = 100;
        String pointsString = Integer.toString(points);

        System.out.println(pointsString); // "100"

        // Quick shortcut (not preferred but common)
        int level = 10;
        String levelString = level + "";

        System.out.println(levelString); // "10"

        // =====================================================
        // WRAPPER CLASSES
        // =====================================================

        // Primitive
        int primitiveInt = 5;

        // Wrapper Object
        Integer wrapperInt = 5;

        System.out.println(wrapperInt);

        // =====================================================
        // AUTOBOXING
        // Primitive -> Wrapper automatically
        // =====================================================

        Integer boxedNumber = 10;

        System.out.println(boxedNumber);

        // =====================================================
        // UNBOXING
        // Wrapper -> Primitive automatically
        // =====================================================

        Integer wrapped = 20;

        int unboxed = wrapped;

        System.out.println(unboxed);

        // =====================================================
        // COLLECTION EXAMPLE
        // Wrapper classes are required in collections
        // =====================================================

        ArrayList<Integer> numbers = new ArrayList<>();

        numbers.add(10); // autoboxing int -> Integer
        numbers.add(20);
        numbers.add(30);

        System.out.println(numbers);

        int firstNumber = numbers.get(0); // unboxing Integer -> int

        System.out.println(firstNumber);

        // =====================================================
        // OBJECT CASTING
        // =====================================================

        Dog dog = new Dog();

        // Upcasting (automatic)
        Animal animal = dog;

        System.out.println(animal);

        // Downcasting (explicit cast required)
        Dog dogAgain = (Dog) animal;

        System.out.println(dogAgain);

    
        ArrayList<String> list = new ArrayList<>();

    // ==========================
    // ADDING
    // ==========================

        list.add("Bob");                          // add item to end
        list.add(0, "Alice");                     // add item at index
        list.addAll(List.of("Tom", "Jerry"));     // add multiple items

        // ==========================
        // REMOVING
        // ==========================

        list.remove("Bob");                       // remove by value
        list.remove(0);                           // remove by index
        list.remove(list.size() - 1);             // remove last item
        list.clear();                             // remove all items

        // ==========================
        // ACCESSING
        // ==========================

        list.get(0);                              // get item at index
        list.set(0, "Mike");                      // replace item at index

        // ==========================
        // SEARCHING
        // ==========================

        list.contains("Mike");                    // check membership
        list.indexOf("Mike");                     // first index of value
        list.lastIndexOf("Mike");                 // last index of value
        Collections.frequency(list, "Mike");      // count occurrences

        // ==========================
        // SIZE / EMPTY
        // ==========================

        list.size();                              // number of elements
        list.isEmpty();                           // true if empty

        // ==========================
        // SORTING / REVERSING
        // ==========================

        Collections.sort(list);                   // sort ascending
        list.sort((a, b) -> a.length() - b.length()); // sort based on length
        Collections.reverse(list);                // reverse order

        list.sort(Comparator.comparingInt(String::length)); // sort by length
        list.sort(Comparator.comparingInt(String::length).reversed()); // longest first

        // ==========================
        // SLICING
        // ==========================

        list.subList(1, 3);                       // elements 1 through 2

        // ==========================
        // ITERATION
        // ==========================

        for (String item : list) { }              // enhanced for loop

        for (int i = 0; i < list.size(); i++) { } // index loop

        list.forEach(System.out::println);        // method reference

        // ==========================
        // CONVERSIONS
        // ==========================

        String[] arr = list.toArray(new String[0]); // ArrayList -> Array

        ArrayList<String> copy =
                new ArrayList<>(list);              // copy ArrayList

        // ==========================
        // BULK OPERATIONS
        // ==========================

        list.removeAll(List.of("Bob", "Tom"));   // remove matching items

        list.retainAll(List.of("Alice", "Mike")); // keep only matching items

        // ==========================
        // CHECK EQUALITY
        // ==========================

        list.equals(new ArrayList<>());          // compare contents

        // ==========================
        // PRINTING
        // ==========================

        System.out.println(list);                // print whole list

        System.out.println(list.get(0));         // print one element

        HashSet<String> set = new HashSet<>();

        // ==========================
        // ADDING
        // ==========================

        set.add("Bob");                          // add one item
        set.addAll(Set.of("Alice", "Tom"));      // add multiple items

        // ==========================
        // REMOVING
        // ==========================

        set.remove("Bob");                       // remove value
        set.clear();                             // remove all values

        // ==========================
        // SEARCHING
        // ==========================

        set.contains("Alice");                   // check membership

        // ==========================
        // SIZE / EMPTY
        // ==========================

        set.size();                              // number of elements
        set.isEmpty();                           // true if empty

        // ==========================
        // ITERATION
        // ==========================

        for (String item : set) { }              // enhanced for loop

        set.forEach(System.out::println);        // method reference

        // ==========================
        // SET OPERATIONS
        // ==========================

        HashSet<String> set2 = new HashSet<>();

        set.addAll(set2);                        // union

        set.retainAll(set2);                     // intersection

        set.removeAll(set2);                     // difference

        // ==========================
        // CHECK EQUALITY
        // ==========================

        set.equals(set2);                        // compare sets

        // ==========================
        // CONVERSIONS
        // ==========================

        ArrayList<String> list = new ArrayList<>(set);            // Set -> ArrayList

        String[] arr = set.toArray(new String[0]);      // Set -> Array







        HashMap<String, Integer> map =new HashMap<>();

        // ==========================
        // ADDING
        // ==========================

        map.put("Bob", 25);

        map.put("Alice", 30);

        map.putAll(Map.of(
                "Tom", 20,
                "Jerry", 22
        ));

        // ==========================
        // ACCESSING
        // ==========================

        map.get("Bob");                    // value for key

        map.getOrDefault("Mike", 0);       // default if missing

        // ==========================
        // UPDATING
        // ==========================

        map.put("Bob", 35);                // replace value

        map.replace("Bob", 40);            // replace value

        // ==========================
        // REMOVING
        // ==========================

        map.remove("Bob");

        map.clear();

        // ==========================
        // SEARCHING
        // ==========================

        map.containsKey("Alice");

        map.containsValue(30);

        // ==========================
        // SIZE / EMPTY
        // ==========================

        map.size();

        map.isEmpty();

        // ==========================
        // ITERATION
        // ==========================

        for (String key : map.keySet()) { }

        for (Integer value : map.values()) { }

        for (Map.Entry<String,Integer> entry :
                map.entrySet()) {

            entry.getKey();

            entry.getValue();
        }

        // ==========================
        // GET COLLECTION VIEWS
        // ==========================

        map.keySet();          // all keys

        map.values();          // all values

        map.entrySet();        // key/value pairs

        // ==========================
        // CONDITIONAL INSERT
        // ==========================

        map.putIfAbsent("Mike", 50);

        // ==========================
        // CONDITIONAL REMOVE
        // ==========================

        map.remove("Bob", 40);

        // ==========================
        // CHECK EQUALITY
        // ==========================

        map.equals(new HashMap<>());


        

        
        // Lambdas 
        // Predicate / .test()
        // Function / .apply()
        // Consumer / .accept()
        // Supplier / .get()

        list.sort((a, b) -> a.length() - b.length()); // sort based on length

        // returns bool
        Predicate<String> longWord = s->s.length()>4;
        System.out.println(longWord.test("example String"));

        //<input type, output type>
        Function<String, Integer> getLength = s -> s.length();
        System.out.println(getLength.apply("Example String"));
    
        Consumer<String> printer = s -> System.out.println(s);
        printer.accept("example String");

        Supplier<Double> randomNumber = ()->Math.random();
        System.out.println(randomNumber.get());

        try {

            int[] nums = {1,2,3};

            System.out.println(nums[10]);

        }
        catch (ArithmeticException e) {
            System.out.println("Math problem");
        }
        catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Bad index");
        }



        // import java.util.stream.*;
        // =====================================================
        // READ A STRING
        // Python:
        // input()
        // =====================================================

        String input = sc.nextLine();

        System.out.println(input);


        // =====================================================
        // SPLIT A STRING INTO WORDS
        // Python:
        // input.split()
        // =====================================================

        String[] words = input.split("\\s+");

        System.out.println(Arrays.toString(words));


        // =====================================================
        // REPLACE SPACES WITH COMMAS
        // Python:
        // input.replace(" ", ",")
        // =====================================================

        String replaced = input.replace(" ", ",");

        System.out.println(replaced);


        // =====================================================
        // CONVERT "1 2 3 4" -> int[]
        // Python:
        // list(map(int, input.split()))
        // =====================================================

        int[] nums = Arrays.stream(input.split("\\s+"))
                           .mapToInt(Integer::parseInt)
                           .toArray();

        System.out.println(Arrays.toString(nums));


        // =====================================================
        // ACCESS FIRST TWO NUMBERS
        // Python:
        // nums[0]
        // nums[1]
        // =====================================================

        if (nums.length >= 2) {

            int num1 = nums[0];
            int num2 = nums[1];

            System.out.println(num1);
            System.out.println(num2);
        }


        // =====================================================
        // READ LENGTH THEN N NUMBERS
        // Python:
        // length = int(input())
        // for i in range(length)
        // =====================================================

        int length = Integer.parseInt(sc.nextLine());

        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < length; i++) {
            list.add(Integer.parseInt(sc.nextLine()));
        }

        System.out.println(list);


        // =====================================================
        // CONVERT Integer List -> String List
        // Python:
        // [str(num) for num in nums]
        // =====================================================

        ArrayList<String> stringList = new ArrayList<>();

        for (Integer num : list) {
            stringList.add(String.valueOf(num));
        }

        System.out.println(stringList);


        // =====================================================
        // "12345" -> [1,2,3,4,5]
        // Python:
        // [int(char) for char in io]
        // =====================================================

        String digits = "12345";

        ArrayList<Integer> digitList = new ArrayList<>();

        for (char c : digits.toCharArray()) {
            digitList.add(Character.getNumericValue(c));
        }

        System.out.println(digitList);


        // =====================================================
        // SUM DIGITS
        // Python:
        // sum([int(char) for char in io])
        // =====================================================

        int sum = 0;

        for (char c : digits.toCharArray()) {
            sum += Character.getNumericValue(c);
        }

        System.out.println(sum);


        // =====================================================
        // "1 2 3 4" -> ArrayList<Integer>
        // Python:
        // [int(x) for x in io.split()]
        // =====================================================

        String spacedNums = "1 2 3 4";

        ArrayList<Integer> intList = new ArrayList<>();

        for (String s : spacedNums.split("\\s+")) {
            intList.add(Integer.parseInt(s));
        }

        System.out.println(intList);


        // =====================================================
        // "1,2,3,4,5" -> ArrayList<Integer>
        // Python:
        // [int(x) for x in string_nums.split(",")]
        // =====================================================

        String csv = "1,2,3,4,5";

        ArrayList<Integer> csvNums = new ArrayList<>();

        for (String s : csv.split(",")) {
            csvNums.add(Integer.parseInt(s));
        }

        System.out.println(csvNums);


        // =====================================================
        // READ A SINGLE INTEGER
        // Python:
        // int(input())
        // =====================================================

        int n = Integer.parseInt(sc.nextLine());

        System.out.println(n);


        // =====================================================
        // READ A DOUBLE
        // Python:
        // float(input())
        // =====================================================

        double d = Double.parseDouble(sc.nextLine());

        System.out.println(d);


        // =====================================================
        // READ A BOOLEAN
        // Python:
        // bool(input())
        // =====================================================

        boolean b = Boolean.parseBoolean(sc.nextLine());

        System.out.println(b);


        sc.close();


        // import java.util.stream.*;
        Scanner sc = new Scanner(System.in);
        //READ A STRING 
        String s = sc.nextLine();

        int n = Integer.parseInt(sc.nextLine());

        double d = Double.parseDouble(sc.nextLine());

        String[] words = s.split("\\s+");

        int[] nums = Arrays.stream(s.split("\\s+"))
                        .mapToInt(Integer::parseInt)
                        .toArray();

        ArrayList<Integer> list = new ArrayList<>();

        for (String x : s.split("\\s+"))
            list.add(Integer.parseInt(x));

        String csv = "1,2,3,4";
        String[] parts = csv.split(",");

        String replaced = s.replace(" ", ",");


}

    
}
