package com.example.lifecycletest.nestedrecyclerview

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.vertical_data_card.view.*
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.LayoutInflater
import android.widget.TextView
import com.example.lifecycletest.R
import kotlinx.android.synthetic.main.horizontal_data_card.view.*


/**
 * Created by ali on 09/11/17.
 */
class VerticalRecyclerAdapter: RecyclerView.Adapter<VerticalRecyclerAdapter.VerticalViewHolder>(){
    var datas: MutableList<Data> = ArrayList()

    override fun onBindViewHolder(holder: VerticalViewHolder?, position: Int) {
        holder?.onBind(position)
    }

    override fun getItemCount(): Int {
        return datas.size
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): VerticalViewHolder {
        val context = parent?.getContext()
        val itemView = LayoutInflater.from(context).inflate(R.layout.vertical_data_card, parent, false)
        return VerticalViewHolder(itemView)
    }

    inner class VerticalViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var context = itemView.context
        var title = itemView.tvTitle
        var subTitle = itemView.tvSubTitle
        var rvHorizontal = itemView.rvHorizontal
        var horizontalAdapter = HorizontalRecyclerAdapter()

        init {
            rvHorizontal.setLayoutManager(LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false))
            rvHorizontal.setAdapter(horizontalAdapter)
        }

        fun onBind(position: Int) {
            title.text = datas[position].aPeople
            subTitle.text = datas[position].aPost
            horizontalAdapter.setData(datas[position].subDatas)
            horizontalAdapter.rowIndex = position
        }
    }

    fun setData(datas: MutableList<Data>){
        this.datas = datas
        notifyDataSetChanged()
    }
}