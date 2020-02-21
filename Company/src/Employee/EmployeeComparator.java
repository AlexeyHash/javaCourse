package Employee;

import java.util.Comparator;

public class EmployeeComparator implements Comparator <Employee>{
    @Override
    public int compare(Employee em1, Employee em2) {

        return Double.compare(em2.getMonthSalary(),em1.getMonthSalary());
    }
}
