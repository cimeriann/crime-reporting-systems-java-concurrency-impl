package org.cscproject;
import java.util.*;
import java.util.concurrent.*;
//import CSV
public class Main {
    public static void main(String[] args) {
            ExecutorService executor = Executors.newFixedThreadPool(3);


        // Step 1: Fetch SERP results for crime-reporting papers
        Future<List<String>> searchResultsFuture = executor.submit(new SerpFetcher("crime reporting papers"));

        try {
            // Step 2: Retrieve search results
            List<String> searchResults = searchResultsFuture.get();

            // Step 3: Extract distinctive features
            Future<Map<String, Integer>> featureAnalysisFuture = executor.submit(new FeatureExtractor(searchResults));
            Map<String, Integer> featureCount = featureAnalysisFuture.get();

            // Step 4: Print feature analysis
            System.out.println("Feature Analysis: " + featureCount);

            // Step 5: Save results to CSV file
            CSVExporter.saveToCSV(featureCount, "crime_features.csv");

            // Step 6: Visualize results in a bar chart
            ChartVisualizer.displayChart(featureCount);

        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        } finally {
            executor.shutdown();
        }
    }
}
