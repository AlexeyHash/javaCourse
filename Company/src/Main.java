import Copmpany.Company;
import Employee.Employee;
import Employee.Manager;
import Employee.TopManager;
import java.util.List;


public class Main {

    public static final int COUNT_MANGER = 80;
    public static final int COUNT_TOPMANGER = 10;
    public static final int COUNT_OPERATOR = 180;

    public static void main(String[] args){

        Company company = new Company();

        for (int i = 0; i < COUNT_MANGER; i++) {
            company.hire(new Manager());
        }
        for (int i = 0; i < COUNT_TOPMANGER; i++) {
            company.hire(new TopManager(company));
        }

        System.out.println(company.getIncome());


        List<Employee> topSalary = company.getTopMonthSalary(90);
        List<Employee> lowSalary = company.getLowestMonthSalary(5);


        for (Employee list : topSalary) {
            System.out.println(list.getMonthSalary());
        }
        System.out.println("\n");

        for (Employee list : lowSalary) {
            System.out.println(list.getMonthSalary());
        }
              company.fire(45);


        List<Employee> topSalary1 = company.getTopMonthSalary(45);
        List<Employee> lowSalary1 = company.getLowestMonthSalary(5);


        for (Employee list : topSalary1) {
            System.out.println(list.getMonthSalary());
        }
        System.out.println("\n");

        for (Employee list : lowSalary1) {
            System.out.println(list.getMonthSalary());
        }
    }
}
