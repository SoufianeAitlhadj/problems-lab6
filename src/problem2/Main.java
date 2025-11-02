package problem2;
public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank("Global Bank");

        bank.addCustomer("Alice", 1000.0);
        bank.addCustomer("Bob", 500.0);

        bank.addTransaction("Alice", -200.0);
        bank.addTransaction("Alice", 150.0);
        bank.addTransaction("Bob", -50.0);
        bank.addTransaction("Bob", 200.0);

        bank.printStatement();
    }
}
