package wel.wat.edu.pl.mojpiniadz;

import android.content.Context;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.IValueFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;


public class podsumowanieFragment extends Fragment {

    PieChart graphZarobki;
    public podsumowanieFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_podsumowanie, container, false);

        graphZarobki =(PieChart) view.findViewById(R.id.graph_zarobki);
        graphZarobki.setUsePercentValues(true);
        graphZarobki.getDescription().setEnabled(false);
        graphZarobki.setExtraOffsets(5,10,5,5);
        graphZarobki.setDragDecelerationFrictionCoef(0.97f);

        graphZarobki.setDrawHoleEnabled(true);
        graphZarobki.setHoleColor(Color.WHITE);
        graphZarobki.setTransparentCircleRadius(0);

        ArrayList<PieEntry> yValues = new ArrayList<>();
        yValues.add(new PieEntry(30f, "Wynagrodzenie"));
        yValues.add(new PieEntry(30f, "Zwrot podatku"));
        yValues.add(new PieEntry(40f, "Pożyczka"));

        Legend legend = graphZarobki.getLegend();
        legend.setEnabled(false);

        graphZarobki.animateY(1000,Easing.EaseInOutCubic);

        PieDataSet dataSet = new PieDataSet(yValues, "Zarobki");
        dataSet.setSliceSpace(3f);
        dataSet.setSelectionShift(5f);
        dataSet.setColors(ColorTemplate.JOYFUL_COLORS);

        PieData data = new PieData(dataSet);
        data.setValueTextSize(10f);
        data.setValueTextColor(Color.BLUE);

        graphZarobki.setData(data);

        // Inflate the layout for this fragment
        return view;
    }



}
