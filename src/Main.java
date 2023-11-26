import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import static java.lang.Math.pow;


public class Main {
    public static void main(String[] args) {


        // 1. Создать список из 1_000 рандомных чисел от 1 до 1_000_000
        System.out.println("1. Создать список из 1_000 рандомных чисел от 1 до 1_000_000");

        List<Integer> randomNumbers = new Random().ints(1,1000000).limit(1000).boxed().toList();
        // randomNumbers.forEach(System.out::println);

        // 1.1 Найти максимальное
        System.out.println("1.1 Найти максимальное");

        System.out.println("Max value  = " + randomNumbers.stream().max(Comparator.comparing(Integer::valueOf)).get() );

        // 1.2 Все числа, большие, чем 500_000, умножить на 5, отнять от них 150 и просуммировать
        System.out.println("1.2 Все числа, большие, чем 500_000, умножить на 5, отнять от них 150 и просуммировать");

        // randomNumbers.stream().filter(num -> num.intValue() > 500000).map(num -> num.intValue()*5-150).forEach(System.out::println);
        System.out.println("Sum value  = " + randomNumbers.stream().filter(num -> num.intValue() > 500000).map(num -> num.intValue()*5-150).mapToInt(Integer::intValue).sum());

        // 1.3 Найти количество чисел, квадрат которых меньше, чем 100_000
        System.out.println("1.3 Найти количество чисел, квадрат которых меньше, чем 100_000");

        // randomNumbers.stream().filter(num -> Math.pow(num, 2) < 100000).forEach(System.out::println);
        System.out.println("Number of elements  = " + randomNumbers.stream().filter(num -> pow(num, 2) < 100000).count());


        // 2. Создать класс Employee (Сотрудник) с полями: String name, int age, double salary, String department
        System.out.println("2. Создать класс Employee (Сотрудник). 2.1 Создать список из 10-20 сотрудников.");
        // 2.1 Создать список из 10-20 сотрудников

        List<Employee> list = Arrays.asList(new Employee("Василий", 20, 40000, "IT"),
                                            new Employee("Иван", 25, 50000, "Support"),
                                            new Employee("Петр", 30, 80000, "Trading"),
                                            new Employee("Елизавета", 28, 120000, "Marketing"),
                                            new Employee("Максим", 40, 100000, "Marketing"),
                                            new Employee("Анастасия", 34, 100000, "IT"),
                                            new Employee("Виктор", 52, 100000, "Marketing"),
                                            new Employee("Роза", 26, 40000, "IT"),
                                            new Employee("Александр", 23, 50000, "Support"),
                                            new Employee("Виталий", 27, 80000, "Trading"),
                                            new Employee("Андрей", 19, 120000, "Marketing"),
                                            new Employee("Дарья", 38, 110000, "Trading"),
                                            new Employee("Ксения", 22, 70000, "Support"),
                                            new Employee("Сергей", 45, 8000, "Support"));
        list.forEach(System.out::println);

        // 2.2 Вывести список всех различных отделов (department) по списку сотрудников
        System.out.println("2.2 Вывести список всех различных отделов (department) по списку сотрудников");

        list.stream().collect(Collectors.toMap(Employee::getDepartment, p -> p, (p, q) -> p)).values().forEach(emp -> System.out.println(emp.getDepartment()));


        // 2.3 Всем сотрудникам, чья зарплата меньше 10_000, повысить зарплату на 20%
        System.out.println("2.3 Всем сотрудникам, чья зарплата меньше 10_000, повысить зарплату на 20%");

        list.stream().filter(employee -> employee.salary < 10000).forEach(System.out::println);
        list.stream().filter(employee -> employee.salary < 10000).map(employee -> new Employee(employee.name, employee.age, employee.salary * 1.2, employee.department)).forEach(System.out::println);
    }
}