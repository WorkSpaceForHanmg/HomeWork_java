package mylab.bank.control;

import mylab.bank.entity.*;
import mylab.bank.exception.*;

public class BankDemo {
    public static void main(String[] args) {
        Bank bank = new Bank();

        try {
            // 1. ���� ����
            System.out.println("=== ���� ���� ===");
            SavingsAccount hong = bank.createSavingsAccount("ȫ�浿", 10000, 3.0);
            CheckingAccount kim = bank.createCheckingAccount("��ö��", 20000, 5000);
            SavingsAccount lee = bank.createSavingsAccount("�̿���", 30000, 2.0);

            System.out.printf("Saving(����) ���°� �����Ǿ����ϴ�: ���¹�ȣ: %s, ������: %s, �ܾ�: %.1f��, ������: %.1f%%\n",
                hong.getAccountNumber(), hong.getOwnerName(), hong.getBalance(), hong.getInterestRate());
            System.out.printf("üŷ ���°� �����Ǿ����ϴ�: ���¹�ȣ: %s, ������: %s, �ܾ�: %.1f��, ��� �ѵ�: %.1f��\n",
                kim.getAccountNumber(), kim.getOwnerName(), kim.getBalance(), kim.getOverdraftLimit());
            System.out.printf("���� ���°� �����Ǿ����ϴ�: ���¹�ȣ: %s, ������: %s, �ܾ�: %.1f��, ������: %.1f%%\n\n",
                lee.getAccountNumber(), lee.getOwnerName(), lee.getBalance(), lee.getInterestRate());

            // 2. ��� ���� ��� ���
            printAllAccounts(bank);

            // 3. �Ա�/��� �׽�Ʈ
            System.out.println("=== �Ա�/��� �׽�Ʈ ===");
            bank.deposit(hong.getAccountNumber(), 5000);
            System.out.printf("5000.0���� �ԱݵǾ����ϴ�. ���� �ܾ�: %.1f��\n", hong.getBalance());
            
            bank.withdraw(kim.getAccountNumber(), 3000);
            System.out.printf("3000.0���� ��ݵǾ����ϴ�. ���� �ܾ�: %.1f��\n\n", kim.getBalance());

            // 4. ���� ���� �׽�Ʈ
            System.out.println("=== ���� ���� �׽�Ʈ ===");
            double interest = hong.getBalance() * hong.getInterestRate() / 100;
            hong.applyInterest();
            System.out.printf("%.1f���� �ԱݵǾ����ϴ�. ���� �ܾ�: %.1f��\n", interest, hong.getBalance());
            System.out.printf("���� %.1f���� ����Ǿ����ϴ�. ���� �ܾ�: %.1f��\n\n", interest, hong.getBalance());

            // 5. ���� ��ü �׽�Ʈ
            System.out.println("=== ���� ��ü �׽�Ʈ ===");
            bank.transfer(lee.getAccountNumber(), kim.getAccountNumber(), 5000);
            System.out.printf("5000.0���� ��ݵǾ����ϴ�. ���� �ܾ�: %.1f��\n", lee.getBalance());
            System.out.printf("5000.0���� �ԱݵǾ����ϴ�. ���� �ܾ�: %.1f��\n", kim.getBalance());
            System.out.printf("5000.0���� %s���� %s�� �۱ݵǾ����ϴ�.\n\n", 
                lee.getAccountNumber(), kim.getAccountNumber());

            // 6. ���� ���� ���� ���
            printAllAccounts(bank);

            // 7. ���� �׽�Ʈ
            System.out.println("=== ���� �׽�Ʈ ===");
            try {
                bank.withdraw(kim.getAccountNumber(), 10000);
            } catch (WithdrawalLimitExceededException e) {
                System.out.println("���� �߻�: " + e.getMessage());
            }
            
            try {
                bank.withdraw(hong.getAccountNumber(), 20000);
            } catch (InsufficientBalanceException e) {
                System.out.println("���� �߻�: " + e.getMessage());
            }
            
            try {
                bank.getAccount("AC9999");
            } catch (AccountNotFoundException e) {
                System.out.println("���� �߻�: " + e.getMessage());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void printAllAccounts(Bank bank) {
        System.out.println("=== ��� ���� ��� ===");
        for (Account account : bank.getAllAccounts()) {
            System.out.println(account.getAccountInfo());
        }
        System.out.println("===================\n");
    }
}