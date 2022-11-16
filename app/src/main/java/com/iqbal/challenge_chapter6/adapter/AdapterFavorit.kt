package com.iqbal.challenge_chapter6.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.iqbal.challenge_chapter6.databinding.ItemFilmfavoritBinding
import com.iqbal.challenge_chapter6.model.GetFavoriteUserItem

class AdapterFavorit (var listfilfavorit : List<GetFavoriteUserItem>) : RecyclerView.Adapter<AdapterFavorit.ViewHolder>() {

    class ViewHolder(var binding : ItemFilmfavoritBinding) : RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var view = ItemFilmfavoritBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.txtJudulfavorit.text = listfilfavorit[position].name
        holder.binding.txtDeskripsifavorit.text = listfilfavorit[position].category
        Glide.with(holder.itemView).load(listfilfavorit[position].image).into(holder.binding.imgFilmfavorit)

    }

    override fun getItemCount(): Int {
        return listfilfavorit.size
    }
}