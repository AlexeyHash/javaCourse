
public class BankAccounts {

    private double moneyAmount;


    public double inputMoney(double input){
        moneyAmount += input;
        System.out.println("Сумма поступления: " + input);
        return moneyAmount;
    }

    public double withdrawMoney(double withdrawMoney){
        if(moneyAmount < withdrawMoney){
            System.out.println("Сумма списания " +"(" + withdrawMoney  + ")" + " превышает количество денег на счету.");
        }
        else {
            moneyAmount -= withdrawMoney;
            System.out.println("Сумма списания: " + withdrawMoney);
        }
        return moneyAmount;
    }

    public void statusAccount(){
        System.out.println("Остаток на счете: " + moneyAmount);
    }

}