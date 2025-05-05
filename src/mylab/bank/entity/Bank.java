package mylab.bank.entity;

import mylab.bank.exception.*;
import java.util.ArrayList;
import java.util.List;

public class Bank {
    private List<Account> accounts;
    private int nextAccountNumber;

    public Bank() {
        this.accounts = new ArrayList<>();
        this.nextAccountNumber = 1000; // AC1000���� ����
    }

    public SavingsAccount createSavingsAccount(String customerName, 
                                            double initialBalance,
                                            double interestRate) {
        String accountNumber = "AC" + nextAccountNumber++;
        SavingsAccount account = new SavingsAccount(accountNumber, customerName, 
                                                 initialBalance, interestRate);
        accounts.add(account);
        return account;
    }

    public CheckingAccount createCheckingAccount(String customerName,
                                              double initialBalance,
                                              double overdraftLimit) {
        String accountNumber = "AC" + nextAccountNumber++;
        CheckingAccount account = new CheckingAccount(accountNumber, customerName,
                                                   initialBalance, overdraftLimit);
        accounts.add(account);
        return account;
    }

    public Account getAccount(String accountNumber) throws AccountNotFoundException {
        for (Account account : accounts) {
            if (account.getAccountNumber().equals(accountNumber)) {
                return account;
            }
        }
        throw new AccountNotFoundException("���¹�ȣ " + accountNumber + "�� �ش��ϴ� ���¸� ã�� �� �����ϴ�.");
    }


    // �Ա�
    public void deposit(String accountNumber, double amount) 
            throws AccountNotFoundException {
        Account account = getAccount(accountNumber);
        account.deposit(amount);
    }

    // ���
    public void withdraw(String accountNumber, double amount) 
            throws AccountNotFoundException, InsufficientBalanceException {
        Account account = getAccount(accountNumber);
        if (!account.withdraw(amount)) {
            if (account instanceof CheckingAccount) {
                throw new WithdrawalLimitExceededException(
                    "��� �ѵ��� �ʰ��߽��ϴ�. �ѵ�: " + 
                    ((CheckingAccount)account).getOverdraftLimit());
            } else {
                throw new InsufficientBalanceException(
                    "�ܾ��� �����մϴ�. ���� �ܾ�: " + account.getBalance());
            }
        }
    }

    // ���� ��ü
    public void transfer(String fromAccountNumber, String toAccountNumber, double amount) 
            throws AccountNotFoundException, InsufficientBalanceException {
        withdraw(fromAccountNumber, amount);
        deposit(toAccountNumber, amount);
    }

    // ��� ���� ���� ���
    public void printAllAccounts() {
        System.out.println("===== ��� ���� ���� =====");
        for (Account account : accounts) {
            System.out.println(account.getAccountInfo());
        }
        System.out.println("===================");
    }

    // ���� ��� ��ȯ
    public List<Account> getAllAccounts() {
        return new ArrayList<>(accounts);
    }
}