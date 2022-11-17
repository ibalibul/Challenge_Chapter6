package com.iqbal.challenge_chapter6.favorit

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.iqbal.challenge_chapter6.R
import com.iqbal.challenge_chapter6.adapter.AdapterFavorit
import com.iqbal.challenge_chapter6.databinding.FragmentFavoriteBinding
import com.iqbal.challenge_chapter6.network.APIClient
import com.iqbal.challenge_chapter6.viewmodel.ViewModelFilmFavorit
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FavoriteFragment : Fragment() {

    lateinit var binding : FragmentFavoriteBinding
    lateinit var viewModel : ViewModelFilmFavorit

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentFavoriteBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this).get(ViewModelFilmFavorit::class.java)

        showDataFavorite()

    }

    fun showDataFavorite(){
        viewModel.callApiFilmFavorit()
        viewModel.getliveDataFavorit().observe(viewLifecycleOwner, Observer {
            if (it != null) {
                binding.rvFavorit.layoutManager = LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false)
                binding.rvFavorit.adapter = AdapterFavorit(it)
            }
        })
    }





}