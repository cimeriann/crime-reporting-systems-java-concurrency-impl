package org.cscproject;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class CSVExporter {
    public static void saveToCSV(Map<String, Integer> featureCount, String fileName) {
        try (FileWriter writer = new FileWriter(fileName)) {
            writer.append("Feature,Occurrences\n");  // CSV Header
            for (Map.Entry<String, Integer> entry : featureCount.entrySet()) {
                writer.append(entry.getKey()).append(",").append(String.valueOf(entry.getValue())).append("\n");
            }
            System.out.println("Data successfully exported to " + fileName);
        } catch (IOException e) {
            System.err.println("Error writing to CSV file: " + e.getMessage());
        }
    }
}

