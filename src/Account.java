import java.util.Scanner;

 class ATM {
    private double balance;
    private String accountNumber;
    private String pin;

    public ATM(String accountNumber, String pin, double balance) {
        this.accountNumber = accountNumber;
        this.pin = pin;
        this.balance = balance;
    }

    public void checkBalance() {
        System.out.println("Your balance is: $" + balance);
    }

    public void withdraw(double amount) {
        if (amount > balance) {
            System.out.println("Insufficient funds.");
        } else {
            balance -= amount;
            System.out.println("You have withdrawn $" + amount + ". Your new balance is $" + balance);
        }
    }

    public void deposit(double amount) {
        balance += amount;
        System.out.println("You have deposited $" + amount + ". Your new balance is $" + balance);
    }

    public boolean authenticate(String accountNumber, String pin) {
        return this.accountNumber.equals(accountNumber) && this.pin.equals(pin);
    }

    public static void main(String[] args) {
        ATM atm = new ATM("123456789", "1234", 1000.0);
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the ATM.");
        System.out.print("Please enter your account number: ");
        String accountNumber = scanner.nextLine();
        System.out.print("Please enter your PIN: ");
        String pin = scanner.nextLine();
        if (!atm.authenticate(accountNumber, pin)) {
            System.out.println("Invalid account number or PIN.");
            return;
        }
        while (true) {
            System.out.println("What would you like to do?");
            System.out.println("1. Check balance");
            System.out.println("2. Withdraw");
            System.out.println("3. Deposit");
            System.out.println("4. Exit");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    atm.checkBalance();
                    break;
                case 2:
                    System.out.print("Enter amount to withdraw: ");
                    double amount = scanner.nextDouble();
                    atm.withdraw(amount);
                    break;
                case 3:
                    System.out.print("Enter amount to deposit: ");
                    amount = scanner.nextDouble();
                    atm.deposit(amount);
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM.");
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}