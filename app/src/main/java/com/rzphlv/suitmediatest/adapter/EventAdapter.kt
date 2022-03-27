package com.rzphlv.suitmediatest.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.rzphlv.suitmediatest.R
import com.rzphlv.suitmediatest.model.Event
import kotlinx.android.synthetic.main.item_event.view.*

class EventAdapter(
    private val event: List<Event>,
    private val adapterOnClick: (Event) -> Unit,
) : RecyclerView.Adapter<EventAdapter.EventHolder>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, p1: Int): EventHolder {
        return EventHolder(LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.item_event, viewGroup, false))
    }

    override fun getItemCount(): Int = event.size

    override fun onBindViewHolder(holder: EventHolder, position: Int) {
        holder.bindEvent(event[position])
    }

    inner class EventHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bindEvent(event: Event) {
            itemView.apply {
                txt_judul.text = event.name
                txt_desc.text = event.desc
                txt_tgl.text = event.date
                Glide.with(this)
                    .load(event.image)
                    .into(img)

                setOnClickListener {
                    adapterOnClick(event)
                }
            }
        }
    }
}