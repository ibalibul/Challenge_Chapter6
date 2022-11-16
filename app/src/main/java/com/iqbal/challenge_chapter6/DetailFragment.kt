package com.iqbal.challenge_chapter6

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.iqbal.challenge_chapter6.databinding.FragmentDetailBinding
import com.iqbal.challenge_chapter6.model.GetFilmResponsItem


class DetailFragment : Fragment() {

    lateinit var binding :FragmentDetailBinding

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

        var dataFilm = arguments?.getSerializable("datafilm") as GetFilmResponsItem
        binding.judulDetail.text = dataFilm.name
        binding.DirectoryDetail.text = dataFilm.director
        binding.categoryDetail.text = dataFilm.description
    }


}