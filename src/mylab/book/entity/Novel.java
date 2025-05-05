package mylab.book.entity;

import java.time.LocalDate;

public class Novel extends Publication {
    private String author;
    private String genre;

    public Novel(String title, LocalDate publishDate, int page, int price, String author, String genre) {
        super(title, publishDate, page, price);
        this.author = author;
        this.genre = genre;
    }

    @Override
    public String toString() {
        return String.format("%s [�Ҽ�] ����:%s, �帣:%s, %d��, %,d��, ������:%s",
                getTitle(), author, genre, getPage(), getPrice(), getPublishDate());
    }
}