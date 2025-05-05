package mylab.bank.control;

import mylab.bank.entity.*;
import mylab.bank.exception.*;

public class BankDemo {
    public static void main(String[] args) {
        Bank bank = new Bank();

        try {
            // 1. 계좌 생성
            System.out.println("=== 계좌 생성 ===");
            SavingsAccount hong = bank.createSavingsAccount("홍길동", 10000, 3.0);
            CheckingAccount kim = bank.createCheckingAccount("김철수", 20000, 5000);
            SavingsAccount lee = bank.createSavingsAccount("이영희", 30000, 2.0);

            System.out.printf("Saving(저축) 계좌가 생성되었습니다: 계좌번호: %s, 소유자: %s, 잔액: %.1f원, 이자율: %.1f%%\n",
                hong.getAccountNumber(), hong.getOwnerName(), hong.getBalance(), hong.getInterestRate());
            System.out.printf("체킹 계좌가 생성되었습니다: 계좌번호: %s, 소유자: %s, 잔액: %.1f원, 출금 한도: %.1f원\n",
                kim.getAccountNumber(), kim.getOwnerName(), kim.getBalance(), kim.getOverdraftLimit());
            System.out.printf("저축 계좌가 생성되었습니다: 계좌번호: %s, 소유자: %s, 잔액: %.1f원, 이자율: %.1f%%\n\n",
                lee.getAccountNumber(), lee.getOwnerName(), lee.getBalance(), lee.getInterestRate());

            // 2. 모든 계좌 목록 출력
            printAllAccounts(bank);

            // 3. 입금/출금 테스트
            System.out.println("=== 입금/출금 테스트 ===");
            bank.deposit(hong.getAccountNumber(), 5000);
            System.out.printf("5000.0원이 입금되었습니다. 현재 잔액: %.1f원\n", hong.getBalance());
            
            bank.withdraw(kim.getAccountNumber(), 3000);
            System.out.printf("3000.0원이 출금되었습니다. 현재 잔액: %.1f원\n\n", kim.getBalance());

            // 4. 이자 적용 테스트
            System.out.println("=== 이자 적용 테스트 ===");
            double interest = hong.getBalance() * hong.getInterestRate() / 100;
            hong.applyInterest();
            System.out.printf("%.1f원이 입금되었습니다. 현재 잔액: %.1f원\n", interest, hong.getBalance());
            System.out.printf("이자 %.1f원이 적용되었습니다. 현재 잔액: %.1f원\n\n", interest, hong.getBalance());

            // 5. 계좌 이체 테스트
            System.out.println("=== 계좌 이체 테스트 ===");
            bank.transfer(lee.getAccountNumber(), kim.getAccountNumber(), 5000);
            System.out.printf("5000.0원이 출금되었습니다. 현재 잔액: %.1f원\n", lee.getBalance());
            System.out.printf("5000.0원이 입금되었습니다. 현재 잔액: %.1f원\n", kim.getBalance());
            System.out.printf("5000.0원이 %s에서 %s로 송금되었습니다.\n\n", 
                lee.getAccountNumber(), kim.getAccountNumber());

            // 6. 최종 계좌 상태 출력
            printAllAccounts(bank);

            // 7. 예외 테스트
            System.out.println("=== 예외 테스트 ===");
            try {
                bank.withdraw(kim.getAccountNumber(), 10000);
            } catch (WithdrawalLimitExceededException e) {
                System.out.println("예외 발생: " + e.getMessage());
            }
            
            try {
                bank.withdraw(hong.getAccountNumber(), 20000);
            } catch (InsufficientBalanceException e) {
                System.out.println("예외 발생: " + e.getMessage());
            }
            
            try {
                bank.getAccount("AC9999");
            } catch (AccountNotFoundException e) {
                System.out.println("예외 발생: " + e.getMessage());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void printAllAccounts(Bank bank) {
        System.out.println("=== 모든 계좌 목록 ===");
        for (Account account : bank.getAllAccounts()) {
            System.out.println(account.getAccountInfo());
        }
        System.out.println("===================\n");
    }
}