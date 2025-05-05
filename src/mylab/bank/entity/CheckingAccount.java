package mylab.bank.entity;

public class CheckingAccount extends Account {
    private double overdraftLimit;

    public CheckingAccount(String accountNumber, String ownerName,
                         double initialBalance, double overdraftLimit) {
        super(accountNumber, ownerName, initialBalance);
        this.overdraftLimit = overdraftLimit;
    }

    public double getOverdraftLimit() { return overdraftLimit; }

    @Override
    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance + overdraftLimit) {
            balance -= amount;
            return true;
        }
        return false;
    }

    @Override
    public String getAccountInfo() {
        return String.format("���¹�ȣ: %s, ������: %s, �ܾ�: %.1f��, ��� �ѵ�: %.1f��",
                          accountNumber, ownerName, balance, overdraftLimit);
    }
}