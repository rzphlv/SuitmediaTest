package com.rzphlv.suitmediatest.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.rzphlv.suitmediatest.R
import com.rzphlv.suitmediatest.model.Guest
import kotlinx.android.synthetic.main.item_event.view.*
import kotlinx.android.synthetic.main.item_guest.view.*

class GuestAdapter(
    private val guest: List<Guest>,
    private val adapterOnClick: (Guest) -> Unit,
) : RecyclerView.Adapter<GuestAdapter.GuestHolder>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, p1: Int): GuestHolder {
        return GuestHolder(LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.item_event, viewGroup, false))
    }

    override fun getItemCount(): Int = guest.size

    override fun onBindViewHolder(holder: GuestHolder, position: Int) {
        holder.bindGuest(guest[position])
    }

    inner class GuestHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bindGuest(guest: Guest) {
            itemView.apply {
                txt_guest.text = guest.first_name
                Glide.with(this)
                    .load(guest.avatar)
                    .into(imgQuest)

                setOnClickListener {
                    adapterOnClick(guest)
                }
            }
        }
    }
}