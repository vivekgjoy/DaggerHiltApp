package com.mobil80.daggerhilt

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class CryptocurrencyAdapter(private val cryptocurrency: List<CryptocurrencyData>): RecyclerView.Adapter<CryptocurrencyAdapter.CryptoViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CryptocurrencyAdapter.CryptoViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return CryptoViewHolder(view)
    }

    override fun onBindViewHolder(holder: CryptocurrencyAdapter.CryptoViewHolder, position: Int) {
        holder.bind(cryptocurrency[position])
    }

    override fun getItemCount() = cryptocurrency.size

    class CryptoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        fun bind(index: CryptocurrencyData){

            Glide.with(itemView.context)
                .load(index.image).dontAnimate()
                .into(itemView.findViewById(R.id.image))
            itemView.findViewById<TextView>(R.id.cryptocurrency).text = index.name
        }
    }

}