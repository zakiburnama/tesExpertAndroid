package com.example.faktaanime.core.ui

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.faktaanime.core.R
import com.example.faktaanime.core.databinding.ItemListAnimeBinding
import com.example.faktaanime.core.domain.model.Anime
import java.util.ArrayList

class AnimeAdapter : RecyclerView.Adapter<AnimeAdapter.ListViewHolder>() {

    private var listData = ArrayList<Anime>()
    var onItemClick: ((Anime) -> Unit)? = null

    @SuppressLint("NotifyDataSetChanged")
    fun setData(newListData: List<Anime>?) {
        if (newListData == null) return
        listData.clear()
        listData.addAll(newListData)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ListViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_list_anime, parent, false))

    override fun getItemCount() = listData.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val data = listData[position]
        holder.bind(data)
    }

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = ItemListAnimeBinding.bind(itemView)
        fun bind(data: Anime) {
            with(binding) {
                Glide.with(itemView.context)
                    .load(data.img)
                    .into(ivItemImage)
                tvItemTitle.text = data.name
                tvItemSubtitle.text = data.id.toString()
            }
        }

        init {
            binding.root.setOnClickListener {
                onItemClick?.invoke(listData[adapterPosition])
            }
        }
    }
}