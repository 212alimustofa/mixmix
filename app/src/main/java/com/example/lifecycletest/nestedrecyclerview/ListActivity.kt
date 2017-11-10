package com.example.lifecycletest.nestedrecyclerview

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.example.lifecycletest.R
import kotlinx.android.synthetic.main.activity_list.*

class ListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)
        val layoutManager = LinearLayoutManager(this)
        rvData.setHasFixedSize(true)
        rvData.layoutManager = layoutManager
        val adapter = VerticalRecyclerAdapter()
        rvData.adapter = adapter

        val commentList1: MutableList<SubData> = ArrayList()
        commentList1.add(SubData("Rudy", "Iki bosok"))
        commentList1.add(SubData("Andi", "Iki bosok"))
        commentList1.add(SubData("Rido", "Apik iki"))

        val commentList2: MutableList<SubData> = ArrayList()
        commentList2.add(SubData("Rudy", "Iki bosok"))
        commentList2.add(SubData("Rido", "Apik iki"))

        val commentList3: MutableList<SubData> = ArrayList()

        val dataList: MutableList<Data> = ArrayList()
        dataList.add(Data("Anto", "Apa-apaan ini", commentList1))
        dataList.add(Data("Rita", "Ruwer lah bos", commentList2))
        dataList.add(Data("Lulu", "Njajal cah", commentList3))
        dataList.add(Data("Renaldi", "Njelei", commentList3))

        adapter.setData(dataList)

    }
}
