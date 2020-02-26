package Copmpany;

import Employee.Employee;
import Employee.EmployeeComparator;
import Employee.Manager;
import Employee.IncomeReceivable;

import java.util.*;

public class Company {


    private List<Employee> employees = new ArrayList<>();

    public void hire(Employee employee) {
        employees.add(employee);
    }

    public void hireAll(Employee employee, int count) {
        for (int i = 0; i < count; i++) {
            employees.add(employee);
        }
    }

    public void fire(int count) {
        if (count < employees.size()){
        for (int i = 0; i < count; i++){
            employees.remove(i);
        }
    }
        else {
            System.out.println("Превышено число сотрудников.");
        }
    }


    public double getIncome() {
        double income = 0;

        for (int i = 0; i < employees.size(); i++) {

            if (employees.get(i) instanceof IncomeReceivable) {
                income = income + ((IncomeReceivable) employees.get(i)).getIncome();
            }
        }
        return (int) income;
    }

    public List<Employee> getTopMonthSalary(int count) {

        return getSortedList(new EmployeeComparator(),count);
    }

    public List<Employee> getLowestMonthSalary(int count) {

        return getSortedList(new EmployeeComparator().reversed(),count);
    }

    private List<Employee> getSortedList (Comparator<Employee>comparator, int count){
        Collections.sort(employees, comparator);
        List<Employee> list = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            list.add(employees.get(i));
        }
        return list;
    }

}
