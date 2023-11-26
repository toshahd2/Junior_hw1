public class Employee {
    String name;
    int age;
    double salary;
    String department;


    public Employee(String name, int age, double salary, String department){
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.department = department;
    }

    public String getDepartment() {
        return department;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                ", department='" + department + '\'' +
                '}';
    }
}
