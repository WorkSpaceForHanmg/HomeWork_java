package mylab.bank.entity;

public class SavingsAccount extends Account {
    private double interestRate;

    public SavingsAccount(String accountNumber, String ownerName, 
                        double initialBalance, double interestRate) {
        super(accountNumber, ownerName, initialBalance);
        this.interestRate = interestRate;
    }

    public double getInterestRate() { return interestRate; }

    public void applyInterest() {
        double interest = balance * interestRate / 100;
        balance += interest;
    }

    @Override
    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            return true;
        }
        return false;
    }

    @Override
    public String getAccountInfo() {
        return String.format("���¹�ȣ: %s, ������: %s, �ܾ�: %.1f��, ������: %.1f%%",
                           accountNumber, ownerName, balance, interestRate);
    }
}