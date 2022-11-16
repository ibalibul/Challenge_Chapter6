package com.iqbal.challenge_chapter6.favorit

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.iqbal.challenge_chapter6.R
import com.iqbal.challenge_chapter6.databinding.FragmentFavoriteBinding
import com.iqbal.challenge_chapter6.network.APIClient

class FavoriteFragment : Fragment() {

    lateinit var binding : FragmentFavoriteBinding

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

    }





}