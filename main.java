import java.util.Scanner;

class User {
    private int id;
    private int pin;
    private int balance;

    public User(int id, int pin, int balance) {
        this.id = id;
        this.pin = pin;
        this.balance = balance;
    }

    public int getId() {
        return id;
    }

    public int getPin() {
        return pin;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }
}

class ATM {
    private User user;

    public ATM(User user) {
        this.user = user;
    }

    public void showMenu() {
        System.out.println("ATM");
        System.out.println("1. Transactions History");
        System.out.println("2. Withdraw");
        System.out.println("3. Deposit");
        System.out.println("4. Transfer");
        System.out.println("5. Quit");
        System.out.print("Enter your choice: ");
    }

    public void transactionHistory() {
        System.out.println("Transaction history for user " + user.getId());
        // implement your transaction history logic here
    }

    public void withdraw() {
        System.out.print("Enter amount to withdraw: ");
        Scanner scanner = new Scanner(System.in);
        int amount = scanner.nextInt();
        int balance = user.getBalance();
        if (amount <= balance) {
            user.setBalance(balance - amount);
            System.out.println("Withdraw successful. New balance is " + user.getBalance());
        } else {
            System.out.println("Insufficient balance");
        }
    }

    public void deposit() {
        System.out.print("Enter amount to deposit: ");
        Scanner scanner = new Scanner(System.in);
        int amount = scanner.nextInt();
        int balance = user.getBalance();
        user.setBalance(balance + amount);
        System.out.println("Deposit successful. New balance is " + user.getBalance());
    }

    public void transfer() {
        System.out.print("Enter recipient user id: ");
        Scanner scanner = new Scanner(System.in);
        int recipientId = scanner.nextInt();
        System.out.print("Enter amount to transfer: ");
        int amount = scanner.nextInt();
        int balance = user.getBalance();
        if (amount <= balance) {
            user.setBalance(balance - amount);
            System.out.println("Transfer successful. New balance is " + user.getBalance());
            // implement your transfer logic here
        } else {
            System.out.println("Insufficient balance");
        }
    }
}

class ATMApplication {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter user id: ");
        int id = scanner.nextInt();
        System.out.print("Enter user pin: ");
        int pin = scanner.nextInt();
        User user = new User(id, pin, 1000);
        ATM atm = new ATM(user);
        int choice = 0;
        while (choice != 5) {
            atm.showMenu();
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    atm.transactionHistory();
                    break;
                case 2:
                    atm.withdraw();
                    break;
                case 3:
                    atm.deposit();
                    break;
                case 4:
                    atm.transfer();
                    break;
                case 5:
                    System.out.println("Thank you for using our ATM. Have a nice day!");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
                    break;
            }
        }
    }
}

