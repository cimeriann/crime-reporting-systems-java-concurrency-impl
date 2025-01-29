package org.cscproject;

import java.util.*;
import java.util.concurrent.*;

public class CrimeSerpAnalysis {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(3);
        Future<List<String>> searchResultsFuture = executor.submit(new SerpFetcher("crime reporting papers"));

        try {
            List<String> searchResults = searchResultsFuture.get();
            Future<Map<String, Integer>> featureAnalysisFuture = executor.submit(new FeatureExtractor(searchResults));

            Map<String, Integer> featureCount = featureAnalysisFuture.get();
            System.out.println("Feature Analysis: " + featureCount);

            ChartVisualizer.displayChart(featureCount);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        } finally {
            executor.shutdown();
        }
    }
}

