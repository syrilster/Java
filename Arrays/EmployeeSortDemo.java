package Arrays;

import java.util.*;

public class EmployeeSortDemo {
    public static void main(String[] args) {
        List<Employee> employeeList = new ArrayList<>();
        Employee employeeOne = new Employee("Mech", "Ravi");
        Employee employeeTwo = new Employee("Mech", "Syril");
        Employee employeeThree = new Employee("CS", "Yoga");
        Employee employeeFour = new Employee("Mech", "Ajit");
        Employee employeeFive = new Employee("CS", "Debu");

        employeeList.add(employeeOne);
        employeeList.add(employeeTwo);
        employeeList.add(employeeThree);
        employeeList.add(employeeFour);
        employeeList.add(employeeFive);

        Map<String, List<String>> employeeByBranch = getEmployeeByBranch(employeeList);
        getSortedEmployee(employeeByBranch);
        employeeByBranch.forEach((branch, name) -> System.out.println("Branch " + branch + " Name " + name));
    }

    private static Map<String, List<String>> getEmployeeByBranch(List<Employee> employeeList) {
        Map<String, List<String>> employeeMap = new HashMap<>();
        for (Employee employee : employeeList) {
            List<String> tempEmployeeList;
            if (employeeMap.get(employee.getBranch()) != null) {
                tempEmployeeList = employeeMap.get(employee.getBranch());
            } else {
                tempEmployeeList = new ArrayList<>();
            }

            tempEmployeeList.add(employee.getName());
            employeeMap.put(employee.getBranch(), tempEmployeeList);
        }
        return employeeMap;
    }

    private static void getSortedEmployee(Map<String, List<String>> employeeMap) {
        for (List<String> e : employeeMap.values()) {
            Collections.sort(e);
        }
    }
}
