package Interview_Problems.Stream_Level2;

import java.awt.*;
import java.util.*;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
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

//    Find the highest paid employee in each department.  Return Map<Department, Employee>
    public static Map<String, Employee> highPaidDepartment(List<Employee> list) {
        Map<String, Employee> result = list.stream().collect(
                Collectors.groupingBy(Employee::getDepartment,
                        Collectors.collectingAndThen(
                                Collectors.maxBy(Comparator.comparingDouble(Employee:: getSalary)) ,
                                Optional:: get
                        )
                        )
        );
        return result;
    }

//    Find average salary of each department.
    public static Map<String, Double> averageSalaryDepartment(List<Employee> list) {
        Map<String, Double> result = list.stream().collect(
                Collectors.groupingBy(Employee:: getDepartment,
                        Collectors.averagingDouble(Employee:: getSalary)
                        )
        );
        return result;

    }

//    Group employees by gender.
    public static Map<String, List<Employee>> groupByGender(List<Employee> list) {
        Map<String, List<Employee>> result = list.stream().collect(Collectors.groupingBy
                (Employee::getGender));
        return result;
    }

//Find the department with the highest average salary
    public static String highestAverageDepartment(List<Employee> list) {
        Map<String, Double> averageSalaryPerDepartment = list.stream().collect(
                Collectors.groupingBy(Employee::getDepartment,
                Collectors.averagingDouble(Employee::getSalary)
        ));
                Optional<Double> result = averageSalaryPerDepartment.values().stream().max(Comparator.naturalOrder());

                String salaryDepartment = averageSalaryPerDepartment.keySet().stream().filter(e ->
                        averageSalaryPerDepartment.get(e) == result.get()).findFirst().orElse("NoOne");
                return salaryDepartment;

    }

//    Find the youngest employee.
    public static Employee youngEmployee(List<Employee> list) {
        return list.stream().min(Comparator.comparingInt(Employee:: getAge)).get();
    }

//    Sort employees by salary descending, then by age ascending.
    public static List<Employee> sortBySalaryAge(List<Employee> list) {
        return list.stream().sorted(Comparator.comparingDouble(Employee:: getSalary).reversed())
                .sorted(Comparator.comparingInt(Employee:: getAge)).collect(Collectors.toList());
    }

//    Get the top 3 highest paid employees.
    public static List<Employee> top3PaidEmployee(List<Employee> list) {
        return list.stream().sorted(Comparator.comparing(Employee:: getSalary).reversed()).limit(3).collect(
                Collectors.toList()
        );
    }

//    Partition employees into salary > 80k and <= 80k.
    public static Map<String, List<Employee>> employeebased80k(List<Employee> list) {
//        return list.stream().collect(Collectors.partitioningBy(employee -> employee.getSalary() > 80000));
        return list.stream().collect(Collectors.groupingBy
                (employee -> employee.getSalary() > 80000 ? "High Package" : "Low Package")
                );
    }


    public static void main(String[] args) {

        List<Employee> employees = List.of(
                new Employee(1, "Sharan", "IT", 80000, 26, "Male"),
                new Employee(2, "Priya", "HR", 60000, 24, "Female"),
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
        System.out.println(highPaidDepartment(employees));
        System.out.println(averageSalaryDepartment(employees));
        System.out.println(groupByGender(employees));
        System.out.println(highestAverageDepartment(employees));
        System.out.println(youngEmployee(employees));
        System.out.println(sortBySalaryAge(employees));
        System.out.println(top3PaidEmployee(employees));
        System.out.println(employeebased80k(employees));

    }

}
