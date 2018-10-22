package dev.setakarim.chartwithmpandroidchart;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    BarChart barChart;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        barChart = findViewById(R.id.barchart);
        barChart.setDrawBarShadow(false);
        barChart.setDrawValueAboveBar(true);
        barChart.setMaxVisibleValueCount(50);
        barChart.setPinchZoom(false);
        barChart.setDrawGridBackground(true);

        ArrayList<BarEntry> barEntriesBookBefore = new ArrayList<>();

        barEntriesBookBefore.add(new BarEntry(1, 40f));
        barEntriesBookBefore.add(new BarEntry(2, 42f));
        barEntriesBookBefore.add(new BarEntry(3, 37f));
        barEntriesBookBefore.add(new BarEntry(4, 46f));

        BarDataSet barDataSetBookBefore = new BarDataSet(barEntriesBookBefore, "Book Before");
        barDataSetBookBefore.setColors(ColorTemplate.MATERIAL_COLORS[0]);


        ArrayList<BarEntry> barEntriesBookNow = new ArrayList<>();

        barEntriesBookNow.add(new BarEntry(1, 30f));
        barEntriesBookNow.add(new BarEntry(2, 24f));
        barEntriesBookNow.add(new BarEntry(3, 27f));
        barEntriesBookNow.add(new BarEntry(4, 26f));

        BarDataSet barDataSetBookNow = new BarDataSet(barEntriesBookNow, "Book Now");
        barDataSetBookNow.setColors(ColorTemplate.MATERIAL_COLORS[1]);


        ArrayList<BarEntry> barEntriesAkadNow = new ArrayList<>();

        barEntriesAkadNow.add(new BarEntry(1, 40f));
        barEntriesAkadNow.add(new BarEntry(2, 41f));
        barEntriesAkadNow.add(new BarEntry(3, 42f));
        barEntriesAkadNow.add(new BarEntry(4, 43f));

        BarDataSet barDataSetAkadNow = new BarDataSet(barEntriesAkadNow, "Akad Now");
        barDataSetAkadNow.setColors(ColorTemplate.MATERIAL_COLORS[2]);


        ArrayList<BarEntry> barEntriesAkadBefore = new ArrayList<>();

        barEntriesAkadBefore.add(new BarEntry(1, 31f));
        barEntriesAkadBefore.add(new BarEntry(2, 32f));
        barEntriesAkadBefore.add(new BarEntry(3, 33f));
        barEntriesAkadBefore.add(new BarEntry(4, 34f));

        BarDataSet barDataSetAkadBefore = new BarDataSet(barEntriesAkadBefore, "Book Now");
        barDataSetAkadBefore.setColors(ColorTemplate.MATERIAL_COLORS[3]);

        BarData data = new BarData(barDataSetBookBefore, barDataSetBookNow, barDataSetAkadNow, barDataSetAkadBefore);

        float groupSpace = 0.2f;
        float barSpace = 0.02f;
        float barWidth = 0.15f;

        barChart.setData(data);

        data.setBarWidth(barWidth);

        barChart.groupBars(1, groupSpace, barSpace);

        String[] months = new String[] {"Jab", "Feb", "Mar", "Apr", "Mei", "Jun"};
        XAxis xAxis = barChart.getXAxis();
        xAxis.setValueFormatter(new MyXAxisVallueFormater(months));
        xAxis.setPosition(XAxis.XAxisPosition.BOTH_SIDED);
        xAxis.setGranularity(1);
        xAxis.setCenterAxisLabels(true);
        xAxis.setAxisMinimum(1);
    }

    public class MyXAxisVallueFormater implements IAxisValueFormatter {

        private String[] mValues;
        public MyXAxisVallueFormater(String[] values) {
            this.mValues = values;
        }

        @Override
        public String getFormattedValue(float value, AxisBase axis) {
            return mValues[(int)value];
        }
    }
}
