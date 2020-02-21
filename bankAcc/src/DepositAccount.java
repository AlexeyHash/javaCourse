import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class DepositAccount extends BankAccounts {

    private DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm");
    private LocalDateTime lastInputDate = LocalDateTime.now();

    @Override
    public double inputMoney(double input) {
        lastInputDate = LocalDateTime.now();
                super.inputMoney(input);
        System.out.println("Вы внесли деньги на депозитный счет.");
        System.out.println("Дата поступления: " + lastInputDate.format(format));
        System.out.println("Вы сможете обналичить их после истечения депозитного срока (1 месяц)");
        return input;
    }

    @Override
    public double withdrawMoney(double withdrawMoney) {
        LocalDateTime withdrawDate = LocalDateTime.now();
        if (withdrawDate.isAfter(lastInputDate.plusMonths(1))) {
            System.out.println("Дата списания средств: " + withdrawDate.format(format));
        super.withdrawMoney(withdrawMoney);
        }
        else {
            System.out.println("Вы не можете снять деньги, пока не закончится срок депозита.");
        }
        return withdrawMoney;
    }
}
