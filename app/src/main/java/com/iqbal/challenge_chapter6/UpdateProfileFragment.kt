package com.iqbal.challenge_chapter6

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.asLiveData
import com.iqbal.challenge_chapter6.databinding.FragmentUpdateProfileBinding
import com.iqbal.challenge_chapter6.datastore.UserPreferencesRepository
import com.iqbal.challenge_chapter6.viewmodel.ViewModelUser

class UpdateProfileFragment : Fragment() {

    lateinit var binding : FragmentUpdateProfileBinding
    lateinit var userpref : UserPreferencesRepository
    lateinit var viewModel : ViewModelUser

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        binding = FragmentUpdateProfileBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        userpref = UserPreferencesRepository(requireContext())

//        userpref.userName.asLiveData().observe(viewLifecycleOwner) {
//            binding.edUpdateUser.text = it
//        }
//        userpref.userPassword.asLiveData().observe(viewLifecycleOwner) {
//            binding.EmailProfile.text = it
//        }

        viewModel = ViewModelProvider(this).get(ViewModelUser::class.java)
    }




}