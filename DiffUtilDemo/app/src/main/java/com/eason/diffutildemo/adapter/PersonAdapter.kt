package com.eason.diffutildemo.adapter

import android.view.View
import com.eason.diffutildemo.R
import com.eason.diffutildemo.entity.Person
import kotlinx.android.synthetic.main.itemview.view.*

/**
 * Created by Eason on 2017/12/6.
 */
class PersonAdapter(data: MutableList<Person>) : AbstractAdapter<Person>(data, R.layout.itemview) {
    override fun onViewRecycled(itemView: View) {
    }

    override fun onItemClick(itemView: View, itemPosition: Int) {
    }

    override fun View.bind(item: Person) {
        name.text = item.name
        age.text = item.age.toString()
    }

}