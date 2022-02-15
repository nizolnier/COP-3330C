public class App {
    public static void main(String[] args) {
        BankAccount acc1 = new BankAccount("John Smith", 20.52, "checking", "123455678"); // reference
        BankAccount acc2 = new BankAccount();
        BankAccount acc3 = new BankAccount("John Smith", 20.52, "checking", "123455678");
        BankAccount acc4 = new BankAccount("Jenna Jones", 120.52, "savings", "87654321"); 

        System.out.println(acc1); // John Smith [20.52] checking
        System.out.println(acc2); // NoName [0.0] checking
        System.out.println(acc1 == acc3); // false

        acc1.deposit(100);
        acc4.withdraw(200);

        System.out.println(acc1); // John Smith [120.52] checking
        System.out.println(acc4); // Jenna Jones [-89.48] savings


        BankAccount[] bank = new BankAccount[100];

        for(int i =0; i < 100; i++) {
            bank[i] = null;
        }
    }
}

class BankAccount {
    // variables
    String holder;
    double balance;
    String type;
    String accountNumber;


    // setters and getters
    public String getHolder() {
        return this.holder;
    }

    public void setHolder(String holder) {
        this.holder = holder;
    }

    public double getBalance() {
        return this.balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAccountNumber() {
        return this.accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    // operations
    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) {
        if(type.equals("checking")) {
            balance -= amount;
        } else {
            balance -= amount*1.05;
        }
    }

    // constructors
    // default
    public BankAccount() {
        holder = "NoName";
        balance = 0;
        type = "checking";
        accountNumber = "0000000000";
    }

    public BankAccount(String holder, double balance, String type, String accountNumber) {
        setHolder(holder);
        setBalance(balance);
        setType(type);
        setAccountNumber(accountNumber);
    }

    public String toString() {
        return holder + " [" + balance + "] " + type;
    }
}