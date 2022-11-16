package com.iqbal.challenge_chapter6.adapter

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.iqbal.challenge_chapter6.R
import com.iqbal.challenge_chapter6.databinding.ItemFilmBinding
import com.iqbal.challenge_chapter6.model.GetFilmResponsItem


class AdapterFilm (var listFilm : List<GetFilmResponsItem>) : RecyclerView.Adapter<AdapterFilm.ViewHolder>() {

    class ViewHolder (var binding : ItemFilmBinding) : RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterFilm. ViewHolder {
        var view = ItemFilmBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder:ViewHolder, position: Int) {
        holder.binding.txtJudul.text = listFilm[position].name
        holder.binding.txtDirector.text = listFilm[position].director
        holder.binding.txtDeskripsi.text = listFilm[position].description
        Glide.with(holder.itemView).load(listFilm[position].image).into(holder.binding.imgFilm)

        holder.binding.cardView.setOnClickListener{
            var bund = Bundle()
            bund.putSerializable("datafilm",listFilm[position])
            Navigation.findNavController(it).navigate(R.id.action_homeFragment_to_detailFragment,bund)
        }

    }

    override fun getItemCount(): Int {
        return listFilm.size
    }
}