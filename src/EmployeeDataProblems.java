import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class EmployeeDataProblems {
	public static void main(String[] args) {
		List<Employee> employees = Arrays.asList(new Employee(1, "Rama", 50000, "QA"), new Employee(2, "Soma", 70000 , "Developer"),
				new Employee(3, "Sundar", 50000, "QA"));

		// Group Employees by salary
		Map<Double, List<Employee>> result = employees.stream().collect(Collectors.groupingBy(Employee::getSalary));

		System.out.println("Group Employee By Salary: " + result);

		// Group salary with Employee names only
		Map<Double, List<String>> resultByName = employees.stream().collect(
				Collectors.groupingBy(Employee::getSalary, Collectors.mapping(Employee::getName, Collectors.toList())));
		System.out.println("Group Employee By Name: " + resultByName);

		// Count Employee by salary
		Map<Double, Long> resultByCount = employees.stream()
				.collect(Collectors.groupingBy(Employee::getSalary, Collectors.counting()));
		System.out.println("Count Employee by Salary: " + resultByCount);

		// Find Highest salary Group
		Optional<Double> maxSalary = employees.stream().map(Employee::getSalary).max(Double::compare);
		System.out.println("Highest Salary: " + maxSalary.get());

		// Employees having highest salary
		double maximumSalary = employees.stream().mapToDouble(Employee::getSalary).max().orElse(0);
		System.out.println("Maximum Salary: " + maximumSalary);

		// Highest Paid Employee
		List<Employee> highestPaidEmployee = employees.stream().filter(e -> e.getSalary() == maximumSalary)
				.collect(Collectors.toList());
		System.out.println("Highest Paid Employee: " + highestPaidEmployee);

		// Sort Grouped Salaries
		Map<Double, List<Employee>> groupedMap = employees.stream()
				.collect(Collectors.groupingBy(Employee::getSalary, TreeMap::new, Collectors.toList()));
		System.out.println("Grouped Map: " + groupedMap);

		// Sum of salaries
		double totalSalary = employees.stream().collect(Collectors.summingDouble(Employee::getSalary));
		System.out.println("Total Salaries: " + totalSalary);

		// Average Salaries
		double averageSalary = employees.stream().collect(Collectors.averagingDouble(Employee::getSalary));
		System.out.println("Average Salaries: " + averageSalary);

		// Group by salary and count names
		Map<Double, List<String>> salaryAndCount = employees.stream().collect(
				Collectors.groupingBy(Employee::getSalary, Collectors.mapping(Employee::getName, Collectors.toList())));
		System.out.println("SalaryAndCount: " + salaryAndCount);

		// Find the highest salary employee from a list
		Employee highestPaidEmployee1 = employees.stream().max(Comparator.comparing(Employee::getSalary)).orElse(null);
		System.out.println("Highest Paid Employee: " + highestPaidEmployee1);

		// Get only Highest salary
		double highestSalary = employees.stream().map(Employee::getSalary).max(Double::compare).orElse(0.0);
		System.out.println("Only Highest Salary: " + highestSalary);

		// Find Top3 Highest salary employee
		employees.stream().sorted(Comparator.comparing(Employee::getSalary).reversed()).limit(3)
				.forEach(entry -> System.out.println(entry.getName() + ":" + entry.getSalary()));

		// Sort employees based on salary using stream api
		List<Employee> sortedEmployees = employees.stream().sorted(Comparator.comparing(Employee::getSalary))
				.collect(Collectors.toList());
		sortedEmployees.forEach(System.out::println);

		// Descending order
		List<Employee> sortedEmployee = employees.stream().sorted(Comparator.comparing(Employee::getSalary).reversed())
				.collect(Collectors.toList());

		// Sort by salary then name
		List<Employee> sortbySalaryThenName = employees.stream()
				.sorted(Comparator.comparing(Employee::getSalary).thenComparing(Employee::getName))
				.collect(Collectors.toList());
		sortbySalaryThenName.forEach(entry -> System.out.println(entry.getName() + ": " + entry.getSalary()));
		
		//Group employee by salary
		Map<String, List<Employee>> groupByDepartment = employees.stream().collect(Collectors.groupingBy(Employee::getDepartment));
		groupByDepartment.forEach((dept, emplist) -> {
			System.out.println(dept+ ":"+emplist);
		});
		
		//Count employee in each department
		Map<String, Long> departmentCount = employees.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));
		System.out.println(departmentCount);
		
		
		
	}
}
