package com.eason.diffutildemo.adapter

import android.support.v7.util.DiffUtil
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 * Base AbstractAdapter
 * Created by Eason on 2017/12/6.
 */
abstract class AbstractAdapter<ITEM>(private var data: MutableList<ITEM>, private val resourceID: Int) :
        RecyclerView.Adapter<AbstractAdapter.ViewHolder>() {
    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = data[position]
        holder.itemView.bind(item)
        Log.i("Eason","item:" + item)
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent?.context).inflate(resourceID, parent, false)
        val holder = ViewHolder(view)
        val itemView = holder.itemView
        itemView.setOnClickListener {
            val position = holder.adapterPosition
            if (position != RecyclerView.NO_POSITION)
                onItemClick(itemView, holder.adapterPosition)
        }
        return holder
    }

    fun update(newList: List<ITEM>) {
        updateAdapterWithDiffResult(calculateDiff(newList))
    }

    /**
     * 使用 DiffUtil 高效的更新 RecycleView
     */
    private fun updateAdapterWithDiffResult(result: DiffUtil.DiffResult) {
        result.dispatchUpdatesTo(this)
    }

    private fun calculateDiff(newItems: List<ITEM>) =
            DiffUtil.calculateDiff(DiffUtilCallback(data, newItems))

    fun add(item: ITEM) {
        data.add(item)
        notifyItemInserted(data.size)
    }

    fun remove(position: Int) {
        data.removeAt(position)
        notifyItemRemoved(position)
    }


    final override fun onViewRecycled(holder: ViewHolder) {
        super.onViewRecycled(holder)
        onViewRecycled(holder.itemView)
    }

    abstract fun onViewRecycled(itemView: View)

    abstract fun onItemClick(itemView: View, itemPosition: Int)

    abstract fun View.bind(item: ITEM)


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}