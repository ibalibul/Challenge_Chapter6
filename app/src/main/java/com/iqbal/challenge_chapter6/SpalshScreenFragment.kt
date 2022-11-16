package com.iqbal.challenge_chapter6

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.asLiveData
import androidx.navigation.Navigation
import com.iqbal.challenge_chapter6.databinding.FragmentSpalshScreenBinding
import com.iqbal.challenge_chapter6.datastore.UserPreferencesRepository
import dagger.hilt.android.AndroidEntryPoint


private const val TAG = "SplashScreenFragment"
class SpalshScreenFragment : Fragment() {

    lateinit var binding : FragmentSpalshScreenBinding
    lateinit var userPrefrences: UserPreferencesRepository

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        binding =  FragmentSpalshScreenBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        userPrefrences =  UserPreferencesRepository(requireContext())




        Handler(Looper.getMainLooper()).postDelayed({
            userPrefrences.userName.asLiveData().observe(viewLifecycleOwner) {
                Toast.makeText(context, "Selamat Datang", Toast.LENGTH_SHORT).show()
                Log.d(TAG, "onViewCreated: $it")
                if (it.isNotEmpty())
                    Navigation.findNavController(view)
                        .navigate(R.id.action_spalshScreenFragment_to_homeFragment)
                else
                    Navigation.findNavController(view)
                        .navigate(R.id.action_spalshScreenFragment_to_loginFragment)
            }
        }, 3000)

    }





}