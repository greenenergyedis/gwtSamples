package com.gec.chart.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.Panel;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.visualization.client.AbstractDataTable;
import com.google.gwt.visualization.client.AbstractDataTable.ColumnType;
import com.google.gwt.visualization.client.DataTable;
import com.google.gwt.visualization.client.VisualizationUtils;
import com.google.gwt.visualization.client.visualizations.corechart.Options;
import com.google.gwt.visualization.client.visualizations.corechart.PieChart;

public class ChartSample implements EntryPoint
{
    @Override
    public void onModuleLoad()
    {
        Runnable onLoadCallback = new Runnable()
        {
            public void run()
            {
                Panel panel = RootPanel.get();

                // Create a pie chart visualization.
                PieChart pie = new PieChart(createTable(), createOptions());

                panel.add(pie);
            }
        };
        VisualizationUtils.loadVisualizationApi(onLoadCallback, PieChart.PACKAGE);
    }

    private AbstractDataTable createTable()
    {
        DataTable data = DataTable.create();
        data.addColumn(ColumnType.STRING, "Task");
        data.addColumn(ColumnType.NUMBER, "Hours per Day");
        data.addRows(2);
        data.setValue(0, 0, "Work");
        data.setValue(0, 1, 14);
        data.setValue(1, 0, "Sleep");
        data.setValue(1, 1, 10);
        return data;
    }

    private Options createOptions()
    {
        Options options = Options.create();
        options.setWidth(400);
        options.setHeight(240);
        options.setTitle("My Daily Activities");
        return options;
    }
}
