package connect.stellantis.car.trip.report;

import java.awt.*;
import javax.swing.*;
import org.jfree.chart.*;
import org.jfree.data.xy.*;
import java.util.ArrayList;
import org.jfree.chart.plot.*;
import org.jfree.chart.renderer.xy.*;

public class ChartScreen extends JFrame {
    private JButton m_backButton;
    private JPanel m_chartPanel;

    public ChartScreen(String title, String labelX, String labelY, String measurementName,
        ArrayList<Long> xData, ArrayList<Number> yData, String backButtonPath) {
        configureScreen();
        XYDataset dataset = createDataset(measurementName, xData, yData);
        createChartPanel(title, labelX, labelY, measurementName, dataset);
        loadElements(backButtonPath);
    }
 
    public JButton getBackButton() {
        return m_backButton;
    }

    private void configureScreen() {
        setSize(1080, 641);
        setVisible(false);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    private void loadElements(String backButtonPath) {
        m_backButton = new JButton(new ImageIcon(backButtonPath));
        addElements();
        configureElementsLayout();
    }

    private void addElements() {
        add(m_chartPanel);
        m_chartPanel.add(m_backButton);
    }

    private void configureElementsLayout() {
        m_chartPanel.setLayout(null);
        m_backButton.setLayout(null);
        configureElementsBounds();
        configureElementsOpacity();
    }

    private void configureElementsBounds() {
        m_chartPanel.setBounds(0, 0, getSize().width,getSize().height);
        m_backButton.setBounds(getInsets().left + 80, getInsets().top + 50, 90, 90);
    }

    private void configureElementsOpacity() {
        m_backButton.setContentAreaFilled(false);
    }

    private void createChartPanel(String title, String labelX, String labelY, String measurementName, XYDataset dataset) {
        JFreeChart chart = ChartFactory.createXYLineChart(title, labelX, labelY, dataset);
        customizeChart(chart);
        m_chartPanel = new ChartPanel(chart);
    }
 
    private XYDataset createDataset(String measurementName, ArrayList<Long> xData, ArrayList<Number> yData) {
        XYSeriesCollection dataset = new XYSeriesCollection();
        XYSeries series = new XYSeries(measurementName);

        for (int i = 0; i < xData.size(); ++i) {
            series.add((double)xData.get(i), Double.valueOf(yData.get(i).toString()));
        }

        dataset.addSeries(series);
        return dataset;
    }

    private void customizeChart(JFreeChart chart) {
		XYPlot plot = chart.getXYPlot();
		XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();
		renderer.setSeriesPaint(0, Color.RED);
		renderer.setSeriesStroke(0, new BasicStroke(4.0f));
		plot.setOutlineStroke(new BasicStroke(2.0f));
		plot.setRenderer(renderer);
		plot.setBackgroundPaint(Color.WHITE);
		plot.setRangeGridlinesVisible(true);
		plot.setRangeGridlinePaint(Color.BLACK);
		plot.setDomainGridlinesVisible(true);
		plot.setDomainGridlinePaint(Color.BLACK);
	}
}
