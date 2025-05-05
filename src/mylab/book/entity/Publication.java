package mylab.book.entity;

import java.time.LocalDate;

public class Publication {
    private String title;
    private LocalDate publishDate;
    private int page;
    private int price;

    public Publication() {}

    public Publication(String title, LocalDate publishDate, int page, int price) {
        this.title = title;
        this.publishDate = publishDate;
        this.page = page;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public LocalDate getPublishDate() {
        return publishDate;
    }

    public int getPage() {
        return page;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return title;
    }
}