package mylab.book.control;

import mylab.book.entity.*;
import java.text.DecimalFormat;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

public class StatisticsAnalyzer {
    private String getPublicationType(Publication pub) {
        if (pub instanceof Novel) return "�Ҽ�";
        if (pub instanceof Magazine) return "����";
        if (pub instanceof ReferenceBook) return "����";
        return "��Ÿ";
    }

    public Map<String, Double> calculateAveragePriceByType(Publication[] pubs) {
        Map<String, List<Publication>> grouped = Arrays.stream(pubs)
                .collect(Collectors.groupingBy(this::getPublicationType));

        Map<String, Double> result = new HashMap<>();
        grouped.forEach((k, v) -> {
            double avg = v.stream().mapToInt(Publication::getPrice).average().orElse(0);
            result.put(k, avg);
        });
        return result;
    }

    public Map<String, Double> calculatePublicationDistribution(Publication[] pubs) {
        Map<String, Long> counts = Arrays.stream(pubs)
                .collect(Collectors.groupingBy(this::getPublicationType, Collectors.counting()));
        int total = pubs.length;
        Map<String, Double> result = new HashMap<>();
        counts.forEach((k, v) -> result.put(k, v * 100.0 / total));
        return result;
    }

    public double calculatePublicationRatioByYear(Publication[] pubs, String year) {
        long count = Arrays.stream(pubs)
                .filter(p -> p.getPublishDate().toString().startsWith(year))
                .count();
        return count * 100.0 / pubs.length;
    }

    public void printStatistics(Publication[] pubs) {
        DecimalFormat df = new DecimalFormat("#,###.##");
        System.out.println("===== ���ǹ� ��� �м� =====");
        System.out.println("1. Ÿ�Ժ� ��� ����:");
        calculateAveragePriceByType(pubs).forEach((k, v) ->
                System.out.printf("   - %s: %s��\n", k, df.format(v)));
        System.out.println("\n2. ���ǹ� ���� ����:");
        calculatePublicationDistribution(pubs).forEach((k, v) ->
                System.out.printf("   - %s: %.2f%%\n", k, v));
        System.out.printf("\n3. 2007�⿡ ���ǵ� ���ǹ� ����: %.2f%%\n", calculatePublicationRatioByYear(pubs, "2007"));
    }
}