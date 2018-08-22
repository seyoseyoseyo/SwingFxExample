import javafx.application.Platform;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;

public class Graph {
    public Graph() {
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                getChart();
            }
        });
    }

    public BarChart<String, Number> getChart() {
        final CategoryAxis xAxis = new CategoryAxis();
        final NumberAxis yAxis = new NumberAxis();
        final BarChart<String, Number> bc = new BarChart<String, Number>(xAxis,
                yAxis);
        bc.setTitle("Country Summary");
        xAxis.setLabel("Country");
        yAxis.setLabel("Value");

        XYChart.Series series1 = new XYChart.Series();
        series1.setName("2003");
        series1.getData().add(new XYChart.Data("austria", 25601.34));
        series1.getData().add(new XYChart.Data("brazil", 20148.82));
        series1.getData().add(new XYChart.Data("france", 10000));
        series1.getData().add(new XYChart.Data("italy", 35407.15));
        series1.getData().add(new XYChart.Data("usa", 12000));

        //Scene scene = new Scene(bc);
        bc.getData().addAll(series1);
        return bc;
    }
}
