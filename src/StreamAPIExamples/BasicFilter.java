package StreamAPIExamples;

import java.util.*;
import java.util.stream.Collectors;

public class BasicFilter {
    public static void main(String[] args){

        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Abhishek", 84000, "Development", 28));
        employees.add(new Employee("Karim", 42000, "QA",25));
        employees.add(new Employee("Janani", 56000, "IT",27));
        employees.add(new Employee("Manish", 150000, "Manager", 40));

        //1. Find employees whose salary > 50000
        employees.stream().filter(e -> e.getSalary() > 50000).forEach(System.out::println);
        List<Employee> salary = employees.stream().filter(e -> e.getSalary() > 50000).collect(Collectors.toList());
        System.out.println(salary);

        //2. Find employees whose age > 30
        employees.stream().filter(e->e.getAge() > 30).forEach(System.out::println);

        //3.Get names of all employees
        employees.stream().map(e->e.getName()).forEach(System.out::println);
        List<String> names = employees.stream().map(e->e.getName()).collect(Collectors.toList());
        System.out.println(names);

        //4.Convert employees names to uppercase.
        employees.stream().map(e->e.getName().toUpperCase()).forEach(System.out::println);
        List<String>namesByUpperCase = employees.stream().map(e->e.getName().toUpperCase()).collect(Collectors.toList());
        System.out.println(namesByUpperCase);

        //5.Count total employees
        long countEmployee = employees.stream().count();
        System.out.println(countEmployee);

        //6.Find employees whose name starts with "A"
        List<Employee> employeeList = employees.stream().filter(employee -> employee.getName().startsWith("A")).collect(Collectors.toList());
        System.out.println(employeeList);

        //MATCHING/SEARCH CONDITION
        //7.Check any employee belongs to IT department
        List<Employee> checkDepartment = employees.stream().filter(employee -> employee.getDepartment().equals("IT")).collect(Collectors.toList());
        System.out.println(checkDepartment);

        //8. Check all employees salary > 10000
        List<Employee> checkSalary = employees.stream().filter(employee -> employee.getSalary()> 10000).collect(Collectors.toList());
        System.out.println(checkSalary);

        //9. Find First employee from HR department
        Employee findFirst = employees.stream().filter(e ->e.getDepartment().equals("HR")).findFirst().orElse(null);
        System.out.println(findFirst);

        //10. Find Employee with Maximum salary
        Employee highestSalaryEmployee = employees.stream().max((e1,e2) -> Double.compare(e1.getSalary(),e2.getSalary())).get();
        System.out.println(highestSalaryEmployee);

        //11. Find Employee with Minimum salary
        Employee lowestSalaryEmployee = employees.stream().min((e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary())).get();
        System.out.println(lowestSalaryEmployee);

        //12. Find second highest salary employee
        Employee secondHighestSalaryEmployee = employees.stream().sorted((e1,e2) -> Double.compare(e1.getSalary(), e2.getSalary())).skip(1).findFirst().get();
        System.out.println(secondHighestSalaryEmployee);

        //13. Find Nth Highest salary employee
        int n = 3;
        Employee nthHighestSalaryEmployee = employees.stream().sorted((e1,e2) -> Double.compare(e1.getSalary(), e2.getSalary())).skip(n-1).findFirst().get();
        System.out.println(nthHighestSalaryEmployee);

        //14. Find top 5 highest paid employee
        employees.stream().sorted((e1, e2) ->Double.compare(e1.getSalary(), e2.getSalary())).limit(5).forEach(System.out::println);

        //15. Find Lowest salary of employee
        Employee lowestSalaryOfEmployee = employees.stream().sorted((e1, e2) ->Double.compare(e1.getSalary(), e2.getSalary())).findFirst().get();
        System.out.println("Lowest Salary of employee: "+lowestSalaryOfEmployee);

        //16. Find Employee with maximum age
        employees.stream().max((e1, e2) -> Integer.compare(e1.getAge(), e2.getAge())).get();
        Employee oldest = employees.stream().max((e1, e2) ->Integer.compare(e1.getAge(), e2.getAge())).get();
        System.out.println("Oldest Employee: "+oldest);

        //17.Find Employee with minimum age
        Employee youngest = employees.stream().min((e1,e2) -> Integer.compare(e1.getAge(), e2.getAge())).get();
        System.out.println("Youngest Employee: "+youngest);

        //18. Find Average salary of employee
        double averageSalary = employees.stream().mapToDouble(e->e.getSalary()).average().getAsDouble();
        double avg = employees.stream().collect(Collectors.averagingDouble(e->e.getSalary()));
        System.out.println(avg);

        //19. Find total salary of employees
        double totalSalary = employees.stream().mapToDouble(e->e.getSalary()).sum();
        employees.stream().collect(Collectors.summingDouble(e->e.getSalary()));

        //20. Find employees earning above average salary
        //21. Find employees earning below average salary
        double avgSalary = employees.stream().mapToDouble(e->e.getSalary()).average().getAsDouble();
        System.out.println("Average Salary: "+avgSalary);
        employees.stream().filter(e->e.getSalary()>avgSalary).forEach(System.out::println);

        System.out.println("/n");
        employees.stream().filter(e->e.getSalary()<avgSalary).forEach(System.out::println);

        //23. Find Employees whose salary is closest average
        Employee closestEmployee = employees.stream().min((e1, e2)-> Double.compare(Math.abs(e1.getSalary() -avgSalary), Math.abs(e2.getSalary()))).get();
        System.out.println(closestEmployee);

        //24. Find Top3 Salaries
        employees.stream().sorted((e1, e2) -> Double.compare(e2.getSalary(), e1.getSalary())).limit(3).forEach(s->System.out.println(s));

        //25. Find Distinct salaries in descending order
        employees.stream().map(e ->e.getSalary()).distinct().sorted(Comparator.reverseOrder()).forEach(s -> System.out.println(s));

        //26.Find Distinct salaries in ascending order.
        employees.stream().map(e->e.getSalary()).sorted((e1,e2) ->Double.compare(e1,e2)).forEach(s-> System.out.println(s));

        //27. Sort Employees by name
        employees.stream().sorted((e1, e2) -> e1.getName().compareTo(e2.getName())).forEach(s -> System.out.println(s));
        employees.stream().map(e ->e.getName()).distinct().sorted(Comparator.naturalOrder()).forEach(s -> System.out.println(s));

        //28. Sort Employees by Age
        employees.stream().sorted((e1,e2) ->Integer.compare(e1.getAge(), e2.getAge())).forEach(s-> System.out.println(s));
        employees.stream().map(e ->e.getAge()).sorted(Comparator.naturalOrder()).forEach(s -> System.out.println(s));

        //29. Sort Employees by department then salary
        employees.stream().sorted((e1,e2)->{
            int deptCompare;
            deptCompare = e1.getDepartment().compareTo(e2.getDepartment());
            if(deptCompare ==0){
                return Double.compare(e1.getSalary(), e2.getSalary());
            }
            return deptCompare;
        }).forEach(h-> System.out.println(h));

        //GROUPING Core Collection
        //Want Employees - Collectors.groupingBy(.......)
        //Want Count - Collectors.groupingBy(...., Collectors.counting())
        //Want names /specific fields - Collectors.groupingBy(....., Collectors.mapping(......, Collectors.toList());
        //Want Average -- Collectors.groupingBy(....., Collectors.averagingDouble(.....);
        //Want sum -- Collectors.groupingBy(....,Collectors.summingDouble(....));
        //Want Highest -- Collectors.groupingBy(..., Collectors.maxBy(....));
        //Want lowest -- Collectors.groupingBy(...., Collectors.minBy(....));

        //Q31. Group Employees by department
        Map<String, List<Employee>> results = employees.stream().collect(Collectors.groupingBy(e ->e.getDepartment()));
        System.out.println("results: "+results);

        //Q32 Count Employee in each department
        Map<String, Long> countEmp = employees.stream().collect(Collectors.groupingBy(e->e.getDepartment(), Collectors.counting()));
        System.out.println("countEmp: "+countEmp);

        //Q33. List Employee name department wise
        Map<String, List<String>> deptwiseData = employees.stream().collect(Collectors.groupingBy(e -> e.getDepartment(), Collectors.mapping(e -> e.getName(), Collectors.toList())));
        System.out.println("deptwiseData: "+deptwiseData);

        //Q34. Group employees by age
        Map<Integer, List<Employee>> employeeByAge = employees.stream().collect(Collectors.groupingBy(e ->e.getAge()));
        System.out.println("employeeByAge: "+employeeByAge);


        //Q35. Highest salary employee in each department
        Map<String, Optional<Employee>> highestSal = employees.stream().collect(Collectors.groupingBy(e->e.getDepartment(), Collectors.maxBy((e1,e2) ->Double.compare(e1.getSalary(), e2.getSalary()))));
        System.out.println("highestSal: "+highestSal);

        //Q36. Lowest salary in each department
        Map<String, Optional<Employee>> lowestSal = employees.stream().collect(Collectors.groupingBy(e->e.getDepartment(), Collectors.minBy((e1,e2) ->Double.compare(e1.getSalary(), e2.getSalary()))));
        System.out.println("lowestSal: "+lowestSal);

        //Q37. Average Salary in each department
        Map<String, Double> averageSal = employees.stream().collect(Collectors.groupingBy(e -> e.getDepartment(), Collectors.averagingDouble(e ->e.getSalary())));
        System.out.println("averageSal: "+averageSal);

        //Q38. Total Salary in each department
        Map<String, Double> totalSal = employees.stream().collect(Collectors.groupingBy(e -> e.getDepartment(), Collectors.summingDouble(e->e.getSalary())));
        System.out.println("totalSal: "+totalSal);

        //Q39. Department having maximum employee
        String deparmentMaxSalary = employees.stream().collect(Collectors.groupingBy(e->e.getDepartment(), Collectors.counting())).entrySet().stream().max((e1, e2) -> Long.compare(e1.getValue(), e2.getValue())).get().getKey();
        System.out.println("deparmentMaxSalary: "+deparmentMaxSalary);

        //Q40. Department having minimum employee
        String departmentMinSalary = employees.stream().collect(Collectors.groupingBy(e->e.getDepartment(), Collectors.counting())).entrySet().stream().min((e1, e2) -> Long.compare(e1.getValue(), e2.getValue())).get().getKey();
        System.out.println("departmentMinSalary: "+departmentMinSalary);

        //Q41.Department with highest average salary
        employees.stream().collect(Collectors.groupingBy(e->e.getDepartment(), Collectors.averagingDouble(h->h.getSalary()))).entrySet().stream().max((e1, e2) -> Double.compare(e1.getValue(),e2.getValue())).get().getKey();

        //Q42. Department with lowests average salary
        employees.stream().collect(Collectors.groupingBy(e ->e.getDepartment(), Collectors.averagingDouble(e->e.getSalary()))).entrySet().stream().min((e1, e2) ->Double.compare(e1.getValue(), e2.getValue())).get().getKey();

        //Q43. Find Duplicate Employee names
        employees.stream().collect(Collectors.groupingBy(e ->e.getName(), Collectors.counting())).entrySet().stream().filter(e->e.getValue() >1).forEach(e -> System.out.println(e.getKey()));

        //Q44. Find Unique Employee name
        employees.stream().collect(Collectors.groupingBy(e ->e.getName(), Collectors.counting())).entrySet().stream().filter(e->e.getValue() == 1).forEach(e -> System.out.println(e.getKey()));

        //Q45. Count occurences of each employee names
        employees.stream().collect(Collectors.groupingBy(e->e.getName(), Collectors.counting())).forEach((key, value) -> System.out.println(key + " "+value));

        //Q46. Convert Employeelist  ->Map<ID, Employee>
        Map<Object, Object> empListToMap = employees.stream().collect(Collectors.toMap(e ->e.getName(), e->e));
        System.out.println("empListToMap: "+empListToMap);

        //Q47. Convert EmployeeList - > Map<Name, Salary>
        Map<String, Integer> nameAndSalary = employees.stream().collect(Collectors.toMap(e ->e.getName(), e->e.getSalary()));
        System.out.println("nameAndSalary: "+nameAndSalary);

        //48. Convert Employeelist -> Map<Department,  List<Employee>>
        Map<String, List<Employee>> convertEmpList = employees.stream().collect(Collectors.groupingBy(e ->e.getDepartment()));
        System.out.println("convertEmpList: "+convertEmpList);

        //49. Find Employees whose salary > department average
        Map<String, Double> deptAvgSalary = employees.stream().collect(Collectors.groupingBy(e->e.getDepartment(), Collectors.averagingDouble(e->e.getSalary())));
        employees.stream().filter(e->e.getSalary() > deptAvgSalary.get(e.getDepartment())).forEach(e -> System.out.println(e));


    }
}
