import java.util.Comparator;
import java.util.List;
import java.util.Random;

import static java.lang.Math.pow;


public class Main {
    public static void main(String[] args) {

        // 1. Создать список из 1_000 рандомных чисел от 1 до 1_000_000

        List<Integer> randomNumbers = new Random().ints(1,1000000).limit(1000).boxed().toList();
        // randomNumbers.forEach(System.out::println);

        // 1.1 Найти максимальное

        System.out.println("Max value  = " + randomNumbers.stream().max(Comparator.comparing(Integer::valueOf)).get() );

        // 1.2 Все числа, большие, чем 500_000, умножить на 5, отнять от них 150 и просуммировать

        // randomNumbers.stream().filter(num -> num.intValue() > 500000).map(num -> num.intValue()*5-150).forEach(System.out::println);
        System.out.println("Sum value  = " + randomNumbers.stream().filter(num -> num.intValue() > 500000).map(num -> num.intValue()*5-150).mapToInt(Integer::intValue).sum());

        // 1.3 Найти количество чисел, квадрат которых меньше, чем 100_000

        // randomNumbers.stream().filter(num -> Math.pow(num, 2) < 100000).forEach(System.out::println);
        System.out.println("Number of elements  = " + randomNumbers.stream().filter(num -> Math.pow(num, 2) < 100000).count());

    }
}