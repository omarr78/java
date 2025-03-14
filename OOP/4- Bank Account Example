public class BankAccount {
    private int accountNO;
    private String accountName;
    private float accountBalance;

    public void insert(int accountNO, String accountName, float accountBalance) {
        this.accountNO = accountNO;
        this.accountName = accountName;
        this.accountBalance = accountBalance;
    }
    public void deposit(float amount) {
        accountBalance += amount;
        System.out.println("new Balance :" + accountBalance);
    }
    public void withdraw(float amount) {
        if(accountBalance >= amount) {
            accountBalance -= amount;
            System.out.println("new Balance :" + accountBalance);
        }
        else {
            System.out.println("Insufficient Balance");
        }
    }
    public void checkBalance() {
        System.out.println("Balance :" + accountBalance);
    }
    public String toString() {
        return "BankAccount{" +
                "accountNO=" + accountNO +
                ", accountName='" + accountName + '\'' +
                ", accountBalance=" + accountBalance +
                '}';
    }
}



public class Main {
    public static void main(String[] args) {
        BankAccount a1 = new BankAccount();
        BankAccount a2 = new BankAccount();
        BankAccount a3 = new BankAccount();

        a1.insert(4451238,"Mohamed",10000);
        a2.insert(4451237,"Belal",100);
        a3.insert(9563145,"Ahmad",500);

        a1.deposit(12000);
        a1.withdraw(2000);
        a1.checkBalance();
        System.out.println(a1.toString());

        a2.deposit(50);
        a2.withdraw(160);
        a2.checkBalance();
        System.out.println(a2.toString());

        a3.deposit(550);
        a3.withdraw(10);
        a3.checkBalance();
        System.out.println(a3.toString());
    }
}
