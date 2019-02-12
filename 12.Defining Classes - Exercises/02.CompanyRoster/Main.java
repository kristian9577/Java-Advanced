package CompanyRoster;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        LinkedHashMap<String, Department> deparments = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String[] tokens = reader.readLine().split(" ");

            String nameEmployee = tokens[0];
            double salary = Double.parseDouble(tokens[1]);
            String position = tokens[2];
            String nameDepartnment = tokens[3];
            Department department;

            if (!deparments.containsKey(nameDepartnment)) {
                department = new Department(nameDepartnment);
                deparments.put(nameDepartnment, department);
            } else {
                department = deparments.get(nameDepartnment);
            }

            Employee employee = null;
            if (tokens.length == 4) {
                employee = new Employee(nameEmployee, salary, position, department);
            } else if (tokens.length == 5) {
                try {
                    int age = Integer.parseInt(tokens[4]);
                    employee = new Employee(nameEmployee, salary, position, department, age);
                } catch (NumberFormatException e) {
                    String email = tokens[4];
                    employee = new Employee(nameEmployee, salary, position, department, email);
                }
            } else if (tokens.length == 6) {
                String email = tokens[4];
                int age = Integer.parseInt(tokens[5]);
                employee = new Employee(nameEmployee, salary, position, department, email, age);
            }
            deparments.get(nameDepartnment).getEmployees().add(employee);
        }

        List<Employee> employeeList = deparments.entrySet().stream()
                .sorted((emp1, emp2) -> {
                    double salary1 = emp1.getValue().getEmployees().stream().mapToDouble(Employee::getSalary).sum();
                    double salary2 = emp2.getValue().getEmployees().stream().mapToDouble(Employee::getSalary).sum();
                    return Double.compare(salary2, salary1);
                })
                .map(emp -> emp.getValue().getEmployees())
                .findFirst().orElse(null);

        System.out.printf("Highest Average Salary: %s%n", employeeList.get(0).getDepartment().getName());

        employeeList.stream().sorted((emp1, emp2) -> Double.compare(emp2.getSalary(), emp1.getSalary()))
                .forEach(emp -> {
                    System.out.printf("%s %.2f %s %d%n",
                            emp.getName(),
                            emp.getSalary(),
                            emp.getEmail(),
                            emp.getAge());
                });
    }
}
