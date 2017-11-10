package com.example.lifecycletest.nestedrecyclerview

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.example.lifecycletest.R
import kotlinx.android.synthetic.main.horizontal_data_card.view.*
import android.view.LayoutInflater

/**
 * Created by ali on 09/11/17.
 */
class HorizontalRecyclerAdapter: RecyclerView.Adapter<HorizontalRecyclerAdapter.HorizontalViewHolder>(){

    var subDatas: MutableList<SubData> = ArrayList()
    var rowIndex = -1

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): HorizontalViewHolder {
        val context = parent?.getContext()
        val itemView = LayoutInflater.from(context).inflate(R.layout.horizontal_data_card, parent, false)
        return HorizontalViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: HorizontalViewHolder?, position: Int) {
        holder?.onBind(position)
    }

    override fun getItemCount(): Int {
        return subDatas.size
    }

    inner class HorizontalViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val aComment = itemView.tvComment
        val aSubComment = itemView.tvSubComment
        fun onBind(position: Int) {
            aComment.text = subDatas[position].aPeople
            aSubComment.text = subDatas[position].aComment
        }
    }

    fun setData(subDatas: MutableList<SubData>){
        this.subDatas = subDatas
        notifyDataSetChanged()
    }

}