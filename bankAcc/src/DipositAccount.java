import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;

public class DipositAccount extends BankAccounts {


    @Override
    public double inputMoney(double input) {
        moneyAmount += input;
        System.out.println("Дата поступления денег: " + inputDate.format(format));
        System.out.println("Сумма поступления: " + input);
        System.out.println("Вы внесли деньги на депозитный счет.");
        System.out.println("Вы сможете обналичить их после истечения депозитного срока (30 дней)");
        return moneyAmount;
    }

    @Override
    public double withdrawMoney(double withdrawMoney) {
        LocalDateTime withdrawDate = LocalDateTime.now();
        if (withdrawDate.isAfter(inputDate.plusDays(30)))
        {
        System.out.println("Дата списания денег: " + withdrawDate.format(format));
        System.out.println("Сумма списания: " + withdrawMoney);
        moneyAmount -= withdrawMoney;
        }
        else {
            System.out.println("Вы не можете снять деньги, пока не закончится срок депозита.");
        }
        return withdrawMoney;
    }
}
