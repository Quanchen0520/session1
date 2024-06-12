package com.example.session1

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.github.mikephil.charting.charts.PieChart
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry

class FragmentA : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        pieChart()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_a, container, false)
        return view
    }


    private fun pieChart() {
        val pc = view?.findViewById<PieChart>(R.id.piechart)
        val data = ArrayList<PieEntry>()
        data.add(PieEntry(30f, "有及格"))
        data.add(PieEntry(70f, "沒及格"))
        // 顏色設定
        val color = ArrayList<Int>()
        color.add(Color.parseColor("#1abc9c"))
        color.add(Color.parseColor("#ffa502"))
        val pieDataSet = PieDataSet(data, "")
        pieDataSet.colors = color

        val pieData = PieData(pieDataSet)
        if (pc != null) {
            pc.data = pieData
        }
    }
}