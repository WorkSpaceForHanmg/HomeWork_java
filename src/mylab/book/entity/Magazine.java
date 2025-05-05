package mylab.book.entity;
import java.time.LocalDate;

public class Magazine extends Publication {
    private String publishPeriod;

    public Magazine(String title, LocalDate publishDate, int page, int price, String publishPeriod) {
        super(title, publishDate, page, price);
        this.publishPeriod = publishPeriod;
    }

    @Override
    public String toString() {
        return String.format("%s [����] �����ֱ�:%s, %d��, %,d��, ������:%s",
                getTitle(), publishPeriod, getPage(), getPrice(), getPublishDate());
    }
}
