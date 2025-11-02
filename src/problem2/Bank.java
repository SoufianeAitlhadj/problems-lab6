package problem2;
import java.util.ArrayList;

public class Bank {
    private String name;
    private ArrayList<Customer> customers;

    public Bank(String name) {
        this.name = name;
        this.customers = new ArrayList<>();
    }

    public boolean addCustomer(String customerName, double initialAmount) {
        if (findCustomer(customerName) == null) {
            customers.add(new Customer(customerName, initialAmount));
            System.out.println("New customer added: " + customerName);
            return true;
        } else {
            System.out.println("Customer already exists: " + customerName);
            return false;
        }
    }

    public boolean addTransaction(String customerName, double amount) {
        Customer existingCustomer = findCustomer(customerName);
        if (existingCustomer != null) {
            existingCustomer.addTransaction(amount);
            System.out.println("Transaction added for " + customerName + ": " + amount);
            return true;
        } else {
            System.out.println("Customer not found: " + customerName);
            return false;
        }
    }

    public void printStatement() {
        System.out.println("\nBank Statement for " + name + ":");
        for (Customer customer : customers) {
            System.out.println("Customer: " + customer.getName());
            System.out.println("Transactions:");
            for (Double transaction : customer.getTransactions()) {
                double amount = transaction; // unboxing
                System.out.println("  " + amount);
            }
            System.out.println();
        }
    }

    private Customer findCustomer(String name) {
        for (Customer customer : customers) {
            if (customer.getName().equalsIgnoreCase(name)) {
                return customer;
            }
        }
        return null;
    }
}
