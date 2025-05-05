package mylab.book.control;

import mylab.book.entity.*;
import java.util.*;
import java.util.stream.Collectors;

public class ShoppingCart {
    private List<Publication> items = new ArrayList<>();

    public void addItem(Publication item) {
        items.add(item);
        System.out.println("[�߰���] " + item);
    }

    public boolean removeItem(String title) {
        Iterator<Publication> it = items.iterator();
        while (it.hasNext()) {
            if (it.next().getTitle().equals(title)) {
                it.remove();
                System.out.println("[���ŵ�] " + title);
                return true;
            }
        }
        return false;
    }

    public void displayCart() {
        int idx = 1;
        for (Publication p : items) {
            System.out.println(idx++ + ". " + p);
        }
        System.out.printf("�� ����: %,d��\n", calculateTotalPrice());
        System.out.printf("���ΰ���: %,d��\n", calculateDiscountedPrice());
    }

    public int calculateTotalPrice() {
        return items.stream().mapToInt(Publication::getPrice).sum();
    }

    public int calculateDiscountedPrice() {
        int total = 0;
        for (Publication p : items) {
            if (p instanceof Magazine) total += p.getPrice() * 0.9;
            else if (p instanceof Novel) total += p.getPrice() * 0.85;
            else if (p instanceof ReferenceBook) total += p.getPrice() * 0.8;
            else total += p.getPrice();
        }
        return total;
    }

    public void printStatistics() {
        Map<String, Long> typeCount = items.stream().collect(
                Collectors.groupingBy(p -> p.getClass().getSimpleName(), Collectors.counting()));
        System.out.println("=== ���ǹ� ��� ===");
        typeCount.forEach((type, count) -> System.out.println(type + ": " + count + "��"));
    }
}