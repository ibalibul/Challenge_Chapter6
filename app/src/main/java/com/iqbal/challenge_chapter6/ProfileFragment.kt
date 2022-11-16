package com.iqbal.challenge_chapter6

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.asLiveData
import androidx.navigation.Navigation
import com.iqbal.challenge_chapter6.databinding.FragmentProfileBinding
import com.iqbal.challenge_chapter6.datastore.UserPreferencesRepository
import com.iqbal.challenge_chapter6.viewmodel.ViewModelUser
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

@AndroidEntryPoint
class ProfileFragment : Fragment() {

    lateinit var binding : FragmentProfileBinding
    lateinit var userViewModel : ViewModelUser
    lateinit var userPrefernce : UserPreferencesRepository

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentProfileBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        userPrefernce = UserPreferencesRepository(requireContext())
       userPrefernce.userName.asLiveData().observe(viewLifecycleOwner){
           binding.NameProfile.text = it
       }
        userPrefernce.userPassword.asLiveData().observe(viewLifecycleOwner){
            binding.EmailProfile.text = it
        }

        userViewModel = ViewModelProvider(this)[ViewModelUser::class.java]


        binding.btnLogout.setOnClickListener{
                GlobalScope.launch {
                    userPrefernce.deletData()
                }
            Navigation.findNavController(view).navigate(R.id.action_profileFragment_to_loginFragment)
        }


    }

}