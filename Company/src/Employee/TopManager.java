package Employee;

import Copmpany.Company;

public class TopManager implements Employee {

    private int salary = 65000;
    private Company company;

    public TopManager(Company company) {
        this.company = company;
    }

    public double getMonthSalary() {

        if (company.getIncome() > 10_000_000) {
            double monthSalary = salary * 1.5;
            return (int) monthSalary;
        } else {
            double monthSalary = salary;
            return (int) monthSalary;
        }
    }
}
