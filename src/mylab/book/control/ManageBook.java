package mylab.book.control;

import mylab.book.entity.*;
import java.time.LocalDate;

public class ManageBook {
    public static void main(String[] args) {
        Publication[] pubs = new Publication[] {
            new Magazine("����ũ�μ���Ʈ", LocalDate.parse("2007-10-01"), 328, 9900, "�ſ�"),
            new Magazine("�濵����ǻ��", LocalDate.parse("2007-10-03"), 316, 9000, "�ſ�"),
            new Novel("���߿�", LocalDate.parse("2007-07-01"), 396, 9800, "����������������", "����Ҽ�"),
            new Novel("���ѻ꼺", LocalDate.parse("2007-04-14"), 383, 11000, "����", "���ϼҼ�"),
            new ReferenceBook("�ǿ��������α׷���", LocalDate.parse("2007-01-14"), 496, 25000, "����Ʈ�������"),
            new Novel("�ҳ��̿´�", LocalDate.parse("2014-05-01"), 216, 15000, "�Ѱ�", "����Ҽ�"),
            new Novel("�ۺ������ʴ´�", LocalDate.parse("2021-09-09"), 332, 15120, "�Ѱ�", "����Ҽ�")
        };

        System.out.println("==== ���� ���� ��� ====");
        for (int i = 0; i < pubs.length; i++) {
            System.out.printf("%d. %s\n", i + 1, pubs[i]);
        }

        Publication p = pubs[6];
        int oldPrice = p.getPrice();
        modifyPrice(p);
        int newPrice = p.getPrice();
        System.out.printf("\n==== ���� ���� ====\n%s ���� �� ����: %,d��\n%s ���� �� ����: %,d��\n����: %,d��\n",
                p.getTitle(), oldPrice, p.getTitle(), newPrice, oldPrice - newPrice);

        StatisticsAnalyzer sa = new StatisticsAnalyzer();
        sa.printStatistics(pubs);
    }

    public static void modifyPrice(Publication p) {
        if (p instanceof Magazine) p.setPrice((int)(p.getPrice() * 0.6));
        else if (p instanceof Novel) p.setPrice((int)(p.getPrice() * 0.8));
        else if (p instanceof ReferenceBook) p.setPrice((int)(p.getPrice() * 0.9));
    }
}
