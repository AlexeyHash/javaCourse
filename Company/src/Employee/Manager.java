package Employee;

public class Manager implements Employee, IncomeReceivable{

    private int salary = 30000;
    private double monthIncome = ((Math.random() + 1.8) * 100000);

    public double getMonthSalary() {
        double monthSalary = (salary + (monthIncome * 0.05));
        return (int) monthSalary;
    }

    public double getIncome() {
        return monthIncome;
    }
}

