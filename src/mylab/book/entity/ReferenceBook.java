package mylab.book.entity;

import java.time.LocalDate;

public class ReferenceBook extends Publication {
    private String field;

    public ReferenceBook(String title, LocalDate publishDate, int page, int price, String field) {
        super(title, publishDate, page, price);
        this.field = field;
    }

    @Override
    public String toString() {
        return String.format("%s [����] �о�:%s, %d��, %,d��, ������:%s",
                getTitle(), field, getPage(), getPrice(), getPublishDate());
    }
}