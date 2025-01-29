package org.cscproject;

//import org.jfree;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import javax.swing.*;
import java.util.Map;

public class ChartVisualizer {
    public static void displayChart(Map<String, Integer> featureCount) {
        JFreeChart barChart = ChartFactory.createBarChart(
                "Crime-Reporting Paper Features",
                "Feature",
                "Occurrences",
                createDataset(featureCount),
                PlotOrientation.VERTICAL,
                true, true, false);

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new ChartPanel(barChart));
        frame.setSize(800, 600);
        frame.setVisible(true);
    }

    private static CategoryDataset createDataset(Map<String, Integer> featureCount) {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for (Map.Entry<String, Integer> entry : featureCount.entrySet()) {
            dataset.addValue(entry.getValue(), "Features", entry.getKey());
        }
        return dataset;
    }
}

