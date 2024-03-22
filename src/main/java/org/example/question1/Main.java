package org.example.question1;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        Map<Employee, Address> employeeAddressMap = new HashMap<>();


        employeeAddressMap.put(new Employee(1, "Nanidni"), new Address(101, "raidurga", "hyderabad", 10001));
        employeeAddressMap.put(new Employee(2, "Jangiti"), new Address(202, "xyz", "Mumbai", 90001));
        employeeAddressMap.put(new Employee(3, "Amrutha"), new Address(303, "abc", "chennai", 60601));


        getAddress(employeeAddressMap, new Employee(3, "akash"));
        Set<String> distinctCities = getDistinctCities(employeeAddressMap);
        System.out.println("Distinct cities in ascending order: " + distinctCities);
    }

    public static void getAddress(Map<Employee, Address> employeeAddressMap, Employee employee) {
        Address address = employeeAddressMap.getOrDefault(employee, null);
        if (address != null) {
            System.out.println("Address for employee " + employee.getName() + ": " +
                    address.getHouseNo() + ", " + address.getStreet() + ", " +
                    address.getCity() + ", " + address.getPincode());
        } else {
            System.out.println("Employee of " + employee.getName() + " does not exist.");
        }
    }

    public static Set<String> getDistinctCities(Map<Employee, Address> employeeAddressMap) {

        return employeeAddressMap.values()
                .stream()
                .map(Address::getCity)
                .sorted()
                .collect(Collectors.toCollection(TreeSet::new));
    }
}
