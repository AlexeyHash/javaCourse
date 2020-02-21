import java.time.LocalDateTime;
import java.util.Scanner;

public class Main {

    static String add = "Внести";
    static String withdraw = "Снять";
    static String status = "Счет";

    public static void main(String[] args) {

        DepositAccount diposit = new DepositAccount();
        CardBankAccount card = new CardBankAccount();
        BankAccounts accounts = new BankAccounts();

//        card.inputMoney(2000.0);
//        card.withdrawMoney(5000.0);
//        card.statusAccount();



        Scanner scanner = new Scanner(System.in);

        while (true) {
            String command = scanner.nextLine();
            if (command.equalsIgnoreCase(add)) {
                diposit.inputMoney(4000);
            } else if (command.equalsIgnoreCase(withdraw)) {
                diposit.withdrawMoney(2000.0);
            } else if (command.equalsIgnoreCase(status)) {
                diposit.statusAccount();
            }
        }


    }
}
