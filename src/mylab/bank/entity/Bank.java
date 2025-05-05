package mylab.bank.entity;

import mylab.bank.exception.*;
import java.util.ArrayList;
import java.util.List;

public class Bank {
    private List<Account> accounts;
    private int nextAccountNumber;

    public Bank() {
        this.accounts = new ArrayList<>();
        this.nextAccountNumber = 1000; // AC1000부터 시작
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
        throw new AccountNotFoundException("계좌번호 " + accountNumber + "에 해당하는 계좌를 찾을 수 없습니다.");
    }


    // 입금
    public void deposit(String accountNumber, double amount) 
            throws AccountNotFoundException {
        Account account = getAccount(accountNumber);
        account.deposit(amount);
    }

    // 출금
    public void withdraw(String accountNumber, double amount) 
            throws AccountNotFoundException, InsufficientBalanceException {
        Account account = getAccount(accountNumber);
        if (!account.withdraw(amount)) {
            if (account instanceof CheckingAccount) {
                throw new WithdrawalLimitExceededException(
                    "출금 한도를 초과했습니다. 한도: " + 
                    ((CheckingAccount)account).getOverdraftLimit());
            } else {
                throw new InsufficientBalanceException(
                    "잔액이 부족합니다. 현재 잔액: " + account.getBalance());
            }
        }
    }

    // 계좌 이체
    public void transfer(String fromAccountNumber, String toAccountNumber, double amount) 
            throws AccountNotFoundException, InsufficientBalanceException {
        withdraw(fromAccountNumber, amount);
        deposit(toAccountNumber, amount);
    }

    // 모든 계좌 정보 출력
    public void printAllAccounts() {
        System.out.println("===== 모든 계좌 정보 =====");
        for (Account account : accounts) {
            System.out.println(account.getAccountInfo());
        }
        System.out.println("===================");
    }

    // 계좌 목록 반환
    public List<Account> getAllAccounts() {
        return new ArrayList<>(accounts);
    }
}