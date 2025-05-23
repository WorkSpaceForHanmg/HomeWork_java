package mylab.book.control;

import mylab.book.entity.*;
import java.time.LocalDate;

public class ManageBook {
    public static void main(String[] args) {
        Publication[] pubs = new Publication[] {
            new Magazine("마이크로소프트", LocalDate.parse("2007-10-01"), 328, 9900, "매월"),
            new Magazine("경영과컴퓨터", LocalDate.parse("2007-10-03"), 316, 9000, "매월"),
            new Novel("빠삐용", LocalDate.parse("2007-07-01"), 396, 9800, "베르나르베르베르", "현대소설"),
            new Novel("남한산성", LocalDate.parse("2007-04-14"), 383, 11000, "김훈", "대하소설"),
            new ReferenceBook("실용주의프로그래머", LocalDate.parse("2007-01-14"), 496, 25000, "소프트웨어공학"),
            new Novel("소년이온다", LocalDate.parse("2014-05-01"), 216, 15000, "한강", "장편소설"),
            new Novel("작별하지않는다", LocalDate.parse("2021-09-09"), 332, 15120, "한강", "장편소설")
        };

        System.out.println("==== 도서 정보 출력 ====");
        for (int i = 0; i < pubs.length; i++) {
            System.out.printf("%d. %s\n", i + 1, pubs[i]);
        }

        Publication p = pubs[6];
        int oldPrice = p.getPrice();
        modifyPrice(p);
        int newPrice = p.getPrice();
        System.out.printf("\n==== 가격 변경 ====\n%s 변경 전 가격: %,d원\n%s 변경 후 가격: %,d원\n차액: %,d원\n",
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
