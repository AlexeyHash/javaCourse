public class CardBankAccount extends BankAccounts {

    @Override
    public double withdrawMoney(double withdrawMoney) {

        double commissionValue = withdrawMoney * 0.01;
        double sum = commissionValue + withdrawMoney;
            super.withdrawMoney(sum);
            System.out.println("Комиссия (1%): " + commissionValue);

        return withdrawMoney;
    }

}
