package Interview_Problems.Stream_Level2;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamLevel2 {


//    Get all employee names as a List.
    public static List<String> getName(List<Employee> employees) {
        List<String> names =  employees.stream().map((employee) -> employee.getName())
                .collect(Collectors.toList());

        return names;
    }

//    Get employees whose salary is greater than 80,000.
    public static List<Employee> salaryBased(List<Employee> employees) {
        return employees.stream().filter(employee -> employee.getSalary() > 80000)
                .collect(Collectors.toList());
    }

//    Count how many employees are in each department.
    public static Map<String, Long> countPerDepartment(List<Employee> employees) {
//        We can use downstream method to mention how the values of the Grouping should be
        return employees.stream().collect(Collectors.
                groupingBy(employee -> employee.getDepartment(), Collectors.counting()));
    }

//    Find the highest paid employee.
    public static Employee highestPaid(List<Employee> employees) {
        return employees.stream().max(Comparator.comparingDouble(Employee::getSalary)).orElse(null);
    }

//    Find the highest paid employee in each department. Return Return Map<Department, Employee>
    public static void main(String[] args) {

        List<Employee> employees = List.of(
                new Employee(1, "Sharan", "IT", 80000, 26, "Male"),
                new Employee(2, "Priya", "HR", 60000, 30, "Female"),
                new Employee(3, "Arjun", "IT", 95000, 28, "Male"),
                new Employee(4, "Sneha", "Finance", 75000, 32, "Female"),
                new Employee(5, "Rahul", "Finance", 72000, 29, "Male"),
                new Employee(6, "Meera", "IT", 99000, 35, "Female"),
                new Employee(7, "Kiran", "HR", 58000, 27, "Male"),
                new Employee(8, "Divya", "IT", 105000, 31, "Female")
        );

        System.out.println(getName(employees));
        System.out.println(salaryBased(employees));
        System.out.println(countPerDepartment(employees));
        System.out.println(highestPaid(employees));
    }

}
