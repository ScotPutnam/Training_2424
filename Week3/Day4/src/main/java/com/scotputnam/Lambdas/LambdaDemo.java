package com.scotputnam.Lambdas;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class LambdaDemo {

    static void main() {

        List<String> names = new ArrayList<>(List.of("Bob", "Alice", "Charlie"));

        Predicate<String> longWord = s->s.length() > 4;

        // Function used to do and return something
        Function<String, Integer> getLength = String::length;

        // Consumers take a value and does something return nothing
        Consumer<String> printer = System.out::println;

        // Suppliers produce values, takes no inputs
        Supplier<Double> randomNumber = Math::random;
        System.out.println(randomNumber.get());

        Function<String, String> upper = String::toUpperCase;

        names.stream().filter(longWord).map(upper).forEach(printer);

    }

}
