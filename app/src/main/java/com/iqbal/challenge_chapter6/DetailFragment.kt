package com.iqbal.challenge_chapter6

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.iqbal.challenge_chapter6.databinding.FragmentDetailBinding
import com.iqbal.challenge_chapter6.model.DataFavorite
import com.iqbal.challenge_chapter6.model.GetFilmResponsItem
import com.iqbal.challenge_chapter6.viewmodel.ViewModelFilmFavorit
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailFragment : Fragment() {

    lateinit var binding :FragmentDetailBinding
    lateinit var viewModel : ViewModelFilmFavorit

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentDetailBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this).get(ViewModelFilmFavorit::class.java)

        var dataFilm = arguments?.getSerializable("datafilm") as GetFilmResponsItem
        binding.judulDetail.text = dataFilm.name
        binding.DirectoryDetail.text = dataFilm.director
        binding.categoryDetail.text = dataFilm.description

        binding.favorit.setOnClickListener {
            var favorite = DataFavorite(id = dataFilm.id, image = dataFilm.image, name = dataFilm.name)
            viewModel.postDataFavorite(favorite)
        }
    }




}