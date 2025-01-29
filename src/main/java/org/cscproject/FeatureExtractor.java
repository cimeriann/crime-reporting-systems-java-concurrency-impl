package org.cscproject;
import java.util.*;
import java.util.concurrent.Callable;

public class FeatureExtractor implements Callable<Map<String, Integer>> {
    private final List<String> documents;

    public FeatureExtractor(List<String> documents) {
        this.documents = documents;
    }

    @Override
    public Map<String, Integer> call() {
        Map<String, Integer> featureCount = new HashMap<>();
        String[] features = {"case study", "data visualization", "statistics", "legal references", "public opinion",
                "geographical coverage", "witness interviews", "crime trends", "historical data", "AI analytics"};

        for (String doc : documents) {
            for (String feature : features) {
                if (doc.toLowerCase().contains(feature)) {
                    featureCount.put(feature, featureCount.getOrDefault(feature, 0) + 1);
                }
            }
        }
        return featureCount;
    }
}
