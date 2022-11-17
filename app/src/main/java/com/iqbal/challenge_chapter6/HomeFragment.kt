package com.iqbal.challenge_chapter6

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.asLiveData
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.iqbal.challenge_chapter6.adapter.AdapterFilm
import com.iqbal.challenge_chapter6.databinding.FragmentHomeBinding
import com.iqbal.challenge_chapter6.datastore.UserPreferencesRepository
import com.iqbal.challenge_chapter6.viewmodel.ViewModelFilm
import com.iqbal.challenge_chapter6.viewmodel.ViewModelFilmFavorit
import dagger.hilt.android.AndroidEntryPoint


private const val TAG = "HomeFragment"

@AndroidEntryPoint
class HomeFragment : Fragment() {

    lateinit var userprefrence : UserPreferencesRepository
    lateinit var binding : FragmentHomeBinding
    lateinit var filmAdapter : AdapterFilm
    lateinit var viewmodel: ViewModelFilm
    lateinit var viewmodelfavorit : ViewModelFilmFavorit

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding =  FragmentHomeBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d(TAG, "onViewCreated: Masuk Home")
        userprefrence =  UserPreferencesRepository(requireContext())
        userprefrence.userName.asLiveData().observe(viewLifecycleOwner){
            Log.d("username", "onViewCreated: $it")
            binding.tvUsername.text = it
        }

        viewmodel = ViewModelProvider(this).get(ViewModelFilm::class.java)

        ShowFilm()

        binding.imgFavorite.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_favoriteFragment)
        }

        binding.imgProfile.setOnClickListener{
            findNavController().navigate(R.id.action_homeFragment_to_profileFragment)
        }

    }

    fun ShowFilm() {

        viewmodel.callApifilm()
        viewmodel.getLiveDatafilm().observe(viewLifecycleOwner, Observer {
//                filmAdapter = AdapterFilm(it!!)
            if (it != null){
                binding.rvListfilm.layoutManager = LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false)
                binding.rvListfilm.adapter = AdapterFilm(it)

            }
        })
//        viewmodel.getLiveDatafilm()
    }

//    fun ShowDatafilmFavorit() {
//
//        viewmodelfavorit.callApiFilmFavorit()
//        viewmodelfavorit.getliveDataFavorit().observe(viewLifecycleOwner, Observer {
//           if (it != null){
//                binding.rvListfilm.layoutManager = LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false)
//           }
//        })
//
//    }


}